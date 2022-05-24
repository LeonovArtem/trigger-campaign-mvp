package com.mostbet.triggerCampaign.operation.conditionParam.check.coupon;

import com.github.database.rider.core.api.dataset.DataSet;
import com.mostbet.triggerCampaign.BaseFunctionalTest;
import com.mostbet.triggerCampaign.entity.Event;
import com.mostbet.triggerCampaign.operation.coupon.CouponInfoService;
import com.mostbet.triggerCampaign.operation.event.EventProcessService;
import com.mostbet.triggerCampaign.operation.triggerCampaign.common.dto.CampaignProcessResponse;
import com.mostbet.triggerCampaign.transport.core.dto.RequestDto;
import com.mostbet.triggerCampaign.transport.core.dto.payload.CouponCloseRequestPayloadDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

//@Disabled
public class CouponMinSumAmountCheckerTest extends BaseFunctionalTest {
    @Autowired
    private EventProcessService eventProcessService;

    @MockBean
    private CouponInfoService couponInfoService;

    @Test
    @DataSet(
            value = {"/dataSet/operation/conditionParam/check/coupon/minSumAmount/dataset.json"},
            executeScriptsBefore = "truncate_all.sql",
            executeScriptsAfter = "truncate_all.sql"
    )
    public void whenSumCouponsEqualsConditionValue_thenCampaignIsFulfilled() {
        BigDecimal sumClosedCoupons = BigDecimal.valueOf(200);
        Mockito.doReturn(sumClosedCoupons).when(couponInfoService).getSumClosedCoupons();

        List<CampaignProcessResponse> responses = eventProcessService.process(assembleRequest("RUB"));

        Assertions.assertEquals(responses.size(), 1);
        responses.forEach(response -> Assertions.assertNotNull(response.getFulfillment()));
    }

    @Test
    @DataSet(
            value = {"/dataSet/operation/conditionParam/check/coupon/minSumAmount/dataset.json"},
            executeScriptsBefore = "truncate_all.sql",
            executeScriptsAfter = "truncate_all.sql"
    )
    public void whenSumCouponsMoreThanConditionValue_thenCampaignIsFulfilled() {
        BigDecimal sumClosedCoupons = BigDecimal.valueOf(300);
        Mockito.doReturn(sumClosedCoupons).when(couponInfoService).getSumClosedCoupons();

        List<CampaignProcessResponse> responses = eventProcessService.process(assembleRequest("RUB"));

        Assertions.assertEquals(responses.size(), 1);
        responses.forEach(response -> Assertions.assertNotNull(response.getFulfillment()));
    }

    @Test
    @DataSet(
            value = {"/dataSet/operation/conditionParam/check/coupon/minSumAmount/dataset.json"},
            executeScriptsBefore = "truncate_all.sql",
            executeScriptsAfter = "truncate_all.sql"
    )
    public void whenSumCouponsLessThanConditionValue_thenCampaignIsNotFulfilled() {
        BigDecimal sumClosedCoupons = BigDecimal.valueOf(100);
        Mockito.doReturn(sumClosedCoupons).when(couponInfoService).getSumClosedCoupons();

        List<CampaignProcessResponse> responses = eventProcessService.process(assembleRequest("RUB"));

        Assertions.assertEquals(responses.size(), 1);
        responses.forEach(response -> Assertions.assertNull(response.getFulfillment()));
    }

    @Test
    @DataSet(
            value = {"/dataSet/operation/conditionParam/check/coupon/minSumAmount/dataset.json"},
            executeScriptsBefore = "truncate_all.sql",
            executeScriptsAfter = "truncate_all.sql"
    )
    public void whenUserCurrencyIsNotExistInConditionParams_thenCampaignIsNotFulfilled() {
        BigDecimal sumClosedCoupons = BigDecimal.valueOf(300);
        Mockito.doReturn(sumClosedCoupons).when(couponInfoService).getSumClosedCoupons();

        List<CampaignProcessResponse> responses = eventProcessService.process(assembleRequest("USD"));

        Assertions.assertEquals(responses.size(), 1);
        responses.forEach(response -> Assertions.assertNull(response.getFulfillment()));
    }

    private static RequestDto<RequestDto.Payload> assembleRequest(String currencyCode) {
        CouponCloseRequestPayloadDto couponCloseRequestPayloadDto = new CouponCloseRequestPayloadDto();
        couponCloseRequestPayloadDto.setCurrencyCode(currencyCode);

        return RequestDto
                .builder()
                .event(Event.COUPON_CLOSED)
                .eventDateTime(LocalDateTime.now())
                .payload(couponCloseRequestPayloadDto)
                .build();
    }
}
