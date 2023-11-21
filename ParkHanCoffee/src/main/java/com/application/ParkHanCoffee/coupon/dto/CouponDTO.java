package com.application.ParkHanCoffee.coupon.dto;

import org.springframework.stereotype.Component;

@Component
public class CouponDTO {
	
	private long couponId;
	private String couponExistence;
	private String couponNumber;
	
	public long getCouponId() {
		return couponId;
	}
	public void setCouponId(long couponId) {
		this.couponId = couponId;
	}
	public String getCouponExistence() {
		return couponExistence;
	}
	public void setCouponExistence(String couponExistence) {
		this.couponExistence = couponExistence;
	}
	public String getCouponNumber() {
		return couponNumber;
	}
	public void setCouponNumber(String couponNumber) {
		this.couponNumber = couponNumber;
	}
	@Override
	public String toString() {
		return "CouponDTO [couponId=" + couponId + ", couponExistence=" + couponExistence + ", couponNumber="
				+ couponNumber + ", toString()=" + super.toString() + "]";
	}
	
	
	
}
