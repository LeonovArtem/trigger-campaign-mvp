package com.mostbet.triggerCampaign.web.api;

import com.mostbet.triggerCampaign.integration.coupon.CouponApiClient;
import com.mostbet.triggerCampaign.integration.coupon.dto.CouponDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("coupon")
public class CouponController {

    @Autowired
    private CouponApiClient couponApiClient;

    @GetMapping("{id}")
    public ResponseEntity<Object> getCouponInfo(@PathVariable("id") int couponId) {

        CouponDto.CouponDataDto couponDataDto = couponApiClient.getCouponById(couponId);

        return new ResponseEntity<>(couponDataDto, HttpStatus.OK);
    }
}
