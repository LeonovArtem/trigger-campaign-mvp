package com.mostbet.triggerCampaign.event;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.database.rider.core.api.dataset.DataSet;
import com.mostbet.triggerCampaign.BaseFunctionalTest;
import com.mostbet.triggerCampaign.entity.TriggerCampaign;
import com.mostbet.triggerCampaign.operation.event.EventProcessService;
import com.mostbet.triggerCampaign.operation.triggerCampaign.common.dto.CampaignProcessResponse;
import com.mostbet.triggerCampaign.repository.TriggerCampaignRepository;
import com.mostbet.triggerCampaign.transport.core.dto.RequestDto;
import com.mostbet.triggerCampaign.transport.core.dto.payload.CouponCloseRequestPayloadDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;

import java.util.List;

public class CampaignMaxFulfilmentCountForUserTest extends BaseFunctionalTest {
    @Autowired
    private EventProcessService eventProcessService;

    @Autowired
    private TriggerCampaignRepository campaignRepository;

    @Test
    @DataSet(
            value = {"/dataSet/eventProcess/campaign/onMaxFulfilmentCountForUser/dataset.json"},
            executeScriptsBefore = "truncate_all.sql",
            executeScriptsAfter = "truncate_all.sql"
    )
    public void whenMaxFulfillmentCountMoreThenOne() throws Exception {
        TriggerCampaign triggerCampaign = campaignRepository.findById(1).orElseThrow();
        if (null == triggerCampaign.getMaxFulfillmentCount()) {
            throw new Exception("Campaign MaxFulfillmentCount can not be NULL");
        }

        int campaignMaxFulfillmentCount = triggerCampaign.getMaxFulfillmentCount();
        final RequestDto<CouponCloseRequestPayloadDto> requestDto = getCouponCloseRequestPayloadDto();
        while (campaignMaxFulfillmentCount != 0) {
            --campaignMaxFulfillmentCount;

            List<CampaignProcessResponse> responses = eventProcessService.process(requestDto);
            assertCampaignIsFulfilledForUser(responses);
        }

        List<CampaignProcessResponse> responses = eventProcessService.process(requestDto);
        assertCampaignIsNotFulfilledForUser(responses);
    }

    @Test
    @DataSet(
            value = {"/dataSet/eventProcess/campaign/onMaxFulfilmentCountForUser/dataset_empty_max_fulfillment_count.json"},
            executeScriptsBefore = "truncate_all.sql",
            executeScriptsAfter = "truncate_all.sql"
    )
    public void whenMaxFulfillmentCountIsNotSet() throws Exception {
        final RequestDto<CouponCloseRequestPayloadDto> requestDto = getCouponCloseRequestPayloadDto();
        List<CampaignProcessResponse> responses = eventProcessService.process(requestDto);
        assertCampaignIsNotFulfilledForUser(responses);
    }

    private void assertCampaignIsFulfilledForUser(List<CampaignProcessResponse> responses) {
        Assertions.assertEquals(responses.size(), 1);
        responses.forEach(campaignProcessResponse -> {
            Assertions.assertNotNull(campaignProcessResponse.getFulfillment());
        });
    }

    private void assertCampaignIsNotFulfilledForUser(List<CampaignProcessResponse> responses) {
        Assertions.assertEquals(responses.size(), 1);
        responses.forEach(campaignProcessResponse -> {
            Assertions.assertNull(campaignProcessResponse.getFulfillment());
        });
    }

    private RequestDto<CouponCloseRequestPayloadDto> getCouponCloseRequestPayloadDto() throws Exception {
        return objectMapper.readValue(
                ResourceUtils.getFile(
                        "classpath:dataSet/eventProcess/campaign/onMaxFulfilmentCountForUser/request/coupon-closed-content.json"
                ),
                new TypeReference<RequestDto<CouponCloseRequestPayloadDto>>() {
                }
        );
    }
}
