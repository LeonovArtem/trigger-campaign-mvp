package com.mostbet.triggerCampaign.integration.user;

import com.mostbet.triggerCampaign.integration.user.dto.AuthRequest;
import com.mostbet.triggerCampaign.integration.user.dto.AuthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Primary
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RedisDecorator implements UserService{

    private static final String KEY_PREFIX = "user_auth_token_";

    private final UserService inner;
    private final RedisTemplate<String, Object> redisTemplate;

    @Override
    public AuthResponse geAuthToken(AuthRequest userDto) {
        String key = getKey(userDto.getLogin());
        if (redisTemplate.opsForValue().get(key) instanceof AuthResponse) {
            return (AuthResponse) redisTemplate.opsForValue().get(key);
        }

        AuthResponse authResponse = inner.geAuthToken(userDto);

        redisTemplate.opsForValue().set(key, authResponse);
        redisTemplate.expire(key, Duration.ofMinutes(1L));

        return authResponse;
    }

    private String getKey(String key) {
        return KEY_PREFIX + key;
    }
}
