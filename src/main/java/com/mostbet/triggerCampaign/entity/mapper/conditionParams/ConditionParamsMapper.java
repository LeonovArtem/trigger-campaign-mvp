package com.mostbet.triggerCampaign.entity.mapper.conditionParams;

import com.mostbet.triggerCampaign.entity.ConditionParam;
import com.mostbet.triggerCampaign.entity.conditionParamValue.ParamValue;
import com.mostbet.triggerCampaign.entity.dto.ConditionDto;

import java.util.Set;

public interface ConditionParamsMapper {
    ConditionDto.Params conditionParamsToParamsDto(Set<ConditionParam> conditionParams);

    Set<ConditionParam> paramsDtoToConditionParams(ConditionDto.Params params);

    default ConditionParam createConditionParam(ConditionParam.ConditionParamName paramName, ParamValue value) {
        ConditionParam conditionParam = new ConditionParam();
        conditionParam.setName(paramName);
        conditionParam.setParamValue(value);

        return conditionParam;
    }
}
