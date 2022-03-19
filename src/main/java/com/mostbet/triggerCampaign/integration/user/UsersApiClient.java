package com.mostbet.triggerCampaign.integration.user;

import com.mostbet.triggerCampaign.integration.user.dto.AuthRequest;
import com.mostbet.triggerCampaign.integration.user.dto.AuthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UsersApiClient {

    @Value(value = "${app.mostbet.base_url}")
    private String baseUrl;

    private final RestTemplate restTemplate;
    private final RedisTemplate<String, Object> redisTemplate;

    public String getBearerToken(String username, String password) {
        AuthResponse authToken = geAuthToken(username, password);

        return String.format("Bearer %s", authToken.getToken());
    }

    public AuthResponse geAuthToken(String username, String password) {
        AuthRequest userDto = new AuthRequest(username, password);
        HttpEntity requestEntity = new HttpEntity(userDto);

        ResponseEntity<AuthResponse> responseEntity = restTemplate.exchange(
                baseUrl + "/api/login_check",
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<>() {
                }
        );

        return responseEntity.getBody();
    }
}
