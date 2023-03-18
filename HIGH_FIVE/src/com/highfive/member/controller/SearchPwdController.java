package com.highfive.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.highfive.member.model.service.MemberService;
import com.highfive.member.model.vo.Member;

/**
 * Servlet implementation class SearchPwdController
 */
@WebServlet("/searchPwd")
public class SearchPwdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchPwdController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		String email = request.getParameter("email");
		
		Member searchPwd = new MemberService().searchPwd(userId, email);
		
		HttpSession session = request.getSession();
		if(searchPwd == null) {
			
			session.setAttribute("alertMsg", "일치하는 회원정보가 없습니다.");	
			response.sendRedirect(request.getContextPath() + "/searchPwdForm");			
			
		} else {
			
			session.setAttribute("searchPwd", searchPwd);
			session.setAttribute("alertMsg", "회원님의 비밀번호를 이메일로 전송했습니다.");
			request.getRequestDispatcher("views/member/searchPwdForm2.jsp").forward(request, response);			
			
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
