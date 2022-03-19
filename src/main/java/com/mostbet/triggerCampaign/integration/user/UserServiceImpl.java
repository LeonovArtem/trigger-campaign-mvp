package com.mostbet.triggerCampaign.integration.user;

import com.mostbet.triggerCampaign.integration.user.dto.AuthRequest;
import com.mostbet.triggerCampaign.integration.user.dto.AuthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService{

    private final UsersApiClient apiClient;

    @Override
    public AuthResponse geAuthToken(AuthRequest userDto) {
        return apiClient.geAuthToken(userDto.getLogin(), userDto.getPassword());
    }
}
