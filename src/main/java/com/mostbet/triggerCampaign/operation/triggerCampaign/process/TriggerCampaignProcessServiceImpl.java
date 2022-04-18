package com.mostbet.triggerCampaign.operation.triggerCampaign.process;

import com.mostbet.triggerCampaign.entity.Condition;
import com.mostbet.triggerCampaign.operation.condition.check.dto.ConditionCheckResponse;
import com.mostbet.triggerCampaign.operation.condition.fulfillment.ConditionFulfillmentRegisterService;
import com.mostbet.triggerCampaign.operation.condition.fulfillment.dto.ConditionFulfillmentRegisterDto;
import com.mostbet.triggerCampaign.operation.fulfillment.FulfillmentRegisterService;
import com.mostbet.triggerCampaign.operation.reward.RewardCreatorService;
import com.mostbet.triggerCampaign.operation.triggerCampaign.check.CampaignCheckService;
import com.mostbet.triggerCampaign.operation.triggerCampaign.check.dto.CampaignCheckResponse;
import com.mostbet.triggerCampaign.operation.triggerCampaign.common.dto.CampaignProcessRequest;
import com.mostbet.triggerCampaign.operation.triggerCampaign.common.dto.CampaignProcessResponse;
import com.mostbet.triggerCampaign.operation.triggerCampaign.common.dto.CampaignProcessResponse.CampaignProcessResponseBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TriggerCampaignProcessServiceImpl implements TriggerCampaignProcessService {
    private final CampaignCheckService triggerCampaignCheck;
    private final FulfillmentRegisterService fulfillmentRegisterService;
    private final ConditionFulfillmentRegisterService conditionFulfillmentRegisterService;
    private final RewardCreatorService rewardCreatorServiceImpl;

    @Override
    public CampaignProcessResponse process(CampaignProcessRequest request) {
        CampaignProcessResponseBuilder campaignProcessResponse = CampaignProcessResponse.builder();

        CampaignCheckResponse campaignCheckResponse = triggerCampaignCheck.behave(request);
        registerFulfilledConditions(request, campaignCheckResponse);

        if (campaignCheckResponse.isFulfilled()) {
            campaignProcessResponse.fulfillment(fulfillmentRegisterService.behave(request));
            campaignProcessResponse.rewardCreatorResponse(rewardCreatorServiceImpl.createForUser());
        }

        return campaignProcessResponse
                .campaignCheckResponse(campaignCheckResponse)
                .build();
    }

    private void registerFulfilledConditions(CampaignProcessRequest request, CampaignCheckResponse tcCheckResponse) {
        List<Condition> fulfilledConditions = tcCheckResponse.getConditionCheckResponses().stream()
                .filter(ConditionCheckResponse::isFulfilled)
                .map(ConditionCheckResponse::getCondition)
                .collect(Collectors.toList());

        fulfilledConditions.forEach(condition -> {
            ConditionFulfillmentRegisterDto conditionFulfillmentRegisterDto = ConditionFulfillmentRegisterDto
                    .builder()
                    .condition(condition)
                    .userId(request.getEventRequest().getUserId())
                    .triggerCampaign(request.getTriggerCampaign())
                    .CreatedAt(request.getEventRequest().getEventDateTime())
                    .build();

            conditionFulfillmentRegisterService.behave(conditionFulfillmentRegisterDto);
        });
    }
}
