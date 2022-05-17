package com.mostbet.triggerCampaign.repository;

import com.mostbet.triggerCampaign.entity.Condition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConditionRepository extends JpaRepository<Condition, Integer>, JpaSpecificationExecutor<Condition> {

    @Query(value = ""
            + "SELECT DISTINCT c.* "
            + "FROM trigger_campaign_condition c "
            + "JOIN trigger_campaign_trigger_campaign_condition ctc ON ctc.trigger_campaign_condition_id = c.id "
            + "LEFT JOIN trigger_campaign_condition_fulfillment cf ON c.id = cf.condition_id "
            + "AND cf.trigger_campaign_id = ctc.trigger_campaign_id "
            + "AND cf.user_id = :userId "
            + "AND cf.fulfillment_id is null "
            + "WHERE ctc.trigger_campaign_id = :triggerCampaignId "
            + "AND cf.id is null",
            nativeQuery = true
    )
    List<Condition> findActiveConditions(@Param("triggerCampaignId") int triggerCampaignId, @Param("userId") int userId);
}
