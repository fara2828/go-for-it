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

import com.highfive.common.JDBCTemplate;
import com.highfive.contact.model.vo.Contact;
import com.highfive.member.model.vo.Member;

public class AdminDetailDao {

	private Properties prop = new Properties();
	
	public AdminDetailDao() {
		
		String file= AdminDetailDao.class.getResource("/sql/admin/adminDetail-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	
	public int firmUpDeleteMember(Connection conn, String delMember) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("firmUpDeleteMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(delMember));
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	
	public int restoreChallenges(Connection conn, String restoreChall) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("restoreChallenges");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(restoreChall));
			result = pstmt.executeUpdate();
			//System.out.println(deleteChallenge);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	
	public int deleteCrowdChallenges(Connection conn, String deleteCrowd) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteCrowdChallenges");
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, Integer.parseInt(deleteCrowd));
			
			result = pstmt.executeUpdate();
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	
	public int firmUpDeleteNotice(Connection conn, String delNotice) {
		
		int result=0;
		PreparedStatement pstmt=null;
		String sql = prop.getProperty("firmUpDeleteNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(delNotice));
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	

	public int firmUpDeleteFaq(Connection conn, String delFaq) {
		int result=0;
		PreparedStatement pstmt=null;
		String sql = prop.getProperty("firmUpDeleteFaq");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(delFaq));
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
		
	}
	
	public ArrayList<Member> selectLevel(Connection conn, int level) {
		
		ArrayList<Member> levelList= new ArrayList();
		PreparedStatement pstmt=null;
		ResultSet rset= null;
		
		try {
		
			String sql= "SELECT" + 
						" USER_NO," + 
						" USER_ID," + 
						" USER_PWD," + 
						" USER_NAME," + 
						" NICKNAME," + 
						" EMAIL," + 
						" BIRTHDATE," + 
						" GENDER," + 
						" POST," + 
						" ADDRESS," + 
						" ADDRESS_DETAIL," + 
						" PHONE," + 
						" USER_TYPE," + 
						" USER_LEVEL," + 
						" ENROLL_DATE," + 
						" MODIFY_DATE," + 
						" PROFILE," + 
						" STATUS" + 
						" FROM" + 
						" MEMBER" + 
						" WHERE" + 
						" STATUS = 'Y'"+
						" AND "+
						" USER_LEVEL="+level+
						" ORDER BY"+
						" USER_NO ASC";
			
			pstmt=conn.prepareStatement(sql);
			
			rset=pstmt.executeQuery();
			
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
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return levelList;
	}
	
	
	public int answerContact(Connection conn, Contact contact) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("answerContact");
		
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, contact.getAnswerContent());
			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	
	public int answerUpdateContact(Connection conn, Contact contact) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("answerUpdateContact");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, contact.getAnswerContent());
			pstmt.setInt(2, contact.getContactNo());
			
			result = pstmt.executeUpdate();
			
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	

	
}
