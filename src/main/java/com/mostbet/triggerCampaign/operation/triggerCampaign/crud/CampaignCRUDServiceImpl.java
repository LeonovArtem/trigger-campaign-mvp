package com.mostbet.triggerCampaign.operation.triggerCampaign.crud;

import com.mostbet.triggerCampaign.entity.TriggerCampaign;
import com.mostbet.triggerCampaign.entity.dto.CampaignWithConditionIdsDto;
import com.mostbet.triggerCampaign.entity.dto.criteria.TriggerCampaignCriteria;
import com.mostbet.triggerCampaign.entity.mapper.TriggerCampaignMapper;
import com.mostbet.triggerCampaign.operation.triggerCampaign.factory.TriggerCampaignFactory;
import com.mostbet.triggerCampaign.repository.TriggerCampaignRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CampaignCRUDServiceImpl implements CampaignCRUDService {
    private final TriggerCampaignRepository campaignRepository;
    private final TriggerCampaignFactory triggerCampaignFactory;
    private final TriggerCampaignMapper campaignMapper;

    @Override
    public Page<TriggerCampaign> getAll(Pageable page, TriggerCampaignCriteria criteria) {
        return findByParams(page, criteria);
    }

    @Override
    public TriggerCampaign getById(Integer id) {
        return campaignRepository.getById(id);
    }

    public TriggerCampaign create(CampaignWithConditionIdsDto dto) {
        return triggerCampaignFactory.create(dto);
    }

    @Override
    public void deleteById(Integer id) {
        TriggerCampaign campaign = campaignRepository.getById(id);
        campaignRepository.delete(campaign);
    }

    @Override
    public TriggerCampaign update(CampaignWithConditionIdsDto dto) {
        TriggerCampaign campaign = campaignRepository.getById(dto.getId());
        campaignMapper.updateTriggerCampaignFromCampaignWithConditionIdsDto(dto, campaign);
        campaignRepository.save(campaign);

        return campaign;
    }

    private Page<TriggerCampaign> findByParams(Pageable page, TriggerCampaignCriteria criteria) {
        TriggerCampaign triggerCampaign = new TriggerCampaign()
                .setIsPublished(criteria.getIsPublished())
                .setId(criteria.getId());

        return campaignRepository.findAll(Example.of(triggerCampaign), page);
    }
}