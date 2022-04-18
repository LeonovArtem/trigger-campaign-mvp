package com.mostbet.triggerCampaign.entity.conditionParamValue.coupon;

import com.mostbet.triggerCampaign.entity.conditionParamValue.ParamValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class CouponMinCoefficientDto implements ParamValue {
    private BigDecimal coefficient;
}
