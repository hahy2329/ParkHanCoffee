package com.application.ParkHanCoffee.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.ParkHanCoffee.coupon.dto.CouponDTO;
import com.application.ParkHanCoffee.product.dto.ProductDTO;
import com.application.ParkHanCoffee.shop.dao.ShopDAO;

@Service
public class ShopServiceImpl implements ShopService {
	
	@Autowired
	private ShopDAO shopDAO;
	
	@Override
	public List<ProductDTO> getProductList() throws Exception {
		return shopDAO.getProductList();
	}

	@Override
	public ProductDTO getProductInfo(long coffeeId) throws Exception {
		return shopDAO.getProductInfo(coffeeId);
	}

	@Override
	public boolean checkCouponNumber(String couponNumber) throws Exception {
		boolean check = false;
		
		if(shopDAO.checkCouponNumber(couponNumber) != null) {
			
			check = true;
			return check;
		}else {
			return check;
		}
		
	}

	@Override
	public void insertSalesPrice(int price) throws Exception {
		shopDAO.insertSalesPrice(price);
		
	}

}
