package com.highfive.search.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.highfive.challenge.model.vo.Challenge;
import com.highfive.search.model.service.SearchService;

/**
 * Servlet implementation class SearchChallengeController
 */
@WebServlet("/search.cl")
public class SearchChallengeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchChallengeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String keyword = request.getParameter("keyword");
		System.out.println(keyword);
		
		ArrayList<Challenge> cList = new SearchService().searchChallenge(keyword);

		int cCount = new SearchService().searchChallengeCount(keyword);
		System.out.println(cList);
		System.out.println(cCount);
		
		request.setAttribute("keyword", keyword);
		
		request.setAttribute("cList", cList);
		
		request.setAttribute("cCount", cCount);
		
		request.getRequestDispatcher("/views/search/searchChallengeView.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
