package com.highfive.contact.model.dao;

import static com.highfive.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.highfive.certBoard.model.vo.Attachment;
import com.highfive.common.model.vo.PageInfo;
import com.highfive.contact.model.vo.Contact;


public class ContactDao {
	
	private Properties prop= new Properties();
	
	public ContactDao() {
		
		String fileName= ContactDao.class.getResource("/sql/contact/contact-mapper.xml").getPath();
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//한페이지에 나오는 게시판 개수만큼 조회
	public int selectListCount(Connection conn) {
		
		//SELECT=> ResultSet 근데 반환형은 int??
		int listCount=0;
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		
		String sql=prop.getProperty("selectListCount");
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				listCount=rset.getInt("COUNT(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
	}
	
	/*
	
	public ArrayList<Contact> selectContactList(Connection conn) {
		
		ArrayList<Contact> list= new ArrayList();
		PreparedStatement pstmt= null;
		ResultSet rset=null;
		
		String sql=prop.getProperty("selectContactList");
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			rset=pstmt.executeQuery();
			
			while(rset.next()) {
				Contact n= new Contact();
				n.setNo(rset.getInt("NO"));
				n.setKind(rset.getString("KIND"));
				n.setTitle(rset.getString("TITLE"));
				n.setContent(rset.getString("CONTENT"));
				n.setEnrollDate(rset.getDate("ENROLLDATE"));
				n.setUserNo(rset.getInt("USER_NO"));
				n.setStatus(rset.getString("STATUS"));

				list.add(n);					
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	*/
	
	public Contact selectContact(Connection conn, int contactNo) {
		Contact c=null;
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		
		String sql=prop.getProperty("selectContact");
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, contactNo);
			
			rset= pstmt.executeQuery();
			
			if(rset.next()) {
				
				c=new Contact(
						rset.getInt("CONTACT_NO")
						,rset.getString("Q_TITLE")
						,rset.getString("Q_CONTENT")
						,rset.getString("ANSWER_YN")
						,rset.getString("A_CONTENT")
						,rset.getInt("USER_NO")
						,rset.getString("STATUS")
						,rset.getDate("CONTACTDATE")
						,rset.getString("NICKNAME")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return c;
	}
	
	
	public ArrayList<Contact> selectList(Connection conn, PageInfo pi) {
		
		//SELECT문=> RESULTSET=> 여러행이므로 aRRAYlIST<bOARD>
		
		ArrayList<Contact> list= new ArrayList();
		
		PreparedStatement pstmt=null;
		
		ResultSet rset=null;
		String sql=prop.getProperty("selectList");
		
		try {
			pstmt=conn.prepareStatement(sql);

			
			int startRow=(pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
			int endRow=startRow+pi.getBoardLimit()-1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset=pstmt.executeQuery();
			
			while(rset.next()) {

				
				Contact c = new Contact();
				
				c.setContactNo(rset.getInt("CONTACT_NO"));
				c.setQuestionTitle(rset.getString("Q_TITLE"));
				c.setNickName(rset.getString("NICKNAME"));
				c.setContactDate(rset.getDate("CONTACTDATE"));
				c.setAnswerYN(rset.getString("ANSWER_YN"));

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
	
	public int insertContact(Connection conn, Contact c) {
		
		int result=0;
		PreparedStatement pstmt=null;
		String sql=prop.getProperty("insertContact");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, c.getQuestionTitle());
			pstmt.setString(2, c.getQuestionContent());
			pstmt.setInt(3, c.getUserNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
		
	}
	
	public int insertAttachment(Connection conn, Attachment at) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, at.getFilePath());
			pstmt.setString(2, at.getOriginName());
			pstmt.setString(3, at.getChangeName());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public Attachment selectAttachment(Connection conn, int contactNo) {
		
		Attachment at = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, contactNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				at = new Attachment();

				at.setFilePath(rset.getString("FILE_PATH"));
				at.setCrowdNo(rset.getInt("CROWD_NO"));
				at.setContactNo(rset.getInt("CONTACT_NO"));
				at.setReviewNo(rset.getInt("REVIEW_NO"));
				at.setChallNo(rset.getInt("CHALL_NO"));
				at.setStatus(rset.getString("STATUS"));
				at.setCertNo(rset.getInt("CERT_NO"));
				at.setOriginName(rset.getString("ORIGIN_NAME"));
				at.setChangeName(rset.getString("CHANGE_NAME"));
				at.setUpload(rset.getString("UPLOAD"));
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return at;
	}
	
	
	public ArrayList<Contact> selectContactListNoPaging(Connection conn, int contactNo) {
		
		//SELECT문=> RESULTSET=> 여러행이므로 aRRAYlIST<bOARD>
		
		ArrayList<Contact> list= new ArrayList();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset=null;
		String sql = prop.getProperty("selectContactListNoPaging");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, contactNo);
			
			rset=pstmt.executeQuery();
			
			while(rset.next()) {
				Contact c = new Contact();
				
				c.setContactNo(rset.getInt("CONTACT_NO"));
				c.setQuestionTitle(rset.getString("Q_TITLE"));
				c.setNickName(rset.getString("NICKNAME"));
				c.setContactDate(rset.getDate("CONTACTDATE"));
				c.setAnswerYN(rset.getString("ANSWER_YN"));
				c.setUserName(rset.getString("USER_NAME"));
				c.setUserNo(rset.getInt("USER_NO"));
				c.setStatus(rset.getString("STATUS"));

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
