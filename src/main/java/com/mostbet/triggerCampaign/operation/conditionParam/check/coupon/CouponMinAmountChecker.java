package com.mostbet.triggerCampaign.operation.conditionParam.check.coupon;

import com.mostbet.triggerCampaign.entity.ConditionParam;
import com.mostbet.triggerCampaign.entity.conditionParamValue.CouponMinAmount;
import com.mostbet.triggerCampaign.operation.conditionParam.check.CheckerInterface;
import com.mostbet.triggerCampaign.operation.conditionParam.check.common.dto.ParamCheckerRequest;
import com.mostbet.triggerCampaign.operation.conditionParam.check.common.dto.ParamCheckerResponse;
import com.mostbet.triggerCampaign.transport.core.dto.payload.CouponCloseRequestPayloadDto;
import org.springframework.stereotype.Service;

@Service
public class CouponMinAmountChecker implements CheckerInterface {

    @Override
    public ConditionParam.ConditionParamName getParamName() {
        return ConditionParam.ConditionParamName.COUPON_MIN_AMOUNT;
    }

    @Override
    public ParamCheckerResponse behave(ParamCheckerRequest request) {
        CouponMinAmount conditionCouponMinAmount = (CouponMinAmount) request.getConditionParam().getValue();
        CouponCloseRequestPayloadDto coupon = getCoupon(request);
        boolean isFulfilled = isCurrenciesEqual(coupon, conditionCouponMinAmount) &&
                              isAmountsEqual(coupon, conditionCouponMinAmount);

        return new ParamCheckerResponse(
                isFulfilled,
                request.getConditionParam()
        );
    }

    private CouponCloseRequestPayloadDto getCoupon(ParamCheckerRequest request) {
        return (CouponCloseRequestPayloadDto) request
                .getEntitySet()
                .getEventRequest().getPayload();
    }

    private boolean isCurrenciesEqual(CouponCloseRequestPayloadDto coupon, CouponMinAmount conditionCouponMinAmount) {
        return coupon.getCurrencyCode().equals(conditionCouponMinAmount.getCurrencyCode());
    }

    private boolean isAmountsEqual(CouponCloseRequestPayloadDto coupon, CouponMinAmount conditionCouponMinAmount) {
        return coupon.getAmount().compareTo(conditionCouponMinAmount.getAmount()) >= 0;
    }
}
