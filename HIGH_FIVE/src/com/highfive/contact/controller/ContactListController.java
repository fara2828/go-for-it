package com.highfive.contact.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.highfive.common.model.vo.PageInfo;
import com.highfive.contact.model.service.ContactService;
import com.highfive.contact.model.vo.Contact;

/**
 * Servlet implementation class ContactListController
 */
@WebServlet("/list.co")
public class ContactListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		int listCount; //현재 일반 게시판의 게시글 중 개수=> BOARD로부터 조회 COUNT(*)활용(STATUS='Y')
		int currentPage;// 현재 페이지(즉, 사용자가 요청한 페이지)=> request.getParameter("cpage")
		int pageLimit; //페이지하단에 보여질 페이지바의 최대 개수=> 10개
		int boardLimit; //한 페이지에 보여질 게시글 최대 개수=>10개
		
		int maxPage; //가장 마지막 페이지가 몇번 페이지인지(총 페이지의 개수)
		int startPage; //페이지 하단에 보여질 페이지바의 시작수
		int endPage; //페이지 하단에 보여질 페이지바의 끝수
		
		listCount=new ContactService().selectListCount();
		
		currentPage= Integer.parseInt(request.getParameter("cpage")); //1
		
		pageLimit=10;
		
		boardLimit=10;
		
		maxPage=(int)Math.ceil((double)listCount/boardLimit);
		
		startPage=(currentPage-1)/pageLimit*pageLimit+1;
		
		endPage=startPage+pageLimit-1;
		
		if(maxPage<endPage) endPage=maxPage;

		PageInfo pi=new PageInfo(listCount,currentPage, pageLimit,boardLimit, maxPage,startPage,endPage);
		
		ArrayList<Contact> list= new ContactService().selectList(pi);
		
		request.setAttribute("list", list);
		request.setAttribute("pi", pi);

		request.getRequestDispatcher("views/contact/contactListView.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
