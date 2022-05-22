package com.mostbet.triggerCampaign.operation.conditionParam.check.refill;

import com.mostbet.triggerCampaign.entity.ConditionParam;
import com.mostbet.triggerCampaign.entity.conditionParamValue.refill.RefillMinAmountDto;
import com.mostbet.triggerCampaign.operation.conditionParam.check.CheckerInterface;
import com.mostbet.triggerCampaign.operation.conditionParam.check.common.dto.ParamCheckerRequest;
import com.mostbet.triggerCampaign.operation.conditionParam.check.common.dto.ParamCheckerResponse;
import com.mostbet.triggerCampaign.transport.core.dto.payload.RefillSuccessRequestPayloadDto;
import org.springframework.stereotype.Service;

@Service
public class RefillMinAmountChecker implements CheckerInterface {

    @Override
    public ConditionParam.ConditionParamName getParamName() {
        return ConditionParam.ConditionParamName.REFILL_MIN_AMOUNT;
    }

    @Override
    public ParamCheckerResponse behave(ParamCheckerRequest request) {
        RefillMinAmountDto conditionRefillMinAmountDto = (RefillMinAmountDto) request.getConditionParam().getParamValue();
        RefillSuccessRequestPayloadDto refill = request.getRefill();
        boolean isFulfilled = isCurrenciesEqual(refill, conditionRefillMinAmountDto) &&
                isCouponAmountEqualOrGreaterConditionAmount(refill, conditionRefillMinAmountDto);

        return new ParamCheckerResponse(
                isFulfilled,
                request.getConditionParam()
        );
    }

    private boolean isCurrenciesEqual(
            RefillSuccessRequestPayloadDto refill,
            RefillMinAmountDto conditionRefillMinAmountDto
    ) {
        return refill.getCurrencyCode().equals(conditionRefillMinAmountDto.getCurrencyCode());
    }

    private boolean isCouponAmountEqualOrGreaterConditionAmount(
            RefillSuccessRequestPayloadDto refill,
            RefillMinAmountDto conditionRefillMinAmountDto
    ) {
        return refill.getAmount().compareTo(conditionRefillMinAmountDto.getAmount()) >= 0;
    }
}
