package com.highfive.notice.model.service;

import static com.highfive.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.highfive.notice.model.dao.NoticeDao;
import com.highfive.notice.model.vo.Notice;
import com.highfive.common.model.vo.PageInfo;
import com.highfive.member.model.dao.MemberDao;

public class NoticeService {
	
	
	//notice 게시글 하나 조회
	public Notice selectNotice(int noticeNo) {
		Connection conn=getConnection();
		
		Notice n=new NoticeDao().selectNotice(conn, noticeNo);
	
		close(conn);
		
		return n;
	}
	
	//게시글 개수 세기
	public int selectListCount() {
		
		Connection conn=getConnection();
		
		int listCount = new NoticeDao().selectListCount(conn);
		//SELECT문의 결과는 ResultSet
		//게시글의 총 개수는 정수형
		close(conn);
		
		return listCount;
	}
	
	//notice 게시글 page 조회
	public ArrayList<Notice> selectList(PageInfo pi) {
		Connection conn=getConnection();
		
		ArrayList<Notice> list=new NoticeDao().selectList(conn,pi);
		
		close(conn);
		
		return list;
	}
	
	public int insertNotice(Notice n) {
		
		Connection conn = getConnection();
		
		int result = new NoticeDao().insertNotice(conn, n);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

}
