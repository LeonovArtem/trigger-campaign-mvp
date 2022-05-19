package com.mostbet.triggerCampaign.operation.conditionParam.check.coupon;

import com.mostbet.triggerCampaign.entity.ConditionParam;
import com.mostbet.triggerCampaign.entity.conditionParamValue.coupon.CouponMinCoefficientDto;
import com.mostbet.triggerCampaign.operation.conditionParam.check.CheckerInterface;
import com.mostbet.triggerCampaign.operation.conditionParam.check.common.dto.ParamCheckerRequest;
import com.mostbet.triggerCampaign.operation.conditionParam.check.common.dto.ParamCheckerResponse;
import com.mostbet.triggerCampaign.transport.core.dto.payload.CouponCloseRequestPayloadDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CouponMinCoefficientChecker implements CheckerInterface {

    @Override
    public ConditionParam.ConditionParamName getParamName() {
        return ConditionParam.ConditionParamName.COUPON_MIN_COEFFICIENT;
    }

    @Override
    public ParamCheckerResponse behave(ParamCheckerRequest request) {
        CouponMinCoefficientDto conditionCouponMinAmountDto = (CouponMinCoefficientDto) request.getConditionParam().getParamValue();
        CouponCloseRequestPayloadDto coupon = request.getCoupon();
        BigDecimal couponCoefficient = coupon.getCoefficient();
        boolean isFulfilled = couponCoefficient.compareTo(conditionCouponMinAmountDto.getCoefficient()) >= 0;

        return new ParamCheckerResponse(
                isFulfilled,
                request.getConditionParam()
        );
    }
}