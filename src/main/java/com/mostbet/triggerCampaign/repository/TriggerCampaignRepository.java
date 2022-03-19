package com.mostbet.triggerCampaign.repository;

import com.mostbet.triggerCampaign.entity.TriggerCampaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TriggerCampaignRepository extends JpaRepository<TriggerCampaign, Integer> {

    @Query(value = ""
            + "SELECT tc.* "
            + "FROM trigger_campaign tc "
            + "LEFT JOIN trigger_campaign_user tcu ON tc.id = tcu.trigger_campaign_id AND tcu.user_id = :userId "
            + "LEFT JOIN trigger_campaign_user_blacklist tcub ON tc.id = tcub.trigger_campaign_id AND tcub.user_id = :userId "
            + "WHERE (:now BETWEEN tc.start_at AND tc.end_at) "
            + "AND tc.is_published = 1 "
            + "AND (tcu.user_id IS NOT NULL OR tc.user_availability IS NOT NULL) "
            + "AND tcub.user_id IS NULL ",
            nativeQuery = true
    )
    List<TriggerCampaign> findActiveTriggerCampaignByUserId(@Param("userId") int userId, LocalDateTime now);
}
