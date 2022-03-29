package com.mostbet.triggerCampaign.util.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mostbet.triggerCampaign.util.converter.dto.FilterDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class StringToFilterDtoConverter implements Converter<String, FilterDto> {

    @Override
    public FilterDto convert(String source) {
        try {
            return new ObjectMapper().readValue(source, FilterDto.class);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
