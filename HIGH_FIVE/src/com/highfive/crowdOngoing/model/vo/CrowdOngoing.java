package com.highfive.crowdOngoing.model.vo;

public class CrowdOngoing {
	
	private int crowdNo;//CROWD_NO	NUMBER
	private int crowdGoodIdea;//CROWD_GOODIDEA	NUMBER
	private int crowdMakeIt;//CROWD_MAKEIT	NUMBER
	private String status;//STATUS	CHAR(1 BYTE)
	
	public CrowdOngoing() {
		super();
	}
	
	public CrowdOngoing(int crowdNo, int crowdGoodIdea, int crowdMakeIt, String status) {
		super();
		this.crowdNo = crowdNo;
		this.crowdGoodIdea = crowdGoodIdea;
		this.crowdMakeIt = crowdMakeIt;
		this.status = status;
	}
	
	public int getCrowdNo() {
		return crowdNo;
	}
	public void setCrowdNo(int crowdNo) {
		this.crowdNo = crowdNo;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "CrowdOngoing [crowdNo=" + crowdNo + ", crowdGoodIdea=" + crowdGoodIdea + ", crowdMakeIt=" + crowdMakeIt
				+ ", status=" + status + "]";
	}

}
