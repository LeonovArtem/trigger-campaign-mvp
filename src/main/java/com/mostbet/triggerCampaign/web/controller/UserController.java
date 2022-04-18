package com.mostbet.triggerCampaign.web.controller;

import com.mostbet.publicapi.sdk.model.GetStatus;
import com.mostbet.publicapi.sdk.model.LoginCheckRequest;
import com.mostbet.publicapi.sdk.model.LoginCheckResponse;
import com.mostbet.publicapi.sdk.model.UserProfile;
import com.mostbet.triggerCampaign.configuration.api.MostbetComApiClientConfiguration;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
    private final MostbetComApiClientConfiguration.UsersApiClient apiClient;
    private final MostbetComApiClientConfiguration.UsersAuthApiClient usersAuthApiClient;

    @GetMapping
    public ResponseEntity<UserProfile> getUser() {
        return apiClient.getUser();
    }

    @GetMapping("/{id}/status")
    public ResponseEntity<GetStatus> getUserStatus(@PathVariable("id") int userId) {
        return apiClient.getStatus(userId);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginCheckResponse> login(@RequestBody LoginCheckRequest loginCheckRequest) {

        return usersAuthApiClient.login(loginCheckRequest);
    }
}
