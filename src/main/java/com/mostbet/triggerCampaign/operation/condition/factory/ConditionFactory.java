package com.mostbet.triggerCampaign.operation.condition.factory;

import com.mostbet.triggerCampaign.entity.Condition;
import com.mostbet.triggerCampaign.entity.dto.ConditionDto;

public interface ConditionFactory {
    Condition create(ConditionDto<ConditionDto.Params> conditionDto);
}
