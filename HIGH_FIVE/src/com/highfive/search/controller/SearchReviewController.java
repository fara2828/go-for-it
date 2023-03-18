package com.highfive.search.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.highfive.review.model.vo.Review;
import com.highfive.search.model.service.SearchService;

/**
 * Servlet implementation class SearchReviewController
 */
@WebServlet("/search.re")
public class SearchReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchReviewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String keyword = request.getParameter("keyword");
		
		ArrayList<Review> rList = new SearchService().searchReview(keyword);
		
		int rCount = new SearchService().searchReviewCount(keyword);
		
		request.setAttribute("keyword", keyword);
		
		request.setAttribute("rList", rList);
		
		request.setAttribute("rCount", rCount);
		
		request.getRequestDispatcher("/views/search/searchReviewView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
