package com.mostbet.triggerCampaign.operation.condition.getInfo;

import com.mostbet.triggerCampaign.entity.Condition;
import com.mostbet.triggerCampaign.entity.dto.ConditionDto;

import java.util.List;

public interface ConditionInfoService {
    List<ConditionDto<ConditionDto.ConditionParams>> getAllByConditionType(Condition.Type type);

    ConditionDto<ConditionDto.ConditionParams> getById(int id);
}
