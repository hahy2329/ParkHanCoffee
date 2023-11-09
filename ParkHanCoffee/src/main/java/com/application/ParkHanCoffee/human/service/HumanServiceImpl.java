package com.application.ParkHanCoffee.human.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.application.ParkHanCoffee.human.dao.HumanDAO;
import com.application.ParkHanCoffee.human.dto.HumanDTO;

@Service
public class HumanServiceImpl implements HumanService {

	@Autowired
	private HumanDAO humanDAO;
	
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public HumanDTO login(HumanDTO humanDTO) throws Exception {
		return humanDAO.login(humanDTO);
	}

	@Override
	public String getOverlappedId(String humanId) throws Exception {
		return humanDAO.getOverlappedId(humanId);
	}

	@Override
	public String getOverlappedEmail(String email) throws Exception {
		return humanDAO.getOverlappedEmail(email);
	}

	@Override
	public void registerHuman(HumanDTO humanDTO) throws Exception {
		
		humanDTO.setPassword(bCryptPasswordEncoder.encode(humanDTO.getPassword()));
		
		humanDAO.registerHuman(humanDTO);
		
		
	}

}
