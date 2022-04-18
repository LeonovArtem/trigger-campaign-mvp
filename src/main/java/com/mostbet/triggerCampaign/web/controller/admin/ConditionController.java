package com.mostbet.triggerCampaign.web.controller.admin;

import com.mostbet.triggerCampaign.entity.Condition;
import com.mostbet.triggerCampaign.entity.dto.ConditionDto;
import com.mostbet.triggerCampaign.entity.dto.criteria.ConditionCriteria;
import com.mostbet.triggerCampaign.entity.mapper.condition.ConditionMapper;
import com.mostbet.triggerCampaign.operation.condition.crud.ConditionCRUDService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

public abstract class ConditionController {
    protected ConditionCRUDService conditionCRUDService;
    protected ConditionMapper mapper;

    public ConditionController(ConditionCRUDService conditionCRUDService, ConditionMapper mapper) {
        this.conditionCRUDService = conditionCRUDService;
        this.mapper = mapper;
    }

    abstract Condition.Type getConditionType();

    @GetMapping
    public Page<ConditionDto<ConditionDto.Params>> getList(Pageable page, ConditionCriteria conditionCriteria) {
        conditionCriteria.setConditionType(getConditionType());

        return conditionCRUDService
                .getAll(page, conditionCriteria)
                .map(mapper::conditionToDto);
    }

    @GetMapping("{id}")
    public ConditionDto<ConditionDto.Params> getById(@PathVariable("id") int conditionId) {
        return mapper.conditionToDto(conditionCRUDService.getById(conditionId));
    }

    @PostMapping
    public ConditionDto<ConditionDto.Params> create(
            @RequestBody ConditionDto<ConditionDto.Params> conditionDto
    ) {
        Condition condition = conditionCRUDService.create(conditionDto);
        conditionDto.setId(condition.getId());

        return conditionDto;
    }

    @PutMapping("{id}")
    public ConditionDto<ConditionDto.Params> update(
            @RequestBody ConditionDto<ConditionDto.Params> dto
    ) {
        return mapper.conditionToDto(conditionCRUDService.update(dto));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer conditionId) {
        conditionCRUDService.deleteById(conditionId);
    }
}
