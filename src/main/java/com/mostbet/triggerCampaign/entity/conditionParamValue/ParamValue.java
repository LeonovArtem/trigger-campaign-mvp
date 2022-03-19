package com.mostbet.triggerCampaign.entity.conditionParamValue;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "paramName")
@JsonSubTypes({
        @JsonSubTypes.Type(name = "COUPON_MIN_AMOUNT", value = CouponMinAmount.class),
        @JsonSubTypes.Type(name = "COUPON_MIN_COEFFICIENT", value = CouponMinimalCoefficient.class),
        @JsonSubTypes.Type(name = "COUPON_TYPE", value = CouponTypeDto.class),
        @JsonSubTypes.Type(name = "REFILL_MIN_AMOUNT", value = RefillMinAmount.class),
})
public interface ParamValue extends Serializable {
    /*_*/
}
