package com.mostbet.triggerCampaign.entity.mapper.condition;

import com.mostbet.triggerCampaign.entity.Condition;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
public class ConditionMapperResolver {
    public ConditionMapper resolveByConditionType(Condition.Type conditionType) {
        switch (conditionType) {
            case COUPON:
                return Mappers.getMapper(ConditionCouponMapper.class);
            case REFILL:
                return Mappers.getMapper(ConditionRefillMapper.class);
            case USER:
                return Mappers.getMapper(ConditionUserMapper.class);
            default:
                throw new RuntimeException("Unidentified operation");

        }
    }
}
