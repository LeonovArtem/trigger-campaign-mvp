package com.mostbet.triggerCampaign.configuration;

import com.mostbet.triggerCampaign.configuration.handlerResolver.ApiPaginationResolver;
import com.mostbet.triggerCampaign.util.converter.StringToFilterDtoConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
    private final ApiPaginationResolver apiPaginationResolver;

    public WebMvcConfiguration(ApiPaginationResolver apiPaginationResolver) {
        this.apiPaginationResolver = apiPaginationResolver;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToFilterDtoConverter());
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(apiPaginationResolver);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedMethods("*")
                        //Todo Нужно для фронта
                        .exposedHeaders("X-Total-Count");
            }
        };
    }
}