package com.mostbet.triggerCampaign.operation.triggerCampaign.getInfo;

import com.mostbet.triggerCampaign.entity.dto.TriggerCampaignDto;

import java.util.List;

public interface CampaignInfoService {
    List<TriggerCampaignDto> getAllCampaign();

    TriggerCampaignDto getById(int id);
}
