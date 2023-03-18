package com.highfive.admin.controller.detail.crowdChallenge;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.highfive.admin.service.AdminDetailService;

/**
 * Servlet implementation class FirmUpDeleteCrowdChallenge
 */
@WebServlet("/deleteCrowdChallenge")
public class DeleteCrowdChallenge extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCrowdChallenge() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		
		String[] deleteCrowdChallenge = request.getParameterValues("dropCrowdChallenges");
		
		int result = 0;
		for(int i = 0; i < deleteCrowdChallenge.length; i++) {
			
			String deleteCrowd = deleteCrowdChallenge[i];
			result += new AdminDetailService().deleteCrowdChallenges(deleteCrowd);
		
		}
		
		if(result == deleteCrowdChallenge.length) {
			
			request.getSession().setAttribute("alertMsg", "크라우드챌린지 삭제 완료되었습니다.");
			response.sendRedirect(request.getContextPath() + "/adminPage");
		
		} else {
			
			request.getSession().setAttribute("alertMsg", "크라우드챌린지 삭제 실패.");
			request.getRequestDispatcher("views/admin/adminListView.jsp");
			
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
