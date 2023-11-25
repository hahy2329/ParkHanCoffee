package com.application.ParkHanCoffee.news.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.ParkHanCoffee.news.dao.NewsDAO;

@Service
public class NewsServiceImpl implements NewsService {
	
	@Autowired
	private NewsDAO newsDAO;
	
	@Override
	public int getAllNoticeCnt(Map<String, String> searchMap) throws Exception {
		return newsDAO.getAllNoticeCnt(searchMap);
	}

}
