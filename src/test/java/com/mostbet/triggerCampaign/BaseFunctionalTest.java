package com.mostbet.triggerCampaign;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlMergeMode;

@SpringBootTest
@ActiveProfiles("test")
@TestPropertySource("/application-test.properties")
@SqlMergeMode(SqlMergeMode.MergeMode.MERGE)
@Sql(value = {"/truncate_all.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public abstract class BaseFunctionalTest {
}
