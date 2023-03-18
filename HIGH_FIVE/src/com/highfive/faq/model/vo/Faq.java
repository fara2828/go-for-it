package com.highfive.faq.model.vo;

import java.sql.Date;

public class Faq {

	private String faqNo; // FAQ_NO	NUMBER	No		1	FAQ 번호
	private String faqTitle; // FAQ_TITLE	VARCHAR2(100 BYTE)	No		2	FAQ 제목
	private String faqContent; // FAQ_CONTENT	VARCHAR2(450 BYTE)	No		3	FAQ 내용
	private String status; // STATUS	CHAR(1 BYTE)	No	"'Y'	"	4	상태
	private Date enrollDate; // ENROLLDATE	DATE	No	SYSDATE 	5	
	
	
	public Faq() {
		super();
	}
	public Faq(String faqNo, String faqTitle, String faqContent, String status, Date enrollDate) {
		super();
		this.faqNo = faqNo;
		this.faqTitle = faqTitle;
		this.faqContent = faqContent;
		this.status = status;
		this.enrollDate = enrollDate;
	}
	
	
	public String getFaqNo() {
		return faqNo;
	}
	public void setFaqNo(String faqNo) {
		this.faqNo = faqNo;
	}
	public String getFaqTitle() {
		return faqTitle;
	}
	public void setFaqTitle(String faqTitle) {
		this.faqTitle = faqTitle;
	}
	public String getFaqContent() {
		return faqContent;
	}
	public void setFaqContent(String faqContent) {
		this.faqContent = faqContent;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}	
	public Date getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}
	
	
	@Override
	public String toString() {
		return "Faq [faqNo=" + faqNo + ", faqTitle=" + faqTitle + ", faqContent=" + faqContent + ", status=" + status
				+ "]";
	}
	
	
	
	
	
}
