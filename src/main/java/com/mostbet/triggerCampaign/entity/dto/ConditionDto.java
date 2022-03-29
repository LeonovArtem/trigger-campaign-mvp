package com.mostbet.triggerCampaign.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.mostbet.triggerCampaign.entity.Condition;
import com.mostbet.triggerCampaign.entity.dto.conditionParams.CouponParamsDto;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConditionDto<T extends ConditionDto.ConditionParams> implements Serializable {
    @JsonProperty("name")
    private final String name;

    @JsonProperty("conditionType")
    private final Condition.Type conditionType;

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "conditionType")
    @JsonSubTypes({
            @JsonSubTypes.Type(name = "COUPON", value = CouponParamsDto.class),
    })
    private final T params;

    public interface ConditionParams {}
}
