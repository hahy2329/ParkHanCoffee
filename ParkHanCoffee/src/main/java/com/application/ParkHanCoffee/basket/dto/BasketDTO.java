package com.application.ParkHanCoffee.basket.dto;

import org.springframework.stereotype.Component;

@Component
public class BasketDTO {
	
	private long basketId;
	private String basketImage;
	private String basketName;
	private String basketPrice;
	private long coffeeId;
	private String humanId;
	
	public long getBasketId() {
		return basketId;
	}
	public void setBasketId(long basketId) {
		this.basketId = basketId;
	}
	public String getBasketImage() {
		return basketImage;
	}
	public void setBasketImage(String basketImage) {
		this.basketImage = basketImage;
	}
	public String getBasketName() {
		return basketName;
	}
	public void setBasketName(String basketName) {
		this.basketName = basketName;
	}
	public String getBasketPrice() {
		return basketPrice;
	}
	public void setBasketPrice(String basketPrice) {
		this.basketPrice = basketPrice;
	}
	public long getCoffeeId() {
		return coffeeId;
	}
	public void setCoffeeId(long coffeeId) {
		this.coffeeId = coffeeId;
	}
	public String getHumanId() {
		return humanId;
	}
	public void setHumanId(String humanId) {
		this.humanId = humanId;
	}
	@Override
	public String toString() {
		return "BasketDTO [basketId=" + basketId + ", basketImage=" + basketImage + ", basketName=" + basketName
				+ ", basketPrice=" + basketPrice + ", coffeeId=" + coffeeId + ", humanId=" + humanId + ", toString()="
				+ super.toString() + "]";
	}
	
	
	
	
	
}
