package com.mostbet.triggerCampaign.operation.triggerCampaign.crud;

import com.mostbet.triggerCampaign.entity.TriggerCampaign;
import com.mostbet.triggerCampaign.entity.dto.CampaignWithConditionIdsDto;
import com.mostbet.triggerCampaign.entity.dto.criteria.TriggerCampaignCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CampaignCRUDService {
    Page<TriggerCampaign> getAll(Pageable page, TriggerCampaignCriteria criteria);

    Optional<TriggerCampaign> findById(Integer id);

    TriggerCampaign create(CampaignWithConditionIdsDto dto);

    void deleteById(Integer id);

    TriggerCampaign update(CampaignWithConditionIdsDto dto);
}
