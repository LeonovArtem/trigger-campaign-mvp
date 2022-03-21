package com.mostbet.triggerCampaign.configuration.api;

import com.mostbet.publicapi.sdk.CouponApi;
import com.mostbet.publicapi.sdk.UsersApi;
import org.springframework.cloud.openfeign.FeignClient;

public class MostbetComApiClientConfiguration {
    @FeignClient(
            name = "couponApiClient",
            url = "${app.mostbet.base_url}",
            configuration = {AuthClientConfiguration.class}
    )
    public interface CouponApiClient extends CouponApi {
    }

    @FeignClient(
            name = "usersApiClient",
            url = "${app.mostbet.base_url}",
            configuration = {AuthClientConfiguration.class}
    )
    public interface UsersApiClient extends UsersApi {
    }

    @FeignClient(
            name = "usersAuthApiClient",
            url = "${app.mostbet.base_url}",
            configuration = {CommonClientConfiguration.class}
    )
    public interface UsersAuthApiClient extends UsersApi {
    }
}
