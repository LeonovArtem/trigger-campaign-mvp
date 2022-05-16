package com.mostbet.triggerCampaign.operation.condition.crud;

import com.mostbet.triggerCampaign.entity.Condition;
import com.mostbet.triggerCampaign.entity.dto.ConditionDto;
import com.mostbet.triggerCampaign.entity.dto.criteria.ConditionCriteria;
import com.mostbet.triggerCampaign.entity.mapper.condition.ConditionFactoryMapper;
import com.mostbet.triggerCampaign.operation.condition.factory.ConditionFactory;
import com.mostbet.triggerCampaign.repository.ConditionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ConditionCRUDServiceImpl implements ConditionCRUDService {
    private final ConditionFactory conditionFactory;
    private final ConditionRepository conditionRepository;
    private final ConditionFactoryMapper conditionMapper;

    @Override
    public Page<Condition> getAll(Pageable page, ConditionCriteria conditionCriteria) {
        return findByParams(page, conditionCriteria);
    }

    @Override
    public Optional<Condition> findById(Integer id) {
        return conditionRepository.findById(id);
    }

    @Override
    public Condition create(ConditionDto<ConditionDto.Params> conditionDto) {
        return conditionFactory.create(conditionDto);
    }

    @Override
    public Condition update(ConditionDto<ConditionDto.Params> conditionDto) {
        Condition condition = conditionRepository.getById(conditionDto.getId());
        conditionMapper
                .createByConditionType(condition.getType())
                .updateConditionFromConditionDto(conditionDto, condition);
        conditionRepository.save(condition);

        return condition;
    }

    @Override
    public void deleteById(Integer id) {
        conditionRepository.delete(conditionRepository.findById(id).orElseThrow());
    }

    private Page<Condition> findByParams(Pageable page, ConditionCriteria criteria) {
        Condition condition = new Condition()
                .setType(criteria.getConditionType())
                .setId(criteria.getId());
        Example<Condition> conditionExample = Example.of(condition);

        return conditionRepository.findAll(conditionExample, page);
    }
}
