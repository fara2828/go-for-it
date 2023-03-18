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
import com.highfive.certBoard.model.vo.CertChall;
import com.highfive.challenge.model.vo.Challenge;

/**
 * Servlet implementation class CertDetailController
 */
@WebServlet("/detail.ce")
public class CertDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CertDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 값뽑기: 클릭한 인증글 번호뽑기
		// http://localhost:7777/HIGH_FIVE/detail.ce?certNo=1
		int certNo = Integer.parseInt(request.getParameter("certNo"));
		int challNo = Integer.parseInt(request.getParameter("challNo"));
		
			
		
		Challenge c = new CertService().selectChall(challNo);			
		CertChall cc = new CertService().selectCertChall(certNo); 
		ArrayList<Attachment> challAtList = new CertService().selectChallAttachmentList(challNo);
		ArrayList<Attachment> certAtList = new CertService().selectCertAttachmentList(certNo);
		
	
		request.setAttribute("c", c);
		request.setAttribute("cc", cc);
		request.setAttribute("challAtList", challAtList);
		request.setAttribute("certAtList", certAtList);
		request.getRequestDispatcher("views/certChall/certDetailView.jsp").forward(request, response);
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
