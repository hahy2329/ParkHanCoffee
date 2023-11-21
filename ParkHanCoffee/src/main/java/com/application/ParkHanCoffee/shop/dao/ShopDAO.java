package com.application.ParkHanCoffee.shop.dao;

import java.util.List;

import com.application.ParkHanCoffee.coupon.dto.CouponDTO;
import com.application.ParkHanCoffee.product.dto.ProductDTO;

public interface ShopDAO {
	
	public List<ProductDTO> getProductList() throws Exception;
	public ProductDTO getProductInfo(long coffeeId) throws Exception;
	public String checkCouponNumber(CouponDTO couponDTO) throws Exception;
}
