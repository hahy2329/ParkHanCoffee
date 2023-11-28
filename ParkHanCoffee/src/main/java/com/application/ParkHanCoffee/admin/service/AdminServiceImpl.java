package com.application.ParkHanCoffee.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.ParkHanCoffee.admin.dao.AdminDAO;
import com.application.ParkHanCoffee.admin.dto.AdminDTO;
import com.application.ParkHanCoffee.notice.dto.NoticeDTO;
import com.application.ParkHanCoffee.product.dto.ProductDTO;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminDAO adminDAO;
	
	@Override
	public AdminDTO login(AdminDTO adminDTO) throws Exception {
		return adminDAO.login(adminDTO);
		
	}

	@Override
	public boolean checkDuplicatedPasswd(AdminDTO adminDTO) throws Exception {
		return adminDAO.checkDuplicatedPasswd(adminDTO);
	}

	@Override
	public void registrationProduct(ProductDTO productDTO) throws Exception {
		adminDAO.registrationProduct(productDTO);
		
	}

	@Override
	public void addNotice(NoticeDTO noticeDTO) throws Exception {
		adminDAO.addNotice(noticeDTO);
		
	}
	

}
