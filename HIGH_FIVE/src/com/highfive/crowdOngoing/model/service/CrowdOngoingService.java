package com.highfive.crowdOngoing.model.service;

import static com.highfive.common.JDBCTemplate.*;

import java.sql.Connection;

import com.highfive.crowdOngoing.model.dao.CrowdOngoingDao;

public class CrowdOngoingService {

	public int selectGoodIdeaUserNo(int cno, int userNo) {

		Connection conn = getConnection();

		int result = new CrowdOngoingDao().selectGoodIdeaUserNo(conn, cno, userNo);

		close(conn);

		return result;
	};
	
	public int selectMakeItUserNo(int cno, int userNo) {
		
		Connection conn = getConnection();
		
		int result = new CrowdOngoingDao().selectMakeItUserNo(conn, cno, userNo);
		
		close(conn);
		
		return result;
	};

	
	public int insertGoodIdea(int cno, int userNo) {
		
		Connection conn = getConnection();
		
		int result = new CrowdOngoingDao().insertGoodIdea(conn, cno, userNo);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		};
		
		close(conn);
		
		return result ;
		
		
	};
	
	public int downGoodIdea(int cno, int userNo) {
		
		Connection conn = getConnection();
		
		int result = new CrowdOngoingDao().downGoodIdea(conn, cno, userNo);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	public int upGoodIdea(int cno, int userNo) {
		
		Connection conn = getConnection();
		
		int result = new CrowdOngoingDao().upGoodIdea(conn, cno, userNo);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}
	
	public int goodIdeaCount(int cno, int userNo) {
		
		Connection conn = getConnection();
		
		int result = new CrowdOngoingDao().goodIdeaCount(conn, cno, userNo);
		
		close(conn);
		
		return result;
	}
	
	public int insertMakeIt(int cno, int userNo) {
		
		Connection conn = getConnection();
		
		int result = new CrowdOngoingDao().insertMakeIt(conn, cno, userNo);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		};
		
		close(conn);
		
		return result ;
	}
	
	public int downMakeIt(int cno, int userNo) {
		
		Connection conn = getConnection();
		
		int result = new CrowdOngoingDao().downMakeIt(conn, cno, userNo);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		};
		
		close(conn);
		
		return result ;
		
	}
	
	public int upMakeIt(int cno, int userNo) {
		
		Connection conn = getConnection();
		
		int result = new CrowdOngoingDao().upMakeIt(conn, cno, userNo);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		};
		
		close(conn);
		
		return result ;
	}
	
	public int makeItCount(int cno) {
		
		Connection conn = getConnection();
		
		int result = new CrowdOngoingDao().makeItCount(conn, cno);
		
		close(conn);
		
		return result;
	}
	
}
