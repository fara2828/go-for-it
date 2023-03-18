package com.highfive.myChallenge.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.highfive.challenge.model.vo.Challenge;
import com.highfive.member.model.vo.Member;
import com.highfive.myChallenge.model.service.myChallengeService;

/**
 * Servlet implementation class joinEndDetailListController
 */
@WebServlet("/joinEndDetail.ch")
public class joinEndDetailListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public joinEndDetailListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member loginUser = (Member)session.getAttribute("loginUser");

		int userNo = loginUser.getUserNo();
		
		ArrayList<Challenge> joinEndList = new myChallengeService().selectEndChallenge(userNo);
		
		request.setAttribute("joinEndList", joinEndList);
		
		request.getRequestDispatcher("views/myChallenge/joinEndListView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
