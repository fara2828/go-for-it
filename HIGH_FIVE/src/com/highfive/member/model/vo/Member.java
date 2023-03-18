package com.highfive.member.model.vo;

import java.sql.Date;

public class Member {
	
	private int userNo;//	`USER_NO`	NUMBER	NOT NULL	COMMENT 'SEQUENCE',
	private String userId;//	`USER_ID`	VARCHAR2(50)	NOT NULL	COMMENT 'UNIQUE',
	private String userPwd;//	`USER_PWD`	VARCHAR2(100)	NOT NULL,
	private String userName;//	`USER_NAME`	VARCHAR2(50)	NOT NULL,
	private String nickName;//	`NICKNAME`	VARCHAR2(50)	NOT NULL,
	private String email;//	`EMAIL`	VARCHAR2(100)	NOT NULL,
	private String birthDate;//	`BIRTHDATE`	VARCHAR2(15)	NOT NULL,
	private String gender;//	`GENDER`	CHAR(1)	NOT NULL	COMMENT 'CHECK (IN('M' , 'F'))',
	private String post;//	`POST`	NUMBER	NOT NULL	COMMENT '우편번호',
	private String address;//	`ADDRESS`	VARCHAR2(150)	NOT NULL	COMMENT '주소',
	private String addressDetail;//	`ADDRESSDETAIL`	VARCHAR2(150)	NULL	COMMENT '상세주소',
	private String phone;//	`PHONE`	VARCHAR2(11)	NOT NULL,
	private String userType;//	`USERTYPE`	CHAR(1)	NOT NULL	DEFAULT 'U'	COMMENT '유저='U' / 관리자='A'',
	private int userLevel;//	`GRADE`	NUMBER	NOT NULL	DEFAULT 1	COMMENT 'CHECK',
	private Date enrollDate;//	`ENROLLDATE`	DATE	NOT NULL	DEFAULT SYSDATE,
	private Date modifyDate;//	`MODIFYDATE`	DATE	NULL,
	private String profile;//	`PROFILE`	VARCHAR2(200)	NULL,
	private String status;//	`DELETE_YN`	CHAR(1)	NOT NULL	DEFAULT 'N'	COMMENT 'CHECK(IN ('Y', 'N')'
    private String checkPwd;
    private String checkNickName;
	
	public Member() {
		super();
	}
	
   public Member(String userId) {
		super();
		this.userId = userId;
	   }
   
	public Member(String userId, String userPwd) {
	super();
	this.userId = userId;
	this.userPwd = userPwd;
}

	public Member(int userNo, String userId, String userPwd, String userName, String nickName, String email,
			String birthDate, String gender, String post, String address, String addressDetail, String phone,
			String userType, int userLevel, Date enrollDate, Date modifyDate, String profile, String status) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.nickName = nickName;
		this.email = email;
		this.birthDate = birthDate;
		this.gender = gender;
		this.post = post;
		this.address = address;
		this.addressDetail = addressDetail;
		this.phone = phone;
		this.userType = userType;
		this.userLevel = userLevel;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.profile = profile;
		this.status = status;
	}

	public int getUserNo() {
		return userNo;
	}
	
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public int getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(int userLevel) {
		this.userLevel = userLevel;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getDelete_YN() {
		return status;
	}

	public void setDelete_YN(String status) {
		this.status = status;
	}

	public String getCheckPwd() {
		return checkPwd;
	}

	public void setCheckPwd(String checkPwd) {
		this.checkPwd = checkPwd;
	}

	public String getCheckNickName() {
		return checkNickName;
	}

	public void setCheckNickName(String checkNickName) {
		this.checkNickName = checkNickName;
	}

	@Override
	public String toString() {
		return "Member [userNo=" + userNo + ", userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName
				+ ", nickName=" + nickName + ", email=" + email + ", birthDate=" + birthDate + ", gender=" + gender
				+ ", post=" + post + ", address=" + address + ", addressDetail=" + addressDetail + ", phone=" + phone
				+ ", userType=" + userType + ", userLevel=" + userLevel + ", enrollDate=" + enrollDate + ", modifyDate="
				+ modifyDate + ", profile=" + profile + ", status=" + status + "]";
	}
	
	
	

	
}

