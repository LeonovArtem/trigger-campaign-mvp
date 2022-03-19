package com.mostbet.triggerCampaign.operation.event;

import com.mostbet.triggerCampaign.operation.triggerCampaign.common.dto.CampaignProcessResponse;
import com.mostbet.triggerCampaign.transport.core.dto.RequestDto;

import java.util.List;

public interface EventProcessService {
    List<CampaignProcessResponse> process(final RequestDto<? extends RequestDto.Payload> request);
}
