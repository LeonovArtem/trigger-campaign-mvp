package com.mostbet.triggerCampaign.web.controller.admin;

import com.github.database.rider.core.api.dataset.DataSet;
import com.mostbet.triggerCampaign.BaseFunctionalTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ConditionCouponControllerTest extends BaseFunctionalTest {

    @ParameterizedTest
    @ValueSource(ints = {1})
    @DataSet(
            value = {"/dataSet/web.controller/admin/condition/dataset.json"},
            executeScriptsBefore = "truncate_all.sql",
            executeScriptsAfter = "truncate_all.sql"
    )
    public void getById_whenConditionExist_thenReturn200(int conditionId) throws Exception {
        String url = String.format("/admin/condition-coupon/%d", conditionId);
        mockMvc
                .perform(get(url).contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    @DataSet(
            value = {"/dataSet/web.controller/admin/condition/dataset.json"},
            executeScriptsBefore = "truncate_all.sql",
            executeScriptsAfter = "truncate_all.sql"
    )
    public void getById_whenConditionIsNotExist_thenReturn404() throws Exception {
        String url = String.format("/admin/condition-coupon/%d", 2);
        mockMvc
                .perform(get(url).contentType("application/json"))
                .andExpect(status().isNotFound());
    }

    @Test
    @DataSet(
            value = {"/dataSet/web.controller/admin/condition/dataset.json"},
            executeScriptsBefore = "truncate_all.sql",
            executeScriptsAfter = "truncate_all.sql"
    )
    public void getList() throws Exception {
        mockMvc
                .perform(get("/admin/condition-coupon").contentType("application/json"))
                .andExpect(status().isOk());
    }
}
