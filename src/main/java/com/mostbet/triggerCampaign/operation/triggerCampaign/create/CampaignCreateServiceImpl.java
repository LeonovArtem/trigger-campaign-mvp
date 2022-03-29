package com.mostbet.triggerCampaign.operation.triggerCampaign.create;

import com.mostbet.triggerCampaign.entity.TriggerCampaign;
import com.mostbet.triggerCampaign.entity.dto.TriggerCampaignDto;
import com.mostbet.triggerCampaign.entity.mapper.TriggerCampaignMapper;
import com.mostbet.triggerCampaign.repository.TriggerCampaignRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CampaignCreateServiceImpl implements CampaignCreateService {
    private final TriggerCampaignRepository campaignRepository;

    private final TriggerCampaignMapper campaignMapper;

    @Override
    public TriggerCampaign create(TriggerCampaignDto triggerCampaignDto) {
        TriggerCampaign triggerCampaign = campaignMapper.triggerCampaignDtoToTriggerCampaign(triggerCampaignDto);
        campaignRepository.save(triggerCampaign);

        return triggerCampaign;
    }
}
