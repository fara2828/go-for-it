package com.highfive.review.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.highfive.review.model.service.ReviewService;
import com.highfive.review.model.vo.Review;

/**
 * Servlet implementation class AjaxReviewListOrderController
 */
@WebServlet("/list.ore")
public class AjaxReviewListOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxReviewListOrderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String selectCategory = request.getParameter("selectCategory");
		String selectOrder = request.getParameter("selectOrder");
		ArrayList<Review> rList = new ReviewService().orderReviewList(selectCategory, selectOrder);
	    
		for(int i=0; i<rList.size() ; i++) {
			
			int reviewNo= rList.get(i).getReviewNo(); 
			rList.get(i).setCountLike(new ReviewService().countReviewLike(reviewNo));
			
		}
		response.setContentType("application/json; charset=UTF-8");
		new Gson().toJson(rList, response.getWriter());
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
