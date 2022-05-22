package com.mostbet.triggerCampaign.operation.conditionParam.check.coupon;

import com.github.database.rider.core.api.dataset.DataSet;
import com.mostbet.triggerCampaign.BaseFunctionalTest;
import com.mostbet.triggerCampaign.entity.CouponStatus;
import com.mostbet.triggerCampaign.entity.Event;
import com.mostbet.triggerCampaign.operation.event.EventProcessService;
import com.mostbet.triggerCampaign.operation.triggerCampaign.common.dto.CampaignProcessResponse;
import com.mostbet.triggerCampaign.transport.core.dto.RequestDto;
import com.mostbet.triggerCampaign.transport.core.dto.payload.CouponCloseRequestPayloadDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

class CouponStatusCheckerTest extends BaseFunctionalTest {
    @Autowired
    private EventProcessService eventProcessService;

    @Test
    @DataSet(
            value = {"/dataSet/operation/conditionParam/check/coupon/status/dataset.json"},
            executeScriptsBefore = "truncate_all.sql",
            executeScriptsAfter = "truncate_all.sql"
    )
    public void whenConditionStatusEqualsCouponStatus_thenCampaignIsFulfilled() {
        List<CampaignProcessResponse> responses = eventProcessService.process(
                assembleRequest(CouponStatus.WIN)
        );

        Assertions.assertEquals(responses.size(), 1);
        responses.forEach(response -> Assertions.assertNotNull(response.getFulfillment()));
    }

    @Test
    @DataSet(
            value = {"/dataSet/operation/conditionParam/check/coupon/status/dataset.json"},
            executeScriptsBefore = "truncate_all.sql",
            executeScriptsAfter = "truncate_all.sql"
    )
    public void whenConditionStatusIsNotEqualsCouponStatus_thenCampaignIsNotFulfilled() {
        List<CampaignProcessResponse> responses = eventProcessService.process(
                assembleRequest(CouponStatus.LOSE)
        );

        Assertions.assertEquals(responses.size(), 1);
        responses.forEach(response -> Assertions.assertNull(response.getFulfillment()));
    }

    private static RequestDto<RequestDto.Payload> assembleRequest(CouponStatus couponStatus) {
        CouponCloseRequestPayloadDto couponCloseRequestPayloadDto = new CouponCloseRequestPayloadDto();
        couponCloseRequestPayloadDto.setCouponStatus(couponStatus);

        return RequestDto
                .builder()
                .event(Event.COUPON_CLOSED)
                .eventDateTime(LocalDateTime.now())
                .payload(couponCloseRequestPayloadDto)
                .build();
    }
}
