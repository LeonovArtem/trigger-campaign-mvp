package com.mostbet.triggerCampaign.operation.event;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mostbet.triggerCampaign.operation.event.dto.CampaignCheckResultMessageLog;
import com.mostbet.triggerCampaign.operation.triggerCampaign.check.dto.CampaignCheckResponse;
import com.mostbet.triggerCampaign.operation.triggerCampaign.common.dto.CampaignProcessResponse;
import com.mostbet.triggerCampaign.transport.core.dto.RequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
@Slf4j
public class LoggerDecorator implements EventProcessService {
    private final EventProcessService inner;
    private final ObjectMapper objectMapper;

    @Override
    public List<CampaignProcessResponse> process(final RequestDto<? extends RequestDto.Payload> request) {
        List<CampaignProcessResponse> campaignProcessResponses = inner.process(request);
        campaignProcessResponses.forEach(
                campaignProcessResponse -> {
                    try {
                        log.info(
                                "TriggerCampaign check result: '{}'",
                                objectMapper.writeValueAsString(assembleMessage(campaignProcessResponse, request))
                        );
                    } catch (JsonProcessingException ex) {
                        log.error("Internal error: JsonProcessingException", ex);
                    }
                }
        );

        return campaignProcessResponses;
    }

    private CampaignCheckResultMessageLog assembleMessage(
            CampaignProcessResponse campaignProcessResponse,
            RequestDto<? extends RequestDto.Payload> request
    ) {
        CampaignCheckResponse campaignCheckResponse = campaignProcessResponse.getCampaignCheckResponse();

        return CampaignCheckResultMessageLog.builder()
                .userId(request.getUserId())
                .triggerCampaignId(campaignCheckResponse.getTriggerCampaignId())
                .isFulfilled(campaignCheckResponse.isFulfilled())
                .isFulfillmentLimitReached(campaignCheckResponse.isFulfillmentLimitReached())
                .event(request.getEvent())
                .build()
                ;
    }
}
