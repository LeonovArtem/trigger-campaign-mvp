package com.mostbet.triggerCampaign.entity.mapper.condition;

import com.mostbet.triggerCampaign.entity.Condition;
import com.mostbet.triggerCampaign.entity.dto.ConditionDto;
import org.mapstruct.*;

public interface ConditionMapper {
    ConditionDto<ConditionDto.Params> conditionToDto(Condition condition);

    @Mapping(source = "conditionType", target = "type")
    Condition dtoToCondition(ConditionDto<ConditionDto.Params> conditionDto);

    Condition.Type getConditionType();

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateConditionFromConditionDto(ConditionDto<ConditionDto.Params> conditionDto, @MappingTarget Condition condition);
}
