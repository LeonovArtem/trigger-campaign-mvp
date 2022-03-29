package com.mostbet.triggerCampaign.operation.triggerCampaign.getInfo;

import com.mostbet.triggerCampaign.entity.dto.TriggerCampaignDto;
import com.mostbet.triggerCampaign.entity.mapper.TriggerCampaignMapper;
import com.mostbet.triggerCampaign.repository.TriggerCampaignRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CampaignInfoServiceImpl implements CampaignInfoService {
    private final TriggerCampaignRepository campaignRepository;
    private final TriggerCampaignMapper triggerCampaignMapper;

    @Override
    public List<TriggerCampaignDto> getAllCampaign() {
        return campaignRepository
                .findAll()
                .stream()
                .map(triggerCampaignMapper::triggerCampaignToTriggerCampaignDto)
                .collect(Collectors.toList());
    }

    @Override
    public TriggerCampaignDto getById(int id) {
        return triggerCampaignMapper.triggerCampaignToTriggerCampaignDto(campaignRepository.getById(id));
    }
}
