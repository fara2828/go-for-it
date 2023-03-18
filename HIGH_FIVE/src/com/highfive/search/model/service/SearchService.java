package com.highfive.search.model.service;

import static com.highfive.common.JDBCTemplate.close;
import static com.highfive.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.highfive.challenge.model.vo.Challenge;
import com.highfive.crowdChallenge.model.vo.CrowdChallenge;
import com.highfive.review.model.vo.Review;
import com.highfive.search.model.dao.SearchDao;

public class SearchService {

	public ArrayList<Challenge> searchChallenge (String keyword){
		
		Connection conn = getConnection();
		
		ArrayList<Challenge> challengeList = new SearchDao().searchChallenge(conn, keyword);
		
		close(conn);
		
		return challengeList;
		
	}
	
	public ArrayList<CrowdChallenge> searchCrowdChallenge(String keyword){
		
		Connection conn = getConnection();
		
		ArrayList<CrowdChallenge> crowdChallengeList = new SearchDao().searchCrowdChallenge(conn, keyword);
		
		close(conn);
		
		return crowdChallengeList;
		
	}
	
	public ArrayList<Review> searchReview(String keyword){
		Connection conn = getConnection();
		
		ArrayList<Review> list = new SearchDao().searchReview(conn, keyword);
		
		close(conn);
		
		return list;
	}
	
	public int searchChallengeCount(String keyword) {
		
		Connection conn = getConnection();
		
		int challCount = new SearchDao().searchChallengeCount(conn, keyword);
		
		close(conn);
		
		return challCount;
	}
	
	public int searchCrowdCount(String keyword) {
		
		Connection conn = getConnection();
		
		int crowdCount = new SearchDao().searchCrowdCount(conn, keyword);
		
		close(conn);
		
		return crowdCount;
	}
	
	public int searchReviewCount(String keyword) {
		Connection conn = getConnection();
		
		int reviewCount = new SearchDao().searchReviewCount(conn, keyword);
		
		close(conn);
		
		return reviewCount;
	}
	
	public ArrayList<Challenge> searchChallengeList(String keyword){
		
		Connection conn = getConnection();
		
		ArrayList<Challenge> cList = new SearchDao().searchChallengeList(conn, keyword);
		
		close(conn);
		
		return cList;
	}
	
	public ArrayList<CrowdChallenge> searchCrowdChallengeList(String keyword){
		
		Connection conn = getConnection();
		
		ArrayList<CrowdChallenge> ccList = new SearchDao().searchCrowdChallengeList(conn, keyword);
		
		close(conn);
		
		return ccList;
	}
	
	public ArrayList<Review> searchReviewList(String keyword){
		
		Connection conn = getConnection();
		
		ArrayList<Review> rList = new SearchDao().searchReviewList(conn, keyword);
		
		close(conn);
		
		return rList;
	}
}
