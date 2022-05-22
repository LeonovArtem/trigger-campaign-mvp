package com.mostbet.triggerCampaign.operation.conditionParam.check.refill;

import com.github.database.rider.core.api.dataset.DataSet;
import com.mostbet.triggerCampaign.BaseFunctionalTest;
import com.mostbet.triggerCampaign.entity.Event;
import com.mostbet.triggerCampaign.operation.event.EventProcessService;
import com.mostbet.triggerCampaign.operation.triggerCampaign.common.dto.CampaignProcessResponse;
import com.mostbet.triggerCampaign.transport.core.dto.RequestDto;
import com.mostbet.triggerCampaign.transport.core.dto.payload.RefillSuccessRequestPayloadDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class RefillMinAmountCheckerTest extends BaseFunctionalTest {
    @Autowired
    private EventProcessService eventProcessService;

    @Test
    @DataSet(
            value = {"/dataSet/operation/conditionParam/check/refill/minAmount/dataset.json"},
            executeScriptsBefore = "truncate_all.sql",
            executeScriptsAfter = "truncate_all.sql"
    )
    public void whenRefillAmountEqualsConditionValue_thenCampaignIsFulfilled() {
        List<CampaignProcessResponse> responses = eventProcessService.process(
                assembleRequest(BigDecimal.valueOf(200), "RUB")
        );

        Assertions.assertEquals(responses.size(), 1);
        responses.forEach(response -> Assertions.assertNotNull(response.getFulfillment()));
    }

    @Test
    @DataSet(
            value = {"/dataSet/operation/conditionParam/check/refill/minAmount/dataset.json"},
            executeScriptsBefore = "truncate_all.sql",
            executeScriptsAfter = "truncate_all.sql"
    )
    public void whenRefillAmountMoreThanConditionValue_thenCampaignIsFulfilled() {
        List<CampaignProcessResponse> responses = eventProcessService.process(
                assembleRequest(BigDecimal.valueOf(300), "RUB")
        );

        Assertions.assertEquals(responses.size(), 1);
        responses.forEach(response -> Assertions.assertNotNull(response.getFulfillment()));
    }

    @Test
    @DataSet(
            value = {"/dataSet/operation/conditionParam/check/refill/minAmount/dataset.json"},
            executeScriptsBefore = "truncate_all.sql",
            executeScriptsAfter = "truncate_all.sql"
    )
    public void whenRefillAmountLessThanConditionValue_thenCampaignIsNotFulfilled() {
        List<CampaignProcessResponse> responses = eventProcessService.process(
                assembleRequest(BigDecimal.valueOf(100), "RUB")
        );

        Assertions.assertEquals(responses.size(), 1);
        responses.forEach(response -> Assertions.assertNull(response.getFulfillment()));
    }

    @Test
    @DataSet(
            value = {"/dataSet/operation/conditionParam/check/refill/minAmount/dataset.json"},
            executeScriptsBefore = "truncate_all.sql",
            executeScriptsAfter = "truncate_all.sql"
    )
    public void whenRefillCurrencyIsNotExistInConditionParams_thenCampaignIsNotFulfilled() {
        List<CampaignProcessResponse> responses = eventProcessService.process(
                assembleRequest(BigDecimal.valueOf(100), "USD")
        );

        Assertions.assertEquals(responses.size(), 1);
        responses.forEach(response -> Assertions.assertNull(response.getFulfillment()));
    }

    private static RequestDto<RequestDto.Payload> assembleRequest(BigDecimal amount, String currencyCode) {
        RefillSuccessRequestPayloadDto refillRequestPayloadDto = new RefillSuccessRequestPayloadDto();
        refillRequestPayloadDto.setAmount(amount);
        refillRequestPayloadDto.setCurrencyCode(currencyCode);

        return RequestDto
                .builder()
                .event(Event.REFILL_SUCCEEDED)
                .eventDateTime(LocalDateTime.now())
                .payload(refillRequestPayloadDto)
                .build();
    }
}
