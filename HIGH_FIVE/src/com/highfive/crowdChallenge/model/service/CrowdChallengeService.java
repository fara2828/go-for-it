package com.highfive.crowdChallenge.model.service;

import static com.highfive.common.JDBCTemplate.*;
import static com.highfive.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.highfive.crowdChallenge.model.dao.CrowdChallengeDao;
import com.highfive.crowdChallenge.model.vo.CrowdChallenge;
import com.highfive.crowdChallenge.model.vo.CrowdChallengeReply;

public class CrowdChallengeService {

	public ArrayList<CrowdChallenge> selectCrowdList(){
		
		Connection conn = getConnection();
		
		ArrayList<CrowdChallenge> list = new CrowdChallengeDao().selectCrowdList(conn);
		
		close(conn);
		
		return list;
	}
	
	public CrowdChallenge selectCrowdChallenge(int crowdChallengeNo){
		
		Connection conn = getConnection();
		
		CrowdChallenge c = new CrowdChallenge();
		
		c  = new CrowdChallengeDao().selectCrowdChallenge(conn, crowdChallengeNo);
		
		close(conn);
		
		
		return c;
	}
	
	public int increaseCrowdChallengeCount(int crowdChallengeNo) {
		
		Connection conn = getConnection();
		
		int result = new CrowdChallengeDao().increaseCrowdChallengeCount(conn, crowdChallengeNo);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	/*
	public int goodIdeaCount() {
		
		Connection conn = getConnection();
		int goodIdeaCount = 0;
		goodIdeaCount = new CrowdChallengeDao().goodIdeaCount(conn);
		
		close(conn);
		
		return goodIdeaCount;
		
	}
	*/
	
	public ArrayList selectCrowdNoList() {
		
		Connection conn = getConnection();
		
		ArrayList crowdNoList = new CrowdChallengeDao().selectCrowdNoList(conn);
		
		close(conn);
		
		return crowdNoList;
		
	}
	
	public ArrayList<CrowdChallengeReply> selectCrowdChallengeReplyList (int cno) {
		
		Connection conn = getConnection();
		
		ArrayList<CrowdChallengeReply> rlist = new CrowdChallengeDao().selectCrowdChallengeReplyList(conn, cno);
		
		close(conn);
		
		return rlist;
	}
	
	public int insertCrowdChallengeReply(CrowdChallengeReply r) {
		
		Connection conn = getConnection();
		
		int result = new CrowdChallengeDao().insertCrowdChallengeReply(conn, r);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	public int deleteCrowdChallengeReply(int crowdNo, int userNo, int replyNo) {
		
		Connection conn = getConnection();
		
		int result = new CrowdChallengeDao().deleteCrowdChallengeReply(conn, crowdNo, userNo, replyNo);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	public int insertCrowdChallenge(CrowdChallenge c) {
		
		Connection conn = getConnection();
		
		int result = new CrowdChallengeDao().insertCrowdChallenge(conn, c);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}
	
	public int deleteCrowdChallenge(int crowdNo) {
		
		Connection conn = getConnection();
		
		int result = new CrowdChallengeDao().deleteCrowdChallenge(conn, crowdNo);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	public int crowdChallengeReplyCount(int crowdNo) {
		
		Connection conn = getConnection();
		
		int result = new CrowdChallengeDao().crowdChallengeReplyCount(conn, crowdNo);
		
		close(conn);
		
		return result;
	}
	
	public int updateCrowdChallengeReply(int crowdNo, int userNo, String context) {
		Connection conn = getConnection();
		
		int result = new CrowdChallengeDao().updateCrowdChallengeReply(conn, crowdNo, userNo, context);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
}
