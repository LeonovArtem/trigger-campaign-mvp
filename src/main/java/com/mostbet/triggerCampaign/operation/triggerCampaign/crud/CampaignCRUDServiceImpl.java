package com.mostbet.triggerCampaign.operation.triggerCampaign.crud;

import com.mostbet.triggerCampaign.entity.TriggerCampaign;
import com.mostbet.triggerCampaign.entity.dto.CampaignWithConditionIdsDto;
import com.mostbet.triggerCampaign.entity.dto.criteria.TriggerCampaignCriteria;
import com.mostbet.triggerCampaign.entity.mapper.TriggerCampaignMapper;
import com.mostbet.triggerCampaign.operation.triggerCampaign.factory.TriggerCampaignFactory;
import com.mostbet.triggerCampaign.repository.TriggerCampaignRepository;
import com.mostbet.triggerCampaign.repository.specification.CampaignSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public Optional<TriggerCampaign> findById(Integer id) {
        return campaignRepository.findById(id);
    }

    public TriggerCampaign create(CampaignWithConditionIdsDto dto) {
        return triggerCampaignFactory.create(dto);
    }

    @Override
    public void deleteById(Integer id) {
        TriggerCampaign campaign = campaignRepository.findById(id).orElseThrow();
        campaignRepository.delete(campaign);
    }

    @Override
    public TriggerCampaign update(CampaignWithConditionIdsDto dto) {
        TriggerCampaign campaign = campaignRepository.findById(dto.getId()).orElseThrow();
        campaignMapper.updateTriggerCampaignFromCampaignWithConditionIdsDto(dto, campaign);
        campaignRepository.save(campaign);

        return campaign;
    }

    private Page<TriggerCampaign> findByParams(Pageable page, TriggerCampaignCriteria criteria) {
        return campaignRepository.findAll(CampaignSpecification.campaignIdOrNameOrIsPublished(criteria), page);
    }
}
