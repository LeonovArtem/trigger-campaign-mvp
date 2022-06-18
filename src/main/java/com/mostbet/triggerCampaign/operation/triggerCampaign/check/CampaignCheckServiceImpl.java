package com.mostbet.triggerCampaign.operation.triggerCampaign.check;

import com.mostbet.triggerCampaign.entity.Condition;
import com.mostbet.triggerCampaign.entity.TriggerCampaign;
import com.mostbet.triggerCampaign.operation.condition.check.ConditionCheckService;
import com.mostbet.triggerCampaign.operation.condition.check.dto.ConditionCheckRequest;
import com.mostbet.triggerCampaign.operation.condition.check.dto.ConditionCheckResponse;
import com.mostbet.triggerCampaign.operation.triggerCampaign.check.dto.CampaignCheckResponse;
import com.mostbet.triggerCampaign.operation.triggerCampaign.check.dto.CampaignCheckResponse.CampaignCheckResponseBuilder;
import com.mostbet.triggerCampaign.operation.triggerCampaign.common.dto.CampaignProcessRequest;
import com.mostbet.triggerCampaign.repository.ConditionRepository;
import com.mostbet.triggerCampaign.repository.FulfillmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CampaignCheckServiceImpl implements CampaignCheckService {
    private final ConditionCheckService conditionChecker;
    private final ConditionRepository conditionRepository;
    private final FulfillmentRepository fulfillmentRepository;

    @Override
    public CampaignCheckResponse behave(CampaignProcessRequest request) {
        CampaignCheckResponseBuilder response = CampaignCheckResponse.builder();
        List<ConditionCheckResponse> conditionCheckResponses = new ArrayList<>();

        boolean isFulfillmentLimitReached = isFulfillmentLimitReached(
                request.getEventRequest().getUserId(),
                request.getTriggerCampaign()
        );

        boolean isFulfilled = !isFulfillmentLimitReached && areAllConditionsFulfilled(request, conditionCheckResponses);

        return response
                .triggerCampaignId(request.getTriggerCampaign().getId())
                .isFulfilled(isFulfilled)
                .isFulfillmentLimitReached(isFulfillmentLimitReached)
                .conditionCheckResponses(conditionCheckResponses)
                .build();
    }

    private boolean areAllConditionsFulfilled(
            CampaignProcessRequest request,
            List<ConditionCheckResponse> conditionCheckResponses
    ) {
        List<Condition> activeConditions = conditionRepository.findActiveConditions(
                request.getTriggerCampaign().getId(),
                request.getEventRequest().getUserId()
        );

        boolean isAllFulfilled = false;
        for (Condition condition : activeConditions) {
            ConditionCheckResponse conditionCheckResponse = conditionChecker.behave(
                    new ConditionCheckRequest(condition, request)
            );
            conditionCheckResponses.add(conditionCheckResponse);

            if (conditionCheckResponse.isFulfilled()) {
                isAllFulfilled = activeConditions.size() == 1;
                break;
            }
        }

        return isAllFulfilled;
    }

    private boolean isFulfillmentLimitReached(int userId, TriggerCampaign triggerCampaign) {
        Integer triggerCampaignMaxFulfillmentCount = triggerCampaign.getMaxFulfillmentCount();
        if (triggerCampaignMaxFulfillmentCount == null) {
            return true;
        }

        Integer fulfillmentCount = fulfillmentRepository.countByUserIdAndTriggerCampaign(userId, triggerCampaign);

        return fulfillmentCount >= triggerCampaignMaxFulfillmentCount;
    }
}
