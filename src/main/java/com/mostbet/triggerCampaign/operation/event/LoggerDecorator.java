package com.mostbet.triggerCampaign.operation.event;

import com.mostbet.triggerCampaign.operation.event.dto.CampaignCheckResultMessageLog;
import com.mostbet.triggerCampaign.operation.triggerCampaign.check.dto.CampaignCheckResponse;
import com.mostbet.triggerCampaign.operation.triggerCampaign.common.dto.CampaignProcessResponse;
import com.mostbet.triggerCampaign.transport.core.dto.RequestDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
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
        CampaignCheckResultMessageLog message = new CampaignCheckResultMessageLog();

        CampaignCheckResponse campaignCheckResponse = campaignProcessResponse.getCampaignCheckResponse();
        message.setUserId(request.getUserId());
        message.setTriggerCampaignId(campaignCheckResponse.getTriggerCampaignId());
        message.setFulfilled(campaignCheckResponse.isFulfilled());
        message.setFulfillmentLimitReached(campaignCheckResponse.isFulfillmentLimitReached());
        message.setEvent(request.getEvent());

        return message;
    }
}
