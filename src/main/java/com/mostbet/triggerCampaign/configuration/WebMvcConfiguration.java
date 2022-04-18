package com.mostbet.triggerCampaign.configuration;

import com.mostbet.triggerCampaign.configuration.handlerResolver.ApiPaginationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class WebMvcConfiguration implements WebMvcConfigurer {
    private final ApiPaginationResolver apiPaginationResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(apiPaginationResolver);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("*")
                .exposedHeaders("X-Total-Count");
    }
}