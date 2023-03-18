package com.highfive.search.model.dao;

import static com.highfive.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.highfive.challenge.model.vo.Challenge;
import com.highfive.crowdChallenge.model.vo.CrowdChallenge;
import com.highfive.review.model.vo.Review;

public class SearchDao {
	
private Properties prop = new Properties();
	
	public SearchDao() {
		String fileName = CrowdChallenge.class.getResource("/sql/search/search-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<Challenge> searchChallenge(Connection conn, String keyword){
		
		ArrayList<Challenge> ChallengeList = new ArrayList<Challenge>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("searchChallenge");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "%"+ keyword + "%");
			pstmt.setString(2, "%"+ keyword + "%");
			
			rset =pstmt.executeQuery();
			
			while(rset.next()) {
				
				Challenge c = new Challenge();
				c.setChallThumbnail(rset.getString("CHALL_THUMBNAIL"));
				c.setChallName(rset.getString("CHALL_NAME"));
				c.setChallIntroduction(rset.getString("CHALL_INTRODUCTION"));
				c.setChallNo(rset.getInt("CHALL_NO"));
				
				ChallengeList.add(c);
				
			};
			
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return ChallengeList;
	}
	
	public ArrayList<CrowdChallenge> searchCrowdChallenge(Connection conn, String keyword){
		
		ArrayList<CrowdChallenge> crowdChallengeList = new ArrayList<CrowdChallenge>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("searchCrowdChallenge");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, '%'+ keyword +'%');
			pstmt.setString(2, '%'+ keyword +'%');
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				CrowdChallenge c = new CrowdChallenge();
				
				c.setCrowdThumbnail(rset.getString("CROWD_THUMBNAIL"));
				c.setCrowdName(rset.getString("CROWD_NAME"));
				c.setCrowdExp(rset.getString("CROWD_EXP"));
				c.setCrowdNo(rset.getInt("CROWD_NO"));
				
				crowdChallengeList.add(c);
				
			}
			
			System.out.println(crowdChallengeList);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return crowdChallengeList;
	}
	
	public ArrayList<Review> searchReview (Connection conn, String keyword){
		
		ArrayList<Review> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("searchReview");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "%"+ keyword + "%");
			pstmt.setString(2, "%"+ keyword + "%");
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Review r = new Review();
				
				r.setReviewTitle(rset.getString("REVIEW_TITLE"));
				r.setReviewContent(rset.getString("REVIEW_CONTENT"));
				r.setReviewThumbnail(rset.getString("REVIEW_THUMBNAIL"));
				r.setReviewNo(rset.getInt("REVIEW_NO"));
				r.setChallNo(rset.getInt("CHALL_NO"));
			
				list.add(r);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	public int searchChallengeCount(Connection conn, String keyword) {
		
		int challCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("searchChallengeCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "%"+ keyword + "%");
			pstmt.setString(2, "%"+ keyword + "%");
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				challCount = rset.getInt("COUNT(*)");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return challCount;
		
	}
	
	public int searchCrowdCount(Connection conn, String keyword) {
		int crowdCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("searchCrowdCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "%"+ keyword + "%");
			pstmt.setString(2, "%"+ keyword + "%");
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				crowdCount = rset.getInt("COUNT(*)");
	
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return crowdCount;
	}
	
	public int searchReviewCount (Connection conn, String keyword) {
		
		int reviewCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("searchReviewCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "%"+ keyword + "%");
			pstmt.setString(2, "%"+ keyword + "%");
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				reviewCount = rset.getInt("COUNT(*)");
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return reviewCount;
		
	}
	
	public ArrayList<Challenge> searchChallengeList(Connection conn, String keyword){
		
		ArrayList<Challenge> cList = new ArrayList<Challenge>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("searchChallengeList");
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, "%"+ keyword + "%");
			pstmt.setString(2, "%"+ keyword + "%");
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Challenge c = new Challenge();
				
				c.setChallThumbnail(rset.getString("CHALL_THUMBNAIL"));
				c.setChallName(rset.getString("CHALL_NAME"));
				c.setChallIntroduction(rset.getString("CHALL_INTRODUCTION"));
				c.setChallNo(rset.getInt("CHALL_NO"));
				
				cList.add(c);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return cList;
	}
	
	public ArrayList<CrowdChallenge> searchCrowdChallengeList(Connection conn, String keyword){
		
		ArrayList<CrowdChallenge> ccList = new ArrayList<CrowdChallenge>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("searchCrowdChallengeList");
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, "%"+ keyword + "%");
			pstmt.setString(2, "%"+ keyword + "%");
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				CrowdChallenge cc = new CrowdChallenge();
				
				cc.setCrowdThumbnail(rset.getString("CROWD_THUMBNAIL"));
				cc.setCrowdName(rset.getString("CROWD_NAME"));
				cc.setCrowdExp(rset.getString("CROWD_EXP"));
				cc.setCrowdNo(rset.getInt("CROWD_NO"));
				
				ccList.add(cc);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return ccList;
		
	}
	
	public ArrayList<Review> searchReviewList(Connection conn, String keyword){
		
		ArrayList<Review> rList = new ArrayList<Review>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("searchReviewList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "%"+ keyword + "%");
			pstmt.setString(2, "%"+ keyword + "%");
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Review r = new Review();
				
				r.setReviewThumbnail(rset.getString("REVIEW_THUMBNAIL"));
				r.setReviewTitle(rset.getString("REVIEW_TITLE"));
				r.setReviewContent(rset.getString("REVIEW_CONTENT"));
				r.setReviewNo(rset.getInt("REVIEW_NO"));
				r.setChallNo(rset.getInt("CHALL_NO"));
				
				rList.add(r);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return rList;
	}
	

}
