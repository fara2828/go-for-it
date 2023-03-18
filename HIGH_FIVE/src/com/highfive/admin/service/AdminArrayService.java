package com.highfive.admin.service;

import static com.highfive.common.JDBCTemplate.close;
import static com.highfive.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.highfive.admin.dao.AdminArrayDao;
import com.highfive.challenge.model.vo.Challenge;
import com.highfive.contact.model.vo.Contact;
import com.highfive.crowdChallenge.model.vo.CrowdChallenge;
import com.highfive.faq.model.vo.Faq;
import com.highfive.member.model.vo.Member;
import com.highfive.notice.model.vo.Notice;

public class AdminArrayService {

	public ArrayList<Member> selectMembers(){
		
		Connection conn = getConnection();
		
		ArrayList<Member> mList = new AdminArrayDao().selectMembers(conn);
		
		close(conn);
		
		return mList;
	}
	
	
	public ArrayList<Challenge> selectChallenge(){
		
		Connection conn = getConnection();
		
		ArrayList<Challenge> challList = new AdminArrayDao().selectChallenge(conn);
		
		close(conn);
		
		return challList;
	}
	
	
	public ArrayList<CrowdChallenge> selectCrowd(){
		
		Connection conn = getConnection();
		
		ArrayList<CrowdChallenge> crowdList = new AdminArrayDao().selectCrowd(conn);
		
		close(conn);
		
		return crowdList;
	}	
	
/*	
	public Challenge selectChallengeAdmin() {
		
		Connection conn = getConnection();
		
		Challenge challenge = new AdminArrayDao().selectChallengeAdmin(conn);
		
		close(conn);
		
		return challenge;
	}
*/	
	public ArrayList<Contact> selectContact(){

		Connection conn = getConnection();
		
		ArrayList<Contact> conList = new AdminArrayDao().selectContact(conn);
		
		close(conn);
		
		return conList;
	}
	
	
	public ArrayList<Faq> selectFaq(){
		
		Connection conn = getConnection();
		
		ArrayList<Faq> faqList = new AdminArrayDao().selectFaq(conn);
		
		close(conn);
		
		return faqList;			
	}
	
	
	public ArrayList<Notice> selectNotice(){
		
		Connection conn = getConnection();
		
		ArrayList<Notice> noticeList = new AdminArrayDao().selectNotice(conn);
		
		close(conn);
		
		return noticeList;			
		
	}
	
	
	public ArrayList<Member> selectLevel(){
		
		Connection conn = getConnection();
		
		ArrayList<Member> levelList = new AdminArrayDao().selectLevel(conn);
		
		close(conn);
		
		return levelList;
	}
	

	
	
}
