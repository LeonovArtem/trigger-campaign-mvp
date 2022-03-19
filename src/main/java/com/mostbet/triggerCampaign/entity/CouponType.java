package com.mostbet.triggerCampaign.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum CouponType {
    @JsonProperty("ordinar")
    ORDINAR,

    @JsonProperty("express")
    EXPRESS
}
