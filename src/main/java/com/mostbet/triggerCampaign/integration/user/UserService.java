package com.mostbet.triggerCampaign.integration.user;

import com.mostbet.triggerCampaign.integration.user.dto.AuthRequest;
import com.mostbet.triggerCampaign.integration.user.dto.AuthResponse;

public interface UserService {
    AuthResponse geAuthToken(AuthRequest userDto);
}
