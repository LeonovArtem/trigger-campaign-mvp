package com.mostbet.triggerCampaign.operation.triggerCampaign.getInfo;

import com.mostbet.triggerCampaign.entity.TriggerCampaign;
import com.mostbet.triggerCampaign.entity.dto.TriggerCampaignDto;
import com.mostbet.triggerCampaign.entity.dto.criteria.TriggerCampaignCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CampaignInfoService {
    List<TriggerCampaignDto> getAllCampaign();
    Page<TriggerCampaign> getAllCampaign(Pageable pageable, TriggerCampaignCriteria criteria);

    TriggerCampaignDto getById(int id);
}
