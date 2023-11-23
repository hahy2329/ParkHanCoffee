package com.application.ParkHanCoffee.human.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.application.ParkHanCoffee.human.dto.HumanDTO;

@Repository
public class HumanDAOImpl implements HumanDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	@Override
	public HumanDTO login(HumanDTO humanDTO) throws Exception {
		return sqlSession.selectOne("human.login", humanDTO);
	}


	@Override
	public String getOverlappedId(String humanId) throws Exception {
		return sqlSession.selectOne("human.getOverlappedId", humanId);
	}


	@Override
	public String getOverlappedEmail(String email) throws Exception {
		return sqlSession.selectOne("human.getOverlappedEmail", email);
	}


	@Override
	public void registerHuman(HumanDTO humanDTO) throws Exception {
		 sqlSession.insert("human.registerHuman", humanDTO);
		
	}


	@Override
	public void updateSavePoint(HashMap<String, Object> humanPoint) throws Exception {
		sqlSession.update("human.updateSavePoint", humanPoint);
		
	}

}
