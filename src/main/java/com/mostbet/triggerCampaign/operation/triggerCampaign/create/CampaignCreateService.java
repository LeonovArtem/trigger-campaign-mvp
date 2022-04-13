package com.mostbet.triggerCampaign.operation.triggerCampaign.create;

import com.mostbet.triggerCampaign.entity.TriggerCampaign;
import com.mostbet.triggerCampaign.entity.dto.CampaignWithConditionIdsDto;
import com.mostbet.triggerCampaign.entity.dto.TriggerCampaignDto;

public interface CampaignCreateService {
    TriggerCampaign create(TriggerCampaignDto triggerCampaignDto);

    TriggerCampaign create(CampaignWithConditionIdsDto triggerCampaignDto);
}
