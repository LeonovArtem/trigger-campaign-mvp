package com.mostbet.triggerCampaign.operation.fulfillment;

import com.mostbet.triggerCampaign.entity.ConditionFulfillment;
import com.mostbet.triggerCampaign.entity.Fulfillment;
import com.mostbet.triggerCampaign.operation.triggerCampaign.common.dto.CampaignProcessRequest;
import com.mostbet.triggerCampaign.repository.ConditionFulfillmentRepository;
import com.mostbet.triggerCampaign.repository.FulfillmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FulfillmentRegisterServiceImpl implements FulfillmentRegisterService {
    private final FulfillmentRepository fulfillmentRepository;
    private final ConditionFulfillmentRepository conditionFulfillmentRepository;

    @Override
    public Fulfillment behave(CampaignProcessRequest request) {
        Fulfillment fulfillment = new Fulfillment();
        fulfillment.setUserId(request.getEventRequest().getUserId());
        fulfillment.setCreatedAt(LocalDateTime.now());
        fulfillment.setTriggerCampaign(request.getTriggerCampaign());

        registerFulfilledConditions(fulfillment);

        fulfillmentRepository.save(fulfillment);

        return fulfillment;
    }

    private void registerFulfilledConditions(Fulfillment fulfillment) {
        List<ConditionFulfillment> activeConditionFulfillmentList = conditionFulfillmentRepository
                .findActiveConditionFulfillment(fulfillment.getUserId(), fulfillment.getTriggerCampaign().getId());

        activeConditionFulfillmentList.forEach(conditionFulfillment -> {
            conditionFulfillment.setFulfillment(fulfillment);
            conditionFulfillmentRepository.save(conditionFulfillment);
        });
    }
}
