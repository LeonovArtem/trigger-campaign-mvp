package com.mostbet.triggerCampaign.web.controller.admin;

import com.mostbet.triggerCampaign.entity.dto.CampaignWithConditionIdsDto;
import com.mostbet.triggerCampaign.entity.dto.TriggerCampaignDto;
import com.mostbet.triggerCampaign.entity.dto.criteria.TriggerCampaignCriteria;
import com.mostbet.triggerCampaign.entity.mapper.TriggerCampaignMapper;
import com.mostbet.triggerCampaign.operation.triggerCampaign.crud.CampaignCRUDService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/campaign")
public class TriggerCampaignController {
    private final CampaignCRUDService campaignCRUDService;
    private final TriggerCampaignMapper campaignMapper;

    @GetMapping
    public Page<TriggerCampaignDto> getList(Pageable page, TriggerCampaignCriteria criteria) {
        return campaignCRUDService
                .getAll(page, criteria)
                .map(campaignMapper::triggerCampaignToTriggerCampaignDto);
    }

    @GetMapping("{id}")
    public TriggerCampaignDto getById(@PathVariable("id") Integer campaignId) {
        return campaignMapper.triggerCampaignToTriggerCampaignDto(
                campaignCRUDService.findById(campaignId).orElseThrow()
        );
    }

    @PostMapping
    public TriggerCampaignDto create(@RequestBody CampaignWithConditionIdsDto dto) {
        return campaignMapper
                .triggerCampaignToTriggerCampaignDto(campaignCRUDService.create(dto));
    }

    @PutMapping("{id}")
    public TriggerCampaignDto update(@RequestBody CampaignWithConditionIdsDto dto) {
        return campaignMapper
                .triggerCampaignToTriggerCampaignDto(campaignCRUDService.update(dto));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id) {
        campaignCRUDService.deleteById(id);
    }
}
