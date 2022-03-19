package com.mostbet.triggerCampaign.operation.conditionParam.check.common.dto;

import com.mostbet.triggerCampaign.entity.ConditionParam;
import com.mostbet.triggerCampaign.operation.triggerCampaign.common.dto.CampaignProcessRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ParamCheckerRequest {

    private ConditionParam conditionParam;

    private CampaignProcessRequest entitySet;
}
