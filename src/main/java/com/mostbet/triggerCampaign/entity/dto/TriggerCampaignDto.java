package com.mostbet.triggerCampaign.entity.dto;

import com.mostbet.triggerCampaign.entity.TriggerCampaign;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TriggerCampaignDto implements Serializable {
//    private Integer id;
    private String name;
    private String description;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private Boolean isPublished;
    private Integer maxFulfillmentCount;
    private TriggerCampaign.UserAvailability userAvailability;
}
