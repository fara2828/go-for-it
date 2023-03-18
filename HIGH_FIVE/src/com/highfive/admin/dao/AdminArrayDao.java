package com.highfive.admin.dao;

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
import com.highfive.contact.model.vo.Contact;
import com.highfive.crowdChallenge.model.vo.CrowdChallenge;
import com.highfive.faq.model.vo.Faq;
import com.highfive.member.model.vo.Member;
import com.highfive.notice.model.vo.Notice;

public class AdminArrayDao {

	private Properties prop = new Properties();
	
	public AdminArrayDao() {
		String file= AdminArrayDao.class.getResource("/sql/admin/adminArray-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<Member> selectMembers(Connection conn) {
		
		ArrayList<Member> mList = new ArrayList<Member>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMembers");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Member m = new Member(
						rset.getInt("USER_NO"),
						rset.getString("USER_ID"),
						rset.getString("USER_PWD"),
						rset.getString("USER_NAME"),
						rset.getString("NICKNAME"),
						rset.getString("EMAIL"),
						rset.getString("BIRTHDATE"),
						rset.getString("GENDER"),
						rset.getString("POST"),
						rset.getString("ADDRESS"),
						rset.getString("ADDRESS_DETAIL"),
						rset.getString("PHONE"),
						rset.getString("USER_TYPE"),
						rset.getInt("USER_LEVEL"),
						rset.getDate("ENROLL_DATE"),
						rset.getDate("MODIFY_DATE"),
						rset.getString("PROFILE"),
						rset.getString("STATUS"));

						mList.add(m);
			}
System.out.println(mList);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return mList;
	}
	
	
	public ArrayList<Challenge> selectChallenge(Connection conn){
		
		ArrayList<Challenge> challList = new ArrayList<Challenge>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectChallenge");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Challenge challenge = new Challenge();
				
				challenge.setChallNo(rset.getInt("CHALL_NO"));
				challenge.setUserNo(rset.getInt("USER_NO"));
				challenge.setChallName(rset.getString("CHALL_NAME"));
				challenge.setChallCategory(rset.getString("CHALL_CATEGORY"));
				challenge.setChallPostDate(rset.getString("CHALL_POSTDATE"));
				challenge.setChallStart(rset.getString("CHALL_START"));	
				challenge.setChallEnd(rset.getString("CHALL_END"));
				challenge.setChallFrequency(rset.getInt("CHALL_FREQUENCY"));
				challenge.setChallParticipant(rset.getInt("CHALL_PARTICIPANT"));
				challenge.setChallParticipantNow(rset.getInt("CHALL_PARTICIPANT_NOW"));
				challenge.setChallHowto(rset.getString("CHALL_HOWTO"));
				challenge.setChallPhothExp(rset.getString("CHALL_PHOTO_EXP"));
				challenge.setChallIntroduction(rset.getString("CHALL_INTRODUCTION"));
				challenge.setChallThumbnail(rset.getString("CHALL_THUMBNAIL"));
				challenge.setChallPublic(rset.getString("CHALL_PUBLIC"));
				challenge.setStatus(rset.getString("STATUS"));
				challenge.setChallCount(rset.getInt("CHALL_COUNT"));
				challenge.setNickName(rset.getString("NICKNAME"));
				challList.add(challenge);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return challList;
	}
	
	
	public ArrayList<CrowdChallenge> selectCrowd(Connection conn){
		
		ArrayList<CrowdChallenge> crowdList = new ArrayList<CrowdChallenge>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectCrowd");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				CrowdChallenge crowd = new CrowdChallenge();
				
				crowd.setCrowdNo(rset.getInt("CROWD_NO"));
				crowd.setUserNo(rset.getInt("USER_NO"));
				crowd.setCrowdName(rset.getString("CROWD_NAME"));
				crowd.setCrowdCategory(rset.getString("CROWD_CATEGORY"));
				crowd.setCrowdPostDate(rset.getString("CROWD_POSTDATE"));
				crowd.setCrowdExp(rset.getString("CROWD_EXP"));
				crowd.setCrowdThumbnail(rset.getString("CROWD_THUMBNAIL"));
				crowd.setCrowdMakeIt(rset.getInt("CROWD_MAKEIT"));

				
				crowdList.add(crowd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return crowdList;
	}	
	
/*	
	public Challenge selectChallengeAdmin(Connection conn) {
		
		Challenge challenge = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectChallengeAdmin");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				
				challenge.setChallNo(rset.getInt("CHALL_NO"));
				challenge.setUserNo(rset.getInt("USER_NO"));
				challenge.setChallName(rset.getString("CHALL_NAME"));
				challenge.setChallCategory(rset.getString("CHALL_CATEGORY"));
				challenge.setChallPostDate(rset.getString("CHALL_POSTDATE"));
				challenge.setChallStart(rset.getString("CHALL_START"));	
				challenge.setChallEnd(rset.getString("CHALL_END"));
				challenge.setChallFrequency(rset.getInt("CHALL_FREQUENCY"));
				challenge.setChallParticipant(rset.getInt("CHALL_PARTICIPANT"));
				challenge.setChallParticipantNow(rset.getInt("CHALL_PARTICIPANT_NOW"));
				challenge.setChallHowto(rset.getString("CHALL_HOWTO"));
				challenge.setChallPhothExp(rset.getString("CHALL_PHOTO_EXP"));
				challenge.setChallIntroduction(rset.getString("CHALL_INTRODUCTION"));
				challenge.setChallThumbnail(rset.getString("CHALL_THUMBNAIL"));
				challenge.setChallPublic(rset.getString("CHALL_PUBLIC"));
				challenge.setStatus(rset.getString("STATUS"));
				challenge.setChallCount(rset.getInt("CHALL_COUNT"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return challenge;
	}
*/	
	public ArrayList<Contact> selectContact(Connection conn) {
		
		ArrayList<Contact> conList = new ArrayList<Contact>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectContact");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Contact contact = new Contact();
				
				contact.setContactNo(rset.getInt("CONTACT_NO"));
				contact.setQuestionTitle(rset.getString("Q_TITLE"));
				contact.setQuestionContent(rset.getString("Q_CONTENT"));
				contact.setAnswerYN(rset.getString("ANSWER_YN"));
				contact.setAnswerContent(rset.getString("A_CONTENT"));
				contact.setUserNo(rset.getInt("USER_NO"));
				contact.setStatus(rset.getString("STATUS"));
				contact.setUserName(rset.getString("USER_NAME"));
				contact.setNickName(rset.getString("NICKNAME"));
				
				conList.add(contact);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return conList;			
	}
	
	
	public ArrayList<Faq> selectFaq(Connection conn) {
		
		ArrayList<Faq> faqList = new ArrayList<Faq>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;	
		
		String sql = prop.getProperty("selectFaq");
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Faq faq = new Faq();
				
				faq.setFaqNo(Integer.toString(rset.getInt("FAQ_NO")));
				faq.setFaqTitle(rset.getString("FAQ_TITLE"));
				faq.setFaqContent(rset.getString("FAQ_CONTENT"));
				faq.setStatus(rset.getString("STATUS"));
				faq.setEnrollDate(rset.getDate("ENROLLDATE"));
				
				faqList.add(faq);				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return faqList;
	}
	
	
	public ArrayList<Notice> selectNotice(Connection conn){

		ArrayList<Notice> noticeList = new ArrayList<Notice>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Notice n= new Notice();
				n.setNo(rset.getInt("NO"));
				n.setKind(rset.getString("KIND"));
				n.setTitle(rset.getString("TITLE"));
				n.setContent(rset.getString("CONTENT"));
				n.setEnrollDate(rset.getDate("ENROLLDATE"));
				n.setUserNo(rset.getInt("USER_NO"));
				n.setStatus(rset.getString("STATUS"));
				noticeList.add(n);	
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return noticeList;
	}
	

	public ArrayList<Member> selectLevel(Connection conn) {
		
		ArrayList<Member> levelList = new ArrayList<Member>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectLevel");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Member m = new Member(
						rset.getInt("USER_NO"),
						rset.getString("USER_ID"),
						rset.getString("USER_PWD"),
						rset.getString("USER_NAME"),
						rset.getString("NICKNAME"),
						rset.getString("EMAIL"),
						rset.getString("BIRTHDATE"),
						rset.getString("GENDER"),
						rset.getString("POST"),
						rset.getString("ADDRESS"),
						rset.getString("ADDRESS_DETAIL"),
						rset.getString("PHONE"),
						rset.getString("USER_TYPE"),
						rset.getInt("USER_LEVEL"),
						rset.getDate("ENROLL_DATE"),
						rset.getDate("MODIFY_DATE"),
						rset.getString("PROFILE"),
						rset.getString("STATUS"));
						
						levelList.add(m);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return levelList;
	}
	

	
}
