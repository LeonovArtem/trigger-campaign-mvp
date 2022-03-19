package com.mostbet.triggerCampaign.web;

import com.mostbet.triggerCampaign.entity.Condition;
import com.mostbet.triggerCampaign.entity.ConditionParam;
import com.mostbet.triggerCampaign.repository.ConditionParamRepository;
import com.mostbet.triggerCampaign.repository.ConditionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("condition")
public class ConditionController {
    private final ConditionParamRepository conditionParamRepository;
    private final ConditionRepository conditionRepository;

    @GetMapping("{id}")
    public Condition  getById(@PathVariable("id") int conditionId) {
        return conditionRepository.getById(conditionId);
    }

    @GetMapping("params")
    public List<ConditionParam> getParams() {
        return conditionParamRepository.findAll();
    }

    @GetMapping("params/{id}")
    public ConditionParam getParamsById(@PathVariable("id") int id) {
        return conditionParamRepository.getById(id);
    }
}
