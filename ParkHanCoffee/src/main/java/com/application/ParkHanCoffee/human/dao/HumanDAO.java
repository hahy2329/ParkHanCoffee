package com.application.ParkHanCoffee.human.dao;

import com.application.ParkHanCoffee.human.dto.HumanDTO;

public interface HumanDAO {
	
	public HumanDTO login(HumanDTO humanDTO) throws Exception;
	public String getOverlappedId(String humanId) throws Exception;
	public String getOverlappedEmail(String email) throws Exception;
}
