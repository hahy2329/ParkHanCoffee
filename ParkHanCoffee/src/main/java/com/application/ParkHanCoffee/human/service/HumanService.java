package com.application.ParkHanCoffee.human.service;

import java.util.HashMap;

import com.application.ParkHanCoffee.human.dto.HumanDTO;

public interface HumanService {

	public HumanDTO login(HumanDTO humanDTO) throws Exception;
	public String getOverlappedId(String humanId) throws Exception;
	public String getOverlappedEmail(String email) throws Exception;
	public void registerHuman(HumanDTO humanDTO) throws Exception;
	public void updateSavePoint(HashMap<String, Object> humanPoint) throws Exception;
}
