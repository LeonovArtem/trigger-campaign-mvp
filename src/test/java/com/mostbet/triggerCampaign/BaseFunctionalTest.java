package com.mostbet.triggerCampaign;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.core.api.configuration.Orthography;
import com.github.database.rider.spring.api.DBRider;
import com.mostbet.triggerCampaign.Replacer.DateTimeReplacer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlMergeMode;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@DBRider
@ActiveProfiles("test")
@TestPropertySource(properties = {"app.scheduling.enable=false",})
@DBUnit(caseInsensitiveStrategy = Orthography.LOWERCASE, batchedStatements = true, allowEmptyFields = true, replacers = DateTimeReplacer.class)
public abstract class BaseFunctionalTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    static {
        PerconaContainer.getInstance();
    }
}
