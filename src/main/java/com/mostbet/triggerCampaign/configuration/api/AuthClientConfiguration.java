package com.mostbet.triggerCampaign.configuration.api;

import org.springframework.context.annotation.Bean;

public class AuthClientConfiguration extends CommonClientConfiguration{
    @Bean
    public JWTAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new JWTAuthRequestInterceptor();
    }
}
