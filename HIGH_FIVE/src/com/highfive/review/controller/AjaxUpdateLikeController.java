package com.highfive.review.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.highfive.review.model.service.ReviewService;

/**
 * Servlet implementation class AjaxUpdateLikeController
 */
@WebServlet("/updateLike.re")
public class AjaxUpdateLikeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxUpdateLikeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int reviewNo= Integer.parseInt(request.getParameter("rno"));
		int userNo= Integer.parseInt(request.getParameter("userNo"));
		
		int likeYN = new ReviewService().selectLike(reviewNo, userNo);
		// 
		if(likeYN<0) {
			
			 int insertLike = new ReviewService().insertLike(reviewNo, userNo);
			
		} else if(likeYN==0){
			
			 new ReviewService().updateLikeY(reviewNo, userNo);
		} else if(likeYN==1) {
			 new ReviewService().updateLikeN(reviewNo, userNo);
			
		}
		
		int countReviewLike = new ReviewService().countReviewLike(reviewNo);
		int myLikeYN = new ReviewService().myLikeYN(reviewNo, userNo);
		
		
		int[] countLikeAndMyLike = {countReviewLike, myLikeYN};
		
		
		
		response.setContentType("application/json; charset=UTF-8");
		new Gson().toJson(countLikeAndMyLike, response.getWriter());

		
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
