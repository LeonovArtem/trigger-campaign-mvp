package com.mostbet.triggerCampaign.web.api.v1;

import com.mostbet.triggerCampaign.entity.Condition;
import com.mostbet.triggerCampaign.entity.dto.ConditionDto;
import com.mostbet.triggerCampaign.entity.dto.ConditionWithIdDto;
import com.mostbet.triggerCampaign.operation.condition.getInfo.ConditionInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/api/v1/condition")
public class ConditionController {
    private final ConditionInfoService conditionInfoService;
//
//    @GetMapping
//    public List<ConditionWithIdDto> getList() {
//        List<ConditionWithIdDto> list = new ArrayList<>();
//        conditionInfoService
//                .getAllByConditionType(Condition.Type.COUPON)
//                .forEach(conditionParamsConditionDto -> {
//                    ConditionWithIdDto condition = new ConditionWithIdDto();
//                    condition.setId(conditionParamsConditionDto.getId());
//                    list.add(condition);
//                });
//
//        return list;
//    }

    @GetMapping
    public List<ConditionDto<ConditionDto.ConditionParams>> getList() {
        return conditionInfoService
                .getAllByConditionType(Condition.Type.COUPON);
    }
}
