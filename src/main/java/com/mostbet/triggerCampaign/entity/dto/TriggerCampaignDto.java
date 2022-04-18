package com.mostbet.triggerCampaign.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mostbet.triggerCampaign.entity.TriggerCampaign;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

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
    private LocalDateTime startAt;

//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.Y HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDateTime endAt;

    private Boolean isPublished;

    private Integer maxFulfillmentCount;

    private TriggerCampaign.UserAvailability userAvailability;

    private List<ConditionDto<ConditionDto.Params>> conditions;
}
