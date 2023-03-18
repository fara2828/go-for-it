package com.highfive.certBoard.model.service;

import static com.highfive.common.JDBCTemplate.*;


import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.highfive.certBoard.model.dao.CertDao;
import com.highfive.certBoard.model.vo.Attachment;
import com.highfive.certBoard.model.vo.CertChall;
import com.highfive.challenge.model.vo.Challenge;
import com.highfive.review.model.vo.Review;	

public class CertService {

	public ArrayList<CertChall> selectThumbnailList(int challNo) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		
		ArrayList<CertChall> list = new CertDao().selectThumbnailList(conn, challNo);
		
		close(conn);

		return list;
		
	}

	public int selectCertCount(int challNo) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		
		int result = new CertDao().selectCertCount(conn, challNo);
		close(conn);

		return result;
	}
	
	


	public Challenge selectChall(int challNo) {
		
		Connection conn = getConnection();
		
		Challenge c =  new CertDao().selectChall(conn, challNo);

		close(conn);

		return c; 
	}

	public ArrayList<Attachment> selectAttachmentList(int challNo) {
		
		Connection conn = getConnection();
		
		ArrayList<Attachment> atList =  new CertDao().selectAttachmentList(conn, challNo);

		close(conn);

		return atList;
	}

	public ArrayList<Challenge> selectMyChallList(int userNo) {
		// TODO Auto-generated method stub
	
		Connection conn = getConnection();
		
		ArrayList<Challenge> cList =  new CertDao().selectMyChallList(conn, userNo);

		close(conn);
	
		return cList;
		
	}

	public ArrayList<Attachment> selectChallAttachmentList(int challNo) {		
		Connection conn = getConnection();
	
		ArrayList<Attachment> challAtList =  new CertDao().selectChallAttachmentList(conn, challNo);

		close(conn);

		return challAtList;
	}
	

	public ArrayList<Attachment> selectCertAttachmentList(int certNo) {
		Connection conn = getConnection();
		
		ArrayList<Attachment> certAtList =  new CertDao().selectCertAttachmentList(conn, certNo);

		close(conn);

		return certAtList;
	}

	public CertChall selectCertChall(int certNo) {
		Connection conn = getConnection();
		
		CertChall cc = new CertDao().selectCertChall(conn, certNo);
		close(conn);

		return cc;
	}

	
	public int insertCert(CertChall cc, ArrayList<Attachment> list) {
		Connection conn= getConnection();
		
		// 1개 트랜잭션에 2개의 inser가 필요함
			
			int result1 = new CertDao().insertCert(conn, cc);
			
			int result2 = new CertDao().insertAttachmentList(conn, list);

			
			
			if(result1*result2 >0) {
				commit(conn);
			} else {
				rollback(conn);
			}
				close(conn);
			
			return result1*result2;		
		
	}

	public ArrayList<CertChall> selectTopCertChallList(int challNo) {
		Connection conn = getConnection();
		
		ArrayList<CertChall> certList = new CertDao().selectTopCertChallList(conn, challNo);
		
		close(conn);

		return certList;
	}

	public int selectCertTotal(int userNo) {
		Connection conn = getConnection();
		
		int certTotal = new CertDao().selectCertTotal(conn, userNo);
		
		close(conn);

		return certTotal;
		
	}

	public int updateMemberLevel(int userNo) {
		Connection conn = getConnection();
		
		int updateMemberLevel = new CertDao().updateMemberLevel(conn, userNo);
		
		close(conn);

			return updateMemberLevel;
	}

	public HashMap<String, Integer> selectCertProgress(int userNo, int challNo) {
		Connection conn = getConnection();
		
		HashMap<String, Integer> certProgress = new CertDao().selectCertProgress(conn, userNo);
		close(conn);

		return certProgress;	
			
		
	}

		
	
	

}
















