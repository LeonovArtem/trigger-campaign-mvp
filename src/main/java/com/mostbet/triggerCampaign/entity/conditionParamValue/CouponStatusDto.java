package com.mostbet.triggerCampaign.entity.conditionParamValue;

import com.mostbet.triggerCampaign.entity.CouponStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CouponStatusDto implements ParamValue{

    private CouponStatus value;
}
