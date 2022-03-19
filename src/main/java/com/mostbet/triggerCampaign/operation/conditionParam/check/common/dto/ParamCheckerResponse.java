package com.mostbet.triggerCampaign.operation.conditionParam.check.common.dto;

import com.mostbet.triggerCampaign.entity.ConditionParam;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ParamCheckerResponse {

    private boolean isFulfilled;

    private ConditionParam conditionParam;
}
