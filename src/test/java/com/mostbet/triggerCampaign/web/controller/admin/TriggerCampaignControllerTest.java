package com.mostbet.triggerCampaign.web.controller.admin;

import com.github.database.rider.core.api.dataset.DataSet;
import com.mostbet.triggerCampaign.BaseFunctionalTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class TriggerCampaignControllerTest extends BaseFunctionalTest {

    @ParameterizedTest
    @ValueSource(ints = {1})
    @DataSet(
            value = {"/dataSet/eventProcess/campaign/onMaxFulfilmentCountForUser/dataset.json"},
            executeScriptsBefore = "truncate_all.sql",
            executeScriptsAfter = "truncate_all.sql"
    )
    public void getById(int campaignId) throws Exception {
        String url = String.format("/admin/campaign/%d", campaignId);
        mockMvc
                .perform(get(url).contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    @DataSet(
            value = {"/dataSet/eventProcess/campaign/onMaxFulfilmentCountForUser/dataset.json"},
            executeScriptsBefore = "truncate_all.sql",
            executeScriptsAfter = "truncate_all.sql"
    )
    public void getList() throws Exception {
        mockMvc
                .perform(get("/admin/campaign").contentType("application/json"))
                .andExpect(status().isOk());
    }
}
