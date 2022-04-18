package com.mostbet.triggerCampaign.web.controller.admin;

import com.mostbet.triggerCampaign.entity.Condition;
import com.mostbet.triggerCampaign.entity.mapper.condition.ConditionCouponMapper;
import com.mostbet.triggerCampaign.operation.condition.crud.ConditionCRUDService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/condition-coupon")
public class ConditionCouponController extends ConditionController {

    public ConditionCouponController(ConditionCRUDService conditionCRUDService, ConditionCouponMapper mapper) {
        super(conditionCRUDService, mapper);
    }

    @Override
    public Condition.Type getConditionType() {
        return Condition.Type.COUPON;
    }
}
