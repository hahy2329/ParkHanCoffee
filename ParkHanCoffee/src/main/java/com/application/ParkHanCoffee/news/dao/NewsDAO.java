package com.application.ParkHanCoffee.news.dao;

import java.util.Map;

public interface NewsDAO {
	
	public int getAllNoticeCnt(Map<String, String> searchMap) throws Exception;
}
