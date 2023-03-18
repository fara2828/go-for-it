package com.highfive.crowdChallenge.model.vo;

public class CrowdChallenge {
	
	private int crowdNo;  //CROWD_NO	NUMBER
	private int userNo; //USER_NO	NUMBER
	private String nickName;
	private String crowdName; //CROWD_NAME	VARCHAR2(20 BYTE)
	private String crowdCategory;//CROWD_CATEGORY	VARCHAR2(30 BYTE)
	private String crowdPostDate;//CROWD_POSTDATE	DATE
	private String crowdExp;//CROWD_EXP	VARCHAR2(3000 BYTE)
	private String status;//STATUS	CHAR(1 BYTE)
	private String crowdThumbnail;
	private int crowdGoodIdea;//CROWD_GOODIDEA,
    private int crowdMakeIt;//CROWD_MAKEIT
    private int crowdPeriod;
    private int crowdCount;
	
    public CrowdChallenge() {
		super();
	}

	public CrowdChallenge(int crowdNo, int userNo, String nickName, String crowdName, String crowdCategory,
			String crowdPostDate, String crowdExp, String status, String crowdThumbnail, int crowdGoodIdea,
			int crowdMakeIt, int crowdPeriod, int crowdCount) {
		super();
		this.crowdNo = crowdNo;
		this.userNo = userNo;
		this.nickName = nickName;
		this.crowdName = crowdName;
		this.crowdCategory = crowdCategory;
		this.crowdPostDate = crowdPostDate;
		this.crowdExp = crowdExp;
		this.status = status;
		this.crowdThumbnail = crowdThumbnail;
		this.crowdGoodIdea = crowdGoodIdea;
		this.crowdMakeIt = crowdMakeIt;
		this.crowdPeriod = crowdPeriod;
		this.crowdCount = crowdCount;
	}

	public int getCrowdNo() {
		return crowdNo;
	}

	public void setCrowdNo(int crowdNo) {
		this.crowdNo = crowdNo;
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

	public String getCrowdName() {
		return crowdName;
	}

	public void setCrowdName(String crowdName) {
		this.crowdName = crowdName;
	}

	public String getCrowdCategory() {
		return crowdCategory;
	}

	public void setCrowdCategory(String crowdCategory) {
		this.crowdCategory = crowdCategory;
	}

	public String getCrowdPostDate() {
		return crowdPostDate;
	}

	public void setCrowdPostDate(String crowdPostDate) {
		this.crowdPostDate = crowdPostDate;
	}

	public String getCrowdExp() {
		return crowdExp;
	}

	public void setCrowdExp(String crowdExp) {
		this.crowdExp = crowdExp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCrowdThumbnail() {
		return crowdThumbnail;
	}

	public void setCrowdThumbnail(String crowdThumbnail) {
		this.crowdThumbnail = crowdThumbnail;
	}

	public int getCrowdGoodIdea() {
		return crowdGoodIdea;
	}

	public void setCrowdGoodIdea(int crowdGoodIdea) {
		this.crowdGoodIdea = crowdGoodIdea;
	}

	public int getCrowdMakeIt() {
		return crowdMakeIt;
	}

	public void setCrowdMakeIt(int crowdMakeIt) {
		this.crowdMakeIt = crowdMakeIt;
	}

	public int getCrowdPeriod() {
		return crowdPeriod;
	}

	public void setCrowdPeriod(int crowdPeriod) {
		this.crowdPeriod = crowdPeriod;
	}

	public int getCrowdCount() {
		return crowdCount;
	}

	public void setCrowdCount(int crowdCount) {
		this.crowdCount = crowdCount;
	}

	@Override
	public String toString() {
		return "CrowdChallenge [crowdNo=" + crowdNo + ", userNo=" + userNo + ", nickName=" + nickName + ", crowdName="
				+ crowdName + ", crowdCategory=" + crowdCategory + ", crowdPostDate=" + crowdPostDate + ", crowdExp="
				+ crowdExp + ", status=" + status + ", crowdThumbnail=" + crowdThumbnail + ", crowdGoodIdea="
				+ crowdGoodIdea + ", crowdMakeIt=" + crowdMakeIt + ", crowdPeriod=" + crowdPeriod + ", crowdCount="
				+ crowdCount + "]";
	}
	

}
