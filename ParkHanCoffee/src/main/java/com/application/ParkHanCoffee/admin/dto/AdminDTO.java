package com.application.ParkHanCoffee.admin.dto;

import org.springframework.stereotype.Component;

@Component
public class AdminDTO {
	
	private String adminId;
	private String adminPassword;
	private String adminName;
	private String adminEmail;
	
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	@Override
	public String toString() {
		return "AdminDTO [adminId=" + adminId + ", adminPassword=" + adminPassword + ", adminName=" + adminName
				+ ", adminEmail=" + adminEmail + ", toString()=" + super.toString() + "]";
	}
	
	
	
	
}
