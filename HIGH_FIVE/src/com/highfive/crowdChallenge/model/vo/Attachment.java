package com.highfive.crowdChallenge.model.vo;

public class Attachment {
	
	private String filePath;//FILE_PATH	VARCHAR2(200 BYTE)
	private int crowdNo;//CROWD_NO	NUMBER
	private int certificationNo;//CERTIFICATION_NO	NUMBER
	private int contactNo;//CONTACT_NO	NUMBER
	private int reviewNo;//REVIEW_NO	NUMBER
	private int challNo;//CHALL_NO	NUMBER
	private String status;//STATUS	CHAR(1 BYTE)
	
	public Attachment() {
		super();
	}
	
	public Attachment(String filePath, int crowdNo, int certificationNo, int contactNo, int reviewNo, int challNo,
			String status) {
		super();
		this.filePath = filePath;
		this.crowdNo = crowdNo;
		this.certificationNo = certificationNo;
		this.contactNo = contactNo;
		this.reviewNo = reviewNo;
		this.challNo = challNo;
		this.status = status;
	}
	
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public int getCrowdNo() {
		return crowdNo;
	}
	public void setCrowdNo(int crowdNo) {
		this.crowdNo = crowdNo;
	}
	public int getCertificationNo() {
		return certificationNo;
	}
	public void setCertificationNo(int certificationNo) {
		this.certificationNo = certificationNo;
	}
	public int getContactNo() {
		return contactNo;
	}
	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}
	public int getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}
	public int getChallNo() {
		return challNo;
	}
	public void setChallNo(int challNo) {
		this.challNo = challNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Attachment [filePath=" + filePath + ", crowdNo=" + crowdNo + ", certificationNo=" + certificationNo
				+ ", contactNo=" + contactNo + ", reviewNo=" + reviewNo + ", challNo=" + challNo + ", status=" + status
				+ "]";
	}

}
