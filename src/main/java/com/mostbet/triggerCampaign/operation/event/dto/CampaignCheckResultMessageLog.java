package com.mostbet.triggerCampaign.operation.event.dto;

import com.mostbet.triggerCampaign.entity.Event;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import java.io.Serializable;

@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonStringType.class),
})
@Getter
@Setter
public class CampaignCheckResultMessageLog implements Serializable {

    @JsonProperty("user_id")
    private int userId;

    @JsonProperty("campaign_id")
    private int triggerCampaignId;

    @JsonProperty("is_fulfilled")
    private boolean isFulfilled;

    @JsonProperty("is_fulfillment_limit_reached")
    private boolean isFulfillmentLimitReached;

    @JsonProperty("event_name")
    private Event event;
}
