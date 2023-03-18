package com.highfive.myChallenge.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.highfive.challenge.model.vo.Challenge;

public class myChallengeDao {
	
	private Properties prop = new Properties();
	
	public myChallengeDao() {
		String file = myChallengeDao.class.getResource("/sql/myChallenge/myChallenge-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Challenge> selectMadeByMeList(Connection conn, int userNo) {

		ArrayList<Challenge> madeByMeList = new ArrayList();
		Challenge c = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectMadeByMeList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				c = new Challenge();
				
				c.setChallNo(rset.getInt("CHALL_NO"));
				c.setChallName(rset.getString("CHALL_NAME"));
				c.setChallThumbnail(rset.getString("CHALL_THUMBNAIL"));
				c.setChallStart(rset.getString("CHALL_START"));
				c.setChallEnd(rset.getString("CHALL_END"));
				c.setChallPublic(rset.getString("CHALL_PUBLIC"));
				
				madeByMeList.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return madeByMeList;
	}

	public ArrayList<Challenge> selectJoinChallenge(Connection conn, int userNo) {
		ArrayList<Challenge> joinNowList = new ArrayList();
		Challenge c = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectJoinChallenge");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				c = new Challenge();
				
				c.setChallNo(rset.getInt("CHALL_NO"));
				c.setChallName(rset.getString("CHALL_NAME"));
				c.setChallThumbnail(rset.getString("CHALL_THUMBNAIL"));
				c.setChallStart(rset.getString("CHALL_START"));
				c.setChallEnd(rset.getString("CHALL_END"));
				c.setChallPublic(rset.getString("CHALL_PUBLIC"));
				
				joinNowList.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return joinNowList;
	}

	public ArrayList<Challenge> selectReadyChallenge(Connection conn, int userNo) {
		
		ArrayList<Challenge> readyList = new ArrayList();
		Challenge c = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectReadyChallenge");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				c = new Challenge();
				
				c.setChallNo(rset.getInt("CHALL_NO"));
				c.setChallName(rset.getString("CHALL_NAME"));
				c.setChallThumbnail(rset.getString("CHALL_THUMBNAIL"));
				c.setChallStart(rset.getString("CHALL_START"));
				c.setChallEnd(rset.getString("CHALL_END"));
				c.setChallPublic(rset.getString("CHALL_PUBLIC"));
				
				readyList.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return readyList;
	}

	public ArrayList<Challenge> selectEndChallenge(Connection conn, int userNo) {
		ArrayList<Challenge> endList = new ArrayList();
		Challenge c = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectEndChallenge");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				c = new Challenge();
				
				c.setChallNo(rset.getInt("CHALL_NO"));
				c.setChallName(rset.getString("CHALL_NAME"));
				c.setChallThumbnail(rset.getString("CHALL_THUMBNAIL"));
				c.setChallStart(rset.getString("CHALL_START"));
				c.setChallEnd(rset.getString("CHALL_END"));
				c.setChallPublic(rset.getString("CHALL_PUBLIC"));
				
				endList.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return endList;
	}
}
