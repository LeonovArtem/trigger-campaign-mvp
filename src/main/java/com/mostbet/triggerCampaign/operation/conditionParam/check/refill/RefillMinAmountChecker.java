package com.mostbet.triggerCampaign.operation.conditionParam.check.refill;

import com.mostbet.triggerCampaign.entity.ConditionParam;
import com.mostbet.triggerCampaign.operation.conditionParam.check.CheckerInterface;
import com.mostbet.triggerCampaign.operation.conditionParam.check.common.dto.ParamCheckerRequest;
import com.mostbet.triggerCampaign.operation.conditionParam.check.common.dto.ParamCheckerResponse;
import org.springframework.stereotype.Service;

@Service
public class RefillMinAmountChecker implements CheckerInterface {

    @Override
    public ConditionParam.ConditionParamName getParamName() {
        return ConditionParam.ConditionParamName.REFILL_MIN_AMOUNT;
    }

    @Override
    public ParamCheckerResponse behave(ParamCheckerRequest request) {
        // todo: нужно добавить dto refill
        boolean isFulfilled = true;

        return new ParamCheckerResponse(isFulfilled, request.getConditionParam());
    }
}
