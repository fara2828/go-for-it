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
 * Servlet implementation class myChallengeListController
 */
@WebServlet("/myList.ch")
public class myChallengeListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public myChallengeListController() {
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
		
		// 내가만든 챌린지
		ArrayList<Challenge> madeByMeList = new myChallengeService().selectMadeByMeList(userNo);
	
		request.setAttribute("madeByMeList", madeByMeList);
		
		// 참여중인 챌린지
		ArrayList<Challenge> joinNowList = new myChallengeService().selectJoinChallenge(userNo);
		
		request.setAttribute("joinNowList", joinNowList);
		
		// 참여예정 챌린지
		ArrayList<Challenge> readyList = new myChallengeService().selectReadyChallenge(userNo);
		
		request.setAttribute("readyList", readyList);
		
		// 참여완료 챌린지
		ArrayList<Challenge> endList = new myChallengeService().selectEndChallenge(userNo);
		
		request.setAttribute("endList", endList);
		
		request.getRequestDispatcher("views/myChallenge/myChallengeListView.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
