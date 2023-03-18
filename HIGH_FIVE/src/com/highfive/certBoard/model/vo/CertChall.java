package com.highfive.certBoard.model.vo;


public class CertChall {
/*	
	CERT_NO	NUMBER
	USER_NO	NUMBER
	CHALL_NO	NUMBER
	CERT_DATE	DATE
	CERT_EXP	VARCHAR2(3000 BYTE)
	STATUS	CHAR(1 BYTE)
*/
	private int certNo;
	private int userNo;
	private int challNo;
	private String certDate;
	private String certExp;
	private String status;	
	private String certThumbnail;
	private String profile;	
	private String nickName;
	






	public CertChall(int certNo, int userNo, int challNo, String certDate, String certExp, String status,
			String certThumbnail, String profile, String nickName) {
		super();
		this.certNo = certNo;
		this.userNo = userNo;
		this.challNo = challNo;
		this.certDate = certDate;
		this.certExp = certExp;
		this.status = status;
		this.certThumbnail = certThumbnail;
		this.profile = profile;
		this.nickName = nickName;
	}







	public CertChall() {
		super();
	}

	
	




	public CertChall(int certNo, int userNo, int challNo, String certDate, String certExp, String status,
			String certThumbnail, String profile) {
		super();
		this.certNo = certNo;
		this.userNo = userNo;
		this.challNo = challNo;
		this.certDate = certDate;
		this.certExp = certExp;
		this.status = status;
		this.certThumbnail = certThumbnail;
		this.profile = profile;
	}







	public int getCertNo() {
		return certNo;
	}


	public void setCertNo(int certNo) {
		this.certNo = certNo;
	}


	public int getUserNo() {
		return userNo;
	}


	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}


	public int getChallNo() {
		return challNo;
	}


	public void setChallNo(int challNo) {
		this.challNo = challNo;
	}


	public String getCertDate() {
		return certDate;
	}


	public void setCertDate(String certDate) {
		this.certDate = certDate;
	}


	public String getCertExp() {
		return certExp;
	}


	public void setCertExp(String certExp) {
		this.certExp = certExp;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}

	

	public String getCertThumbnail() {
		return certThumbnail;
	}



	public void setCertThumbnail(String certThumbnail) {
		this.certThumbnail = certThumbnail;
	}



	public String getProfile() {
		return profile;
	}




	public void setProfile(String profile) {
		this.profile = profile;
	}




	public String getNickName() {
		return nickName;
	}







	public void setNickName(String nickName) {
		this.nickName = nickName;
	}




	@Override
	public String toString() {
		return "CertChall [certNo=" + certNo + ", userNo=" + userNo + ", challNo=" + challNo + ", certDate=" + certDate
				+ ", certExp=" + certExp + ", status=" + status + ", certThumbnail=" + certThumbnail + ", profile="
				+ profile + ", nickName=" + nickName + "]";
	}

	
 
	
	
	
	
	
	
}
