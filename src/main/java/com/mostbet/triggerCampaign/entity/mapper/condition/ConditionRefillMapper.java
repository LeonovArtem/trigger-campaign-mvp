package com.mostbet.triggerCampaign.entity.mapper.condition;

import com.mostbet.triggerCampaign.entity.Condition;
import com.mostbet.triggerCampaign.entity.mapper.conditionParams.RefillParamsMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", uses = RefillParamsMapper.class)
public abstract class ConditionRefillMapper implements ConditionMapper {
    @Override
    public Condition.Type getConditionType() {
        return Condition.Type.REFILL;
    }
}
