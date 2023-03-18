package com.highfive.admin.controller.detail.challenge;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.highfive.admin.service.AdminDetailService;

/**
 * Servlet implementation class FirmUpDeleteChallenge
 */
@WebServlet("/firmUpDeleteChallenge")
public class FirmUpDeleteChallenge extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirmUpDeleteChallenge() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String[] restoreChallenges = request.getParameterValues("restoreChallenges");
		
		int result = 0;
		
		for(int i = 0; i < restoreChallenges.length; i++) {
			String restoreChall = restoreChallenges[i];
			result += new AdminDetailService().restoreChallenges(restoreChall);
		}
		
		System.out.println(result);
		
		if(result == restoreChallenges.length) {
			
			request.getSession().setAttribute("alertMsg", "챌린지 복구 완료.");
			response.sendRedirect(request.getContextPath() + "/adminPage");
			
		} else {
			
			request.getSession().setAttribute("alertMsg", "챌린지 복구에 실패했습니다.");
			request.getRequestDispatcher("views/common/errorPage.jsp");
			
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
