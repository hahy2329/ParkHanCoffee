package com.application.ParkHanCoffee.basket.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.application.ParkHanCoffee.basket.dto.BasketDTO;
import com.application.ParkHanCoffee.basket.service.BasketService;
import com.application.ParkHanCoffee.coupon.dto.CouponDTO;
import com.application.ParkHanCoffee.shop.service.ShopService;

@Controller
@RequestMapping("/basket")
public class BasketController {
	
	@Autowired
	private BasketService basketService;
	
	@Autowired
	private ShopService shopService;
	
	
	@GetMapping("/myCart")
	public ModelAndView myCart(String humanId) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		List<BasketDTO> basketList = basketService.getMyCartInfo(humanId);
		
		mv.addObject("basketList", basketList);
		mv.setViewName("/basket/myCart");
		
		return mv;
	}
	
	@GetMapping("/myCartReset")
	public ResponseEntity<Object> myCartReset(String humanId, HttpServletRequest request) throws Exception{
		
		basketService.myCartReset(humanId);
		
		String message = "<script>";
		message += "alert('장바구니 초기화 완료!');";
		message +="location.href='" + request.getContextPath() + "/';";
		message +="</script>";
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		return new ResponseEntity<Object>(message, responseHeaders, HttpStatus.OK);
		 
		
	}
	
	@GetMapping("/couponInput")
	public ResponseEntity<String> couponInput(String couponNumber) throws Exception{
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		if(shopService.checkCouponNumber(couponNumber)) {
			
			return new ResponseEntity<String>("checked", responseHeaders, HttpStatus.OK);
			
			
		}else {
			
			return new ResponseEntity<String>("NotChecked",responseHeaders, HttpStatus.OK);
					
		}
		
		
		
	}
}
