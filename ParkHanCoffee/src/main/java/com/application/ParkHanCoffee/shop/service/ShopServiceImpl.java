package com.application.ParkHanCoffee.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
