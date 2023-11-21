package com.application.ParkHanCoffee.shop.service;

import java.util.List;

import com.application.ParkHanCoffee.coupon.dto.CouponDTO;
import com.application.ParkHanCoffee.product.dto.ProductDTO;

public interface ShopService {

	public List<ProductDTO> getProductList() throws Exception;
	public ProductDTO getProductInfo(long coffeeId) throws Exception;
	public boolean checkCouponNumber(CouponDTO couponDTO) throws Exception;
}
