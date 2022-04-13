package com.mostbet.triggerCampaign.web.api.v1;

import com.mostbet.triggerCampaign.entity.TriggerCampaign;
import com.mostbet.triggerCampaign.entity.dto.CampaignWithConditionIdsDto;
import com.mostbet.triggerCampaign.entity.dto.TriggerCampaignDto;
import com.mostbet.triggerCampaign.entity.dto.criteria.TriggerCampaignCriteria;
import com.mostbet.triggerCampaign.operation.triggerCampaign.create.CampaignCreateService;
import com.mostbet.triggerCampaign.operation.triggerCampaign.getInfo.CampaignInfoService;
import com.mostbet.triggerCampaign.repository.TriggerCampaignRepository;
import com.mostbet.triggerCampaign.web.api.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/api/v1/trigger-campaign")
public class TriggerCampaignController {
    private final TriggerCampaignRepository campaignRepository;
    private final CampaignCreateService campaignCreateService;
    private final CampaignInfoService campaignInfoService;

    @GetMapping
    public Page<TriggerCampaign> getList(Pageable page, TriggerCampaignCriteria criteria) {
        return campaignInfoService.getAllCampaign(page, criteria);
    }

    @GetMapping("{id}")
    public TriggerCampaignDto getById(@PathVariable("id") int campaignId) {
        return campaignInfoService.getById(campaignId);
    }

    @PostMapping
    public TriggerCampaign create(@RequestBody CampaignWithConditionIdsDto campaignWithConditionIdsDto) {

        return campaignCreateService.create(campaignWithConditionIdsDto);
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
