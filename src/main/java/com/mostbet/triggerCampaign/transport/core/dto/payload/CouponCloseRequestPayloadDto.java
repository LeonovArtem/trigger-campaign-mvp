package com.mostbet.triggerCampaign.transport.core.dto.payload;

import com.mostbet.triggerCampaign.entity.CouponType;
import com.mostbet.triggerCampaign.transport.core.dto.RequestDto;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CouponCloseRequestPayloadDto implements RequestDto.Payload{

    @JsonAlias({"coupon_id"})
    private int couponId;

    @JsonProperty("amount")
    private BigDecimal amount;

    @JsonProperty("currency")
    private String currencyCode;

    @JsonProperty("coupon_type")
    private CouponType couponType;
}
