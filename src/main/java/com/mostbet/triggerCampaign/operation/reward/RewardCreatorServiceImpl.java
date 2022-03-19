package com.mostbet.triggerCampaign.operation.reward;

import com.mostbet.triggerCampaign.operation.reward.dto.RewardCreatorResponse;
import com.mostbet.triggerCampaign.operation.reward.dto.RewardCreatorResponse.RewardCreatorResponseBuilder;
import org.springframework.stereotype.Service;

@Service
public class RewardCreatorServiceImpl implements RewardCreatorService {
    @Override
    public RewardCreatorResponse createForUser() {
        RewardCreatorResponseBuilder response = RewardCreatorResponse.builder();

        return response.build();
    }
}
