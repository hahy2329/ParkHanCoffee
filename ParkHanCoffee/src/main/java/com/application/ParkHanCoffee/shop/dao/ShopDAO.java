package com.application.ParkHanCoffee.shop.dao;

import java.util.List;

import com.application.ParkHanCoffee.product.dto.ProductDTO;

public interface ShopDAO {
	
	public List<ProductDTO> getProductList() throws Exception;
}
