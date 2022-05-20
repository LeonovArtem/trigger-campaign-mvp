package com.mostbet.triggerCampaign.operation.conditionParam.check.coupon;

import com.mostbet.triggerCampaign.entity.ConditionParam;
import com.mostbet.triggerCampaign.entity.CouponType;
import com.mostbet.triggerCampaign.entity.conditionParamValue.coupon.CouponTypeDto;
import com.mostbet.triggerCampaign.operation.conditionParam.check.CheckerInterface;
import com.mostbet.triggerCampaign.operation.conditionParam.check.common.dto.ParamCheckerRequest;
import com.mostbet.triggerCampaign.operation.conditionParam.check.common.dto.ParamCheckerResponse;
import org.springframework.stereotype.Service;

@Service
public class CouponTypeChecker implements CheckerInterface {

    @Override
    public ConditionParam.ConditionParamName getParamName() {
        return ConditionParam.ConditionParamName.COUPON_TYPE;
    }

    @Override
    public ParamCheckerResponse behave(ParamCheckerRequest request) {
        CouponTypeDto conditionCouponType = (CouponTypeDto) request.getConditionParam().getParamValue();
        CouponType couponType = request.getCoupon().getCouponType();

        boolean isFulfilled = conditionCouponType.getCouponType().equals(couponType);

        return new ParamCheckerResponse(
                isFulfilled,
                request.getConditionParam()
        );
    }
}
