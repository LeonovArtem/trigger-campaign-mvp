package com.mostbet.triggerCampaign.operation.condition.crud;

import com.mostbet.triggerCampaign.entity.Condition;
import com.mostbet.triggerCampaign.entity.dto.ConditionDto;
import com.mostbet.triggerCampaign.entity.dto.criteria.ConditionCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ConditionCRUDService {
    Page<Condition> getAll(Pageable page, ConditionCriteria conditionCriteria);

    Condition getById(Integer id);

    Condition create(ConditionDto<ConditionDto.Params> conditionDto);

    void deleteById(Integer id);

    Condition update(ConditionDto<ConditionDto.Params> conditionDto);
}
