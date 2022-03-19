package com.mostbet.triggerCampaign.web.api;

import com.mostbet.triggerCampaign.integration.user.UserService;
import com.mostbet.triggerCampaign.integration.user.dto.AuthRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
    private final UserService userService;

    @GetMapping("token")
    public String getUserToken() {
        return userService
                .geAuthToken(new AuthRequest("test_artem@ya.ru", "betmen88"))
                .getToken();
    }
}
