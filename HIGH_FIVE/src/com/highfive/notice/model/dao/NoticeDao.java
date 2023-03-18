package com.highfive.notice.model.dao;

import static com.highfive.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.highfive.common.model.vo.PageInfo;
import com.highfive.notice.model.vo.Notice;


public class NoticeDao {
	
	private Properties prop= new Properties();
	
	public NoticeDao() {
		
		String fileName= NoticeDao.class.getResource("/sql/notice/notice-mapper.xml").getPath();
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
	
	public ArrayList<Notice> selectNoticeList(Connection conn) {
		
		ArrayList<Notice> list= new ArrayList();
		PreparedStatement pstmt= null;
		ResultSet rset=null;
		
		String sql=prop.getProperty("selectNoticeList");
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			rset=pstmt.executeQuery();
			
			while(rset.next()) {
				Notice n= new Notice();
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
	
	public Notice selectNotice(Connection conn, int noticeNo) {
		Notice n=null;
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		
		String sql=prop.getProperty("selectNotice");
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, noticeNo);
			
			rset= pstmt.executeQuery();
			
			if(rset.next()) {
				
				n=new Notice();
				
				n.setNo(rset.getInt("NO"));
				n.setKind(rset.getString("KIND"));
				n.setTitle(rset.getString("TITLE"));
				n.setContent(rset.getString("CONTENT"));
				n.setEnrollDate(rset.getDate("ENROllDATE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return n;
	}
	
	
	public ArrayList<Notice> selectList(Connection conn, PageInfo pi) {
		
		//SELECT문=> RESULTSET=> 여러행이므로 aRRAYlIST<bOARD>
		
		ArrayList<Notice> list= new ArrayList();
		
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

				
				Notice n= new Notice();
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
	
	public int insertNotice(Connection conn, Notice n) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("insertNotice");
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,n.getKind());
			pstmt.setString(2,n.getTitle());
			pstmt.setString(3,n.getContent());
			pstmt.setInt(4, n.getUserNo());

			result = pstmt.executeUpdate();
			System.out.println(result);
			System.out.println(sql);
			System.out.println(pstmt);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}	
		return result;
		
		
	}
	

}
