package com.highfive.challenge.model.vo;

public class Challenge {
	private int challNo; // CHALL_NO;
	private int userNo; // USER_NO
	private String challName; // CHALL_NAME
	private String challCategory; // CHALL_CATEGORY
	private String challPostDate; // CHALL_POSTDATE
	private String challStart; // CHALL_START
	private String challEnd; // CHALL_END
	private int challFrequency; // CHALL_FREQUENCY
	private int challParticipant; // CHALL_PARTICIPANT
	private int challParticipantNow; // CHALL_PARTICIPANT_NOW
	private String challHowto; // CHALL_HOWTO
	private String challPhothExp; // CHALL_PHOTO_EXP
	private String challIntroduction; // CHALL_INTRODUCTION
	private String challThumbnail; // CHALL_THUMBNAIL
	private String challPublic; // CHALL_PUBLIC
	private String status; // STATUS
	private String challPwd; // CHALL_PWD
	private int challCount; // CHALL_COUNT
	private String challDayCount; // 종료일 - 시작일
	
	private String nickName;	// 챌린지 만든이 별명
	private String profile;		// 챌린지 만든이 프로필
	private String filePath;	// 사진 파일 경로
	private int userLevel;		// 사용자 레벨
	
	public Challenge() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Challenge(int challNo, int userNo, String challName, String challCategory, String challPostDate,
			String challStart, String challEnd, int challFrequency, int challParticipant, int challParticipantNow,
			String challHowto, String challPhothExp, String challIntroduction, String challThumbnail,
			String challPublic, String status, String challPwd, int challCount, String challDayCount) {
		super();
		this.challNo = challNo;
		this.userNo = userNo;
		this.challName = challName;
		this.challCategory = challCategory;
		this.challPostDate = challPostDate;
		this.challStart = challStart;
		this.challEnd = challEnd;
		this.challFrequency = challFrequency;
		this.challParticipant = challParticipant;
		this.challParticipantNow = challParticipantNow;
		this.challHowto = challHowto;
		this.challPhothExp = challPhothExp;
		this.challIntroduction = challIntroduction;
		this.challThumbnail = challThumbnail;
		this.challPublic = challPublic;
		this.status = status;
		this.challPwd = challPwd;
		this.challCount = challCount;
		this.challDayCount = challDayCount;
	}

	public int getChallNo() {
		return challNo;
	}

	public void setChallNo(int challNo) {
		this.challNo = challNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getChallName() {
		return challName;
	}

	public void setChallName(String challName) {
		this.challName = challName;
	}

	public String getChallCategory() {
		return challCategory;
	}

	public void setChallCategory(String challCategory) {
		this.challCategory = challCategory;
	}

	public String getChallPostDate() {
		return challPostDate;
	}

	public void setChallPostDate(String challPostDate) {
		this.challPostDate = challPostDate;
	}

	public String getChallStart() {
		return challStart;
	}

	public void setChallStart(String challStart) {
		this.challStart = challStart;
	}

	public String getChallEnd() {
		return challEnd;
	}

	public void setChallEnd(String challEnd) {
		this.challEnd = challEnd;
	}

	public int getChallFrequency() {
		return challFrequency;
	}

	public void setChallFrequency(int challFrequency) {
		this.challFrequency = challFrequency;
	}

	public int getChallParticipant() {
		return challParticipant;
	}

	public void setChallParticipant(int challParticipant) {
		this.challParticipant = challParticipant;
	}

	public int getChallParticipantNow() {
		return challParticipantNow;
	}

	public void setChallParticipantNow(int challParticipantNow) {
		this.challParticipantNow = challParticipantNow;
	}

	public String getChallHowto() {
		return challHowto;
	}

	public void setChallHowto(String challHowto) {
		this.challHowto = challHowto;
	}

	public String getChallPhothExp() {
		return challPhothExp;
	}

	public void setChallPhothExp(String challPhothExp) {
		this.challPhothExp = challPhothExp;
	}

	public String getChallIntroduction() {
		return challIntroduction;
	}

	public void setChallIntroduction(String challIntroduction) {
		this.challIntroduction = challIntroduction;
	}

	public String getChallThumbnail() {
		return challThumbnail;
	}

	public void setChallThumbnail(String challThumbnail) {
		this.challThumbnail = challThumbnail;
	}

	public String getChallPublic() {
		return challPublic;
	}

	public void setChallPublic(String challPublic) {
		this.challPublic = challPublic;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getChallPwd() {
		return challPwd;
	}

	public void setChallPwd(String challPwd) {
		this.challPwd = challPwd;
	}

	public int getChallCount() {
		return challCount;
	}

	public void setChallCount(int challCount) {
		this.challCount = challCount;
	}

	public String getChallDayCount() {
		return challDayCount;
	}

	public void setChallDayCount(String challDayCount) {
		this.challDayCount = challDayCount;
	}


	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public int getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(int userLevel) {
		this.userLevel = userLevel;
	}

	@Override
	public String toString() {
		return "Challenge [challNo=" + challNo + ", userNo=" + userNo + ", challName=" + challName + ", challCategory="
				+ challCategory + ", challPostDate=" + challPostDate + ", challStart=" + challStart + ", challEnd="
				+ challEnd + ", challFrequency=" + challFrequency + ", challParticipant=" + challParticipant
				+ ", challParticipantNow=" + challParticipantNow + ", challHowto=" + challHowto + ", challPhothExp="
				+ challPhothExp + ", challIntroduction=" + challIntroduction + ", challThumbnail=" + challThumbnail
				+ ", challPublic=" + challPublic + ", status=" + status + ", challPwd=" + challPwd + ", challCount="
				+ challCount + ", challDayCount=" + challDayCount + ", nickName=" + nickName + ", profile=" + profile
				+ ", filePath=" + filePath + ", userLevel=" + userLevel + "]";
	}
	
	
	

}
