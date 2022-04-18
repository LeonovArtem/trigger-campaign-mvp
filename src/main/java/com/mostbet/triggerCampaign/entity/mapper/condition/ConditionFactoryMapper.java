package com.mostbet.triggerCampaign.entity.mapper.condition;

import com.mostbet.triggerCampaign.entity.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ConditionFactoryMapper {
    private static final Map<Condition.Type, ConditionMapper> conditionMappers = new HashMap<>();

    @Autowired
    public ConditionFactoryMapper(List<ConditionMapper> mappers) {
        mappers.forEach(mapper -> conditionMappers.put(mapper.getConditionType(), mapper));
    }

    public ConditionMapper createByConditionType(Condition.Type conditionType) {
        return conditionMappers.get(conditionType);
    }
}
