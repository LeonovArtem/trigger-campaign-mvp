package com.mostbet.triggerCampaign.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "trigger_campaign_fulfillment")
@Getter
@Setter
@NoArgsConstructor
public class Fulfillment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_at", updatable = false, nullable = false)
    @Generated(GenerationTime.INSERT)
    private LocalDateTime createdAt;

    @Column(name = "user_id")
    private int userId;

    @ManyToOne
    @JoinColumn(name = "trigger_campaign_id")
    private TriggerCampaign triggerCampaign;
}
