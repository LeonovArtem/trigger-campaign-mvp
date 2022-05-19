package com.mostbet.triggerCampaign.operation.conditionParam.check.common.dto;

import com.mostbet.triggerCampaign.entity.ConditionParam;
import com.mostbet.triggerCampaign.operation.triggerCampaign.common.dto.CampaignProcessRequest;
import com.mostbet.triggerCampaign.transport.core.dto.payload.CouponCloseRequestPayloadDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ParamCheckerRequest {

    private ConditionParam conditionParam;

    private CampaignProcessRequest entitySet;

    public CouponCloseRequestPayloadDto getCoupon() {
        return (CouponCloseRequestPayloadDto) getEntitySet().getEventRequest().getPayload();
    }
}
