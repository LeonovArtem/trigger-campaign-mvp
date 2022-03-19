package com.mostbet.triggerCampaign.transport.core.dto.payload;

import com.mostbet.triggerCampaign.transport.core.dto.RequestDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RefillSuccessRequestPayloadDto implements RequestDto.Payload{

    @JsonProperty("refill_id")
    private int refillId;

    @JsonProperty("amount")
    private BigDecimal amount;

    @JsonProperty("currency")
    private String currencyCode;
}
