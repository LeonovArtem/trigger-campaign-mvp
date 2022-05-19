package com.mostbet.triggerCampaign.operation.conditionParam.check.coupon;

import com.mostbet.triggerCampaign.entity.ConditionParam;
import com.mostbet.triggerCampaign.entity.CouponStatus;
import com.mostbet.triggerCampaign.entity.conditionParamValue.coupon.CouponStatusDto;
import com.mostbet.triggerCampaign.operation.conditionParam.check.CheckerInterface;
import com.mostbet.triggerCampaign.operation.conditionParam.check.common.dto.ParamCheckerRequest;
import com.mostbet.triggerCampaign.operation.conditionParam.check.common.dto.ParamCheckerResponse;
import org.springframework.stereotype.Service;

@Service
public class CouponStatusChecker implements CheckerInterface {

    @Override
    public ConditionParam.ConditionParamName getParamName() {
        return ConditionParam.ConditionParamName.COUPON_STATUS;
    }

    @Override
    public ParamCheckerResponse behave(ParamCheckerRequest request) {
        CouponStatusDto conditionCouponStatus = (CouponStatusDto) request.getConditionParam().getParamValue();
        CouponStatus couponStatus = request.getCoupon().getCouponStatus();

        boolean isFulfilled = conditionCouponStatus.getCouponStatus().equals(couponStatus);

        return new ParamCheckerResponse(
                isFulfilled,
                request.getConditionParam()
        );
    }
}
