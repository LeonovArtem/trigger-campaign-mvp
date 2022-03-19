package com.mostbet.triggerCampaign.operation.triggerCampaign.process;

import com.mostbet.triggerCampaign.operation.triggerCampaign.common.dto.CampaignProcessRequest;
import com.mostbet.triggerCampaign.operation.triggerCampaign.common.dto.CampaignProcessResponse;

public interface TriggerCampaignProcessService {
    CampaignProcessResponse process(CampaignProcessRequest request);
}
