package com.mostbet.triggerCampaign.entity.mapper.condition;

import com.mostbet.triggerCampaign.entity.Condition;
import com.mostbet.triggerCampaign.entity.mapper.conditionParams.CouponParamsMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", uses = CouponParamsMapper.class)
public abstract class ConditionCouponMapper implements ConditionMapper {
    @Override
    public Condition.Type getConditionType() {
        return Condition.Type.COUPON;
    }
}
