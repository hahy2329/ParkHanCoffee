package com.application.ParkHanCoffee.admin.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.application.ParkHanCoffee.admin.dto.AdminDTO;

@Repository
public class AdminDAOImpl implements AdminDAO {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public AdminDTO login(AdminDTO adminDTO) throws Exception {
		return sqlSession.selectOne("admin.getLoginInfo", adminDTO);
	}
	
	
	
	
}
