package com.mostbet.triggerCampaign.operation.triggerCampaign.factory;

import com.mostbet.triggerCampaign.entity.Condition;
import com.mostbet.triggerCampaign.entity.TriggerCampaign;
import com.mostbet.triggerCampaign.entity.dto.CampaignWithConditionIdsDto;
import com.mostbet.triggerCampaign.entity.dto.TriggerCampaignDto;
import com.mostbet.triggerCampaign.entity.mapper.TriggerCampaignMapper;
import com.mostbet.triggerCampaign.repository.ConditionRepository;
import com.mostbet.triggerCampaign.repository.TriggerCampaignRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TriggerCampaignFactoryImpl implements TriggerCampaignFactory {
    private final TriggerCampaignRepository campaignRepository;
    private final ConditionRepository conditionRepository;
    private final TriggerCampaignMapper campaignMapper;

    @Override
    public TriggerCampaign create(TriggerCampaignDto triggerCampaignDto) {
        TriggerCampaign triggerCampaign = campaignMapper.triggerCampaignDtoToTriggerCampaign(triggerCampaignDto);
        campaignRepository.save(triggerCampaign);

        return triggerCampaign;
    }

    @Override
    @Transactional
    public TriggerCampaign create(CampaignWithConditionIdsDto triggerCampaignDto) {
        List<Condition> conditions = conditionRepository.findAllById(triggerCampaignDto.getConditionIds());
        TriggerCampaign triggerCampaign = campaignMapper.campaignWithConditionIdsToTriggerCampaign(triggerCampaignDto);
        triggerCampaign.setConditions(new HashSet<>(conditions));
        campaignRepository.save(triggerCampaign);

        return triggerCampaign;
    }
}
