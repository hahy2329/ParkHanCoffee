package com.application.ParkHanCoffee.admin.dao;

import com.application.ParkHanCoffee.admin.dto.AdminDTO;

public interface AdminDAO {
	
	public AdminDTO login(AdminDTO adminDTO) throws Exception;
	
}
