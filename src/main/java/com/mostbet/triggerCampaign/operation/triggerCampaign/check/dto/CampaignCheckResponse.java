package com.mostbet.triggerCampaign.operation.triggerCampaign.check.dto;

import com.mostbet.triggerCampaign.operation.condition.check.dto.ConditionCheckResponse;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class CampaignCheckResponse {

    private int triggerCampaignId;

    private boolean isFulfilled;

    private boolean isFulfillmentLimitReached;

    private List<ConditionCheckResponse> conditionCheckResponses;
}
