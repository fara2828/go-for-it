package com.highfive.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.highfive.member.model.service.MemberService;
import com.highfive.member.model.vo.Member;

/**
 * Servlet implementation class ForgetIdController2
 */
@WebServlet("/searchId")
public class SearchIdController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchIdController2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		
		Member searchId = new MemberService().searchId(userName, email);
		
		HttpSession session = request.getSession();
		
		if(searchId == null) {
			
			session.setAttribute("alertMsg", "아이디가 존재하지 않습니다.");	
			response.sendRedirect(request.getContextPath() + "/searchIdForm");
		
		} else {
			
			session.setAttribute("searchId", searchId);
			session.setAttribute("alertMsg", "회원님의 아이디를 이메일로 전송했습니다.");
			request.getRequestDispatcher("views/member/searchIdForm2.jsp").forward(request, response);
			//response.sendRedirect(request.getContextPath() + "/loginForm");
			
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
