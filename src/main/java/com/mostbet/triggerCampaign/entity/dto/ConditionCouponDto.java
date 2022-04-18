package com.mostbet.triggerCampaign.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mostbet.triggerCampaign.entity.Condition;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConditionCouponDto {

    @JsonProperty("name")
    private String name;

    @JsonProperty("conditionType")
    private Condition.Type conditionType;

    @JsonProperty("limits")
    private List<CurrencyLimitDto> limits;

    @Data
    public static class CurrencyLimitDto {
        @JsonProperty("currency")
        private String currencyCode;

        @JsonProperty("minAmount")
        private BigDecimal minAmount;
    }
}
