package com.highfive.faq.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import static com.highfive.common.JDBCTemplate.*;
import com.highfive.faq.model.vo.Faq;
import com.highfive.member.model.dao.MemberDao;

public class FaqDao {
	
	private Properties prop = new Properties();
	
	public FaqDao() {
		
		String file = MemberDao.class.getResource("/sql/faq/faq-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(file));
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	
	public ArrayList<Faq> selectFaqList(Connection conn){

		ArrayList<Faq> fList = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectFaqList");
		
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
				
				fList.add(faq);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return fList;	
	}
	
	
	public int insertFaq(Connection conn, Faq faq) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertFaq");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, faq.getFaqTitle());
			pstmt.setString(2, faq.getFaqContent());
			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	
	public int deleteFaq(Connection conn, int faqNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteFaq");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, faqNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	
	
	
}
