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
 * Servlet implementation class MemberDeleteController2
 */
@WebServlet("/delete2.me")
public class MemberDeleteController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDeleteController2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String userPwd = request.getParameter("userPwd");
		
		HttpSession session = request.getSession();
		String userId = ((Member)session.getAttribute("loginUser")).getUserId();
	
		int result = new MemberService().deleteMember(userId, userPwd);
		
		if(result > 0) {
			request.getSession().setAttribute("alertMsg", "회원탈퇴에 성공했습니다. 그동안 이용해주셔서 감사합니다.");
			session.removeAttribute("loginUser");
			response.sendRedirect(request.getContextPath());
		} else {
			request.getSession().setAttribute("alertMsg", "회원탈퇴에 실패했습니다.");
			request.getRequestDispatcher("views/member/memberDeleteForm.jsp").forward(request, response);
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
