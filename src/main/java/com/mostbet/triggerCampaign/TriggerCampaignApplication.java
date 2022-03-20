package com.mostbet.triggerCampaign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TriggerCampaignApplication {

    public static void main(String[] args) {
        SpringApplication.run(TriggerCampaignApplication.class, args);
    }

}
