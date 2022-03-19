package com.mostbet.triggerCampaign.operation.condition.fulfillment.dto;

import com.mostbet.triggerCampaign.entity.Condition;
import com.mostbet.triggerCampaign.entity.TriggerCampaign;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class ConditionFulfillmentRegisterDto {

    private int userId;

    private TriggerCampaign triggerCampaign;

    private Condition condition;

    private LocalDateTime CreatedAt;
}
