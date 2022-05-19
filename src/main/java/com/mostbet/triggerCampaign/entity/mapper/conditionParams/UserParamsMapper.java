package com.mostbet.triggerCampaign.entity.mapper.conditionParams;

import com.mostbet.triggerCampaign.entity.ConditionParam;
import com.mostbet.triggerCampaign.entity.dto.ConditionDto;
import com.mostbet.triggerCampaign.entity.dto.conditionParams.UserParamsDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.HashSet;
import java.util.Set;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public abstract class UserParamsMapper implements ConditionParamsMapper {
    @Override
    public ConditionDto.Params conditionParamsToParamsDto(Set<ConditionParam> conditionParams) {
        UserParamsDto userParamsDto = new UserParamsDto();

        return userParamsDto;
    }

    @Override
    public Set<ConditionParam> paramsDtoToConditionParams(ConditionDto.Params params) {
        Set<ConditionParam> conditionParamList = new HashSet<>();
        UserParamsDto userParamsDto = (UserParamsDto) params;

        return conditionParamList;
    }
}
