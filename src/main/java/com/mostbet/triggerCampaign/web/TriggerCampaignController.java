package com.mostbet.triggerCampaign.web;

import com.mostbet.triggerCampaign.entity.TriggerCampaign;
import com.mostbet.triggerCampaign.repository.TriggerCampaignRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("trigger-campaign")
public class TriggerCampaignController {
    private final TriggerCampaignRepository triggerCampaignRepository;

    @GetMapping
    public List<TriggerCampaign> getList(){
        return triggerCampaignRepository.findAll();
    }
}
