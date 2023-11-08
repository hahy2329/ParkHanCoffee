package com.application.ParkHanCoffee.admin.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.application.ParkHanCoffee.admin.dto.AdminDTO;
import com.application.ParkHanCoffee.admin.service.AdminService;
import com.application.ParkHanCoffee.product.dto.ProductDTO;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	private String FILE_REPO_PATH = "C:\\coffee_Image\\";
	
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
	
	@GetMapping("/ParkHanShop/productRegistration")
	public ModelAndView productRegistration() throws Exception{
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/admin/ParkHanShop/productRegistration");
		return mv;
		
	}
	
	@GetMapping("/checkDuplicatedPasswd")
	public ResponseEntity<String> checkDuplicatedPasswd(AdminDTO adminDTO) throws Exception{
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		
		if(adminService.checkDuplicatedPasswd(adminDTO)) {
			
			return new ResponseEntity<String>("duplicate", responseHeaders, HttpStatus.OK);
			
		}else {
			
			return new ResponseEntity<String>("Notduplicate", responseHeaders, HttpStatus.OK);
			
		}
		
	}
	
	@PostMapping("/ParkHanShop/productRegistration")
	public ResponseEntity<Object> productRegistration(MultipartHttpServletRequest multipartRequest, HttpServletRequest request) throws Exception{
		
		ProductDTO productDTO = new ProductDTO();
		
		Iterator<String> fileList = multipartRequest.getFileNames();
		String fileName = "";
		
		while(fileList.hasNext()) {
			MultipartFile uploadFile = multipartRequest.getFile(fileList.next());
				if(!uploadFile.getOriginalFilename().isEmpty()) {
					SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
					fileName = fmt.format(new Date()) + "_" + UUID.randomUUID() + "_" + uploadFile.getOriginalFilename();
					uploadFile.transferTo(new File(FILE_REPO_PATH + fileName));
					productDTO.setCoffeeImage(fileName);
				}
		}
		
		int coffeeWeightInt = Integer.parseInt(multipartRequest.getParameter("coffeeWeight"));
		int coffeeKcalInt = Integer.parseInt(multipartRequest.getParameter("coffeeKcal"));
		float coffeeFatFt = Float.parseFloat(multipartRequest.getParameter("coffeeFat"));
		float coffeeSaccharidesFt = Float.parseFloat(multipartRequest.getParameter("coffeeSaccharides"));
		float coffeeSodiumFt = Float.parseFloat(multipartRequest.getParameter("coffeeSodium"));
		float coffeeProteinFt = Float.parseFloat(multipartRequest.getParameter("coffeeProtein"));
		int coffeeCaffeineInt = Integer.parseInt(multipartRequest.getParameter("coffeeCaffeine"));
		
		
		
		SimpleDateFormat fmtt = new SimpleDateFormat("yyyy-MM-dd");
		Date coffeeReleaseDateParse = fmtt.parse(multipartRequest.getParameter("coffeeReleaseDate"));
		
		int coffeePriceInt = Integer.parseInt(multipartRequest.getParameter("coffeePrice"));
		int coffeeInventoryMountInt = Integer.parseInt(multipartRequest.getParameter("coffeeInventoryMount"));
		
		
		
		
		productDTO.setCoffeeSubject(multipartRequest.getParameter("coffeeSubject"));
		productDTO.setCoffeeSubjectEn(multipartRequest.getParameter("coffeeSubjectEn"));
		productDTO.setCoffeeWeight(coffeeWeightInt);
		productDTO.setCoffeeKcal(coffeeKcalInt);
		productDTO.setCoffeeContent(multipartRequest.getParameter("coffeeContent"));
		productDTO.setCoffeeAllergy(multipartRequest.getParameter("coffeeAllergy"));
		productDTO.setCoffeeFat(coffeeFatFt);
		productDTO.setCoffeeSaccharides(coffeeSaccharidesFt);
		productDTO.setCoffeeSodium(coffeeSodiumFt);
		productDTO.setCoffeeProtein(coffeeProteinFt);
		productDTO.setCoffeeCaffeine(coffeeCaffeineInt);
		productDTO.setCoffeeSort(multipartRequest.getParameter("coffeeSort"));
		productDTO.setCoffeeReleaseDate(coffeeReleaseDateParse);
		productDTO.setCoffeePrice(coffeePriceInt);
		productDTO.setCoffeeInventoryMount(coffeeInventoryMountInt);
		
		
		adminService.registrationProduct(productDTO);
		
		String message = "<script>";
		message +="alert('정상적으로 등록 되었습니다.');";
		message +="location.href='" + request.getContextPath() + "/';";
		message +="</script>";
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		return new ResponseEntity<Object>(message, responseHeaders, HttpStatus.OK);
		
		
	}
	
}
