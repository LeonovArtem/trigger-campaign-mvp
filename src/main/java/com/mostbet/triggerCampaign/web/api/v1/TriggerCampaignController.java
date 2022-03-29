package com.mostbet.triggerCampaign.web.api.v1;

import com.mostbet.triggerCampaign.entity.TriggerCampaign;
import com.mostbet.triggerCampaign.entity.dto.TriggerCampaignDto;
import com.mostbet.triggerCampaign.operation.triggerCampaign.create.CampaignCreateService;
import com.mostbet.triggerCampaign.operation.triggerCampaign.getInfo.CampaignInfoService;
import com.mostbet.triggerCampaign.repository.TriggerCampaignRepository;
import com.mostbet.triggerCampaign.web.api.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/api/v1/trigger-campaign")
public class TriggerCampaignController {
    private final TriggerCampaignRepository campaignRepository;
    private final CampaignCreateService campaignCreateService;
    private final CampaignInfoService campaignInfoService;

    @GetMapping
    public List<TriggerCampaignDto> getList(){
        return campaignInfoService.getAllCampaign();
    }

    @GetMapping("{id}")
    public TriggerCampaignDto getOne(@PathVariable("id") int campaignId) {
        return campaignInfoService.getById(campaignId);
    }

    @PostMapping
    public TriggerCampaign create(@RequestBody TriggerCampaignDto campaign) {
        return campaignCreateService.create(campaign);
    }

    @PutMapping("{id}")
    public TriggerCampaign update(
            @PathVariable("id") TriggerCampaign campaignFromDb,
            @RequestBody TriggerCampaign campaign
    ) {
        BeanUtils.copyProperties(campaign, campaignFromDb, "id");

        return campaignRepository.save(campaignFromDb);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") int id) throws NotFoundException {
        TriggerCampaign campaign = campaignRepository.findById(id).orElseThrow(NotFoundException::new);

        campaignRepository.delete(campaign);
    }
}
