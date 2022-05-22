package com.mostbet.triggerCampaign.operation.conditionParam.check.coupon;

import com.github.database.rider.core.api.dataset.DataSet;
import com.mostbet.triggerCampaign.BaseFunctionalTest;
import com.mostbet.triggerCampaign.entity.Event;
import com.mostbet.triggerCampaign.operation.event.EventProcessService;
import com.mostbet.triggerCampaign.operation.triggerCampaign.common.dto.CampaignProcessResponse;
import com.mostbet.triggerCampaign.transport.core.dto.RequestDto;
import com.mostbet.triggerCampaign.transport.core.dto.payload.CouponCloseRequestPayloadDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class CouponMinCoefficientCheckerTest extends BaseFunctionalTest {
    @Autowired
    private EventProcessService eventProcessService;

    @Test
    @DataSet(
            value = {"/dataSet/operation/conditionParam/check/coupon/minCoefficient/dataset.json"},
            executeScriptsBefore = "truncate_all.sql",
            executeScriptsAfter = "truncate_all.sql"
    )
    public void whenCouponCoefficientEqualsConditionValue_thenCampaignIsFulfilled() {
        List<CampaignProcessResponse> responses = eventProcessService.process(
                assembleRequest(BigDecimal.valueOf(2.25))
        );

        Assertions.assertEquals(responses.size(), 1);
        responses.forEach(response -> Assertions.assertNotNull(response.getFulfillment()));
    }

    @Test
    @DataSet(
            value = {"/dataSet/operation/conditionParam/check/coupon/minCoefficient/dataset.json"},
            executeScriptsBefore = "truncate_all.sql",
            executeScriptsAfter = "truncate_all.sql"
    )
    public void whenCouponCoefficientMoreThanConditionValue_thenCampaignIsFulfilled() {
        List<CampaignProcessResponse> responses = eventProcessService.process(
                assembleRequest(BigDecimal.valueOf(2.26))
        );

        Assertions.assertEquals(responses.size(), 1);
        responses.forEach(response -> Assertions.assertNotNull(response.getFulfillment()));
    }

    @Test
    @DataSet(
            value = {"/dataSet/operation/conditionParam/check/coupon/minCoefficient/dataset.json"},
            executeScriptsBefore = "truncate_all.sql",
            executeScriptsAfter = "truncate_all.sql"
    )
    public void whenCouponCoefficientLessThanConditionValue_thenCampaignIsNotFulfilled() {
        List<CampaignProcessResponse> responses = eventProcessService.process(
                assembleRequest(BigDecimal.valueOf(2.24))
        );

        Assertions.assertEquals(responses.size(), 1);
        responses.forEach(response -> Assertions.assertNull(response.getFulfillment()));
    }

    private static RequestDto<RequestDto.Payload> assembleRequest(BigDecimal coefficient) {
        CouponCloseRequestPayloadDto couponCloseRequestPayloadDto = new CouponCloseRequestPayloadDto();
        couponCloseRequestPayloadDto.setCoefficient(coefficient);

        return RequestDto
                .builder()
                .event(Event.COUPON_CLOSED)
                .eventDateTime(LocalDateTime.now())
                .payload(couponCloseRequestPayloadDto)
                .build();
    }
}
