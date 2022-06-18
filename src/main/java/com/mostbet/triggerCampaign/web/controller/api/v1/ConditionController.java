package com.mostbet.triggerCampaign.web.controller.api.v1;

import com.mostbet.triggerCampaign.entity.dto.ConditionDto;
import com.mostbet.triggerCampaign.entity.mapper.ConditionMapper;
import com.mostbet.triggerCampaign.operation.condition.info.ConditionInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/condition")
@RequiredArgsConstructor
public class ConditionController {
    private final ConditionInfoService conditionInfoService;
    private final ConditionMapper conditionMapper;

    @GetMapping
    public List<ConditionDto<ConditionDto.Params>> getAll() {
//        return conditionInfoService.getAll();
        return conditionInfoService.getAll()
                .stream()
                .map(conditionMapper::conditionToDto)
                .collect(Collectors.toList());

    }
}
