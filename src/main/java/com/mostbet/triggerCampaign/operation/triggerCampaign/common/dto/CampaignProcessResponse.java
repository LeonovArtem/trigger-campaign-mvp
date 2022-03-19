package com.mostbet.triggerCampaign.operation.triggerCampaign.common.dto;

import com.mostbet.triggerCampaign.entity.Fulfillment;
import com.mostbet.triggerCampaign.operation.reward.dto.RewardCreatorResponse;
import com.mostbet.triggerCampaign.operation.triggerCampaign.check.dto.CampaignCheckResponse;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Builder
@Getter
public class CampaignProcessResponse implements Serializable {

    private Fulfillment fulfillment;

    private CampaignCheckResponse campaignCheckResponse;

    private RewardCreatorResponse rewardCreatorResponse;
}
