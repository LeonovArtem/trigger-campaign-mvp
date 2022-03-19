package com.mostbet.triggerCampaign.entity.conditionParamValue;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RefillMinAmount implements ParamValue{

    private String currencyCode;

    private BigDecimal amount;
}
