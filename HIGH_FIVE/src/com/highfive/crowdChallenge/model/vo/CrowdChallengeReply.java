package com.highfive.crowdChallenge.model.vo;

public class CrowdChallengeReply {

	private int CrowdCommentNo;//C_COMMENT_NO	NUMBER
	private String CrowdCommentText;//C_COMMENT_TEXT	VARCHAR2(200 BYTE)
	private int CrowdNo;//C_ROWD_NO	NUMBER
	private int userNo;//USER_NO	NUMBER
	private String status;// STATUS	CHAR(1 BYTE)
	private String nickName;
	private String crowdReplyDate;
	
	public CrowdChallengeReply() {
		super();
	}

	public CrowdChallengeReply(int crowdCommentNo, String crowdCommentText, int crowdNo, int userNo, String status,
			String nickName, String crowdReplyDate) {
		super();
		CrowdCommentNo = crowdCommentNo;
		CrowdCommentText = crowdCommentText;
		CrowdNo = crowdNo;
		this.userNo = userNo;
		this.status = status;
		this.nickName = nickName;
		this.crowdReplyDate = crowdReplyDate;
	}

	public int getCrowdCommentNo() {
		return CrowdCommentNo;
	}

	public void setCrowdCommentNo(int crowdCommentNo) {
		CrowdCommentNo = crowdCommentNo;
	}

	public String getCrowdCommentText() {
		return CrowdCommentText;
	}

	public void setCrowdCommentText(String crowdCommentText) {
		CrowdCommentText = crowdCommentText;
	}

	public int getCrowdNo() {
		return CrowdNo;
	}

	public void setCrowdNo(int crowdNo) {
		CrowdNo = crowdNo;
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

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getCrowdReplyDate() {
		return crowdReplyDate;
	}

	public void setCrowdReplyDate(String crowdReplyDate) {
		this.crowdReplyDate = crowdReplyDate;
	}

	@Override
	public String toString() {
		return "CrowdChallengeReply [CrowdCommentNo=" + CrowdCommentNo + ", CrowdCommentText=" + CrowdCommentText
				+ ", CrowdNo=" + CrowdNo + ", userNo=" + userNo + ", status=" + status + ", nickName=" + nickName
				+ ", crowdReplyDate=" + crowdReplyDate + "]";
	}
	
	
	
	
	
	
	
}
