package com.highfive.review.model.vo;

public class Review {
	
	
	private int reviewNo; //	REVIEW_NO	NUMBER
	private int userNo;		//	USER_NO	NUMBER
	private int challNo;		//	CHALL_NO	NUMBER
	private String reviewTitle;		//	REVIEW_TITLE	VARCHAR2(50 BYTE)
	private String reviewDate;		//	REVIEW_DATE	DATE
	private String reviewContent;		//	REVIEW_CONTENT	VARCHAR2(3000 BYTE)
	private String reviewThumbnail;		//	REVIEW_THUMBNAIL	VARCHAR2(100 BYTE)
	private int reviewCount;		//	REVIEW_COUNT	NUMBER
	private String status;		//	STATUS	CHAR(1 BYTE)
	private int countLike;
	private String nickName;



	public Review() {
		super();
	}


	public Review(int reviewNo, int userNo, int challNo, String reviewTitle, String reviewDate, String reviewContent,
			String reviewThumbnail, int reviewCount, String status, int countLike, String nickName) {
		super();
		this.reviewNo = reviewNo;
		this.userNo = userNo;
		this.challNo = challNo;
		this.reviewTitle = reviewTitle;
		this.reviewDate = reviewDate;
		this.reviewContent = reviewContent;
		this.reviewThumbnail = reviewThumbnail;
		this.reviewCount = reviewCount;
		this.status = status;
		this.countLike = countLike;
		this.nickName = nickName;
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





	public int getChallNo() {
		return challNo;
	}





	public void setChallNo(int challNo) {
		this.challNo = challNo;
	}





	public String getReviewTitle() {
		return reviewTitle;
	}





	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}





	public String getReviewDate() {
		return reviewDate;
	}





	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}





	public String getReviewContent() {
		return reviewContent;
	}





	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}





	public String getReviewThumbnail() {
		return reviewThumbnail;
	}





	public void setReviewThumbnail(String reviewThumbnail) {
		this.reviewThumbnail = reviewThumbnail;
	}





	public int getReviewCount() {
		return reviewCount;
	}





	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}





	public String getStatus() {
		return status;
	}





	public void setStatus(String status) {
		this.status = status;
	}


	
	

	public int getCountLike() {
		return countLike;
	}







	public void setCountLike(int countLike) {
		this.countLike = countLike;
	}




	public String getNickName() {
		return nickName;
	}






	public void setNickName(String nickName) {
		this.nickName = nickName;
	}







	@Override
	public String toString() {
		return "Review [reviewNo=" + reviewNo + ", userNo=" + userNo + ", challNo=" + challNo + ", reviewTitle="
				+ reviewTitle + ", reviewDate=" + reviewDate + ", reviewContent=" + reviewContent + ", reviewThumbnail="
				+ reviewThumbnail + ", reviewCount=" + reviewCount + ", status=" + status + ", countLike=" + countLike
				+ ", nickName=" + nickName + "]";
	}
	
	
	
	
	

}
