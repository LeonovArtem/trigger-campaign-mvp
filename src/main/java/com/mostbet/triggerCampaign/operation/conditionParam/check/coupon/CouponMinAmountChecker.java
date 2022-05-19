package com.mostbet.triggerCampaign.operation.conditionParam.check.coupon;

import com.mostbet.triggerCampaign.entity.ConditionParam;
import com.mostbet.triggerCampaign.entity.conditionParamValue.coupon.CouponMinAmountDto;
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
        CouponMinAmountDto conditionCouponMinAmountDto = (CouponMinAmountDto) request.getConditionParam().getParamValue();
        CouponCloseRequestPayloadDto coupon = request.getCoupon();
        boolean isFulfilled = isCurrenciesEqual(coupon, conditionCouponMinAmountDto) &&
                              isCouponAmountEqualOrGreaterConditionAmount(coupon, conditionCouponMinAmountDto);

        return new ParamCheckerResponse(
                isFulfilled,
                request.getConditionParam()
        );
    }

    private boolean isCurrenciesEqual(CouponCloseRequestPayloadDto coupon, CouponMinAmountDto conditionCouponMinAmountDto) {
        return coupon.getCurrencyCode().equals(conditionCouponMinAmountDto.getCurrencyCode());
    }

    private boolean isCouponAmountEqualOrGreaterConditionAmount(CouponCloseRequestPayloadDto coupon, CouponMinAmountDto conditionCouponMinAmountDto) {
        return coupon.getAmount().compareTo(conditionCouponMinAmountDto.getAmount()) >= 0;
    }
}
