package com.mostbet.triggerCampaign.entity.conditionParamValue.fulfillment;

import com.mostbet.triggerCampaign.entity.conditionParamValue.ParamValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LimitPerDayDto implements ParamValue {
    Boolean value;
}
