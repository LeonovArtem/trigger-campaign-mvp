package com.mostbet.triggerCampaign.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "trigger_campaign_condition")
@Getter
@Setter
@NoArgsConstructor
public class Condition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, updatable = false)
    private Type type;

    @Fetch(FetchMode.JOIN)
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "trigger_campaign_condition_params",
            joinColumns = @JoinColumn(name = "condition_id"),
            inverseJoinColumns = @JoinColumn(name = "params_id")
    )
    private List<ConditionParam> params;

    public enum Type {
        COUPON,
        REFILL,
        USER,
        EVENT,
        CONDITION_FULFILLMENT,
    }
}
