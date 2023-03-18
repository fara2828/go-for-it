package com.highfive.crowdOngoing.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.highfive.crowdOngoing.model.service.CrowdOngoingService;

/**
 * Servlet implementation class AjaxMakeItController
 */
@WebServlet("/makeit.cc")
public class AjaxMakeItController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjaxMakeItController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 만들어주세요 입니다...

		request.setCharacterEncoding("UTF-8");

		int cno = Integer.parseInt(request.getParameter("cno"));
		int userNo = Integer.parseInt(request.getParameter("userNo"));

		int checkGoodIdeaUserNo = new CrowdOngoingService().selectGoodIdeaUserNo(cno, userNo); // userNo가 Goodidea를 누른적
																								// 없으면 2가 들어온다.
		int checkMakeItUserNo = new CrowdOngoingService().selectMakeItUserNo(cno, userNo); // userNo가 makeIt을 누른적 없으면 2가
																							// 들어온다.

		int num = checkGoodIdeaUserNo + checkMakeItUserNo;

		if (num == 4) {
			int makeIt = new CrowdOngoingService().insertMakeIt(cno, userNo);

		} else if (checkMakeItUserNo == 1) {
			// downMakeIt.. 1 -> 0으로 만들어준다.
			// goodIdea는 그대로 둔다
			int down = new CrowdOngoingService().downMakeIt(cno, userNo);

		} else if (checkMakeItUserNo == 0) {
			// downMakeIt 0 -> 1로 만들어준다.
			// goodIdea는 그대로 둔다.
			int up = new CrowdOngoingService().upMakeIt(cno, userNo);

		}

		int result = new CrowdOngoingService().makeItCount(cno);

		System.out.println(result);

		response.setContentType("text/html; charset=UTF-8");

		response.getWriter().print(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
