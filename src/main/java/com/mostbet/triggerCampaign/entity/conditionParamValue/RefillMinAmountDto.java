package com.mostbet.triggerCampaign.entity.conditionParamValue;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class RefillMinAmountDto implements ParamValue {
    private String currencyCode;
    private BigDecimal amount;
}
