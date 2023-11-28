package com.application.ParkHanCoffee.news.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.ParkHanCoffee.news.dao.NewsDAO;
import com.application.ParkHanCoffee.notice.dto.NoticeDTO;

@Service
public class NewsServiceImpl implements NewsService {
	
	@Autowired
	private NewsDAO newsDAO;
	
	@Override
	public int getAllNoticeCnt(Map<String, String> searchCntMap) throws Exception {
		return newsDAO.getAllNoticeCnt(searchCntMap);
	}

	@Override
	public List<NoticeDTO> getNoticeList(Map<String, Object> searchMap) throws Exception {
		return newsDAO.getNoticeList(searchMap);
	}

	@Override
	public void increaseReadCnt(long boardId) throws Exception {
		newsDAO.increaseReadCnt(boardId);
		
	}
	
	@Override
	public NoticeDTO getNoticeDetail(long boardId) throws Exception {
		return newsDAO.getNoticeDetail(boardId);
	}


}
