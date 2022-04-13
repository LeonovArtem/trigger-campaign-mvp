package com.mostbet.triggerCampaign.web.api.v1;

import com.mostbet.triggerCampaign.entity.Condition;
import com.mostbet.triggerCampaign.entity.dto.ConditionDto;
import com.mostbet.triggerCampaign.operation.condition.create.ConditionCreateService;
import com.mostbet.triggerCampaign.operation.condition.getInfo.ConditionInfoService;
import com.mostbet.triggerCampaign.repository.ConditionParamRepository;
import com.mostbet.triggerCampaign.repository.ConditionRepository;
import com.mostbet.triggerCampaign.entity.dto.ConditionCouponDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/api/v1/condition-coupon")
public class ConditionCouponController {
    private final ConditionCreateService conditionCreateService;
    private final ConditionInfoService conditionInfoService;

    @GetMapping("{id}")
    public ConditionDto<ConditionDto.ConditionParams>  getById(@PathVariable("id") int conditionId) {
        return conditionInfoService.getById(conditionId);
    }

    @GetMapping
    public Page<Condition> getList(Pageable page){
        return conditionInfoService.getAll(page);
    }

    @PostMapping
    public ConditionDto<ConditionDto.ConditionParams> create(
            @RequestBody ConditionDto<ConditionDto.ConditionParams> conditionDto
    ) {
        Condition condition = conditionCreateService.create(conditionDto);

        return conditionDto.setId(condition.getId());
    }
}
