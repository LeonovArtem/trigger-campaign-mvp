package com.mostbet.triggerCampaign.repository;

import com.mostbet.triggerCampaign.entity.ConditionFulfillment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConditionFulfillmentRepository extends JpaRepository<ConditionFulfillment, Integer> {

    @Query(value = ""
            + "SELECT tccf.* "
            + "FROM trigger_campaign_condition_fulfillment tccf "
            + "WHERE tccf.user_id = :userId "
            + "AND tccf.trigger_campaign_id = :triggerCampaignId "
            + "AND tccf.fulfillment_id IS NULL ",
            nativeQuery = true
    )
    List<ConditionFulfillment> findActiveConditionFulfillment(int userId, int triggerCampaignId);
}
