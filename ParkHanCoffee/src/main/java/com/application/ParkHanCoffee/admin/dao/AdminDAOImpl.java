package com.application.ParkHanCoffee.admin.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.application.ParkHanCoffee.admin.dto.AdminDTO;
import com.application.ParkHanCoffee.product.dto.ProductDTO;

@Repository
public class AdminDAOImpl implements AdminDAO {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public AdminDTO login(AdminDTO adminDTO) throws Exception {
		return sqlSession.selectOne("admin.getLoginInfo", adminDTO);
	}

	@Override
	public boolean checkDuplicatedPasswd(AdminDTO adminDTO) throws Exception {
		if(sqlSession.selectOne("admin.checkDuplicatedPasswd",adminDTO)!=null) {
			return true;
		}else {
			return false;
		}
		
			
	}

	@Override
	public void registrationProduct(ProductDTO productDTO) throws Exception {
		sqlSession.insert("admin.registrationProduct", productDTO);
		
	}
	
	
	
	
	
	
}
