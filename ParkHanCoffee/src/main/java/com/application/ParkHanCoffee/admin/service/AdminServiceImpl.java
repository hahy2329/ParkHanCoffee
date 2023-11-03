package com.application.ParkHanCoffee.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.ParkHanCoffee.admin.dao.AdminDAO;
import com.application.ParkHanCoffee.admin.dto.AdminDTO;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminDAO adminDAO;
	
	@Override
	public AdminDTO login(AdminDTO adminDTO) throws Exception {
		return adminDAO.login(adminDTO);
		
	}
	

}
