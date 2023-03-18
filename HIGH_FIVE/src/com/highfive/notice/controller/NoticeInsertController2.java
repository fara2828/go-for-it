package com.highfive.notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.highfive.notice.model.service.NoticeService;
import com.highfive.notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeInsertController2
 */
@WebServlet("/insert2.no")
public class NoticeInsertController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeInsertController2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String kind=request.getParameter("kind");
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		int userNo=Integer.parseInt(request.getParameter("userNo"));
		
		System.out.println(kind);
		System.out.println(title);
		System.out.println(content);
		System.out.println(userNo);
		
		Notice n= new Notice();
		
		n.setKind(kind);
		n.setTitle(title);
		n.setContent(content);
		n.setUserNo(userNo);
		
		int result= new NoticeService().insertNotice(n);
		
		System.out.println(request.getContextPath());
		
		if(result > 0) {
			request.getSession().setAttribute("alertMsg", "작성 완료했습니다.");
			response.sendRedirect(request.getContextPath()+"/list.no?cpage=1");
		} else {
			request.setAttribute("errorMsg", "작성 실패했습니다.");
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorpage.jsp");
			view.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
