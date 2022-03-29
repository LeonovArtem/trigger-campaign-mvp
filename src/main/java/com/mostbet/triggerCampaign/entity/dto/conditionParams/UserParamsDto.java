package com.mostbet.triggerCampaign.entity.dto.conditionParams;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mostbet.triggerCampaign.entity.dto.ConditionDto;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserParamsDto implements ConditionDto.ConditionParams {
}
