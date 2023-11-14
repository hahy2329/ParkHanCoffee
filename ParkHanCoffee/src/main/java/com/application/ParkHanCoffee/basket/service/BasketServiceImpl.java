package com.application.ParkHanCoffee.basket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.ParkHanCoffee.basket.dao.BasketDAO;
import com.application.ParkHanCoffee.basket.dto.BasketDTO;

@Service
public class BasketServiceImpl implements BasketService {
	
	@Autowired
	private BasketDAO basketDAO;
	
	@Override
	public void insertProductInfo(BasketDTO basketDTO) throws Exception {
		
		basketDAO.insertProductInfo(basketDTO);
		
	}

}
