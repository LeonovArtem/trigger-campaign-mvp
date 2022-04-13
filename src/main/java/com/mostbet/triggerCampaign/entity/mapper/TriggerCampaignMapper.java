package com.mostbet.triggerCampaign.entity.mapper;

import com.mostbet.triggerCampaign.entity.Condition;
import com.mostbet.triggerCampaign.entity.ConditionParam;
import com.mostbet.triggerCampaign.entity.TriggerCampaign;
import com.mostbet.triggerCampaign.entity.dto.CampaignWithConditionIdsDto;
import com.mostbet.triggerCampaign.entity.dto.ConditionDto;
import com.mostbet.triggerCampaign.entity.dto.TriggerCampaignDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TriggerCampaignMapper {
    TriggerCampaign triggerCampaignDtoToTriggerCampaign(TriggerCampaignDto triggerCampaignDto);

    TriggerCampaign campaignWithConditionIdsToTriggerCampaign(CampaignWithConditionIdsDto triggerCampaignDto);

    TriggerCampaignDto triggerCampaignToTriggerCampaignDto(TriggerCampaign triggerCampaign);

    default List<ConditionDto<ConditionDto.ConditionParams>> map(Set<Condition> conditions) {
        List<ConditionDto<ConditionDto.ConditionParams>> conditionDtoList = new ArrayList<>();
        return conditions.stream()
                .map(ConditionMapper.INSTANCE::conditionToDto)
                .collect(Collectors.toList())
                ;
    }

    default List<ConditionParam> map(ConditionDto.ConditionParams value){
        return null;
    }
}
