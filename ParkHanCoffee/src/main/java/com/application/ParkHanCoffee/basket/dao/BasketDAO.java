package com.application.ParkHanCoffee.basket.dao;

import java.util.List;

import com.application.ParkHanCoffee.basket.dto.BasketDTO;

public interface BasketDAO {
	
	public void insertProductInfo(BasketDTO basketDTO) throws Exception;
	public List<BasketDTO> getMyCartInfo(String humanId) throws Exception;
}
