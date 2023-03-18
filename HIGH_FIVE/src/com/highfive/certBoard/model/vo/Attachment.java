package com.highfive.certBoard.model.vo;

public class Attachment {
	/*
	 * VARCHAR2(200 BYTE)	FILE_PATH
		NUMBER	CROWD_NO
		NUMBER	CERTIFICATION_NO
		NUMBER	CONTACT_NO
		NUMBER	REVIEW_NO
		NUMBER	CHALL_NO
		CHAR(1 BYTE)	STATUS
	**/
	private String filePath;
	private int crowdNo;
	private int contactNo;
	private int reviewNo;
	private int challNo;
	private String status;
	
	private int certNo;
	private String originName;
	private String changeName;
	private String upload;
	private int fileNo;
	
	
	public Attachment() {
		super();
	}
	
	
	
	




	public Attachment(String filePath, int crowdNo, int contactNo, int reviewNo, int challNo, String status, int certNo,
			String originName, String changeName, String upload, int fileNo) {
		super();
		this.filePath = filePath;
		this.crowdNo = crowdNo;
		this.contactNo = contactNo;
		this.reviewNo = reviewNo;
		this.challNo = challNo;
		this.status = status;
		this.certNo = certNo;
		this.originName = originName;
		this.changeName = changeName;
		this.upload = upload;
		this.fileNo = fileNo;
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



	public int getCertNo() {
		return certNo;
	}


	public void setCertNo(int certNo) {
		this.certNo = certNo;
	}



	public String getOriginName() {
		return originName;
	}


	public void setOriginName(String originName) {
		this.originName = originName;
	}
	
	public String getChangeName() {
		return changeName;
	}



	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}

	public String getUpload() {
		return upload;
	}


	public void setUpload(String upload) {
		this.upload = upload;
	}

	

	public int getFileNo() {
		return fileNo;
	}








	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}








	@Override
	public String toString() {
		return "Attachment [filePath=" + filePath + ", crowdNo=" + crowdNo + ", contactNo=" + contactNo + ", reviewNo="
				+ reviewNo + ", challNo=" + challNo + ", status=" + status + ", certNo=" + certNo + ", originName="
				+ originName + ", changeName=" + changeName + ", upload=" + upload + ", fileNo=" + fileNo + "]";
	}








	
	
	
}


