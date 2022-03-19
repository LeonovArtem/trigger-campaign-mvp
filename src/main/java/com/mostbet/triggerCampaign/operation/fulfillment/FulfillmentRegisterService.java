package com.mostbet.triggerCampaign.operation.fulfillment;

import com.mostbet.triggerCampaign.entity.Fulfillment;
import com.mostbet.triggerCampaign.operation.triggerCampaign.common.dto.CampaignProcessRequest;

public interface FulfillmentRegisterService {
    Fulfillment behave(CampaignProcessRequest request);
}
