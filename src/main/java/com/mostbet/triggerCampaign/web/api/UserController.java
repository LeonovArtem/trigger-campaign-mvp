package com.mostbet.triggerCampaign.web.api;

import com.mostbet.publicapi.sdk.model.GetStatus;
import com.mostbet.triggerCampaign.configuration.api.MostbetComApiClientConfiguration;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
    private final MostbetComApiClientConfiguration.UsersApiClient apiClient;

    @GetMapping("/{id}/status")
    public ResponseEntity<GetStatus> getUserStatus(@PathVariable("id") int userId) {
        return apiClient.getStatus(userId);
    }
}
