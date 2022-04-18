package com.mostbet.triggerCampaign.web.controller.admin;

import com.mostbet.triggerCampaign.entity.Condition;
import com.mostbet.triggerCampaign.entity.mapper.condition.ConditionRefillMapper;
import com.mostbet.triggerCampaign.operation.condition.crud.ConditionCRUDService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/condition-refill")
public class ConditionRefillController extends ConditionController {

    public ConditionRefillController(ConditionCRUDService conditionCRUDService, ConditionRefillMapper mapper) {
        super(conditionCRUDService, mapper);
    }

    @Override
    public Condition.Type getConditionType() {
        return Condition.Type.REFILL;
    }
}
