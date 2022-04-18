package com.mostbet.triggerCampaign.entity.mapper.condition;

import com.mostbet.triggerCampaign.entity.Condition;
import com.mostbet.triggerCampaign.entity.mapper.conditionParams.UserParamsMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", uses = UserParamsMapper.class)
public abstract class ConditionUserMapper implements ConditionMapper {
    @Override
    public Condition.Type getConditionType() {
        return Condition.Type.USER;
    }
}
