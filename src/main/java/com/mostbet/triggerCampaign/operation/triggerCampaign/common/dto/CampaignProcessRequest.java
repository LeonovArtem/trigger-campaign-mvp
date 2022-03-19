package com.mostbet.triggerCampaign.operation.triggerCampaign.common.dto;

import com.mostbet.triggerCampaign.entity.TriggerCampaign;
import com.mostbet.triggerCampaign.transport.core.dto.RequestDto;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CampaignProcessRequest {

    private TriggerCampaign triggerCampaign;

    private RequestDto<? extends RequestDto.Payload> eventRequest;
}
