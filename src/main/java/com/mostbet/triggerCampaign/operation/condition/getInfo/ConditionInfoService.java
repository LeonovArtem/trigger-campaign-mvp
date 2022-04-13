package com.mostbet.triggerCampaign.operation.condition.getInfo;

import com.mostbet.triggerCampaign.entity.Condition;
import com.mostbet.triggerCampaign.entity.dto.ConditionDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ConditionInfoService {
    List<ConditionDto<ConditionDto.ConditionParams>> getAllByConditionType(Condition.Type type);

    Page<Condition> getAll(Pageable page);

    ConditionDto<ConditionDto.ConditionParams> getById(int id);
}
