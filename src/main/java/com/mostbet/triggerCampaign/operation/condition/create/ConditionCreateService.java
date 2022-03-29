package com.mostbet.triggerCampaign.operation.condition.create;

import com.mostbet.triggerCampaign.entity.Condition;
import com.mostbet.triggerCampaign.entity.dto.ConditionDto;

public interface ConditionCreateService {
    Condition create(ConditionDto<ConditionDto.ConditionParams> conditionDto);
}
