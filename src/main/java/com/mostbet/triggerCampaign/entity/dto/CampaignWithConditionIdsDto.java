package com.mostbet.triggerCampaign.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mostbet.triggerCampaign.entity.TriggerCampaign;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
public class CampaignWithConditionIdsDto {
    private Integer id;

    private String name;

    private String description;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDateTime startAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDateTime endAt;

    private Boolean isPublished;

    private Integer maxFulfillmentCount;

    private TriggerCampaign.UserAvailability userAvailability;

    private ConditionsIds conditionsIds;

    public List<Integer> getAllConditionIds(){
        return Stream.of(conditionsIds.coupons, conditionsIds.refills, conditionsIds.users)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    @Data
    private static class ConditionsIds {
        List<Integer> coupons = new ArrayList<>();

        List<Integer> refills= new ArrayList<>();

        List<Integer> users = new ArrayList<>();
    }
}
