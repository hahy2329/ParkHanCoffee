package com.application.ParkHanCoffee.news.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.application.ParkHanCoffee.notice.dto.NoticeDTO;

@Repository
public class NewsDAOImpl implements NewsDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int getAllNoticeCnt(Map<String, String> searchCntMap) throws Exception {
		return sqlSession.selectOne("news.getAllNoticeCnt", searchCntMap);
	}

	@Override
	public List<NoticeDTO> getNoticeList(Map<String, Object> searchMap) throws Exception {
		return sqlSession.selectList("news.getNoticeList", searchMap);
	}

}
