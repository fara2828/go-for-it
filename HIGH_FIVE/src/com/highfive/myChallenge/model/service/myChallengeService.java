package com.highfive.myChallenge.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.highfive.challenge.model.vo.Challenge;
import com.highfive.myChallenge.model.dao.myChallengeDao;

import static com.highfive.common.JDBCTemplate.*;

public class myChallengeService {

	public ArrayList<Challenge> selectMadeByMeList(int userNo) {
		Connection conn = getConnection();
		
		ArrayList<Challenge> madeByMeList = new myChallengeDao().selectMadeByMeList(conn, userNo);
		
		close(conn);
		
		return madeByMeList;
	}

	public ArrayList<Challenge> selectJoinChallenge(int userNo) {
		Connection conn = getConnection();
		
		ArrayList<Challenge> joinNowList = new myChallengeDao().selectJoinChallenge(conn, userNo);
		
		close(conn);
		
		return joinNowList;
	}

	public ArrayList<Challenge> selectReadyChallenge(int userNo) {
		Connection conn = getConnection();
		
		ArrayList<Challenge> readyList = new myChallengeDao().selectReadyChallenge(conn, userNo);
		
		close(conn);
		
		return readyList;
	}

	public ArrayList<Challenge> selectEndChallenge(int userNo) {
		Connection conn = getConnection();
		
		ArrayList<Challenge> endList = new myChallengeDao().selectEndChallenge(conn, userNo);
		
		close(conn);
		
		return endList;
	}

}
