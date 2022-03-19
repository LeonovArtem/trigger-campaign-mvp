package com.mostbet.triggerCampaign.transport.core.dto;


import com.mostbet.triggerCampaign.entity.Event;
import com.mostbet.triggerCampaign.transport.core.dto.payload.CouponCloseRequestPayloadDto;
import com.mostbet.triggerCampaign.transport.core.dto.payload.RefillSuccessRequestPayloadDto;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestDto<T extends RequestDto.Payload> {

    @JsonAlias({"event_name"})
    private Event event;

    @JsonAlias({"event_timestamp"})
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime eventDateTime;

    @JsonAlias({"user_id"})
    private int userId;

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "event_name")
    @JsonSubTypes({
            @JsonSubTypes.Type(name = "refill_succeeded", value = RefillSuccessRequestPayloadDto.class),
            @JsonSubTypes.Type(name = "coupon_closed", value = CouponCloseRequestPayloadDto.class),
    })
    private T payload;

    public interface Payload {}
}
