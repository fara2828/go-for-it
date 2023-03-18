package com.highfive.crowdChallenge.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.highfive.crowdChallenge.model.service.CrowdChallengeService;
import com.highfive.crowdChallenge.model.vo.CrowdChallengeReply;
import com.highfive.member.model.vo.Member;

/**
 * Servlet implementation class AjaxCrowdChallengeInsertReplyController
 */
@WebServlet("/rinsert.cc")
public class AjaxCrowdChallengeInsertReplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxCrowdChallengeInsertReplyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int CrowdNo = Integer.parseInt(request.getParameter("cno"));
		String CommentText = request.getParameter("content");
		
		int userNo = ((Member)request.getSession().getAttribute("loginUser")).getUserNo();
		
		//VO로 가공 => Reply
		CrowdChallengeReply r = new CrowdChallengeReply();
		r.setCrowdNo(CrowdNo);
		r.setCrowdCommentText(CommentText);
		r.setUserNo(userNo);
		
		int result = new CrowdChallengeService().insertCrowdChallengeReply(r);
		
		
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
