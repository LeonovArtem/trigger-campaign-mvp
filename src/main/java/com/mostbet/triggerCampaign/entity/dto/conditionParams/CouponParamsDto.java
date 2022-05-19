package com.mostbet.triggerCampaign.entity.dto.conditionParams;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mostbet.triggerCampaign.entity.CouponLineType;
import com.mostbet.triggerCampaign.entity.CouponStatus;
import com.mostbet.triggerCampaign.entity.CouponType;
import com.mostbet.triggerCampaign.entity.dto.ConditionCouponDto;
import com.mostbet.triggerCampaign.entity.dto.ConditionDto;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CouponParamsDto implements ConditionDto.Params {

    @JsonProperty("couponMinCoefficient")
    private BigDecimal minCoefficient;

    @JsonProperty("couponStatus")
    private CouponStatus couponStatus;

    @JsonProperty("couponType")
    private CouponType couponType;

    @JsonProperty("couponLineType")
    private CouponLineType lineType;

    @JsonProperty("couponIsFirst")
    private Boolean couponIsFirst;

    @JsonProperty("limitPerDay")
    private Boolean limitPerDay;

    @JsonProperty("limits")
    private Set<ConditionCouponDto.CurrencyLimitDto> limits;

    public static class CurrencyLimitDto {
        @JsonProperty("currency")
        private String currencyCode;

        @JsonProperty("amount")
        private String amount;
    }
}
