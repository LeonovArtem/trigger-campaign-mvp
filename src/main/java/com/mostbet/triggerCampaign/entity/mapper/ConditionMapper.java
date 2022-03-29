package com.mostbet.triggerCampaign.entity.mapper;

import com.mostbet.triggerCampaign.entity.Condition;
import com.mostbet.triggerCampaign.entity.ConditionParam;
import com.mostbet.triggerCampaign.entity.conditionParamValue.CouponMinimalCoefficient;
import com.mostbet.triggerCampaign.entity.conditionParamValue.CouponStatusDto;
import com.mostbet.triggerCampaign.entity.conditionParamValue.ParamValue;
import com.mostbet.triggerCampaign.entity.dto.ConditionDto;
import com.mostbet.triggerCampaign.entity.dto.conditionParams.CouponParamsDto;
import com.mostbet.triggerCampaign.entity.dto.conditionParams.RefillParamsDto;
import com.mostbet.triggerCampaign.entity.dto.conditionParams.UserParamsDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.ArrayList;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ConditionMapper {
    default Condition conditionDtoToCondition(ConditionDto<ConditionDto.ConditionParams> conditionDto) {
        if (conditionDto == null) {
            return null;
        }

        Condition condition = new Condition();
        condition.setName(conditionDto.getName());
        condition.setType(conditionDto.getConditionType());
        condition.setParams(assembleParams(conditionDto));

        return condition;
    }

    private List<ConditionParam> assembleParams(ConditionDto<ConditionDto.ConditionParams> conditionDto) {
        switch (conditionDto.getConditionType()) {
            case COUPON:
                return createParams((CouponParamsDto) conditionDto.getParams());
            case REFILL:
                return createParams((RefillParamsDto) conditionDto.getParams());
            case USER:
                return createParams((UserParamsDto) conditionDto.getParams());
            default:
                throw new RuntimeException("Unidentified operation");

        }
    }

    private List<ConditionParam> createParams(CouponParamsDto couponParams) {
        List<ConditionParam> conditionParamList = new ArrayList<>();

        if (couponParams.getMinCoefficient() != null) {
            conditionParamList.add(
                    createConditionParam(
                            ConditionParam.ConditionParamName.COUPON_MIN_COEFFICIENT,
                            new CouponMinimalCoefficient(couponParams.getMinCoefficient())
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

        return conditionParamList;
    }

    private List<ConditionParam> createParams(RefillParamsDto conditionDto) {
        List<ConditionParam> conditionParamList = new ArrayList<>();

        return conditionParamList;
    }

    private List<ConditionParam> createParams(UserParamsDto conditionDto) {
        List<ConditionParam> conditionParamList = new ArrayList<>();

        return conditionParamList;
    }

    private ConditionParam createConditionParam(ConditionParam.ConditionParamName paramName, ParamValue value) {
        ConditionParam conditionParam = new ConditionParam();
        conditionParam.setName(paramName);
        conditionParam.setValue(value);

        return conditionParam;
    }

}
