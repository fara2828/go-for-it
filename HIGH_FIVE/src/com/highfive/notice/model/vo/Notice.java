package com.highfive.notice.model.vo;

import java.sql.Date;

public class Notice {

	private int no; //	NO	NUMBER	No		1	공지사항
	private String kind;//	KIND	VARCHAR2(50 BYTE)	No		2	KIND
	private String title;//	TITLE	VARCHAR2(100 BYTE)	No		3	제목
	private String content;//	CONTENT	VARCHAR2(450 BYTE)	No		4	내용
	private Date enrollDate;//	ENROLLDATE	DATE	No	"SYSDATE	"	5	등록일
	private int userNo;//	USER_NO	NUMBER	No		6	회원번호
	private String status;//	STATUS	CHAR(1 BYTE)	No	"'Y'	"	7	 편의를 위해 string으로 받음	
	
	public Notice() {
		super();
	}
	
	
	
	public Notice(String kind, String title, String content, int userNo) {
		super();
		this.kind = kind;
		this.title = title;
		this.content = content;
		this.userNo = userNo;
	}



	public Notice(int no, String kind, String title, String content, Date enrollDate, int userNo, String status) {
		super();
		this.no = no;
		this.kind = kind;
		this.title = title;
		this.content = content;
		this.enrollDate = enrollDate;
		this.userNo = userNo;
		this.status = status;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Notice [no=" + no + ", kind=" + kind + ", title=" + title + ", content=" + content + ", enrollDate="
				+ enrollDate + ", userNo=" + userNo + ", status=" + status + "]";
	}

	
}
