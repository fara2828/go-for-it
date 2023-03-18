package com.highfive.member.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import static com.highfive.common.JDBCTemplate.*;
import com.highfive.member.model.vo.Member;

public class MemberDao {
	
	private Properties prop=new Properties();
	
	public MemberDao() {
		String file= MemberDao.class.getResource("/sql/member/member-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Member loginMember(Connection conn, String userId, String userPwd) {

		Member m=null;
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		
		String sql=prop.getProperty("loginMember");
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1,userId);
			pstmt.setString(2,userPwd);
			
			rset = pstmt.executeQuery();

			if(rset.next()) {
				
				m= new Member(
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
						rset.getString("STATUS")
						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return m;
		
	}
	
	public int insertMember(Connection conn, Member member) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("insertMember");
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getUserPwd());
			pstmt.setString(3, member.getUserName());
			pstmt.setString(4, member.getNickName());
			pstmt.setString(5, member.getEmail());
			pstmt.setString(6, member.getBirthDate());
			pstmt.setString(7, member.getGender());
			pstmt.setString(8, member.getPost());
			pstmt.setString(9, member.getAddress());
			pstmt.setString(10, member.getAddressDetail());
			pstmt.setString(11, member.getPhone());
			pstmt.setString(12, member.getProfile());

			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}	
		return result;
	}



	
	public Member selectMember(Connection conn,String userId) {		
		
		Member m=null;
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		
		String sql=prop.getProperty("selectMember");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rset= pstmt.executeQuery();
			
			if(rset.next()) {
				m=new Member(
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
						rset.getString("STATUS")
						
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return m;
	}
	
	public int updateMember(Connection conn, Member m) {
		
		int result=0;
		PreparedStatement pstmt=null;
		String sql=prop.getProperty("updateMember");
		
		try {
			pstmt= conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getUserPwd());
			pstmt.setString(2, m.getNickName());
			pstmt.setString(3, m.getEmail());
			pstmt.setString(4, m.getBirthDate());
			pstmt.setString(5, m.getGender());
			pstmt.setString(6, m.getPost());
			pstmt.setString(7, m.getAddress());
			pstmt.setString(8, m.getAddressDetail());
			pstmt.setString(9, m.getPhone());
			pstmt.setString(10, m.getUserId());

			
			result=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int deleteMember(Connection conn, String userId, String userPwd) {
		
		int result=0;
		PreparedStatement pstmt=null;
		String sql=prop.getProperty("deleteMember");
		
		try {
			pstmt= conn.prepareStatement(sql);
			
			
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			
		}
		
		return result;
	}
	
	
	public Member searchId(Connection conn, String userName, String email) {
		
		Member searchId = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("searchId");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userName);
			pstmt.setString(2,  email);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				//searchId.setUserId(rset.getString("USER_ID"));
				searchId = new Member(rset.getString("USER_ID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return searchId;
	}
	
	public Member searchPwd(Connection conn, String userId, String email) {
		
		Member searchPwd = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("searchPwd");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			pstmt.setString(2, email);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				searchPwd = new Member(
						rset.getString("USER_ID"),
						rset.getString("USER_PWD")
						);
				//searchPwd.setUserPwd(rset.getString("USER_PWD"));
			}
			System.out.println(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return searchPwd;
	}
	
	public int idCheck(Connection conn, String checkId) {
		
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("idCheck");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, checkId);
			
			rset = pstmt.executeQuery();

			if(rset.next()) {
				count = rset.getInt("COUNT(*)");

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return count;
	}
	
	
	public int nickNameCheck(Connection conn, String checkNickName) {
		
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("nickNameCheck");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, checkNickName);
			
			rset = pstmt.executeQuery();

			if(rset.next()) {
				count = rset.getInt("COUNT(*)");
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return count;
	}
	
	public int insertProfile(Connection conn, String profile, String userId) {
		
		int result=0;
		PreparedStatement pstmt=null;
		String sql=prop.getProperty("insertProfile");

		try {
			pstmt= conn.prepareStatement(sql);
			
			pstmt.setString(1, profile);
			pstmt.setString(2, userId);
			
			result=pstmt.executeUpdate();
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	
	

}
