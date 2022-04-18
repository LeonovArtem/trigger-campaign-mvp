package com.mostbet.triggerCampaign.operation.conditionParam.check;

import com.mostbet.triggerCampaign.entity.ConditionParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ParamCheckFactory {
    private static final Map<ConditionParam.ConditionParamName, CheckerInterface> paramCheckList = new HashMap<>();

    @Autowired
    private ParamCheckFactory(List<CheckerInterface> checkers) {
        checkers.forEach(checker -> paramCheckList.put(checker.getParamName(), checker));
    }

    public CheckerInterface create(ConditionParam.ConditionParamName paramName) {
        CheckerInterface checker = paramCheckList.get(paramName);
        if (checker != null) {
            return checker;
        }

        throw new RuntimeException("Unknown paramName: " + paramName);
    }
}
