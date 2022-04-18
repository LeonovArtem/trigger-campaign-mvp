package com.mostbet.triggerCampaign.operation.conditionParam.check.coupon;

import com.mostbet.triggerCampaign.entity.ConditionParam;
import com.mostbet.triggerCampaign.entity.CouponType;
import com.mostbet.triggerCampaign.entity.conditionParamValue.coupon.CouponTypeDto;
import com.mostbet.triggerCampaign.operation.conditionParam.check.CheckerInterface;
import com.mostbet.triggerCampaign.operation.conditionParam.check.common.dto.ParamCheckerRequest;
import com.mostbet.triggerCampaign.operation.conditionParam.check.common.dto.ParamCheckerResponse;
import com.mostbet.triggerCampaign.transport.core.dto.payload.CouponCloseRequestPayloadDto;
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
        CouponType couponType = getCouponType(request);

        boolean isFulfilled = conditionCouponType.getCouponType().equals(couponType);

        return new ParamCheckerResponse(
                isFulfilled,
                request.getConditionParam()
        );
    }

    private CouponType getCouponType(ParamCheckerRequest request){
        CouponCloseRequestPayloadDto payload = (CouponCloseRequestPayloadDto) request
                .getEntitySet()
                .getEventRequest().getPayload();

        return payload.getCouponType();
    }
}
