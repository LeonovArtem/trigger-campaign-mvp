package com.mostbet.triggerCampaign.integration.user.dto;

import com.mostbet.triggerCampaign.integration.Dto.User;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Getter
@Setter
@Accessors(chain = true)
public class AuthResponse implements Serializable{
    private User user;
    private String token;
}
