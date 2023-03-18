package com.highfive.challenge.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.highfive.certBoard.model.vo.Attachment;
import com.highfive.challenge.model.service.ChallengeService;
import com.highfive.challenge.model.vo.Challenge;

/**
 * Servlet implementation class ChallengeDetailView
 */
@WebServlet("/detail.ch")
public class ChallengeDetailView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChallengeDetailView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cno = Integer.parseInt(request.getParameter("cno"));
		
		int result = new ChallengeService().increaseCount(cno);
		
		if(result > 0) {
			
			Challenge challenge = new ChallengeService().selectChallengeDetail(cno);
			
			ArrayList<Attachment> list = new ChallengeService().selectChallengeAttechment(cno);
		
			request.setAttribute("challenge", challenge);
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("views/challenge/challengeDetailView.jsp").forward(request, response);
		} else {
			System.out.println("오류낫지롱~~~");
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
