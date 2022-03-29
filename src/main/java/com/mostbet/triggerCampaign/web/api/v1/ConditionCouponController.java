package com.mostbet.triggerCampaign.web.api.v1;

import com.mostbet.triggerCampaign.entity.Condition;
import com.mostbet.triggerCampaign.entity.dto.ConditionDto;
import com.mostbet.triggerCampaign.repository.ConditionParamRepository;
import com.mostbet.triggerCampaign.repository.ConditionRepository;
import com.mostbet.triggerCampaign.entity.dto.ConditionCouponDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/api/v1/condition-coupon")
public class ConditionCouponController {
    private final ConditionParamRepository conditionParamRepository;
    private final ConditionRepository conditionRepository;

    @GetMapping("{id}")
    public Condition  getById(@PathVariable("id") int conditionId) {
        return conditionRepository.getById(conditionId);
    }

    @GetMapping
    public List<ConditionCouponDto> getList(){
        return new ArrayList<>();
    }

    @PostMapping
    public ConditionDto<ConditionDto.ConditionParams> create(
            @RequestBody ConditionDto<ConditionDto.ConditionParams> conditionCouponDto
    ) {
        return conditionCouponDto;
    }
}
