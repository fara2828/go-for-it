package com.highfive.contact.model.vo;

import java.sql.Date;

public class Contact {
	
	private int contactNo;//	CONTACT_NO	NUMBER	No		1	질문번호
	private String questionTitle;//	Q_TITLE	VARCHAR2(100 BYTE)	No		2	질문제목
	private String questionContent;//	Q_CONTENT	VARCHAR2(450 BYTE)	No		3	질문내용
	private String answerYN;//	ANSWER_YN	CHAR(1 BYTE)	No	"'N'	"	4	답변여부
	private String answerContent;//	A_CONTENT	VARCHAR2(450 BYTE)	Yes		5	답변내용
	private int userNo;//	USER_NO	NUMBER	No		6	회원번호
	private String nickName;
	private Date contactDate;
	private String status; //	STATUS	CHAR(1 BYTE)	No	"'Y'	"	7	
	private String userName;



	public Contact() {
		super();
	}
	
	
	public Contact(String questionTitle, String answerContent, int userNo) {
		super();
		this.questionTitle = questionTitle;
		this.answerContent = answerContent;
		this.userNo = userNo;
	}



	public Contact(int contactNo, String questionTitle, String questionContent, String answerYN, String answerContent,
			int userNo, String status, Date contactDate, String nickName) {
		super();
		this.contactNo = contactNo;
		this.questionTitle = questionTitle;
		this.questionContent = questionContent;
		this.answerYN = answerYN;
		this.answerContent = answerContent;
		this.userNo = userNo;
		this.nickName = nickName;
		this.contactDate = contactDate;
		this.status = status;
	}



	public int getContactNo() {
		return contactNo;
	}
	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}
	public String getQuestionTitle() {
		return questionTitle;
	}
	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}
	public String getQuestionContent() {
		return questionContent;
	}
	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}
	public String getAnswerYN() {
		return answerYN;
	}
	public void setAnswerYN(String answerYN) {
		this.answerYN = answerYN;
	}
	public String getAnswerContent() {
		return answerContent;
	}
	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getContactDate() {
		return contactDate;
	}
	public void setContactDate(Date contactDate) {
		this.contactDate = contactDate;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}


	@Override
	public String toString() {
		return "Contact [contactNo=" + contactNo + ", questionTitle=" + questionTitle + ", questionContent="
				+ questionContent + ", answerYN=" + answerYN + ", answerContent=" + answerContent + ", userNo=" + userNo
				+ ", nickName=" + nickName + ", status=" + status + "]";
	}

	
	
}