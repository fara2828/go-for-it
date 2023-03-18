package com.highfive.search.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.highfive.crowdChallenge.model.vo.CrowdChallenge;
import com.highfive.search.model.service.SearchService;

/**
 * Servlet implementation class SearchCrowdChallengeController
 */
@WebServlet("/search.cc")
public class SearchCrowdChallengeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchCrowdChallengeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String keyword = request.getParameter("keyword");
		
		ArrayList<CrowdChallenge> ccList = new SearchService().searchCrowdChallenge(keyword);
		
		int ccCount = new SearchService().searchCrowdCount(keyword);
		
		request.setAttribute("ccList", ccList);
		
		request.setAttribute("ccCount", ccCount);
		
		request.setAttribute("keyword", keyword);
		
		request.getRequestDispatcher("/views/search/searchCrowdChallengeView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
