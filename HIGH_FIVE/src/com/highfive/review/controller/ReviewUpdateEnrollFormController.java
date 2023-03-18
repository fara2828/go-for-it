package com.highfive.review.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.highfive.certBoard.model.vo.Attachment;
import com.highfive.challenge.model.vo.Challenge;
import com.highfive.review.model.service.ReviewService;
import com.highfive.review.model.vo.Review;

/**
 * Servlet implementation class RevieEnrollFormController
 */
@WebServlet("/updateEnrollForm.re")
public class ReviewUpdateEnrollFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewUpdateEnrollFormController() {
    	super();
    	
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int reviewNo= Integer.parseInt(request.getParameter("rno"));
		int challNo= Integer.parseInt(request.getParameter("cno"));
		
		Review r = new ReviewService().selectReview(reviewNo);
		Challenge c = new ReviewService().selectChall(challNo);
		ArrayList<Attachment> rAtList = new ReviewService().selectReviewAttachmentList(reviewNo);
	
		
		request.setAttribute("r", r);
		request.setAttribute("c", c);
		request.setAttribute("rAtList", rAtList);
		
		request.getRequestDispatcher("views/review/reviewUpdateForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
