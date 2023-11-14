package com.application.ParkHanCoffee.basket.dao;

import com.application.ParkHanCoffee.basket.dto.BasketDTO;

public interface BasketDAO {
	
	public void insertProductInfo(BasketDTO basketDTO) throws Exception;
}
