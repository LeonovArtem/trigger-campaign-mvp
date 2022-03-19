package com.mostbet.triggerCampaign.event;

import com.mostbet.triggerCampaign.BaseFunctionalTest;
import com.mostbet.triggerCampaign.entity.CouponType;
import com.mostbet.triggerCampaign.entity.Event;
import com.mostbet.triggerCampaign.event.dto.CouponParamsDto;
import com.mostbet.triggerCampaign.operation.event.EventProcessService;
import com.mostbet.triggerCampaign.operation.triggerCampaign.common.dto.CampaignProcessResponse;
import com.mostbet.triggerCampaign.transport.core.dto.RequestDto;
import com.mostbet.triggerCampaign.transport.core.dto.payload.CouponCloseRequestPayloadDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

public class EventProcessServiceTest extends BaseFunctionalTest {
    @Autowired
    private EventProcessService eventProcessServiceIml;

    @ParameterizedTest
    @MethodSource("campaignWithCouponTypeConditionProvider")
    @Sql(value = {"/fixture/campaign/with_coupon_type_condition.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void campaignWithCouponTypeCondition(CouponType couponType, boolean expectedIsFulfilledCampaign) {
        CouponParamsDto couponParamsDto = CouponParamsDto.builder().type(couponType).build();
        execute(couponParamsDto, expectedIsFulfilledCampaign);
    }

    @ParameterizedTest
    @MethodSource("campaignWithCouponMinAmountConditionProvider")
    @Sql(value = {"/fixture/campaign/with_min_amount_condition.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void campaignWithCouponMinAmountCondition(
            BigDecimal couponAmount,
            String couponCurrencyCode,
            boolean expectedIsFulfilledCampaign
    ) {
        CouponParamsDto couponParamsDto = CouponParamsDto.builder()
                .amount(couponAmount)
                .currencyCode(couponCurrencyCode)
                .build();
        execute(couponParamsDto, expectedIsFulfilledCampaign);
    }

    private void execute(CouponParamsDto couponParamsDto, boolean expectedIsFulfilledCampaign) {
        RequestDto<RequestDto.Payload> requestDto = assemblerRequest(couponParamsDto);
        List<CampaignProcessResponse> responses = eventProcessServiceIml.process(requestDto);
        Assertions.assertEquals(responses.size(), 1);
        responses.forEach(campaignProcessResponse -> {
            if (expectedIsFulfilledCampaign) {
                Assertions.assertNotNull(campaignProcessResponse.getFulfillment());
            } else {
                Assertions.assertNull(campaignProcessResponse.getFulfillment());
            }
        });
    }

    private static Stream<Arguments> campaignWithCouponTypeConditionProvider() {
        return Stream.of(
                Arguments.of(CouponType.ORDINAR, true),
                Arguments.of(CouponType.EXPRESS, false)
        );
    }

    private static Stream<Arguments> campaignWithCouponMinAmountConditionProvider() {
        return Stream.of(
                Arguments.of(BigDecimal.valueOf(200), "RUB", true),
                Arguments.of(BigDecimal.valueOf(100), "RUB", false),
                Arguments.of(BigDecimal.valueOf(10), "USD", true),
                Arguments.of(BigDecimal.valueOf(5), "USD", false),
                Arguments.of(BigDecimal.valueOf(10), "BGN", false)
        );
    }

    private static RequestDto<RequestDto.Payload> assemblerRequest(CouponParamsDto couponParamsDto) {
        CouponCloseRequestPayloadDto couponCloseRequestPayloadDto = new CouponCloseRequestPayloadDto();
        couponCloseRequestPayloadDto.setCouponId(1);
        couponCloseRequestPayloadDto.setAmount(couponParamsDto.getAmount());
        couponCloseRequestPayloadDto.setCurrencyCode(couponParamsDto.getCurrencyCode());
        couponCloseRequestPayloadDto.setCouponType(couponParamsDto.getType());

        return RequestDto
                .builder()
                .event(Event.COUPON_CLOSED)
                .eventDateTime(LocalDateTime.now().plusDays(1))
                .userId(1)
                .payload(couponCloseRequestPayloadDto)
                .build();
    }
}
