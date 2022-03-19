package com.mostbet.triggerCampaign.operation.condition.check;

import com.mostbet.triggerCampaign.operation.condition.check.dto.ConditionCheckRequest;
import com.mostbet.triggerCampaign.operation.condition.check.dto.ConditionCheckResponse;

public interface ConditionCheckService {
    ConditionCheckResponse behave(ConditionCheckRequest request);
}
