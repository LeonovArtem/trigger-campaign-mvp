package com.mostbet.triggerCampaign.integration.coupon;

import com.mostbet.triggerCampaign.integration.coupon.dto.CouponDto;
import com.mostbet.triggerCampaign.integration.user.UserService;
import com.mostbet.triggerCampaign.integration.user.dto.AuthRequest;
import com.mostbet.triggerCampaign.integration.user.dto.AuthResponse;
import com.mostbet.triggerCampaign.web.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CouponApiClient {
    private String DEFAULT_DATE_FROM = "22.01.2015";

    @Value(value = "${app.mostbet.base_url}")
    private String baseUrl;

    private final RestTemplate restTemplate;
    private final UserService userService;

    public CouponDto.CouponDataDto getCouponById(int couponId) {
        UriComponents urlBuilder = UriComponentsBuilder
                .fromHttpUrl(baseUrl + "/api/v1/user/coupons.json")
                .queryParam("couponIds", couponId)
                .queryParam("dateFrom", DEFAULT_DATE_FROM)
                .queryParam("dateTo", formatDate(new Date()))
                .build();

        ResponseEntity<CouponDto> response = restTemplate.exchange(
                urlBuilder.toUriString(),
                HttpMethod.GET,
                new HttpEntity<String>(getHttpHeaders()),
                CouponDto.class
        );

        try {
            return response.getBody().getData().get(0);
        } catch (Exception e){
            throw new NotFoundException();
        }
    }

    private HttpHeaders getHttpHeaders() {
        AuthResponse authToken = userService
                .geAuthToken(new AuthRequest("test_artem@ya.ru", "betmen88"));

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", String.format("Bearer %s", authToken.getToken()));

        return httpHeaders;
    }

    private String formatDate(Date date) {
        var dateFormatter = new SimpleDateFormat("dd.MM.yyyy");

        return dateFormatter.format(date);
    }
}
