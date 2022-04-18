package com.mostbet.triggerCampaign.entity.conditionParamValue.coupon;

import com.mostbet.triggerCampaign.entity.CouponType;
import com.mostbet.triggerCampaign.entity.conditionParamValue.ParamValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CouponTypeDto implements ParamValue {
    private CouponType couponType;
}
