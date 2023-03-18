package com.highfive.review.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.highfive.certBoard.model.service.CertService;
import com.highfive.certBoard.model.vo.Attachment;
import com.highfive.challenge.model.vo.Challenge;
import com.highfive.review.model.service.ReviewService;
import com.highfive.review.model.vo.Review;

/**
 * Servlet implementation class ReviewDetailViewController
 */
@WebServlet("/detail.re")
public class ReviewDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int reviewNo = Integer.parseInt(request.getParameter("rno"));
		int challNo = Integer.parseInt(request.getParameter("cno"));
	
		
		
		
		int result = new ReviewService().increaseReviewCount(reviewNo);
		if (result>0) {
			Challenge c = new ReviewService().selectChall(challNo);			
			Review r = new ReviewService().selectReview(reviewNo); 
			ArrayList<Attachment> rAtList = new ReviewService().selectReviewAttachmentList(reviewNo);
			
			
			request.setAttribute("c",c);
			request.setAttribute("r", r);
			request.setAttribute("rAtList", rAtList);
			 

			
            request.getRequestDispatcher("views/review/reviewDetailView.jsp").forward(request, response);
				

		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
