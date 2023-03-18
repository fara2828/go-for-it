package com.highfive.contact.model.service;

import static com.highfive.common.JDBCTemplate.close;
import static com.highfive.common.JDBCTemplate.commit;
import static com.highfive.common.JDBCTemplate.getConnection;
import static com.highfive.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.highfive.certBoard.model.vo.Attachment;
import com.highfive.common.model.vo.PageInfo;
import com.highfive.contact.model.dao.ContactDao;
import com.highfive.contact.model.vo.Contact;

public class ContactService {
	
	//contact 게시글 하나 조회
	public Contact selectContact(int contactNo) {
		Connection conn=getConnection();
		
		Contact c = new ContactDao().selectContact(conn, contactNo);
	
		close(conn);
		
		return c;
	}
	
	//게시글 참고자료 조회
	public Attachment selectAttachment(int contactNo) {
		
		Connection conn = getConnection();
		
		Attachment at = new ContactDao().selectAttachment(conn, contactNo);
		
		close(conn);
		
		return at;
		
	}
	
	//게시글 개수 세기
	public int selectListCount() {
		
		Connection conn=getConnection();
		
		int listCount = new ContactDao().selectListCount(conn);
		//SELECT문의 결과는 ResultSet
		//게시글의 총 개수는 정수형
		close(conn);
		
		return listCount;
	}
	
	//contact 게시글 page 조회
	public ArrayList<Contact> selectList(PageInfo pi) {
		Connection conn=getConnection();
		
		ArrayList<Contact> list=new ContactDao().selectList(conn,pi);
		
		close(conn);
		
		return list;
	}
	
	public int insertContact(Contact c, Attachment at) {
		Connection conn= getConnection();
		
		int result1=new ContactDao().insertContact(conn, c);
		
		int result2=1;
		if(at!=null) {
			
			result2= new ContactDao().insertAttachment(conn, at);
		}
		
		if((result1*result2)>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return(result1*result2);
		
	}
	
	
	public ArrayList<Contact> selectContactListNoPaging(int contactNo) {
		
		Connection conn = getConnection();
		
		ArrayList<Contact> list = new ContactDao().selectContactListNoPaging(conn, contactNo);
		
		close(conn);
		
		return list;
	}


}
