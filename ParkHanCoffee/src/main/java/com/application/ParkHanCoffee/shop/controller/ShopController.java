package com.application.ParkHanCoffee.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/ParkHanShop")
public class ShopController {
	
	@GetMapping("/menu")
	public ModelAndView menu() throws Exception{
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/ParkHanShop/menu");
		return mv;
	}

}
