package com.mostbet.triggerCampaign.integration.coupon.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class CouponDto {

    @JsonProperty("data")
    private List<CouponDataDto> data;

    @Data
    public static class CouponDataDto {
        @JsonProperty("id")
        private int id;

        @JsonProperty("coefficient")
        private float coefficient;

        @JsonProperty("status")
        private String status;

        @JsonProperty("amount")
        private String amount;

        @JsonProperty("type")
        private String type;
    }
}
