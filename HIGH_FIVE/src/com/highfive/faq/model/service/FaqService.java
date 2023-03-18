package com.highfive.faq.model.service;

import static com.highfive.common.JDBCTemplate.*;
import static com.highfive.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.highfive.faq.model.dao.FaqDao;
import com.highfive.faq.model.vo.Faq;

public class FaqService {
		
	public ArrayList<Faq> selectFaqList(){ 
			
		Connection conn = getConnection();
			
		ArrayList<Faq> fList = new FaqDao().selectFaqList(conn);
			
		close(conn);
			
		return fList;
		
	}
	
	
	public int insertFaq(Faq faq) {
		
		Connection conn = getConnection();		
		
		int result = new FaqDao().insertFaq(conn, faq);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	
	
	public int deleteFaq(int faqNo) {
		
		Connection conn = getConnection();		
		
		int result = new FaqDao().deleteFaq(conn, faqNo);	
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	
		
		
		
	
}
