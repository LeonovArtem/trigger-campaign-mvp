package com.mostbet.triggerCampaign.operation.condition.fulfillment;

import com.mostbet.triggerCampaign.entity.ConditionFulfillment;
import com.mostbet.triggerCampaign.operation.condition.fulfillment.dto.ConditionFulfillmentRegisterDto;
import com.mostbet.triggerCampaign.repository.ConditionFulfillmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConditionFulfillmentRegisterServiceImpl implements ConditionFulfillmentRegisterService {
    private final ConditionFulfillmentRepository conditionFulfillmentRepository;

    @Override
    public void behave(ConditionFulfillmentRegisterDto request) {
        ConditionFulfillment conditionFulfillment = new ConditionFulfillment();
        conditionFulfillment.setCondition(request.getCondition());
        conditionFulfillment.setCreatedAt(request.getCreatedAt());
        conditionFulfillment.setUserId(request.getUserId());
        conditionFulfillment.setTriggerCampaign(request.getTriggerCampaign());

        conditionFulfillmentRepository.save(conditionFulfillment);
    }
}
