package com.mostbet.triggerCampaign;

import liquibase.Contexts;
import liquibase.LabelExpression;
import liquibase.Liquibase;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.resource.ClassLoaderResourceAccessor;
import lombok.SneakyThrows;
import org.cactoos.io.ResourceOf;
import org.cactoos.text.TextOf;
import org.jetbrains.annotations.NotNull;
import org.testcontainers.containers.ContainerLaunchException;
import org.testcontainers.containers.JdbcDatabaseContainer;
import org.testcontainers.utility.DockerImageName;

import java.sql.DriverManager;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public final class PerconaContainer extends JdbcDatabaseContainer<PerconaContainer> {

    private static final String IMAGE_VERSION = "reg.8adm.com/8bit/percona-server:8.0.17";

    private static PerconaContainer CONTAINER;

    private static final String MY_CNF_CONFIG_OVERRIDE_PARAM_NAME = "TC_MY_CNF";
    private static final String DEFAULT_USER = "test";
    private static final String DEFAULT_PASSWORD = "test";
    private static final Integer PERCONA_PORT = 3306;
    private static final String databaseName = "test";
    private static final String username = DEFAULT_USER;
    private static final String password = DEFAULT_PASSWORD;
    private static final String PERCONA_ROOT_USER = "root";

    private PerconaContainer() {
        this(DockerImageName.parse(IMAGE_VERSION));
    }

    public PerconaContainer(final DockerImageName dockerImageName) {
        super(dockerImageName);

        addExposedPort(PERCONA_PORT);
    }

    @NotNull
    @Override
    public Set<Integer> getLivenessCheckPortNumbers() {
        return new HashSet<>(getMappedPort(PERCONA_PORT));
    }

    @Override
    protected void configure() {
        optionallyMapResourceParameterAsVolume(MY_CNF_CONFIG_OVERRIDE_PARAM_NAME, "/etc/mysql/conf.d",
                "mysql-default-conf");

        addEnv("MYSQL_DATABASE", databaseName);
        if (!PERCONA_ROOT_USER.equalsIgnoreCase(username)) {
            addEnv("MYSQL_USER", username);
        }
        if (password != null && !password.isEmpty()) {
            addEnv("MYSQL_PASSWORD", password);
            addEnv("MYSQL_ROOT_PASSWORD", password);
        } else if (PERCONA_ROOT_USER.equalsIgnoreCase(username)) {
            addEnv("MYSQL_ALLOW_EMPTY_PASSWORD", "yes");
        } else {
            throw new ContainerLaunchException("Empty password can be used only with the root user");
        }
        setStartupAttempts(3);
    }

    @Override
    public String getDriverClassName() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return "com.mysql.cj.jdbc.Driver";
        } catch (ClassNotFoundException e) {
            return "com.mysql.jdbc.Driver";
        }
    }

    @Override
    public String getJdbcUrl() {
        String additionalUrlParams = constructUrlParameters("?", "&");
        return "jdbc:mysql://" + getHost() + ":" + getMappedPort(PERCONA_PORT) +
                "/" + databaseName + additionalUrlParams;
    }

    @Override
    protected String constructUrlForConnection(String queryString) {
        String url = super.constructUrlForConnection(queryString);

        if (!url.contains("useSSL=")) {
            String separator = url.contains("?") ? "&" : "?";
            url = url + separator + "useSSL=false";
        }

        if (!url.contains("allowPublicKeyRetrieval=")) {
            url = url + "&allowPublicKeyRetrieval=true";
        }

        return url;
    }

    @Override
    public String getDatabaseName() {
        return databaseName;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getTestQueryString() {
        return "SELECT 1";
    }

    public static PerconaContainer getInstance() {
        try {
            if (CONTAINER == null) {
                CONTAINER = new PerconaContainer();
                CONTAINER.start();
                CONTAINER.waitUntilContainerStarted();
                CONTAINER.runMigrations();
                CONTAINER.runSql("truncate_all_procedure.sql");
            }
            return CONTAINER;
        } catch (Throwable t) {
            System.out.println(t);
            throw t;
        }
    }

    @Override
    public void start() {
        super.start();
        System.setProperty("MYSQL_HOST", CONTAINER.getContainerIpAddress());
        System.setProperty("MYSQL_PORT",
            CONTAINER.getMappedPort(org.testcontainers.containers.MySQLContainer.MYSQL_PORT).toString());
        System.setProperty("MYSQL_DATABASE", CONTAINER.getDatabaseName());
        System.setProperty("MYSQL_USER", CONTAINER.getUsername());
        System.setProperty("MYSQL_PASSWORD", CONTAINER.getPassword());
    }

    @SneakyThrows
    private void runMigrations() {
        final Liquibase liquibase = new Liquibase("db/changelog/db.changelog-master.yaml",
            new ClassLoaderResourceAccessor(),
            DatabaseFactory.getInstance().findCorrectDatabaseImplementation(this.jdbcConnection()));
        liquibase.update(new Contexts(), new LabelExpression());
    }

    @SneakyThrows
    private void runSql(String path) {
        try (var statement = this.jdbcConnection().createStatement()) {
            statement.execute(new TextOf(new ResourceOf(path)).asString());
        }
    }

    @SneakyThrows
    private JdbcConnection jdbcConnection() {
        Properties properties = new Properties();
        properties.setProperty("user", CONTAINER.getUsername());
        properties.setProperty("password", CONTAINER.getPassword());
        properties.put("allowMultiQueries", "true");

        return new JdbcConnection(DriverManager.getConnection(CONTAINER.getJdbcUrl(), properties));
    }
}
