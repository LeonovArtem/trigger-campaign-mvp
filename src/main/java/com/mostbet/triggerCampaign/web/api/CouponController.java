package com.mostbet.triggerCampaign.web.api;

import com.mostbet.publicapi.sdk.model.UserCouponsResponse;
import com.mostbet.triggerCampaign.configuration.api.MostbetComApiClientConfiguration;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("coupon")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CouponController {
    private final MostbetComApiClientConfiguration.CouponApiClient couponApiClient;

    @GetMapping("list")
    public ResponseEntity<UserCouponsResponse> getList(){
        String dateFrom = ZonedDateTime.now()
                .minusDays(9999)
                .format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        String dateTo = ZonedDateTime.now()
                .plusDays(1)
                .format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        return couponApiClient.getCoupons(
                dateFrom, dateTo, null, null, null, null, null, null
        );
    }
}
