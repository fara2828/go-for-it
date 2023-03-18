package com.highfive.crowdOngoing.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.highfive.crowdOngoing.model.service.CrowdOngoingService;
import com.highfive.crowdOngoing.model.vo.CrowdOngoing;

/**
 * Servlet implementation class AjaxGoodIdeaController
 */
@WebServlet("/goodidea.cc")
public class AjaxGoodIdeaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxGoodIdeaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//굿 아이디어,,,입니다...
		
		request.setCharacterEncoding("UTF-8");
		
		int cno = Integer.parseInt(request.getParameter("cno"));
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		
		int checkGoodIdeaUserNo = new CrowdOngoingService().selectGoodIdeaUserNo(cno, userNo); // userNo가 Goodidea를 누른적 없으면 2가 들어온다.
		//int checkMakeItUserNo = new CrowdOngoingService().selectMakeItUserNo(cno, userNo); //userNo가 makeIt을 누른적 없으면 2가 들어온다.
		
		//int num = checkGoodIdeaUserNo//+checkMakeItUserNo;
		
		
		//result의 값이 4면 user가 굿아이디어와 만들어주세요를 누른적 없다.
		//=>user값을 insert해준다.
		if(checkGoodIdeaUserNo == 2 ) {
				int goodIdea = new CrowdOngoingService().insertGoodIdea(cno, userNo);
				
				
		}else if(checkGoodIdeaUserNo == 1) {
			//downGoodIdea.. 1 -> 0으로 만들어준다.
			//make it은 그대로 둔다
			int down = new CrowdOngoingService().downGoodIdea(cno, userNo);

			
		}else if(checkGoodIdeaUserNo == 0) {
			//upGoodIdea 0 -> 1로 만들어준다.
			//makeit은 그대로 둔다.
			int up = new CrowdOngoingService().upGoodIdea(cno, userNo);
			
		}
		
		int result = new CrowdOngoingService().goodIdeaCount(cno, userNo);
		
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
