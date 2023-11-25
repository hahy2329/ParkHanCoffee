package com.application.ParkHanCoffee.notice.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class NoticeDTO {
	
	private long boardId;
	private String adminId;
	private String subject;
	private String content;
	private int readCnt;
	private Date enrollDt;
	
	public long getBoardId() {
		return boardId;
	}
	public void setBoardId(long boardId) {
		this.boardId = boardId;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReadCnt() {
		return readCnt;
	}
	public void setReadCnt(int readCnt) {
		this.readCnt = readCnt;
	}
	public Date getEnrollDt() {
		return enrollDt;
	}
	public void setEnrollDt(Date enrollDt) {
		this.enrollDt = enrollDt;
	}
	@Override
	public String toString() {
		return "NoticeDTO [boardId=" + boardId + ", adminId=" + adminId + ", subject=" + subject + ", content="
				+ content + ", readCnt=" + readCnt + ", enrollDt=" + enrollDt + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	
	
}
