package com.application.ParkHanCoffee.product.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class ProductDTO {
	
	private long coffeeId;
	private String coffeeImage;
	private String coffeeSubject;
	private String coffeeSubjectEn;
	private int coffeeWeight;
	private int coffeeKcal;
	private String coffeeContent;
	private String coffeeAllergy;
	private float coffeeFat;
	private float coffeeSaccharides;
	private float coffeeSodium;
	private float coffeeProtein;
	private int coffeeCaffeine;
	private String coffeeSort;
	private Date  coffeeReleaseDate;
	private String coffeePrice;
	private int coffeeInventoryMount;
	
	public long getCoffeeId() {
		return coffeeId;
	}
	public void setCoffeeId(long coffeeId) {
		this.coffeeId = coffeeId;
	}
	public String getCoffeeImage() {
		return coffeeImage;
	}
	public void setCoffeeImage(String coffeeImage) {
		this.coffeeImage = coffeeImage;
	}
	public String getCoffeeSubject() {
		return coffeeSubject;
	}
	public void setCoffeeSubject(String coffeeSubject) {
		this.coffeeSubject = coffeeSubject;
	}
	public String getCoffeeSubjectEn() {
		return coffeeSubjectEn;
	}
	public void setCoffeeSubjectEn(String coffeeSubjectEn) {
		this.coffeeSubjectEn = coffeeSubjectEn;
	}
	public int getCoffeeWeight() {
		return coffeeWeight;
	}
	public void setCoffeeWeight(int coffeeWeight) {
		this.coffeeWeight = coffeeWeight;
	}
	public int getCoffeeKcal() {
		return coffeeKcal;
	}
	public void setCoffeeKcal(int coffeeKcal) {
		this.coffeeKcal = coffeeKcal;
	}
	public String getCoffeeContent() {
		return coffeeContent;
	}
	public void setCoffeeContent(String coffeeContent) {
		this.coffeeContent = coffeeContent;
	}
	public String getCoffeeAllergy() {
		return coffeeAllergy;
	}
	public void setCoffeeAllergy(String coffeeAllergy) {
		this.coffeeAllergy = coffeeAllergy;
	}
	public float getCoffeeFat() {
		return coffeeFat;
	}
	public void setCoffeeFat(float coffeeFat) {
		this.coffeeFat = coffeeFat;
	}
	public float getCoffeeSaccharides() {
		return coffeeSaccharides;
	}
	public void setCoffeeSaccharides(float coffeeSaccharides) {
		this.coffeeSaccharides = coffeeSaccharides;
	}
	public float getCoffeeSodium() {
		return coffeeSodium;
	}
	public void setCoffeeSodium(float coffeeSodium) {
		this.coffeeSodium = coffeeSodium;
	}
	public float getCoffeeProtein() {
		return coffeeProtein;
	}
	public void setCoffeeProtein(float coffeeProtein) {
		this.coffeeProtein = coffeeProtein;
	}
	public int getCoffeeCaffeine() {
		return coffeeCaffeine;
	}
	public void setCoffeeCaffeine(int coffeeCaffeine) {
		this.coffeeCaffeine = coffeeCaffeine;
	}
	public String getCoffeeSort() {
		return coffeeSort;
	}
	public void setCoffeeSort(String coffeeSort) {
		this.coffeeSort = coffeeSort;
	}
	public Date getCoffeeReleaseDate() {
		return coffeeReleaseDate;
	}
	public void setCoffeeReleaseDate(Date coffeeReleaseDate) {
		this.coffeeReleaseDate = coffeeReleaseDate;
	}
	public String getCoffeePrice() {
		return coffeePrice;
	}
	public void setCoffeePrice(String coffeePrice) {
		this.coffeePrice = coffeePrice;
	}
	public int getCoffeeInventoryMount() {
		return coffeeInventoryMount;
	}
	public void setCoffeeInventoryMount(int coffeeInventoryMount) {
		this.coffeeInventoryMount = coffeeInventoryMount;
	}
	@Override
	public String toString() {
		return "ProductDTO [coffeeId=" + coffeeId + ", coffeeImage=" + coffeeImage + ", coffeeSubject=" + coffeeSubject
				+ ", coffeeSubjectEn=" + coffeeSubjectEn + ", coffeeWeight=" + coffeeWeight + ", coffeeKcal="
				+ coffeeKcal + ", coffeeContent=" + coffeeContent + ", coffeeAllergy=" + coffeeAllergy + ", coffeeFat="
				+ coffeeFat + ", coffeeSaccharides=" + coffeeSaccharides + ", coffeeSodium=" + coffeeSodium
				+ ", coffeeProtein=" + coffeeProtein + ", coffeeCaffeine=" + coffeeCaffeine + ", coffeeSort="
				+ coffeeSort + ", coffeeReleaseDate=" + coffeeReleaseDate + ", coffeePrice=" + coffeePrice
				+ ", coffeeInventoryMount=" + coffeeInventoryMount + ", toString()=" + super.toString() + "]";
	}
	
	
	
	
	
}
