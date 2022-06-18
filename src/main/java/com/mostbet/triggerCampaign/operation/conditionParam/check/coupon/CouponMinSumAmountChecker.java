package com.mostbet.triggerCampaign.operation.conditionParam.check.coupon;

import com.mostbet.triggerCampaign.entity.ConditionParam;
import com.mostbet.triggerCampaign.entity.conditionParamValue.coupon.CouponMinAmountDto;
import com.mostbet.triggerCampaign.operation.conditionParam.check.CheckerInterface;
import com.mostbet.triggerCampaign.operation.conditionParam.check.common.dto.ParamCheckerRequest;
import com.mostbet.triggerCampaign.operation.conditionParam.check.common.dto.ParamCheckerResponse;
import com.mostbet.triggerCampaign.operation.coupon.CouponInfoService;
import com.mostbet.triggerCampaign.transport.core.dto.payload.CouponCloseRequestPayloadDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CouponMinSumAmountChecker implements CheckerInterface {
    private final CouponInfoService couponInfoService;

    @Override
    public ConditionParam.ConditionParamName getParamName() {
        return ConditionParam.ConditionParamName.COUPON_MIN_SUM_AMOUNT;
    }

    @Override
    public ParamCheckerResponse behave(ParamCheckerRequest request) {
        CouponMinAmountDto conditionCouponMinAmountDto = (CouponMinAmountDto) request.getConditionParam().getParamValue();
        CouponCloseRequestPayloadDto coupon = request.getCoupon();
        BigDecimal sumClosedCoupons = couponInfoService.getSumClosedCoupons();
        boolean isFulfilled = isCurrenciesEqual(coupon, conditionCouponMinAmountDto) &&
                isCouponAmountEqualOrGreaterConditionAmount(sumClosedCoupons, conditionCouponMinAmountDto);

        return new ParamCheckerResponse(
                isFulfilled,
                request.getConditionParam()
        );
    }

    private boolean isCurrenciesEqual(
            CouponCloseRequestPayloadDto coupon,
            CouponMinAmountDto conditionCouponMinAmountDto
    ) {
        return coupon.getCurrencyCode().equals(conditionCouponMinAmountDto.getCurrencyCode());
    }

    private boolean isCouponAmountEqualOrGreaterConditionAmount(
            BigDecimal sumClosedCoupons,
            CouponMinAmountDto conditionDto
    ) {
        return sumClosedCoupons.compareTo(conditionDto.getAmount()) >= 0;
    }
}
