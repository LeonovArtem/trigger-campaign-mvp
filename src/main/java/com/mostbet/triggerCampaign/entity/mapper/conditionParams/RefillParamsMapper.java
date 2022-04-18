package com.mostbet.triggerCampaign.entity.mapper.conditionParams;

import com.mostbet.triggerCampaign.entity.ConditionParam;
import com.mostbet.triggerCampaign.entity.dto.ConditionDto;
import com.mostbet.triggerCampaign.entity.dto.conditionParams.RefillParamsDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.ArrayList;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public abstract class RefillParamsMapper implements ConditionParamsMapper {
    @Override
    public RefillParamsDto conditionParamsToParamsDto(List<ConditionParam> conditionParams) {
        RefillParamsDto refillParamsDto = new RefillParamsDto();

        return refillParamsDto;
    }

    @Override
    public List<ConditionParam> paramsDtoToConditionParams(ConditionDto.Params params) {
        List<ConditionParam> conditionParamList = new ArrayList<>();
        RefillParamsDto refillParamsDto = (RefillParamsDto) params;

        return conditionParamList;
    }
}
