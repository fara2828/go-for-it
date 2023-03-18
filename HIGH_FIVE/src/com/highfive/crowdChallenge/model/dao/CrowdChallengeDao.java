package com.highfive.crowdChallenge.model.dao;

import static com.highfive.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.highfive.crowdChallenge.model.vo.CrowdChallenge;
import com.highfive.crowdChallenge.model.vo.CrowdChallengeReply;

public class CrowdChallengeDao {
	
	private Properties prop = new Properties();
	
	public CrowdChallengeDao() {
		String fileName = CrowdChallenge.class.getResource("/sql/crowdChallenge/crowdChallenge-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<CrowdChallenge> selectCrowdList(Connection conn) {
		
		
		ArrayList<CrowdChallenge> list = new ArrayList();
		CrowdChallenge c = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectCrowdChallengeList");
		
		try {
				pstmt = conn.prepareStatement(sql);
				 rset = pstmt.executeQuery();
					 
				 while(rset.next()) {
					 c = new CrowdChallenge();
					 c.setCrowdNo(rset.getInt("CROWD_NO"));
					 c.setUserNo(rset.getInt("USER_NO"));					 
					 c.setNickName(rset.getString("NICKNAME"));
					 c.setCrowdName(rset.getString("CROWD_NAME"));
					 c.setCrowdCategory(rset.getString("CROWD_CATEGORY"));
					 c.setCrowdPostDate(rset.getString("CROWD_POSTDATE"));
					 c.setCrowdExp(rset.getString("CROWD_EXP"));
					 c.setCrowdThumbnail(rset.getString("CROWD_THUMBNAIL"));
					 c.setCrowdGoodIdea(rset.getInt("CROWD_GOODIDEA"));
					 c.setCrowdMakeIt(rset.getInt("CROWD_MAKEIT"));
					 
					 list.add(c);
				 }
				 
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(pstmt);
		}
		
		return list;
	}
	
	public CrowdChallenge selectCrowdChallenge (Connection conn, int CrowdChallengeNo) {
		
		CrowdChallenge c = new CrowdChallenge();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectCrowdChallenge");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, CrowdChallengeNo);
			pstmt.setInt(2, CrowdChallengeNo);
			pstmt.setInt(3, CrowdChallengeNo);
			pstmt.setInt(4, CrowdChallengeNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				c.setCrowdNo(rset.getInt("CROWD_NO"));
				c.setUserNo(rset.getInt("USER_NO"));
				c.setNickName(rset.getString("NICKNAME"));
				c.setCrowdName(rset.getString("CROWD_NAME"));
				c.setCrowdCategory(rset.getString("CROWD_CATEGORY"));
				c.setCrowdPostDate(rset.getString("CROWD_POSTDATE"));
				c.setCrowdExp(rset.getString("CROWD_EXP"));
				c.setCrowdThumbnail(rset.getString("CROWD_THUMBNAIL"));
				c.setCrowdGoodIdea(rset.getInt("CROWD_GOODIDEA"));
				c.setCrowdMakeIt(rset.getInt("CROWD_MAKEIT"));
				c.setCrowdCount(rset.getInt("CROWD_COUNT"));
				c.setCrowdPeriod(rset.getInt("CROWD_PERIOD"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return c;
		
	}
	
	public int increaseCrowdChallengeCount(Connection conn, int crowdNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("increaseCrowdChallengeCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, crowdNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	/*
	public int goodIdeaCount(Connection conn) {
		
		int goodIdeaCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("increaseGoodIdeaCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			while(rset.next()) {
				
				goodIdeaCount = rset. 
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	*/
	
	public ArrayList selectCrowdNoList(Connection conn) {
		
		ArrayList crowdNoList = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("CrowdNoList");
		
		try {
			pstmt = conn.prepareStatement(sql);

			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				crowdNoList.add(rset.getInt("CROWD_NO"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return crowdNoList;
	}
	
	
	public ArrayList<CrowdChallengeReply> selectCrowdChallengeReplyList(Connection conn, int cno){
		
		CrowdChallengeReply c = null;
		ArrayList<CrowdChallengeReply> rlist = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectCrowdChallengeReplyList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, cno);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {

				 c = new CrowdChallengeReply();
				 
				 c.setCrowdCommentNo(rset.getInt("C_COMMENT_NO"));
				 c.setCrowdCommentText(rset.getString("C_COMMENT_TEXT"));
				 c.setCrowdNo(rset.getInt("C_ROWD_NO"));
				 c.setUserNo(rset.getInt("USER_NO"));
				 c.setStatus(rset.getString("STATUS"));
				 c.setNickName(rset.getString("NICKNAME"));
				 c.setCrowdReplyDate(rset.getString("C_REPLY_DATE"));
				 
				 rlist.add(c);
				
				 
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return rlist;
		
	}
	
	public int insertCrowdChallengeReply(Connection conn, CrowdChallengeReply r) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertCrowdChallengeReply");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, r.getCrowdCommentText());
			pstmt.setInt(2, r.getCrowdNo());
			pstmt.setInt(3, r.getUserNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int deleteCrowdChallengeReply(Connection conn, int crowdNo, int userNo, int replyNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteCrowdChallengeReply");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, crowdNo);
			pstmt.setInt(2, userNo);
			pstmt.setInt(3, replyNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int insertCrowdChallenge(Connection conn, CrowdChallenge c) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertCrowdChallenge");
		
		try {
			pstmt= conn.prepareStatement(sql);
			
			pstmt.setInt(1, c.getUserNo());
			pstmt.setString(2, c.getCrowdName());
			pstmt.setString(3, c.getCrowdCategory());
			pstmt.setString(4, c.getCrowdExp());
			pstmt.setString(5, c.getCrowdThumbnail());
			pstmt.setInt(6, c.getCrowdPeriod());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	public int deleteCrowdChallenge(Connection conn, int crowdNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteCrowdChallenge");
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, crowdNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int crowdChallengeReplyCount(Connection conn, int crowdNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("crowdChallengeReplyCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, crowdNo);
			
			rset= pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt("COUNT(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}
	
	public int updateCrowdChallengeReply(Connection conn, int crowdNo, int userNo, String context) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateCrowdChallengeReply");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, context);
			pstmt.setInt(2, crowdNo);
			pstmt.setInt(1, userNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
}
