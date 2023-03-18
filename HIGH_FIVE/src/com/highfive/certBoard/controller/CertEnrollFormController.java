package com.highfive.certBoard.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.highfive.certBoard.model.service.CertService;
import com.highfive.certBoard.model.vo.Attachment;
import com.highfive.challenge.model.vo.Challenge;
import com.highfive.member.model.vo.Member;

/**
 * Servlet implementation class CertEnrollFormController
 */
@WebServlet("/enrollForm.ce")
public class CertEnrollFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CertEnrollFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//챌린지 게시판에서 챌린지 번호, userNo를 넘겨 받아야함

		
		Member loginUser= (Member)(request.getSession().getAttribute("loginUser"));
		
		int userNo = loginUser.getUserNo();				
		int challNo = Integer.parseInt(request.getParameter("challNo"));
		
		
		ArrayList<Challenge> cList = new CertService().selectMyChallList(userNo);
		ArrayList<Attachment> challAtList = new CertService().selectChallAttachmentList(challNo);			
		
		Challenge c = new CertService().selectChall(challNo);
		
		
		request.setAttribute("cList", cList);
		request.setAttribute("c", c);
		request.setAttribute("challAtList", challAtList);
	
		
		request.getRequestDispatcher("views/certChall/certEnrollForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
