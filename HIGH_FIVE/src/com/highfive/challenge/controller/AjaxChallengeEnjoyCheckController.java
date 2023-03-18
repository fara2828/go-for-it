package com.highfive.challenge.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.highfive.challenge.model.service.ChallengeService;
import com.highfive.challenge.model.vo.Challenge;

/**
 * Servlet implementation class AjaxChallengeEnjoyController
 */
@WebServlet("/enjoyCheck.ch")
public class AjaxChallengeEnjoyCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxChallengeEnjoyCheckController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cno = Integer.parseInt(request.getParameter("cno"));
		int userNo = Integer.parseInt(request.getParameter("userNo"));

		int result = new ChallengeService().enjoyCheck(cno, userNo);
		
		Challenge c = new ChallengeService().participateChallengeNow(cno);
		boolean participant = true;
		
		if(c.getChallParticipant() <= c.getChallParticipantNow()) {
			// 참여불가능
			participant = false;
		}
		
		
		
		JSONObject jObj = new JSONObject();
		
		jObj.put("result", result);
		jObj.put("participant", participant);
		
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
