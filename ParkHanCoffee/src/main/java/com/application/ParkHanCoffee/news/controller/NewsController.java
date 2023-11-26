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
		
		mv.setViewName("/news/notice");
		
		String searchKeyword = request.getParameter("searchKeyword");
		if(searchKeyword == null) searchKeyword = "total";
		//선택 박스 란에 기준값이 없다면 total(전체)로!
		
		String searchWord = request.getParameter("searchWord");
		if(searchWord == null) searchKeyword = "";
		//검색 란에 입력 값이 없다면 ""
		
		int onePageViewCnt = 10; // 초깃값, 한 페이지 당 10개씩 보여주기 
		
		if(request.getParameter("onePageViewCnt") != null) {
			onePageViewCnt = Integer.parseInt(request.getParameter("onePageViewCnt"));
		} //만약! 뷰 페이지 갯수를 정해놨다면 if문 안 문장을 실행 
		
		String temp = request.getParameter("currentPageNumber"); // 현재 페이지
		if(temp == null) {
			temp = "1";
		}
		
		int currentPageNumber = Integer.parseInt(temp); // 현재 페이지를 숫자형으로 변환		
		
		Map<String, String> searchCntMap = new HashMap<String, String>();
		searchCntMap.put("searchKeyword", searchKeyword);
		searchCntMap.put("searchWord", searchWord);
		//선택 란 기준값과 검색 입력 값을 map함수에 넣어줌 
		
		int allBoardCnt = newsService.getAllNoticeCnt(searchCntMap); // map에 넣어진 값을 기준으로 전체 갯수를 가져옴
		
		int allPageCnt = allBoardCnt / onePageViewCnt + 1;
		
		if(allBoardCnt % onePageViewCnt == 0) {
			allPageCnt --;
			
		}
		
		int startPage = (currentPageNumber - 1) / 10 * 10 +1; //스타트 페이지는 현재 페이지가 아닌 시작 페이지를 의미!
		
		if(startPage == 0) {
			startPage = 1;
		}
		
		int endPage = startPage + 9; // (1~10, 11 ~ 20)
		
		if(endPage > allPageCnt) endPage = allPageCnt;
		
		int startBoardIdx = (currentPageNumber - 1) * onePageViewCnt; //각 페이지의 게시판 첫 번호
		
		mv.addObject("startPage", startPage);
		mv.addObject("endPage", endPage);
		mv.addObject("allBoardCnt", allBoardCnt);
		mv.addObject("allPageCnt", allPageCnt);
		mv.addObject("onePageViewCnt", onePageViewCnt);
		mv.addObject("currentPageNumber", currentPageNumber);
		mv.addObject("startBoardIdx", startBoardIdx);
		mv.addObject("searchKeyword", searchKeyword);
		mv.addObject("searchWord", searchWord);
		
		Map<String, Object> searchMap = new HashMap<String, Object>();
		searchMap.put("onePageViewCnt", onePageViewCnt);
		searchMap.put("startBoardIdx", startBoardIdx);
		searchMap.put("searchKeyword", searchKeyword);
		searchMap.put("searchWord", searchWord);
		mv.addObject("noticeList", newsService.getNoticeList(searchMap));
		
		return mv;
		
		
		
		
	}
	
	
	
	
}
