package com.application.ParkHanCoffee.admin.service;

import com.application.ParkHanCoffee.admin.dto.AdminDTO;
import com.application.ParkHanCoffee.product.dto.ProductDTO;

public interface AdminService {
	
	public AdminDTO login(AdminDTO adminDTO) throws Exception;
	public boolean checkDuplicatedPasswd(AdminDTO adminDTO) throws Exception;
	public void registrationProduct(ProductDTO productDTO) throws Exception;
}
