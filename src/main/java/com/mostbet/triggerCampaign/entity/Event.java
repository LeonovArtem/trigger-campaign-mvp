package com.mostbet.triggerCampaign.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Event {

    @JsonProperty("refill_succeeded")
    REFILL_SUCCEEDED,

    @JsonProperty("coupon_closed")
    COUPON_CLOSED,
}
