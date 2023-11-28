package com.application.ParkHanCoffee.news.dao;

import java.util.List;
import java.util.Map;

import com.application.ParkHanCoffee.notice.dto.NoticeDTO;

public interface NewsDAO {
	
	public int getAllNoticeCnt(Map<String, String> searchCntMap) throws Exception;
	public List<NoticeDTO> getNoticeList(Map<String, Object> searchMap) throws Exception;
	public void increaseReadCnt(long boardId) throws Exception;
	public NoticeDTO getNoticeDetail(long boardId) throws Exception;
}
