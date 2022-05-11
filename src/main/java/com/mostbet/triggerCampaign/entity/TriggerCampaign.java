package com.mostbet.triggerCampaign.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "trigger_campaign")
@Getter
@Setter
@NoArgsConstructor
public class TriggerCampaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "start_at", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Date startAt;

    @Column(name = "end_at", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Date endAt;

    @Column(name = "created_at", updatable = false, nullable = false)
    @Generated(GenerationTime.INSERT)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @Generated(GenerationTime.ALWAYS)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDateTime updatedAt;

    @Column(name = "is_published", columnDefinition = "BOOLEAN", nullable = false)
    private Boolean isPublished;

    @Column(name = "max_fulfillment_count")
    public Integer maxFulfillmentCount;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_availability", nullable = false)
    private UserAvailability userAvailability;

    @Type(type = "json")
    @Column(name = "client_platforms",  columnDefinition = "json")
    private Set<ClientPlatforms> clientPlatforms;

    @Column(name = "is_confirmation_participation", columnDefinition = "BOOLEAN", nullable = false)
    private Boolean isConfirmationParticipation;

    @Fetch(FetchMode.JOIN)
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "trigger_campaign_trigger_campaign_condition",
            joinColumns = @JoinColumn(name = "trigger_campaign_id"),
            inverseJoinColumns = @JoinColumn(name = "trigger_campaign_condition_id")
    )
    private Set<Condition> conditions;

    @ElementCollection(targetClass = User.class, fetch = FetchType.LAZY)
    @CollectionTable(
            name = "trigger_campaign_user",
            joinColumns = @JoinColumn(name = "trigger_campaign_id")
    )
    private Set<User> users;

    @ElementCollection(targetClass = User.class, fetch = FetchType.LAZY)
    @CollectionTable(
            name = "trigger_campaign_user_blacklist",
            joinColumns = @JoinColumn(name = "trigger_campaign_id")
    )
    private Set<User> userBlacklist;

    public enum UserAvailability {
        ALL,
        NEW,
    }

    public enum ClientPlatforms {
        MOBILE_APP,
        WEB_DESKTOP,
        WEB_MOBILE,
    }
}
