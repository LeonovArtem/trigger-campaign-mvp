package com.mostbet.triggerCampaign.operation.condition.getInfo;

import com.mostbet.triggerCampaign.entity.Condition;
import com.mostbet.triggerCampaign.entity.dto.ConditionDto;
import com.mostbet.triggerCampaign.entity.mapper.ConditionMapper;
import com.mostbet.triggerCampaign.repository.ConditionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ConditionInfoServiceImpl implements ConditionInfoService {
    private final ConditionRepository conditionRepository;
    private final ConditionMapper conditionMapper;

    @Override
    public List<ConditionDto<ConditionDto.ConditionParams>> getAllByConditionType(Condition.Type type) {

        return conditionRepository
                .findAllByType(type)
                .stream()
                .map(conditionMapper::conditionToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ConditionDto<ConditionDto.ConditionParams> getById(int id) {
        return conditionMapper.conditionToDto(conditionRepository.getById(id));
    }
}
