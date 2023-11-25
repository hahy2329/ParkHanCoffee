package com.application.ParkHanCoffee.news.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NewsDAOImpl implements NewsDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int getAllNoticeCnt(Map<String, String> searchMap) throws Exception {
		return sqlSession.selectOne("news.getAllNoticeCnt", searchMap);
	}

}
