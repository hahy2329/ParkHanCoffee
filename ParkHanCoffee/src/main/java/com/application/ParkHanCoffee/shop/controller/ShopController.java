package com.application.ParkHanCoffee.shop.controller;

import java.io.File;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.application.ParkHanCoffee.product.dto.ProductDTO;
import com.application.ParkHanCoffee.shop.service.ShopService;

import net.coobird.thumbnailator.Thumbnails;

@Controller
@RequestMapping("/ParkHanShop")
public class ShopController {
	
	private String FILE_REPO_PATH = "C:\\coffee_Image\\";
	
	@Autowired
	private ShopService shopService;
	
	@GetMapping("/menu")
	public ModelAndView menu() throws Exception{
		
		ModelAndView mv = new ModelAndView();
		List<ProductDTO> productList = shopService.getProductList();
		mv.addObject("productList", productList);
		mv.setViewName("/ParkHanShop/menu");
		return mv;
	}
	
	
	@GetMapping("/thumbnails")
	public void thumbnails(@RequestParam("images") String coffeeImage, HttpServletResponse response) throws Exception{
		
		OutputStream out = response.getOutputStream();
		
		File image = new File(FILE_REPO_PATH + coffeeImage);
		if(image.exists()) {
			Thumbnails.of(image).forceSize(1200, 1486).outputFormat("jpg").toOutputStream(out);
		}
		byte[] buffer = new byte[1024 * 8];
		out.write(buffer);
		out.close();
		
		
	}
	
}
