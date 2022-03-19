package com.mostbet.triggerCampaign.entity.conditionParamValue;

import com.mostbet.triggerCampaign.entity.CouponType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CouponTypeDto implements ParamValue{

    private CouponType value;
}
