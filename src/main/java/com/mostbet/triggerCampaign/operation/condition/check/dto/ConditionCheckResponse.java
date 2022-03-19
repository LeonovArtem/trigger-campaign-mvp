package com.mostbet.triggerCampaign.operation.condition.check.dto;

import com.mostbet.triggerCampaign.entity.Condition;
import com.mostbet.triggerCampaign.operation.conditionParam.check.common.dto.ParamCheckerResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ConditionCheckResponse {

    private boolean isFulfilled;

    private Condition condition;

    private List<ParamCheckerResponse> paramCheckerResponseList;
}
