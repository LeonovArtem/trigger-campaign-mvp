package com.mostbet.triggerCampaign.configuration.api;

import com.mostbet.publicapi.sdk.*;
import com.mostbet.triggerCampaign.configuration.api.ClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;

public class MostbetComApiClientConfiguration {
    @FeignClient(
            name = "couponApiClient",
            url = "${app.mostbet.base_url}",
            configuration = {ClientConfiguration.class}
    )
    public interface CouponApiClient extends CouponApi {
    }

    @FeignClient(
            name = "usersApiClient",
            url = "${app.mostbet.base_url}",
            configuration = {ClientConfiguration.class}
    )
    public interface UsersApiClient extends UsersApi {
    }
}