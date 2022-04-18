package com.mostbet.triggerCampaign.web.controller.admin;

import com.mostbet.triggerCampaign.entity.Condition;
import com.mostbet.triggerCampaign.entity.mapper.condition.ConditionUserMapper;
import com.mostbet.triggerCampaign.operation.condition.crud.ConditionCRUDService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/condition-user")
public class ConditionUserController extends ConditionController {

    public ConditionUserController(ConditionCRUDService conditionCRUDService, ConditionUserMapper mapper) {
        super(conditionCRUDService, mapper);
    }

    @Override
    public Condition.Type getConditionType() {
        return Condition.Type.USER;
    }
}
