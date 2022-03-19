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
    private ParamCheckFactory(List<CheckerInterface> paramCheckList) {
        for (CheckerInterface checker : paramCheckList) {
            ParamCheckFactory.paramCheckList.put(checker.getParamName(), checker);
        }
    }

    public CheckerInterface create(ConditionParam.ConditionParamName paramName) {
        CheckerInterface checker = paramCheckList.get(paramName);
        if (checker == null) throw new RuntimeException("Unknown paramName: " + paramName);

        return checker;
    }
}
