package com.mostbet.triggerCampaign.entity.mapper;

import com.mostbet.triggerCampaign.entity.dto.TriggerCampaignDto;
import com.mostbet.triggerCampaign.entity.TriggerCampaign;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TriggerCampaignMapper {
    TriggerCampaign triggerCampaignDtoToTriggerCampaign(TriggerCampaignDto triggerCampaignDto);

    TriggerCampaignDto triggerCampaignToTriggerCampaignDto(TriggerCampaign triggerCampaign);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateTriggerCampaignFromTriggerCampaignDto(TriggerCampaignDto triggerCampaignDto, @MappingTarget TriggerCampaign triggerCampaign);
}
