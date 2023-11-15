package com.application.ParkHanCoffee.basket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.application.ParkHanCoffee.basket.dto.BasketDTO;
import com.application.ParkHanCoffee.basket.service.BasketService;

@Controller
@RequestMapping("/basket")
public class BasketController {
	
	@Autowired
	private BasketService basketService;
	
	
	@GetMapping("/myCart")
	public ModelAndView myCart(String humanId) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		List<BasketDTO> basketList = basketService.getMyCartInfo(humanId);
		mv.addObject("basketList", basketList);
		mv.setViewName("/basket/myCart");
		
		return mv;
	}
}
