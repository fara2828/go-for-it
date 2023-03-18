package com.highfive.search.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.highfive.challenge.model.vo.Challenge;
import com.highfive.crowdChallenge.model.vo.CrowdChallenge;
import com.highfive.review.model.vo.Review;
import com.highfive.search.model.service.SearchService;

/**
 * Servlet implementation class SearchController
 */
@WebServlet("/search.do")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String keyword = request.getParameter("query");
		
		ArrayList<Challenge> cList = new SearchService().searchChallengeList(keyword);
		
		ArrayList<CrowdChallenge> ccList = new SearchService().searchCrowdChallengeList(keyword);
		
		ArrayList<Review> rList = new SearchService().searchReviewList(keyword);
		
		int challCount = new SearchService().searchChallengeCount(keyword);
		
		int crowdCount = new SearchService().searchCrowdCount(keyword);
		
		int reviewCount = new SearchService().searchReviewCount(keyword);
		
		int count = challCount + crowdCount + reviewCount;
		
		request.setAttribute("cList", cList);
		
		request.setAttribute("ccList", ccList);
		
		request.setAttribute("rList", rList);
		
		request.setAttribute("keyword", keyword);
		
		request.setAttribute("challCount", challCount);

		request.setAttribute("crowdCount", crowdCount);
		
		request.setAttribute("reviewCount", reviewCount);
		
		request.setAttribute("count", count);
		
		request.setAttribute("keyword", keyword);
		
		request.getRequestDispatcher("/views/search/searchView.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
