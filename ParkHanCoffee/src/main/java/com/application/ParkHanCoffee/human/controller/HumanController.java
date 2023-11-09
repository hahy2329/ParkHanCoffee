package com.application.ParkHanCoffee.human.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.application.ParkHanCoffee.human.dto.HumanDTO;
import com.application.ParkHanCoffee.human.service.HumanService;

@Controller
@RequestMapping("/human")
public class HumanController {
	
	@Autowired
	private HumanService humanService;
	
	
	@GetMapping("/joinHuman")
	public ModelAndView joinHuman() throws Exception{
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/human/joinHuman");
		return mv;
		
	}
	
	@GetMapping("/checkDuplicatedInfo")
	public ResponseEntity<String> checkDuplicatedInfo(@RequestParam("humanId") String humanId) throws Exception{
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		if(humanService.getOverlappedId(humanId) == null) {
				
			return new ResponseEntity<String>("duplicate", responseHeaders, HttpStatus.OK);
		}
		else {
			
			return new ResponseEntity<String>("Notduplicate", responseHeaders, HttpStatus.OK);
		}
	}
	
	@GetMapping("/checkOverlappedEmail")
	public ResponseEntity<String> checkOverlappedEmail(@RequestParam("email") String email) throws Exception{
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		if(humanService.getOverlappedEmail(email) == null) {
			return new ResponseEntity<String>("duplicate", responseHeaders, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("Notduplicate", responseHeaders, HttpStatus.OK);
		}
		
	}
	
	@PostMapping("/joinHuman")
	public ResponseEntity<Object> joinHuman(HttpServletRequest request) throws Exception{
		
		HumanDTO humanDTO = new HumanDTO();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date birthDt = sdf.parse(request.getParameter("birthDt"));
		
		humanDTO.setHumanId(request.getParameter("humanId"));
		humanDTO.setPassword(request.getParameter("password"));
		humanDTO.setName(request.getParameter("name"));
		humanDTO.setBirthDt(birthDt);
		humanDTO.setEmail(request.getParameter("email"));
		
		System.out.println(humanDTO.getHumanId());
		System.out.println(humanDTO.getPassword());
		System.out.println(humanDTO.getName());
		System.out.println(humanDTO.getBirthDt());
		System.out.println(humanDTO.getEmail());
		
		
		humanService.registerHuman(humanDTO);
		
		String message = "<script>";
		message +="alert('정상적으로 가입이 완료되었습니다.');";
		message +="location.href='" + request.getContextPath() +"/';";
		message +="</script>";
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		return new ResponseEntity<Object>(message, responseHeaders, HttpStatus.OK);
		
		
	}
	
	@GetMapping("/login")
	public ModelAndView human() throws Exception{
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/human/login");
		return mv;
	}
	
	@PostMapping("/login")
	public ResponseEntity<Object> login(HumanDTO humanDTO, HttpServletRequest request) throws Exception{
		
		HumanDTO humanInfo = humanService.login(humanDTO);
		
		String message = "";
		
		if(humanInfo != null) {
			
			message ="<script>";
			message +="alert('정상적으로 로그인이 되었습니다.');";
			message +="location.href='" + request.getContextPath() + "/';";
			message +="</script>";
			
			HttpSession session = request.getSession();
			
			session.setAttribute("humanId", humanInfo.getHumanId());
			session.setMaxInactiveInterval(3600);
		}
		
		else {
			message ="<script>";
			message +="alert('아이디 혹으 패스워드를 확인해주세요.');";
			message +="history.go(-1)';";
			message +="</script>";
			
		}
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		return new ResponseEntity<Object>(message, responseHeaders, HttpStatus.OK);
	}
}
