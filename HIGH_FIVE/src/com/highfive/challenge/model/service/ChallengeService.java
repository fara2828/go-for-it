package com.highfive.challenge.model.service;

import static com.highfive.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.highfive.certBoard.model.vo.Attachment;
import com.highfive.challenge.model.dao.ChallengeDao;
import com.highfive.challenge.model.vo.Challenge;

public class ChallengeService {

	public ArrayList<Challenge> selectChallengeList(String orderQuery, String whereQuery) {

		Connection conn = getConnection();
		
		ArrayList<Challenge> list = new ChallengeDao().selectChallengeList(conn, orderQuery, whereQuery);
		
		close(conn);
		
		return list;
	}

	public Challenge selectChallengeDetail(int cno) {
		
		Connection conn = getConnection();
		
		Challenge challenge = new ChallengeDao().selectChallengeDetail(conn, cno);
		
		close(conn);
		
		return challenge;
	}

	public int increaseCount(int cno) {

		Connection conn = getConnection();
		
		int result = new ChallengeDao().increaseCount(conn, cno);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int enjoyCheck(int cno, int userNo) {
		Connection conn = getConnection();
		
		int result = new ChallengeDao().enjoyCheck(cno, userNo, conn);
		
		close(conn);
		
		return result;
	}

	public int enjoyChallenge(int cno, int userNo) {
		Connection conn = getConnection();
		
		int result = new ChallengeDao().enjoyChallenge(conn, cno, userNo);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int checkChallPwd(int cno, String challPwd) {
		
		Connection conn = getConnection();
		
		int result = new ChallengeDao().checkChallPwd(conn, cno, challPwd);
		
		close(conn);
		
		return result;
	}

	public int selectEnjoyCount(int userNo) {
		Connection conn = getConnection();
		
		int result = new ChallengeDao().selectEnjoyCount(conn, userNo);
		
		close(conn);
		
		return result;
	}

	public int selectEndCount(int userNo) {
		Connection conn = getConnection();

		int result = new ChallengeDao().selectEndCount(conn, userNo);
		
		close(conn);
		
		return result;
	}

	public int selectMadeCount(int userNo) {
		Connection conn = getConnection();

		int result = new ChallengeDao().selectMadeCount(conn, userNo);
		
		close(conn);
		
		return result;
	}

	public int insertChallenge(Challenge c, ArrayList<Attachment> list) {
		Connection conn = getConnection();
		
		int result1 = new ChallengeDao().insertChallenge(conn, c);
		
		int result2 = new ChallengeDao().insertChallengeAttachment(conn, list);
		
		int enjoyChallenge = new ChallengeDao().insertEnjoyChallenge(conn, c.getUserNo());
		
		if((result1 * result2) > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return (result1 * result2);
	}

	public ArrayList<Attachment> selectChallengeAttechment(int cno) {
		
		Connection conn = getConnection();
		
		ArrayList<Attachment> list = new ChallengeDao().selectChallengeAttechment(conn, cno);
		
		close(conn);
		
		return list;
	}

	public Challenge participateChallengeNow(int cno) {

		Connection conn = getConnection();
		
		Challenge c = new ChallengeDao().participateChallengeNow(conn, cno);
		
		close(conn);
		
		return c;
	}

	public void increaseChallParticipantNow(int cno) {
		Connection conn = getConnection();
		
		int result = new ChallengeDao().increaseChallParticipantNow(conn, cno);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		
	}

	public int deleteChallenge(int cno) {
		Connection conn = getConnection();
		
		int result = new ChallengeDao().deleteChallenge(conn, cno);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public ArrayList<Challenge> selectCarouselList() {
		Connection conn = getConnection();
		
		ArrayList<Challenge> list = new ChallengeDao().selectCarouselList(conn);
		
		close(conn);
		
		return list;
	}

	public ArrayList<Challenge> selectRoutineList(String whereQuery) {
		Connection conn = getConnection();
		
		ArrayList<Challenge> list = new ChallengeDao().selectRoutineList(conn, whereQuery);
		
		close(conn);
		
		return list;
	}

	public int selectCountNotCert(int userNo) {
		Connection conn = getConnection();
		
		int result = new ChallengeDao().selectCountNotCert(conn, userNo);
		
		close(conn);
		
		return result;
	}

	public ArrayList<Challenge> selectNotCertList(int userNo) {
		Connection conn = getConnection();
		
		ArrayList<Challenge> list = new ChallengeDao().selectNotCertList(conn, userNo);
		
		close(conn);
		
		return list;
	}

}
