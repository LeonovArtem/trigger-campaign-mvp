package com.mostbet.triggerCampaign.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mostbet.triggerCampaign.entity.TriggerCampaign;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TriggerCampaignDto implements Serializable {
    private Integer id;

    private String name;

    private String description;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDateTime createdAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Date startAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Date endAt;

    private Boolean isPublished;

    private Integer maxFulfillmentCount;

    private TriggerCampaign.UserAvailability userAvailability;

    private Boolean isConfirmationParticipation;

    private Set<TriggerCampaign.ClientPlatforms> clientPlatforms;

    private List<ConditionDto<ConditionDto.Params>> conditions;
}
