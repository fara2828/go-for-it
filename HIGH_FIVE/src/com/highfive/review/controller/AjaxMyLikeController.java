package com.highfive.review.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.highfive.review.model.service.ReviewService;

/**
 * Servlet implementation class AjaxMyLikeController
 */
@WebServlet("/myLike.re")
public class AjaxMyLikeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxMyLikeController() {
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
		
		int myLikeYN = new ReviewService().myLikeYN(reviewNo, userNo);
		

		
		response.setContentType("application/json; charset=UTF-8");
		new Gson().toJson(myLikeYN, response.getWriter());

		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
