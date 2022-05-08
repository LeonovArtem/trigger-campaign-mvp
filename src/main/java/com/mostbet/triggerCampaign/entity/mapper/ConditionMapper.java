package com.mostbet.triggerCampaign.entity.mapper;

import com.mostbet.triggerCampaign.entity.Condition;
import com.mostbet.triggerCampaign.entity.dto.ConditionDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ConditionMapper {
    default Condition dtoToCondition(ConditionDto<ConditionDto.Params> conditionDto) {
        if (conditionDto == null) {
            return null;
        }

        Condition condition = new Condition();
        condition.setName(conditionDto.getName());
        condition.setType(conditionDto.getConditionType());

        return condition;
    }

    default ConditionDto<ConditionDto.Params> conditionToDto(Condition condition) {
        return ConditionDto.builder()
                .id(condition.getId())
                .conditionType(condition.getType())
                .name(condition.getName())
                .build();
    }
}
