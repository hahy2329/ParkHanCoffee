package com.application.ParkHanCoffee.basket.service;

import java.util.List;

import com.application.ParkHanCoffee.basket.dto.BasketDTO;

public interface BasketService {
	
	public void insertProductInfo(BasketDTO basketDTO) throws Exception;
	public List<BasketDTO> getMyCartInfo(String humanId) throws Exception;
	public void myCartReset(String humanId) throws Exception;
}
