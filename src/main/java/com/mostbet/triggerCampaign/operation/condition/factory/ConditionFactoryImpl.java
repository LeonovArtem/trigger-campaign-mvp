package com.mostbet.triggerCampaign.operation.condition.factory;

import com.mostbet.triggerCampaign.entity.Condition;
import com.mostbet.triggerCampaign.entity.dto.ConditionDto;
import com.mostbet.triggerCampaign.entity.mapper.condition.ConditionFactoryMapper;
import com.mostbet.triggerCampaign.repository.ConditionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ConditionFactoryImpl implements ConditionFactory {
    private final ConditionRepository conditionRepository;
    private final ConditionFactoryMapper conditionMapper;

    @Override
    public Condition create(ConditionDto<ConditionDto.Params> conditionDto) {
        Condition condition = conditionMapper
                .createByConditionType(conditionDto.getConditionType())
                .dtoToCondition(conditionDto);
        conditionRepository.save(condition);

        return condition;
    }
}