package com.mostbet.triggerCampaign.operation.condition.check;

import com.mostbet.triggerCampaign.entity.Condition;
import com.mostbet.triggerCampaign.entity.ConditionParam;
import com.mostbet.triggerCampaign.operation.condition.check.dto.ConditionCheckRequest;
import com.mostbet.triggerCampaign.operation.condition.check.dto.ConditionCheckResponse;
import com.mostbet.triggerCampaign.operation.conditionParam.check.CheckerInterface;
import com.mostbet.triggerCampaign.operation.conditionParam.check.ParamCheckFactory;
import com.mostbet.triggerCampaign.operation.conditionParam.check.common.dto.ParamCheckerRequest;
import com.mostbet.triggerCampaign.operation.conditionParam.check.common.dto.ParamCheckerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ConditionCheckServiceImpl implements ConditionCheckService {
    private final ParamCheckFactory paramCheckFactory;

    @Override
    public ConditionCheckResponse behave(ConditionCheckRequest request) {
        List<ParamCheckerResponse> paramCheckerResponseList = new ArrayList<>();
        Condition condition = request.getCondition();

        boolean isFulfilled = areAllParamsFulfilled(request, condition, paramCheckerResponseList);

        return new ConditionCheckResponse(isFulfilled, request.getCondition(), paramCheckerResponseList);
    }

    private boolean areAllParamsFulfilled(
            ConditionCheckRequest request,
            Condition condition,
            List<ParamCheckerResponse> paramCheckerResponseList
    ) {
        Map<ConditionParam.ConditionParamName, List<ConditionParam>> groupedConditionParams = condition
                .getParams()
                .stream()
                .collect(Collectors.groupingBy(ConditionParam::getName, Collectors.toList()));

        boolean isFulfilled = true;
        for (Map.Entry<ConditionParam.ConditionParamName, List<ConditionParam>> entry : groupedConditionParams.entrySet()) {
            ConditionParam.ConditionParamName conditionParamName = entry.getKey();
            List<ConditionParam> paramsGroup = entry.getValue();
            if (!isParamsGroupFulfilled(paramsGroup, conditionParamName, request, paramCheckerResponseList)) {
                isFulfilled = false;
                break;
            }
        }

        return isFulfilled;
    }

    private boolean isParamsGroupFulfilled(
            List<ConditionParam> paramsGroup,
            ConditionParam.ConditionParamName conditionParamName,
            ConditionCheckRequest request,
            List<ParamCheckerResponse> paramCheckerResponseList
    ) {
        CheckerInterface paramChecker = paramCheckFactory.create(conditionParamName);

        boolean isFulfilled = false;
        for (ConditionParam conditionParam : paramsGroup) {
            ParamCheckerResponse paramCheckerResponse = paramChecker.behave(
                    new ParamCheckerRequest(conditionParam, request.getEntitySet())
            );
            paramCheckerResponseList.add(paramCheckerResponse);

            if (paramCheckerResponse.isFulfilled()) {
                isFulfilled = true;
                break;
            }
        }

        return isFulfilled;
    }
}
