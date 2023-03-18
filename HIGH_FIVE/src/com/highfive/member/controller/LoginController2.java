package com.highfive.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.highfive.challenge.model.service.ChallengeService;
import com.highfive.challenge.model.vo.Challenge;
import com.highfive.member.model.service.MemberService;
import com.highfive.member.model.vo.Member;

/**
 * Servlet implementation class LoginController2
 */
@WebServlet("/login.me")
public class LoginController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		Member loginUser = new MemberService().loginMember(userId, userPwd);
		
		HttpSession session = request.getSession();
		int certNotCount = 0;
		if(loginUser != null) {	
			
			
			// 주은 추가
			certNotCount = new ChallengeService().selectCountNotCert(loginUser.getUserNo());
			if(certNotCount > 0) {
				ArrayList<Challenge> certNotList = new ChallengeService().selectNotCertList(loginUser.getUserNo());
				
				String challName = "";
				
				for(int i=0; i<certNotList.size(); i++) { 
					if(i == certNotList.size() - 1) {
						challName += certNotList.get(i).getChallName();
					} else {
						challName += certNotList.get(i).getChallName() 
								  + ", ";
					}
					
				}
				session.setAttribute("challName", challName);
			
				String confirmMsg = "아직 한 번도 인증하지 않은 글이 " + certNotCount + "건 있어요."
								  + "[" + challName + "]"
								  + "참여중인 챌린지 목록으로 이동할까요?";
				session.setAttribute("confirmMsg", confirmMsg);
			}
			session.setAttribute("loginUser", loginUser);
			
			//response.sendRedirect(request.getHeader("referer"));
			response.sendRedirect("/HIGH_FIVE");
		} else {		
			session.setAttribute("alertMsg", "일치하는 회원정보가 없습니다.");		
			response.sendRedirect(request.getContextPath() + "/loginForm");
			//RequestDispatcher view = request.getRequestDispatcher("views/member/memberLoginForm2.jsp");
			//view.forward(request, response);
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
