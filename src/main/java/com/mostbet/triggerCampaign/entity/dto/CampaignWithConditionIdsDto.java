package com.mostbet.triggerCampaign.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mostbet.triggerCampaign.entity.TriggerCampaign;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CampaignWithConditionIdsDto {
    private Integer id;

    private String name;

    private String description;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Date startAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Date endAt;

    private Boolean isPublished;

    private Integer maxFulfillmentCount;

    private TriggerCampaign.UserAvailability userAvailability;

    private Boolean isConfirmationParticipation;

    private Set<TriggerCampaign.ClientPlatforms> clientPlatforms;

    private ConditionsIds conditionIds;

    public List<Integer> getConditionIds() {
        return Stream.of(
                        conditionIds.getConditionCouponId(),
                        conditionIds.getConditionRefillId(),
                        conditionIds.getConditionUserId()
                )
                .collect(Collectors.toList());
    }

    @Data
    private static class ConditionsIds {
        Integer conditionCouponId;
        Integer conditionRefillId;
        Integer conditionUserId;
    }
}
