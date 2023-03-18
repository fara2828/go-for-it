package com.highfive.member.model.service;

import java.sql.Connection;

import static com.highfive.common.JDBCTemplate.*;
import com.highfive.member.model.dao.MemberDao;
import com.highfive.member.model.vo.Member;

public class MemberService {
	
	public Member loginUser(String userId, String userPwd) {
		
		Connection conn =getConnection();
		
		Member loginUser = new MemberDao().loginMember(conn, userId, userPwd);
		
		close(conn);
		
		return loginUser;
	}
	
	public int insertMember(Member member) {
		
		Connection conn = getConnection();
		
		int result = new MemberDao().insertMember(conn, member);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	

		
	public Member loginMember(String userId, String userPwd) {
			
		Connection conn=getConnection();
			
		Member m = new MemberDao().loginMember(conn, userId, userPwd);
			
		close(conn);
			
		return m;
	}
	
	public Member updateMember(Member m) {
		
		Connection conn= getConnection();
		
		int result= new MemberDao().updateMember(conn,m);
		
		Member updateMem=null;
		
		if(result>0) {
			commit(conn);
			updateMem= new MemberDao().selectMember(conn,m.getUserId());
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return updateMem;
	}
	
	public int deleteMember(String userId, String userPwd) {
		
		Connection conn =getConnection();
		
		int result = new MemberDao().deleteMember(conn, userId, userPwd);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	//아이디 찾기
	public Member searchId(String userName, String email) {
		
		Connection conn = getConnection();
		
		Member searchId = new MemberDao().searchId(conn, userName, email);
		
		close(conn);
		
		return searchId;
	}
	
	//비밀번호 찾기
	public Member searchPwd(String userId, String email) {
		
		Connection conn = getConnection();
		
		Member searchPwd = new MemberDao().searchPwd(conn, userId, email);
		
		close(conn);
		
		return searchPwd;
	}
	
	public int idCheck(String checkId) {
		
		Connection conn = getConnection();
		
		int count = new MemberDao().idCheck(conn, checkId);
		
		return count;
	}
	
	
	public int nickNameCheck(String checkNickName) {
		
		Connection conn = getConnection();
		
		int count = new MemberDao().nickNameCheck(conn, checkNickName);
		
		return count;
	}
	
	public Member insertProfile(String profile, String userId) {
		
		Connection conn=getConnection();
		
		int result= new MemberDao().insertProfile(conn,profile,userId);
		
		Member updateMem1=null;
		
		if(result>0) {
			commit(conn);
			updateMem1= new MemberDao().selectMember(conn,userId);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return updateMem1;
		
		
		
	}
	

	
	
	
	

}
