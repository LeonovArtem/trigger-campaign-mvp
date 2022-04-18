package com.mostbet.triggerCampaign.entity.mapper.conditionParams;

import com.mostbet.triggerCampaign.entity.ConditionParam;
import com.mostbet.triggerCampaign.entity.dto.ConditionDto;
import com.mostbet.triggerCampaign.entity.dto.conditionParams.UserParamsDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.ArrayList;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public abstract class UserParamsMapper implements ConditionParamsMapper {
    @Override
    public ConditionDto.Params conditionParamsToParamsDto(List<ConditionParam> conditionParams) {
        UserParamsDto userParamsDto = new UserParamsDto();

        return userParamsDto;
    }

    @Override
    public List<ConditionParam> paramsDtoToConditionParams(ConditionDto.Params params) {
        List<ConditionParam> conditionParamList = new ArrayList<>();
        UserParamsDto userParamsDto = (UserParamsDto) params;

        return conditionParamList;
    }
}
