package com.mostbet.triggerCampaign.operation.condition.crud;

import com.mostbet.triggerCampaign.entity.Condition;
import com.mostbet.triggerCampaign.entity.dto.ConditionDto;
import com.mostbet.triggerCampaign.entity.dto.criteria.ConditionCriteria;
import com.mostbet.triggerCampaign.entity.mapper.condition.ConditionFactoryMapper;
import com.mostbet.triggerCampaign.operation.condition.factory.ConditionFactory;
import com.mostbet.triggerCampaign.repository.ConditionRepository;
import com.mostbet.triggerCampaign.repository.specification.ConditionSpecification;
import com.mostbet.triggerCampaign.web.controller.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
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
        Condition condition = conditionRepository
                .findById(conditionDto.getId())
                .orElseThrow(NotFoundException::new);

        conditionMapper
                .createByConditionType(condition.getType())
                .updateConditionFromConditionDto(conditionDto, condition);

        condition.getParams().forEach(conditionParam -> conditionParam.setCondition(condition));
        conditionRepository.save(condition);

        return condition;
    }

    @Override
    public void deleteById(Integer id) {
        conditionRepository.delete(
                conditionRepository
                        .findById(id)
                        .orElseThrow(NotFoundException::new)
        );
    }

    private Page<Condition> findByParams(Pageable page, ConditionCriteria criteria) {
        return conditionRepository.findAll(ConditionSpecification.conditionIdOrConditionTypeOrName(criteria), page);
    }
}
