package com.highfive.admin.service;

import static com.highfive.common.JDBCTemplate.close;
import static com.highfive.common.JDBCTemplate.commit;
import static com.highfive.common.JDBCTemplate.getConnection;
import static com.highfive.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.highfive.admin.dao.AdminDetailDao;
import com.highfive.contact.model.vo.Contact;
import com.highfive.member.model.vo.Member;

public class AdminDetailService {

	public int firmUpDeleteMember(String delMember) {
		
		Connection conn = getConnection();
		
		int result = new AdminDetailDao().firmUpDeleteMember(conn, delMember);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	
	
	public int restoreChallenges(String restoreChall) {
		
		Connection conn = getConnection();
		
		int result = new AdminDetailDao().restoreChallenges(conn, restoreChall);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	
	
	public int deleteCrowdChallenges(String deleteCrowd) {
		
		Connection conn = getConnection();
		
		int result = new AdminDetailDao().deleteCrowdChallenges(conn, deleteCrowd);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	
	
	public int answerContact(Contact contact) {
		
		Connection conn = getConnection();
		
		int result = new AdminDetailDao().answerContact(conn, contact);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;			
	}
	
	
	public int answerUpdateContact(Contact contact) {
		
		Connection conn = getConnection();
		
		int result = new AdminDetailDao().answerUpdateContact(conn, contact);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	
	
	public int firmUpDeleteNotice(String delNotice) {
		
		Connection conn = getConnection();
		
		int result = new AdminDetailDao().firmUpDeleteNotice(conn, delNotice);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	
	
	public ArrayList<Member> selectLevel(int level) {
		
		Connection conn = getConnection();
		
		ArrayList<Member> levelList = new AdminDetailDao().selectLevel(conn, level);
		
		close(conn);
		
		return levelList;
		
	}
	
	public int firmUpDeleteFaq(String delFaq) {
		
		Connection conn = getConnection();
		
		int result = new AdminDetailDao().firmUpDeleteFaq(conn, delFaq);

		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
		
	}
	
}
