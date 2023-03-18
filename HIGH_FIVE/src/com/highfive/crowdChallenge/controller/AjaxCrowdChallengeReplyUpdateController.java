package com.highfive.crowdChallenge.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.highfive.crowdChallenge.model.service.CrowdChallengeService;

/**
 * Servlet implementation class AjaxCrowdChallengeReplyUpdateController
 */
@WebServlet("/rUpdate.cc")
public class AjaxCrowdChallengeReplyUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxCrowdChallengeReplyUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int crowdNo = Integer.parseInt(request.getParameter("cno"));
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		String context = request.getParameter("context");
		
		int result = new CrowdChallengeService().updateCrowdChallengeReply(crowdNo, userNo, context);
		
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
