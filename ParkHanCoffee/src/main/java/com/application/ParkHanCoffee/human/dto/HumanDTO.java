package com.application.ParkHanCoffee.human.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class HumanDTO {
	
	private String humanId;
	private String password;
	private String name;
	private Date birthDt;
	private int point;
	private String email;
	private Date enrollDt;
	
	public String getHumanId() {
		return humanId;
	}
	public void setHumanId(String humanId) {
		this.humanId = humanId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthDt() {
		return birthDt;
	}
	public void setBirthDt(Date birthDt) {
		this.birthDt = birthDt;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getEnrollDt() {
		return enrollDt;
	}
	public void setEnrollDt(Date enrollDt) {
		this.enrollDt = enrollDt;
	}
	@Override
	public String toString() {
		return "HumanDTO [humanId=" + humanId + ", password=" + password + ", name=" + name + ", birthDt=" + birthDt
				+ ", point=" + point + ", email=" + email + ", enrollDt=" + enrollDt + ", toString()="
				+ super.toString() + "]";
	}
	
	
	
	
	
}
