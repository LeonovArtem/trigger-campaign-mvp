package com.mostbet.triggerCampaign.operation.event;

import com.mostbet.triggerCampaign.entity.TriggerCampaign;
import com.mostbet.triggerCampaign.operation.triggerCampaign.common.dto.CampaignProcessRequest;
import com.mostbet.triggerCampaign.operation.triggerCampaign.common.dto.CampaignProcessResponse;
import com.mostbet.triggerCampaign.operation.triggerCampaign.process.TriggerCampaignProcessService;
import com.mostbet.triggerCampaign.repository.TriggerCampaignRepository;
import com.mostbet.triggerCampaign.transport.core.dto.RequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventProcessServiceImpl implements EventProcessService {
    private final TriggerCampaignRepository campaignRepository;
    private final TriggerCampaignProcessService campaignProcessService;

    @Transactional
    public List<CampaignProcessResponse> process(final RequestDto<? extends RequestDto.Payload> request) {
        List<TriggerCampaign> campaignList = campaignRepository.findActiveTriggerCampaignByUserId(
                request.getUserId(),
                request.getEventDateTime()
        );
        List<CampaignProcessResponse> processCampaignResponses = new ArrayList<>();

        campaignList.forEach(triggerCampaign -> {
            CampaignProcessResponse responseDto = campaignProcessService.process(
                    CampaignProcessRequest
                            .builder()
                            .eventRequest(request)
                            .triggerCampaign(triggerCampaign)
                            .build()
            );
            processCampaignResponses.add(responseDto);
        });

        return processCampaignResponses;
    }
}
