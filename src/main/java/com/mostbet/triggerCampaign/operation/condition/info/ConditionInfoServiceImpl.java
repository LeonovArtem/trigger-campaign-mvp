package com.mostbet.triggerCampaign.operation.condition.info;

import com.mostbet.triggerCampaign.entity.Condition;
import com.mostbet.triggerCampaign.repository.ConditionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConditionInfoServiceImpl implements ConditionInfoService {
    private final ConditionRepository conditionRepository;

    @Override
    public List<Condition> getAll() {
        return conditionRepository.findAll();
    }
}
