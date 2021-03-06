package com.mostbet.triggerCampaign.entity.dto.criteria;

import com.mostbet.triggerCampaign.entity.Condition;
import lombok.Data;

@Data
public class ConditionCriteria {
    private Integer id;
    private String name;
    private Condition.Type conditionType;
}
