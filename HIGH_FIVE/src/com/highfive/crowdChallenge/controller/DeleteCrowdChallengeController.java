package com.highfive.crowdChallenge.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.highfive.crowdChallenge.model.service.CrowdChallengeService;

/**
 * Servlet implementation class DeleteCrowdChallengeController
 */
@WebServlet("/delete.cc")
public class DeleteCrowdChallengeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCrowdChallengeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int crowdNo = Integer.parseInt(request.getParameter("cno"));
		
		int result = new CrowdChallengeService().deleteCrowdChallenge(crowdNo);
		
		if(result > 0) {
			request.getSession().setAttribute("alertMsg", "삭제 완료");
			response.sendRedirect(request.getContextPath() + "/list.cc");
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