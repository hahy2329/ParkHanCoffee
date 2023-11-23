package com.application.ParkHanCoffee.shop.controller;

import java.io.File;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import com.application.ParkHanCoffee.basket.dto.BasketDTO;
import com.application.ParkHanCoffee.basket.service.BasketService;
import com.application.ParkHanCoffee.human.service.HumanService;
import com.application.ParkHanCoffee.product.dto.ProductDTO;
import com.application.ParkHanCoffee.shop.service.ShopService;

import net.coobird.thumbnailator.Thumbnails;

@Controller
@RequestMapping("/ParkHanShop")
public class ShopController {
	
	private String FILE_REPO_PATH = "C:\\coffee_Image\\";
	
	@Autowired
	private ShopService shopService;
	
	@Autowired
	private BasketService basketService;
	
	@Autowired
	private HumanService humanService;
	
	
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
			Thumbnails.of(image).forceSize(307, 317).outputFormat("jpg").toOutputStream(out);
		}
		byte[] buffer = new byte[1024 * 8];
		out.write(buffer);
		out.close();
		
		
	}
	
	@GetMapping("/shoppingBasket")
	public ResponseEntity<Object> shoppingBasket(@RequestParam("coffeeId") long coffeeId ,HttpServletRequest request) throws Exception{
		
		ProductDTO productDTO = shopService.getProductInfo(coffeeId);
		BasketDTO basketDTO = new BasketDTO();
		basketDTO.setBasketImage(productDTO.getCoffeeImage());
		basketDTO.setBasketName(productDTO.getCoffeeSubject());
		basketDTO.setBasketPrice(productDTO.getCoffeePrice());
		basketDTO.setCoffeeId(productDTO.getCoffeeId());
		basketDTO.setHumanId(request.getParameter("humanId"));
		
		basketService.insertProductInfo(basketDTO);
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		String message = "<script>";
		message +="alert('장바구니 저장 완료!');";
		message +="location.href='" +request.getContextPath() + "/';";
		message +="</script>";
		
		return new ResponseEntity<Object>(message, responseHeaders, HttpStatus.OK);
		
		
		
	}
	
	@PostMapping("/productBuy")
	public ResponseEntity<String> productBuy(@RequestParam("price") int price, @RequestParam("humanId") String humanId) throws Exception{
		
		shopService.insertSalesPrice(price);
		
		int point = (price * 5/100);
		System.out.println(humanId);
		
		HashMap<String, Object> humanPoint = new HashMap<String, Object>();
		humanPoint.put("humanId", humanId);
		humanPoint.put("point",point);
		
		
		humanService.updateSavePoint(humanPoint);
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		return new ResponseEntity<String>("successful", responseHeaders, HttpStatus.OK);
		
		
		
		
	}
	
}
