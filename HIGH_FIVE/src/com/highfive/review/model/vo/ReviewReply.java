package com.highfive.review.model.vo;

public class ReviewReply {
	
	private int rCommentNo;	//		R_COMMENT_NO	NUMBER
	private int userNo;	//		USER_NO	NUMBER
	private String nickName;
	private int reviewNo;	//		REVIEW_NO	NUMBER
	private String rCommentText;	//		R_COMMENT_TEXT	VARCHAR2(500 BYTE)
	private String status;	//		STATUS	CHAR(1 BYTE)	
	private String replyDate;
	
	
	public ReviewReply() {
		
		super();
	}

	
	

	public ReviewReply(int rCommentNo, int userNo, String nickName, int reviewNo, String rCommentText, String status,
			String replyDate) {
		super();
		this.rCommentNo = rCommentNo;
		this.userNo = userNo;
		this.nickName = nickName;
		this.reviewNo = reviewNo;
		this.rCommentText = rCommentText;
		this.status = status;
		this.replyDate = replyDate;
	}



	
	public int getrCommentNo() {
		return rCommentNo;
	}




	public void setrCommentNo(int rCommentNo) {
		this.rCommentNo = rCommentNo;
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




	public int getReviewNo() {
		return reviewNo;
	}




	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}




	public String getrCommentText() {
		return rCommentText;
	}




	public void setrCommentText(String rCommentText) {
		this.rCommentText = rCommentText;
	}




	public String getStatus() {
		return status;
	}




	public void setStatus(String status) {
		this.status = status;
	}




	public String getReplyDate() {
		return replyDate;
	}




	public void setReplyDate(String replyDate) {
		this.replyDate = replyDate;
	}




	@Override
	public String toString() {
		return "ReviewReply [rCommentNo=" + rCommentNo + ", userNo=" + userNo + ", nickName=" + nickName + ", reviewNo="
				+ reviewNo + ", rCommentText=" + rCommentText + ", status=" + status + ", replyDate=" + replyDate + "]";
	}
	
	
	
	
	
}
