package com.mostbet.triggerCampaign.web.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mostbet.triggerCampaign.entity.Condition;
import lombok.*;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConditionCouponDto {

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("conditionType")
    private Condition.Type conditionType;

    @JsonProperty("limits")
    private List<CurrencyLimitDto> limits;

    public static class CurrencyLimitDto {
        @JsonProperty("currency")
        private String currencyCode;

        @JsonProperty("amount")
        private String amount;
    }
}
