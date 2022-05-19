package com.mostbet.triggerCampaign.entity.mapper.conditionParams;

import com.mostbet.triggerCampaign.entity.ConditionParam;
import com.mostbet.triggerCampaign.entity.dto.ConditionDto;
import com.mostbet.triggerCampaign.entity.dto.conditionParams.RefillParamsDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.HashSet;
import java.util.Set;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public abstract class RefillParamsMapper implements ConditionParamsMapper {
    @Override
    public RefillParamsDto conditionParamsToParamsDto(Set<ConditionParam> conditionParams) {
        RefillParamsDto refillParamsDto = new RefillParamsDto();

        return refillParamsDto;
    }

    @Override
    public Set<ConditionParam> paramsDtoToConditionParams(ConditionDto.Params params) {
        Set<ConditionParam> conditionParamList = new HashSet<>();
        RefillParamsDto refillParamsDto = (RefillParamsDto) params;

        return conditionParamList;
    }
}
