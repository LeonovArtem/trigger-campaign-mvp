package com.mostbet.triggerCampaign.operation.triggerCampaign.check;

import com.mostbet.triggerCampaign.operation.triggerCampaign.check.dto.CampaignCheckResponse;
import com.mostbet.triggerCampaign.operation.triggerCampaign.common.dto.CampaignProcessRequest;

public interface CampaignCheckService {
    CampaignCheckResponse behave(CampaignProcessRequest request);
}
