package com.mostbet.triggerCampaign.operation.conditionParam.check;

import com.mostbet.triggerCampaign.entity.ConditionParam;
import com.mostbet.triggerCampaign.operation.conditionParam.check.common.dto.ParamCheckerRequest;
import com.mostbet.triggerCampaign.operation.conditionParam.check.common.dto.ParamCheckerResponse;

public interface CheckerInterface {

    ParamCheckerResponse behave(ParamCheckerRequest request);

    ConditionParam.ConditionParamName getParamName();
}
