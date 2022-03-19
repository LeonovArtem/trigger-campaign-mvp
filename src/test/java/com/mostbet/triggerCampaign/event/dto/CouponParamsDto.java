package com.mostbet.triggerCampaign.event.dto;

import com.mostbet.triggerCampaign.entity.CouponType;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class CouponParamsDto {
    private BigDecimal amount;
    private CouponType type;
    private String currencyCode;
}
