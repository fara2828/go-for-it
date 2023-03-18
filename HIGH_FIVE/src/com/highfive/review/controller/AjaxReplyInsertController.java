package com.highfive.review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.highfive.review.model.service.ReviewService;
import com.highfive.review.model.vo.ReviewReply;

/**
 * Servlet implementation class AjaxReviewInsertController
 */
@WebServlet("/rpinsert.re")
public class AjaxReplyInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxReplyInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		int reviewNo = Integer.parseInt(request.getParameter("rno"));
		String rCommentText = request.getParameter("rCommentText");
	    int userNo = Integer.parseInt(request.getParameter("userNo"));

		ReviewReply rr = new ReviewReply();
		rr.setReviewNo(reviewNo);		
		rr.setrCommentText(rCommentText);
		rr.setUserNo(userNo);
			
		
		int result = new ReviewService().insertReply(rr);

	
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().print(result);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
