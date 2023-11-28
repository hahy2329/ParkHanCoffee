package com.application.ParkHanCoffee.news.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.application.ParkHanCoffee.news.service.NewsService;

@Controller
@RequestMapping("/news")
public class NewsController {
	
	@Autowired
	private NewsService newsService;
	
	
	@GetMapping("/notice")
	public ModelAndView notice(HttpServletRequest request) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		
		
		
		String searchKeyword = request.getParameter("searchKeyword");
		if(searchKeyword == null) searchKeyword = "total";
		//셀렉트 박스에서 (memberId, subject, content 중 택 1) 없으면 total 
		
		
		String searchWord = request.getParameter("searchWord");
		if(searchWord == null) searchWord = "";
		//검색 바에서 키워드 입력, 없으면 ""
		
		
		int onePageViewCnt = 10; //초깃값, 한 페이지 당 10개씩 보여주기 
		
		if(request.getParameter("onePageViewCnt") != null) {
			onePageViewCnt = Integer.parseInt(request.getParameter("onePageViewCnt"));
		} 
		
		
		String temp = request.getParameter("currentPageNumber"); //현재 페이지 
		if(temp ==null) {
			temp = "1";
		}
		
		int currentPageNumber = Integer.parseInt(temp);		
		
		Map<String, String> searchCntMap = new HashMap<String, String>();
		searchCntMap.put("searchKeyword", searchKeyword);
		searchCntMap.put("searchWord", searchWord);
		//선택 란 기준값과 검색 입력 값을 map함수에 넣어줌 
		
		int allBoardCnt = newsService.getAllNoticeCnt(searchCntMap); // map에 넣어진 값을 기준으로 전체 갯수를 가져옴
		
		int allPageCnt = allBoardCnt / onePageViewCnt + 1;
		
		if(allBoardCnt % onePageViewCnt==0) allPageCnt --;
		
		int startPage = (currentPageNumber - 1) /10 * 10 +1;
		//스타트 페이지 
		
		if(startPage == 0) {
			startPage =1;
		}
		
		
		int endPage = startPage + 9;
		//총 10페이지 씩 단위로 구성 예정(예) 1 ~ 10, 11~20 ...)
		
		if(endPage > allPageCnt) endPage = allPageCnt;
		
		int startBoardIdx = (currentPageNumber - 1) * onePageViewCnt;
		
		mv.addObject("startPage", startPage); //스타트 페이지
		mv.addObject("endPage", endPage); //끝 페이지
		mv.addObject("allBoardCnt", allBoardCnt); // 전체검색결과 갯수 
		mv.addObject("allPageCnt", allPageCnt); // 전체 페이지 수 
		mv.addObject("onePageViewCnt", onePageViewCnt); //한 페이지에 보여질 갯수 
		mv.addObject("currentPageNumber", currentPageNumber); //현재 페이지  
		mv.addObject("startBoardIdx", startBoardIdx); //각 게시글에 주어지는 일련번호
		mv.addObject("searchKeyword", searchKeyword); //검색 범위
		mv.addObject("searchWord",searchWord); // 검색 키워드
		
		Map<String, Object> searchMap = new HashMap<String, Object>();
		searchMap.put("onePageViewCnt", onePageViewCnt);
		searchMap.put("startBoardIdx", startBoardIdx);
		searchMap.put("searchKeyword", searchKeyword);
		searchMap.put("searchWord", searchWord);
		mv.addObject("noticeList", newsService.getNoticeList(searchMap));
		
		mv.setViewName("/news/notice");
		return mv;
		
		
		
		
	}
	
	
	
	
}
