package com.highfive.crowdChallenge.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.highfive.crowdChallenge.model.service.CrowdChallengeService;
import com.highfive.crowdChallenge.model.vo.CrowdChallenge;

/**
 * Servlet implementation class CrowdChallengeDetailViewController
 */
@WebServlet("/detail.cc")
public class CrowdChallengeDetailViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrowdChallengeDetailViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int crowdChallengeNo = Integer.parseInt(request.getParameter("cno")); 
		
		CrowdChallengeService ccService = new CrowdChallengeService();
		
		int result = ccService.increaseCrowdChallengeCount(crowdChallengeNo);
		
		if(result > 0) {
		
			CrowdChallenge c = new CrowdChallenge();
			
			c = ccService.selectCrowdChallenge(crowdChallengeNo);
			
			System.out.println(c.getCrowdCount());
			
			request.setAttribute("c", c);
			
			request.getRequestDispatcher("/views/crowd/crowdChallengeDetailView.jsp").forward(request, response);
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
