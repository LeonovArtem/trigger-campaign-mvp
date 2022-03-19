package com.mostbet.triggerCampaign.operation.condition.check.dto;

import com.mostbet.triggerCampaign.entity.Condition;
import com.mostbet.triggerCampaign.operation.triggerCampaign.common.dto.CampaignProcessRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ConditionCheckRequest {

    private Condition condition;

    private CampaignProcessRequest entitySet;
}
