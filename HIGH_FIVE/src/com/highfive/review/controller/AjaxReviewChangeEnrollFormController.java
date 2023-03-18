package com.highfive.review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.highfive.challenge.model.vo.Challenge;
import com.highfive.review.model.service.ReviewService;

/**
 * Servlet implementation class AjaxChangeEnrollFormController
 */
@WebServlet("/changeEnrollForm.re")
public class AjaxReviewChangeEnrollFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxReviewChangeEnrollFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int challNo= Integer.parseInt(request.getParameter("challNo"));
		Challenge c = new ReviewService().selectChall(challNo);
		
		response.setContentType("application/json; charset=UTF-8");
		new Gson().toJson(c, response.getWriter());
		


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
