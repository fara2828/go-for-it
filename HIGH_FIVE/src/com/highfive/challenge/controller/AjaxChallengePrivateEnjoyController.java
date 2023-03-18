package com.highfive.challenge.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.highfive.challenge.model.service.ChallengeService;

/**
 * Servlet implementation class AjaxChallengePrivateEnjoyController
 */
@WebServlet("/enjoyPrivate.ch")
public class AjaxChallengePrivateEnjoyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxChallengePrivateEnjoyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cno = Integer.parseInt(request.getParameter("cno"));
		String challPwd = request.getParameter("password");
		
		int pwdCheck = new ChallengeService().checkChallPwd(cno, challPwd);
		
		response.setContentType("text/html, charset=UTF-8");
		
		response.getWriter().print(pwdCheck);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
