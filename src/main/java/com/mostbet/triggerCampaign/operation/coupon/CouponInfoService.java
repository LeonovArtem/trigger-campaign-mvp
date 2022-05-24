package com.mostbet.triggerCampaign.operation.coupon;

import com.mostbet.publicapi.sdk.model.UserCouponsResponse;
import com.mostbet.triggerCampaign.configuration.api.MostbetComApiClientConfiguration;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CouponInfoService {
    private final MostbetComApiClientConfiguration.CouponApiClient couponApiClient;

    public ResponseEntity<UserCouponsResponse> getAllByUser() {
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

    public BigDecimal getSumClosedCoupons() {
        ResponseEntity<UserCouponsResponse> response = getAllByUser();

        double sum = response.getBody().getData()
                .stream()
                .mapToDouble(placedCoupon -> Double.parseDouble(placedCoupon.getAmount()))
                .sum();

        return BigDecimal.valueOf(sum);
    }
}
