package com.mostbet.triggerCampaign.web;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Disabled
@SpringBootTest
@AutoConfigureMockMvc
public class CouponControllerTest {
    @Autowired
    protected MockMvc mockMvc;

    @ParameterizedTest
    @ValueSource(ints = {11, 12})
    void getCouponInfoSuccessful() throws Exception {
        String url = String.format("/coupon/%d/", 11);

        mockMvc
                .perform(get(url).contentType("application/json"))
                .andExpect(status().isOk())
        ;
    }

    @Test
    void getCouponInfoNotFound() throws Exception {
        String url = String.format("/coupon/%d/", 999);

        mockMvc
                .perform(get(url).contentType("application/json"))
                .andExpect(status().isNotFound())
        ;
    }
}