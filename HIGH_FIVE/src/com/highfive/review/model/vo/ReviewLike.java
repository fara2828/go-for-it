package com.highfive.review.model.vo;

public class ReviewLike {
	
	private int reviewNo; //	REVIEW_NO	NUMBER
	private int userNo; //	USER_NO	NUMBER
	private String likeYN; //	LIKE_YN	VARCHAR2(1 BYTE)
	
	
	
	
	
	
	public ReviewLike() {
		super();
	}


	public ReviewLike(int reviewNo, int userNo, String likeYN) {
		super();
		this.reviewNo = reviewNo;
		this.userNo = userNo;
		this.likeYN = likeYN;
	}


	public int getReviewNo() {
		return reviewNo;
	}


	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}


	public int getUserNo() {
		return userNo;
	}


	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}


	public String getLikeYN() {
		return likeYN;
	}


	public void setLikeYN(String likeYN) {
		this.likeYN = likeYN;
	}


	@Override
	public String toString() {
		return "ReviewLike [reviewNo=" + reviewNo + ", userNo=" + userNo + ", likeYN=" + likeYN + "]";
	}
	
	
	
	
	
	
}
