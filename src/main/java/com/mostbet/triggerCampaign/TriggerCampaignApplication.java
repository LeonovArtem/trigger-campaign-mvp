package com.mostbet.triggerCampaign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableFeignClients
@EnableRetry
@EnableIntegration
public class TriggerCampaignApplication {

    public static void main(String[] args) {
        SpringApplication.run(TriggerCampaignApplication.class, args);
    }

}
