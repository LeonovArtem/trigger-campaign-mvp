package com.mostbet.triggerCampaign.entity.dto.conditionParams;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mostbet.triggerCampaign.entity.CouponStatus;
import com.mostbet.triggerCampaign.entity.dto.ConditionCouponDto;
import com.mostbet.triggerCampaign.entity.dto.ConditionDto;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CouponParamsDto implements ConditionDto.ConditionParams {

    @JsonAlias("couponMinCoefficient")
    private BigDecimal minCoefficient;

    @JsonAlias("couponStatus")
    private CouponStatus couponStatus;

    @JsonProperty("limits")
    private List<ConditionCouponDto.CurrencyLimitDto> limits;

    public static class CurrencyLimitDto {
        @JsonProperty("currency")
        private String currencyCode;

        @JsonProperty("amount")
        private String amount;
    }
}
