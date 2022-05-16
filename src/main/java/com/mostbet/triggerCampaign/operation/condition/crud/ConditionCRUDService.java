package com.mostbet.triggerCampaign.operation.condition.crud;

import com.mostbet.triggerCampaign.entity.Condition;
import com.mostbet.triggerCampaign.entity.dto.ConditionDto;
import com.mostbet.triggerCampaign.entity.dto.criteria.ConditionCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ConditionCRUDService {
    Page<Condition> getAll(Pageable page, ConditionCriteria conditionCriteria);

    Optional<Condition> findById(Integer id);

    Condition create(ConditionDto<ConditionDto.Params> conditionDto);

    void deleteById(Integer id);

    Condition update(ConditionDto<ConditionDto.Params> conditionDto);
}
