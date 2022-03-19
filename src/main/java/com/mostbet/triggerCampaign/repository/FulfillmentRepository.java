package com.mostbet.triggerCampaign.repository;

import com.mostbet.triggerCampaign.entity.Fulfillment;
import com.mostbet.triggerCampaign.entity.TriggerCampaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FulfillmentRepository extends JpaRepository<Fulfillment, Integer> {

    Integer countByUserIdAndTriggerCampaign(int userId, TriggerCampaign triggerCampaign);
}
