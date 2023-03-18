package com.highfive.review.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.highfive.challenge.model.vo.Challenge;
import com.highfive.member.model.vo.Member;
import com.highfive.review.model.service.ReviewService;

/**
 * Servlet implementation class ReviewEnrollFormController
 */
@WebServlet("/enrollForm.re")
public class AjaxReviewEnrollFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxReviewEnrollFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userNo =((Member)(request.getSession().getAttribute("loginUser"))).getUserNo();
		
		//int userNo= Integer.parseInt(request.getParameter("userNo"));
		ArrayList<Challenge> cList = new ReviewService().seletChallWithoutReview(userNo);
		
			response.setContentType("application/json; charset=UTF-8");
		new Gson().toJson(cList, response.getWriter());
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
