package com.mostbet.triggerCampaign.entity.conditionParamValue;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.mostbet.triggerCampaign.entity.conditionParamValue.coupon.*;
import com.mostbet.triggerCampaign.entity.conditionParamValue.fulfillment.LimitPerDayDto;
import com.mostbet.triggerCampaign.entity.conditionParamValue.refill.RefillMinAmountDto;

import java.io.Serializable;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "paramName")
@JsonSubTypes({
        @JsonSubTypes.Type(name = "COUPON_MIN_AMOUNT", value = CouponMinAmountDto.class),
        @JsonSubTypes.Type(name = "COUPON_MIN_COEFFICIENT", value = CouponMinCoefficientDto.class),
        @JsonSubTypes.Type(name = "COUPON_TYPE", value = CouponTypeDto.class),
        @JsonSubTypes.Type(name = "COUPON_STATUS", value = CouponStatusDto.class),
        @JsonSubTypes.Type(name = "COUPON_LINE_TYPE", value = CouponLineTypeDto.class),
        @JsonSubTypes.Type(name = "COUPON_IS_FIRST", value = CouponIsFirstDto.class),
        @JsonSubTypes.Type(name = "REFILL_MIN_AMOUNT", value = RefillMinAmountDto.class),
        @JsonSubTypes.Type(name = "CONDITION_FULFILLMENT_LIMIT_PER_DAY", value = LimitPerDayDto.class),
})
public interface ParamValue extends Serializable {
    /*_*/
}
