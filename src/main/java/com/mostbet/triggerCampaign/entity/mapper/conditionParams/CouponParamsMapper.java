package com.mostbet.triggerCampaign.entity.mapper.conditionParams;

import com.mostbet.triggerCampaign.entity.ConditionParam;
import com.mostbet.triggerCampaign.entity.conditionParamValue.coupon.*;
import com.mostbet.triggerCampaign.entity.conditionParamValue.fulfillment.LimitPerDayDto;
import com.mostbet.triggerCampaign.entity.dto.ConditionCouponDto;
import com.mostbet.triggerCampaign.entity.dto.ConditionDto;
import com.mostbet.triggerCampaign.entity.dto.conditionParams.CouponParamsDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.ArrayList;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public abstract class CouponParamsMapper implements ConditionParamsMapper {
    @Override
    public CouponParamsDto conditionParamsToParamsDto(List<ConditionParam> conditionParams) {
        CouponParamsDto couponParamsDto = new CouponParamsDto();
        List<ConditionCouponDto.CurrencyLimitDto> limits = new ArrayList<>();
        conditionParams.forEach(conditionParam -> {
            if (conditionParam.getParamValue() instanceof CouponMinCoefficientDto) {
                couponParamsDto.setMinCoefficient(
                        ((CouponMinCoefficientDto) conditionParam.getParamValue()).getCoefficient()
                );
            }

            if (conditionParam.getParamValue() instanceof CouponStatusDto) {
                couponParamsDto.setCouponStatus(
                        ((CouponStatusDto) conditionParam.getParamValue()).getCouponStatus()
                );
            }

            if (conditionParam.getParamValue() instanceof CouponTypeDto) {
                couponParamsDto.setCouponType(
                        ((CouponTypeDto) conditionParam.getParamValue()).getCouponType()
                );
            }

            if (conditionParam.getParamValue() instanceof CouponLineTypeDto) {
                couponParamsDto.setLineType(
                        ((CouponLineTypeDto) conditionParam.getParamValue()).getCouponLineType()
                );
            }

            if (conditionParam.getParamValue() instanceof CouponIsFirstDto) {
                couponParamsDto.setCouponIsFirst(
                        ((CouponIsFirstDto) conditionParam.getParamValue()).getValue()
                );
            }

            if (conditionParam.getParamValue() instanceof LimitPerDayDto) {
                couponParamsDto.setLimitPerDay(
                        ((LimitPerDayDto) conditionParam.getParamValue()).getValue()
                );
            }

            if (conditionParam.getParamValue() instanceof CouponMinAmountDto) {
                CouponMinAmountDto couponMinAmountDto = (CouponMinAmountDto) conditionParam.getParamValue();
                limits.add(
                        new ConditionCouponDto.CurrencyLimitDto()
                                .setCurrencyCode(couponMinAmountDto.getCurrencyCode())
                                .setMinAmount(couponMinAmountDto.getAmount())
                );
            }
        });

        if (!limits.isEmpty()) {
            couponParamsDto.setLimits(limits);
        }

        return couponParamsDto;
    }

    @Override
    public List<ConditionParam> paramsDtoToConditionParams(ConditionDto.Params params) {
        List<ConditionParam> conditionParamList = new ArrayList<>();
        CouponParamsDto couponParams = (CouponParamsDto) params;

        if (couponParams.getMinCoefficient() != null) {
            conditionParamList.add(
                    createConditionParam(
                            ConditionParam.ConditionParamName.COUPON_MIN_COEFFICIENT,
                            new CouponMinCoefficientDto(couponParams.getMinCoefficient())
                    )
            );
        }

        if (couponParams.getCouponStatus() != null) {
            conditionParamList.add(
                    createConditionParam(
                            ConditionParam.ConditionParamName.COUPON_STATUS,
                            new CouponStatusDto(couponParams.getCouponStatus())
                    )
            );
        }

        if (couponParams.getCouponType() != null) {
            conditionParamList.add(
                    createConditionParam(
                            ConditionParam.ConditionParamName.COUPON_TYPE,
                            new CouponTypeDto(couponParams.getCouponType())
                    )
            );
        }

        if (couponParams.getLineType() != null) {
            conditionParamList.add(
                    createConditionParam(
                            ConditionParam.ConditionParamName.COUPON_LINE_TYPE,
                            new CouponLineTypeDto(couponParams.getLineType())
                    )
            );
        }

        if (couponParams.getCouponIsFirst() != null) {
            conditionParamList.add(
                    createConditionParam(
                            ConditionParam.ConditionParamName.COUPON_IS_FIRST,
                            new CouponIsFirstDto(couponParams.getCouponIsFirst())
                    )
            );
        }

        if (couponParams.getLimitPerDay() != null) {
            conditionParamList.add(
                    createConditionParam(
                            ConditionParam.ConditionParamName.CONDITION_FULFILLMENT_LIMIT_PER_DAY,
                            new LimitPerDayDto(couponParams.getLimitPerDay())
                    )
            );
        }

        couponParams.getLimits().forEach(currencyLimitDto -> {
            if (currencyLimitDto.getMinAmount() != null) {
                conditionParamList.add(
                        createConditionParam(
                                ConditionParam.ConditionParamName.COUPON_MIN_AMOUNT,
                                new CouponMinAmountDto(
                                        currencyLimitDto.getCurrencyCode(),
                                        currencyLimitDto.getMinAmount()
                                )
                        )
                );
            }
        });

        return conditionParamList;
    }
}
