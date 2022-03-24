package com.mostbet.triggerCampaign.event;

import com.github.database.rider.core.api.dataset.DataSet;
import com.mostbet.triggerCampaign.BaseFunctionalTest;
import com.mostbet.triggerCampaign.entity.Event;
import com.mostbet.triggerCampaign.event.dto.CouponParamsDto;
import com.mostbet.triggerCampaign.operation.event.EventProcessService;
import com.mostbet.triggerCampaign.operation.triggerCampaign.common.dto.CampaignProcessResponse;
import com.mostbet.triggerCampaign.transport.core.dto.RequestDto;
import com.mostbet.triggerCampaign.transport.core.dto.payload.CouponCloseRequestPayloadDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

public class MaxFulfilmentCountForUserTest extends BaseFunctionalTest {
    @Autowired
    private EventProcessService eventProcessService;

    @ParameterizedTest
    @MethodSource("provideMaxFulfillmentCountAndExpectedIsFulfilledCampaign")
    @Sql(value = {"/fixture/campaign/with_min_amount_condition.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    private void execute(int triggerCampaignMaxFulfillmentCount, boolean expectedIsFulfilledCampaign) {
        RequestDto<RequestDto.Payload> requestDto = assemblerRequest();
        List<CampaignProcessResponse> responses = eventProcessService.process(requestDto);
        Assertions.assertEquals(responses.size(), 1);

        responses.forEach(campaignProcessResponse -> {
            if (expectedIsFulfilledCampaign) {
                Assertions.assertNotNull(campaignProcessResponse.getFulfillment());
            } else {
                Assertions.assertNull(campaignProcessResponse.getFulfillment());
            }
        });
    }


    @Test
    @DataSet(
            value = {"/dataSet/eventProcess/dataset.json"},
            executeScriptsBefore = "truncate_all.sql",
            executeScriptsAfter = "truncate_all.sql"
    )
    public void whenCampaignHasNotFulfilled() {
        RequestDto<RequestDto.Payload> requestDto = assemblerRequest();
        List<CampaignProcessResponse> responses = eventProcessService.process(requestDto);
        Assertions.assertEquals(responses.size(), 1);

//        responses.forEach(campaignProcessResponse -> {
//            if (expectedIsFulfilledCampaign) {
//                Assertions.assertNotNull(campaignProcessResponse.getFulfillment());
//            } else {
//                Assertions.assertNull(campaignProcessResponse.getFulfillment());
//            }
//        });
    }

    private static Stream<Arguments> provideMaxFulfillmentCountAndExpectedIsFulfilledCampaign() {
        return Stream.of(
                Arguments.of(2, false),
                Arguments.of(1, true)
        );
    }

    private static RequestDto<RequestDto.Payload> assemblerRequest() {
        CouponCloseRequestPayloadDto couponCloseRequestPayloadDto = new CouponCloseRequestPayloadDto();
        couponCloseRequestPayloadDto.setCouponId(1);
        couponCloseRequestPayloadDto.setAmount(BigDecimal.valueOf(200));
        couponCloseRequestPayloadDto.setCurrencyCode("RUB");

        return RequestDto
                .builder()
                .event(Event.COUPON_CLOSED)
                .eventDateTime(LocalDateTime.now().plusDays(1))
                .userId(1)
                .payload(couponCloseRequestPayloadDto)
                .build();
    }
}
