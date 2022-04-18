package com.mostbet.triggerCampaign.entity;

import com.mostbet.triggerCampaign.entity.conditionParamValue.ParamValue;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "condition_param")
@Getter
@Setter
@NoArgsConstructor
@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonStringType.class),
})
public class ConditionParam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, updatable = false)
    private ConditionParamName name;

    @Type(type = "json")
    @Column(name = "value", columnDefinition = "json")
    private ParamValue paramValue;

    public enum ConditionParamName {
        COUPON_TYPE,
        COUPON_STATUS,
        COUPON_MIN_COEFFICIENT,
        COUPON_LINE_CATEGORY,
        COUPON_LINE_TYPE,
        COUPON_LINE_MATCH,
        COUPON_LINE_SUBCATEGORY,
        COUPON_MIN_AMOUNT,
        COUPON_MIN_SUM_AMOUNT,
        COUPON_IS_ACTIVE_BONUS,
        COUPON_EXPRESS_COUNT_LOSE_BET,
        COUPON_EXPRESS_MIN_COUNT_BET,
        COUPON_EXPRESS_MINIMAL_COEFFICIENT_BET,
        COUPON_EXPRESS_MIN_COUNT_WIN_BET,
        COUPON_IS_FREE,
        COUPON_IS_PROMO,
        COUPON_IS_FIRST,

        CONDITION_FULFILLMENT_SEQUENCE,
        CONDITION_FULFILLMENT_LIMIT_PER_DAY,

        REFILL_MIN_AMOUNT,
        REFILL_COUNT_PER_USER,
        REFILL_DAYS_OF_WEEK,

        USER_AVAILABLE_CURRENCY,
        USER_AVAILABLE_BONUS;

        public static List<ConditionParamName> namesForLimit() {
            return List.of(COUPON_MIN_AMOUNT, COUPON_MIN_SUM_AMOUNT, REFILL_MIN_AMOUNT);
        }
    }
}
