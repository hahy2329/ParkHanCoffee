package com.application.ParkHanCoffee.basket.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.application.ParkHanCoffee.basket.dto.BasketDTO;

@Repository
public class BasketDAOImpl implements BasketDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insertProductInfo(BasketDTO basketDTO) throws Exception {
		sqlSession.insert("basket.insertProductInfo", basketDTO);
		
	}

	@Override
	public List<BasketDTO> getMyCartInfo(String humanId) throws Exception {
		return sqlSession.selectList("basket.getMyCartInfo" , humanId);
	}

	@Override
	public void myCartReset(String humanId) throws Exception {
		sqlSession.delete("basket.myCartReset", humanId);
		
	}

}
