
package com.mostbet.triggerCampaign.configuration.api;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Value;

public class JWTAuthRequestInterceptor implements RequestInterceptor {

    @Value(value = "${mostbet.api.user_token}")
    private String userToken;

    @Override
    public void apply(RequestTemplate template) {
        template.header("Authorization", "Bearer " + userToken);
    }
}
