package com.application.ParkHanCoffee.admin.controller;

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
import org.springframework.web.servlet.ModelAndView;

import com.application.ParkHanCoffee.admin.dto.AdminDTO;
import com.application.ParkHanCoffee.admin.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/login")
	public ModelAndView login() throws Exception{
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/admin/login");
		
		return mv;
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<Object> login(AdminDTO adminDTO, HttpServletRequest request) throws Exception{
		
		String message = "";
		
		AdminDTO adminInfo = adminService.login(adminDTO);
		
		
		if(adminInfo!= null) {
			
			HttpSession session = request.getSession();
			session.setAttribute("adminId", adminInfo.getAdminId());
			session.setMaxInactiveInterval(3600);
			
			message += "<script>";
			message +="alert('정상적으로 로그인이 완료되었습니다.');";
			message +="location.href='" + request.getContextPath() + "/';";
			message +="</script>";
			
			
			
		}else {
			
			message += "<script>";
			message +="alert('ID혹은 PW를 다시 입력해주세요.');";
			message +="history.go(-1)';";
			message +="</script>";
		}
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		return new ResponseEntity<Object>(message, responseHeaders, HttpStatus.OK);
		
	}
	
	@GetMapping("/logout")
	public ResponseEntity<Object> logout(HttpServletRequest reqeust) throws Exception{
		
		HttpSession session = reqeust.getSession();
		session.invalidate();
		
		String message = "<script>";
		message +="location.href='"+reqeust.getContextPath() +"/';";
		message +="alert('정상적으로 로그아웃 되었습니다.');";
		message +="</script>";
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		return new ResponseEntity<Object>(message, responseHeaders, HttpStatus.OK);
		
	}
	
}
