package com.application.ParkHanCoffee.basket.service;

import com.application.ParkHanCoffee.basket.dto.BasketDTO;

public interface BasketService {
	
	public void insertProductInfo(BasketDTO basketDTO) throws Exception;
	public BasketDTO getMyCartInfo(String humanId) throws Exception;
}
