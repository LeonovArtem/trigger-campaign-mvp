package com.mostbet.triggerCampaign.entity.mapper.conditionParams;

import com.mostbet.triggerCampaign.entity.ConditionParam;
import com.mostbet.triggerCampaign.entity.conditionParamValue.ParamValue;
import com.mostbet.triggerCampaign.entity.dto.ConditionDto;

import java.util.List;

public interface ConditionParamsMapper {
    ConditionDto.Params conditionParamsToParamsDto(List<ConditionParam> conditionParams);

    List<ConditionParam> paramsDtoToConditionParams(ConditionDto.Params params);

    default ConditionParam createConditionParam(ConditionParam.ConditionParamName paramName, ParamValue value) {
        ConditionParam conditionParam = new ConditionParam();
        conditionParam.setName(paramName);
        conditionParam.setParamValue(value);

        return conditionParam;
    }
}
