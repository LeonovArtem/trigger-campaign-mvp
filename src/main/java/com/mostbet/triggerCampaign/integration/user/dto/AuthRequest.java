package com.mostbet.triggerCampaign.integration.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AuthRequest {

    @JsonProperty("_username")
    private String login;

    @JsonProperty("_password")
    private String password;
}
