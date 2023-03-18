package com.highfive.challenge.model.dao;

import static com.highfive.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import javax.naming.spi.DirStateFactory.Result;

import com.highfive.certBoard.model.vo.Attachment;
import com.highfive.challenge.model.vo.Challenge;


public class ChallengeDao {
	
	private Properties prop = new Properties();
	
	public ChallengeDao() {
		String file = ChallengeDao.class.getResource("/sql/challenge/challenge-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	public ArrayList<Challenge> selectChallengeList(Connection conn, String orderQuery, String whereQuery) {
		
		ArrayList<Challenge> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "";
		// String sql = prop.getProperty("selectChallengeList");
		
		if(whereQuery.equals("all")) {
			sql = "SELECT"
				+ "		CHALL_NO,"
				+ "		CHALL_NAME,"
				+ "		TO_CHAR(CHALL_START, 'YYYY.MM.DD') CHALL_START,"
				+ "		TO_CHAR(CHALL_END, 'YYYY.MM.DD') CHALL_END,"
				+ "		CHALL_FREQUENCY,"
				+ "		(CHALL_END - CHALL_START) as CHALL_DAYCOUNT,"
				+ "		CHALL_THUMBNAIL,"
				+ "		CHALL_FREQUENCY,"
				+ "		CHALL_COUNT,"
				+ "		CHALL_PARTICIPANT_NOW"
				+ "	FROM"
				+ "		CHALLENGE"
				+ "	WHERE"
				+ "		CHALL_PUBLIC = 'Y'"
				+ "		AND STATUS = 'Y'"
				+ "ORDER BY "
				+ orderQuery
				+ " DESC";
			
		} else {
			sql = "SELECT"
				+ "		CHALL_NO,"
				+ "		CHALL_NAME,"
				+ "		TO_CHAR(CHALL_START, 'YYYY.MM.DD') CHALL_START,"
				+ "		TO_CHAR(CHALL_END, 'YYYY.MM.DD') CHALL_END,"
				+ "		CHALL_FREQUENCY,"
				+ "		(CHALL_END - CHALL_START) as CHALL_DAYCOUNT,"
				+ "		CHALL_THUMBNAIL,"
				+ "		CHALL_FREQUENCY,"
				+ "		CHALL_COUNT,"
				+ "		CHALL_PARTICIPANT_NOW"
				+ "	FROM"
				+ "		CHALLENGE"
				+ "	WHERE"
				+ "		CHALL_PUBLIC = 'Y'"
				+ "		AND STATUS = 'Y'"
				+ "		AND CHALL_CATEGORY = '"
				+ whereQuery + "'"
				+ "ORDER BY "
				+ orderQuery
				+ " DESC";
			
		}
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Challenge c = new Challenge();
				
				c.setChallNo(rset.getInt("CHALL_NO"));
				c.setChallName(rset.getString("CHALL_NAME"));
				c.setChallStart(rset.getString("CHALL_START"));
				c.setChallEnd(rset.getString("CHALL_END"));
				c.setChallFrequency(rset.getInt("CHALL_FREQUENCY"));
				c.setChallDayCount(rset.getString("CHALL_DAYCOUNT"));
				c.setChallThumbnail(rset.getString("CHALL_THUMBNAIL"));
				c.setChallFrequency(rset.getInt("CHALL_FREQUENCY"));
				c.setChallCount(rset.getInt("CHALL_COUNT"));
				c.setChallCount(rset.getInt("CHALL_PARTICIPANT_NOW"));
				
				list.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	
	
	

	public Challenge selectChallengeDetail(Connection conn, int bno) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Challenge challenge = null;
		
		String sql = prop.getProperty("selectChallengeDetail");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bno);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				challenge = new Challenge();
				
				challenge.setChallNo(rset.getInt("CHALL_NO"));
				challenge.setChallName(rset.getString("CHALL_NAME"));
				challenge.setChallCategory(rset.getString("CHALL_CATEGORY"));
				challenge.setChallStart(rset.getString("CHALL_START"));
				challenge.setChallEnd(rset.getString("CHALL_END"));
				challenge.setChallFrequency(rset.getInt("CHALL_FREQUENCY"));
				challenge.setChallDayCount(rset.getString("CHALL_DAYCOUNT"));
				challenge.setNickName(rset.getString("NICKNAME"));
				challenge.setProfile(rset.getString("PROFILE"));
				challenge.setUserLevel(rset.getInt("USER_LEVEL"));
				challenge.setChallIntroduction(rset.getString("CHALL_INTRODUCTION"));
				challenge.setChallHowto(rset.getString("CHALL_HOWTO"));
				challenge.setChallPhothExp(rset.getString("CHALL_PHOTO_EXP"));
				challenge.setChallPublic(rset.getString("CHALL_PUBLIC"));
				challenge.setFilePath(rset.getString("FILE_PATH"));
				challenge.setChallThumbnail(rset.getString("CHALL_THUMBNAIL"));
				challenge.setChallPublic(rset.getString("CHALL_PUBLIC"));
				challenge.setChallPwd(rset.getString("CHALL_PWD"));
				challenge.setUserNo(rset.getInt("USER_NO"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return challenge;
	}

	public int increaseCount(Connection conn, int cno) {

		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("increaseCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, cno);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

	public int enjoyCheck(int cno, int userNo, Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		ResultSet rset = null;
		
		String sql = prop.getProperty("enjoyCheck");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, cno);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt("COUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return result;
	}

	public int enjoyChallenge(Connection conn, int cno, int userNo) {

		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = prop.getProperty("enjoyChallenge");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, cno);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int checkChallPwd(Connection conn, int cno, String challPwd) {

		PreparedStatement pstmt = null;
		int result = 0;
		ResultSet rset = null;
		String sql = prop.getProperty("checkChallPwd");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, cno);
			pstmt.setString(2, challPwd);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt("COUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public int selectEnjoyCount(Connection conn, int userNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectEnjoyCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt("COUNT");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public int selectEndCount(Connection conn, int userNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectEndCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt("COUNT");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public int selectMadeCount(Connection conn, int userNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectMadeCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt("COUNT");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public int insertChallenge(Connection conn, Challenge c) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertChallenge");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, c.getUserNo());
			pstmt.setString(2, c.getChallName());
			pstmt.setString(3, c.getChallCategory());
			pstmt.setString(4, c.getChallStart());
			pstmt.setString(5, c.getChallEnd());
			pstmt.setInt(6, c.getChallFrequency());
			pstmt.setInt(7, c.getChallParticipant());
			pstmt.setString(8, c.getChallHowto());
			pstmt.setString(9, c.getChallIntroduction());
			pstmt.setString(10, c.getChallThumbnail());
			pstmt.setString(11, c.getChallPublic());
			pstmt.setString(12, c.getChallPwd());
			pstmt.setString(13, c.getChallPhothExp());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertChallengeAttachment(Connection conn, ArrayList<Attachment> list) {
		int result = 1;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertChallengeAttachment");
		
		try {
			for(Attachment at : list) {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, at.getFilePath());
				pstmt.setString(2, at.getOriginName());
				pstmt.setString(3, at.getChangeName());
				
				result *= pstmt.executeUpdate();
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertEnjoyChallenge(Connection conn, int userNo) {

		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = prop.getProperty("insertEnjoyChallenge");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Attachment> selectChallengeAttechment(Connection conn, int cno) {
		
		PreparedStatement pstmt = null;
		ArrayList<Attachment> list = new ArrayList();
		Attachment at = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectChallengeAttechment");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, cno);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				at = new Attachment();
				at.setFilePath(rset.getString("FILE_PATH"));
				list.add(at);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return list;
	}

	public Challenge participateChallengeNow(Connection conn, int cno) {
		Challenge c = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("participateChallengeNow");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, cno);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				c = new Challenge();
				c.setChallParticipant(rset.getInt("CHALL_PARTICIPANT"));
				c.setChallParticipantNow(rset.getInt("CHALL_PARTICIPANT_NOW"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return c;
	}

	public int increaseChallParticipantNow(Connection conn, int cno) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("increaseChallParticipantNow");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, cno);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteChallenge(Connection conn, int cno) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteChallenge");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, cno);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Challenge> selectCarouselList(Connection conn) {
		ArrayList<Challenge> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectCarouselList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Challenge c = new Challenge();
				
				c.setChallNo(rset.getInt("CHALL_NO"));
				c.setChallName(rset.getString("CHALL_NAME"));
				c.setChallThumbnail(rset.getString("CHALL_THUMBNAIL"));
				c.setChallIntroduction(rset.getString("CHALL_INTRODUCTION"));
				c.setChallCount(rset.getInt("CHALL_COUNT"));
				
				list.add(c);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Challenge> selectRoutineList(Connection conn, String whereQuery) {
		ArrayList<Challenge> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectRoutineList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, whereQuery);
						
			rset = pstmt.executeQuery();
			
			
			while(rset.next()) {
				Challenge c = new Challenge();
				
				c.setChallNo(rset.getInt("CHALL_NO"));
				c.setChallName(rset.getString("CHALL_NAME"));
				c.setChallThumbnail(rset.getString("CHALL_THUMBNAIL"));
				c.setChallIntroduction(rset.getString("CHALL_INTRODUCTION"));
				c.setChallStart(rset.getString("CHALL_START"));
				c.setChallEnd(rset.getString("CHALL_END"));
				c.setChallDayCount(rset.getString("CHALL_DAYCOUNT"));
				c.setChallFrequency(rset.getInt("CHALL_FREQUENCY"));
				c.setChallCount(rset.getInt("CHALL_COUNT"));
				c.setChallParticipantNow(rset.getInt("CHALL_PARTICIPANT_NOW"));
				
				list.add(c);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int selectCountNotCert(Connection conn, int userNo) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectCountNotCert");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt("COUNT(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Challenge> selectNotCertList(Connection conn, int userNo) {
		ArrayList<Challenge> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectNotCertList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Challenge c = new Challenge();
				c.setChallName(rset.getString("CHALL_NAME"));
				
				list.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
		    close(pstmt);
		}
		
		return list;
	}
	
}
