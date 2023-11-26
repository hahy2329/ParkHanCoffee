package com.application.ParkHanCoffee.news.service;

import java.util.List;
import java.util.Map;

import com.application.ParkHanCoffee.notice.dto.NoticeDTO;

public interface NewsService {
	
	public int getAllNoticeCnt(Map<String, String> searchCntMap) throws Exception;
	public List<NoticeDTO> getNoticeList(Map<String, Object> searchMap) throws Exception; 
}
