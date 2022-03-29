package com.mostbet.triggerCampaign.entity.conditionParamValue;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CouponMinimalCoefficient implements ParamValue {

    private BigDecimal coefficient;
}
