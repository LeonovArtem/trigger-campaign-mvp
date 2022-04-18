package com.mostbet.triggerCampaign.entity.mapper;

import com.mostbet.triggerCampaign.entity.Condition;
import com.mostbet.triggerCampaign.entity.TriggerCampaign;
import com.mostbet.triggerCampaign.entity.dto.CampaignWithConditionIdsDto;
import com.mostbet.triggerCampaign.entity.dto.ConditionDto;
import com.mostbet.triggerCampaign.entity.dto.TriggerCampaignDto;
import org.mapstruct.*;

import java.util.List;
import java.util.Set;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", uses = ConditionMapper.class)
public interface TriggerCampaignMapper {
    TriggerCampaign triggerCampaignDtoToTriggerCampaign(TriggerCampaignDto triggerCampaignDto);

    TriggerCampaignDto triggerCampaignToTriggerCampaignDto(TriggerCampaign triggerCampaign);

    TriggerCampaign campaignWithConditionIdsToTriggerCampaign(CampaignWithConditionIdsDto triggerCampaignDto);

    CampaignWithConditionIdsDto triggerCampaignToCampaignWithConditionIds(TriggerCampaign triggerCampaign);

    List<ConditionDto<ConditionDto.Params>> conditionListToDtoList(Set<Condition> conditions);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateTriggerCampaignFromCampaignWithConditionIdsDto(
            CampaignWithConditionIdsDto dto,
            @MappingTarget TriggerCampaign triggerCampaign
    );
}
