package com.highfive.challenge.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.highfive.challenge.model.service.ChallengeService;

/**
 * Servlet implementation class AjaxChallengeMadeByUser
 */
@WebServlet("/madeByUser.ch")
public class AjaxChallengeMadeByUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxChallengeMadeByUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userNo = Integer.parseInt(request.getParameter("userNo"));

		int enjoyCount = new ChallengeService().selectEnjoyCount(userNo);	// 참가중인 챌린지
		int endCount = new ChallengeService().selectEndCount(userNo);		// 완료 챌린지
		int madeCount = new ChallengeService().selectMadeCount(userNo);		// 생성 챌린지
		
		JSONObject jObj = new JSONObject();
		
		jObj.put("enjoyCount", enjoyCount);
		jObj.put("endCount", endCount);
		jObj.put("madeCount", madeCount);
		
		response.setContentType("application/json; charset=UTF-8");
		
		response.getWriter().print(jObj);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
