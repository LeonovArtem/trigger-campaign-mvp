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

public class CouponMinAmountCheckerTest extends BaseFunctionalTest {
    @Autowired
    private EventProcessService eventProcessService;

    @Test
    @DataSet(
            value = {"/dataSet/operation/conditionParam/check/coupon/minAmount/dataset.json"},
            executeScriptsBefore = "truncate_all.sql",
            executeScriptsAfter = "truncate_all.sql"
    )
    public void whenCouponAmountEqualsConditionValue_thenCampaignIsFulfilled() {
        List<CampaignProcessResponse> responses = eventProcessService.process(
                assembleRequest(BigDecimal.valueOf(200), "RUB")
        );

        Assertions.assertEquals(responses.size(), 1);
        responses.forEach(response -> Assertions.assertNotNull(response.getFulfillment()));
    }

    @Test
    @DataSet(
            value = {"/dataSet/operation/conditionParam/check/coupon/minAmount/dataset.json"},
            executeScriptsBefore = "truncate_all.sql",
            executeScriptsAfter = "truncate_all.sql"
    )
    public void whenCouponAmountMoreThanConditionValue_thenCampaignIsFulfilled() {
        List<CampaignProcessResponse> responses = eventProcessService.process(
                assembleRequest(BigDecimal.valueOf(300), "RUB")
        );

        Assertions.assertEquals(responses.size(), 1);
        responses.forEach(response -> Assertions.assertNotNull(response.getFulfillment()));
    }

    @Test
    @DataSet(
            value = {"/dataSet/operation/conditionParam/check/coupon/minAmount/dataset.json"},
            executeScriptsBefore = "truncate_all.sql",
            executeScriptsAfter = "truncate_all.sql"
    )
    public void whenCouponAmountLessThanConditionValue_thenCampaignIsNotFulfilled() {
        List<CampaignProcessResponse> responses = eventProcessService.process(
                assembleRequest(BigDecimal.valueOf(100), "RUB")
        );

        Assertions.assertEquals(responses.size(), 1);
        responses.forEach(response -> Assertions.assertNull(response.getFulfillment()));
    }

    @Test
    @DataSet(
            value = {"/dataSet/operation/conditionParam/check/coupon/minAmount/dataset.json"},
            executeScriptsBefore = "truncate_all.sql",
            executeScriptsAfter = "truncate_all.sql"
    )
    public void whenCouponCurrencyIsNotExistInConditionParams_thenCampaignIsNotFulfilled() {
        List<CampaignProcessResponse> responses = eventProcessService.process(
                assembleRequest(BigDecimal.valueOf(100), "USD")
        );

        Assertions.assertEquals(responses.size(), 1);
        responses.forEach(response -> Assertions.assertNull(response.getFulfillment()));
    }

    private static RequestDto<RequestDto.Payload> assembleRequest(BigDecimal amount, String currencyCode) {
        CouponCloseRequestPayloadDto couponCloseRequestPayloadDto = new CouponCloseRequestPayloadDto();
        couponCloseRequestPayloadDto.setAmount(amount);
        couponCloseRequestPayloadDto.setCurrencyCode(currencyCode);

        return RequestDto
                .builder()
                .event(Event.COUPON_CLOSED)
                .eventDateTime(LocalDateTime.now())
                .payload(couponCloseRequestPayloadDto)
                .build();
    }
}
