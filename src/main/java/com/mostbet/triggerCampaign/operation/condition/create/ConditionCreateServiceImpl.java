package com.mostbet.triggerCampaign.operation.condition.create;

import com.mostbet.triggerCampaign.entity.Condition;
import com.mostbet.triggerCampaign.entity.dto.ConditionDto;
import com.mostbet.triggerCampaign.entity.mapper.ConditionMapper;
import com.mostbet.triggerCampaign.repository.ConditionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ConditionCreateServiceImpl implements ConditionCreateService {
    private final ConditionRepository conditionRepository;
    private final ConditionMapper conditionMapper;

    @Override
    public Condition create(ConditionDto<ConditionDto.ConditionParams> conditionDto) {
        Condition condition = conditionMapper.dtoToCondition(conditionDto);
        conditionRepository.save(condition);

        return condition;
    }
}
