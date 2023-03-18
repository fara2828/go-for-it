package com.highfive.certBoard.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.highfive.certBoard.model.service.CertService;
import com.highfive.certBoard.model.vo.Attachment;
import com.highfive.challenge.model.vo.Challenge;

/**
 * Servlet implementation class AjaxChangeEnrollFormController
 */
@WebServlet("/changeEnrollForm.ce")
public class AjaxCertChangeEnrollFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxCertChangeEnrollFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int challNo = Integer.parseInt(request.getParameter("challNo"));
		Challenge c = new CertService().selectChall(challNo);
		ArrayList challAtList = new CertService().selectChallAttachmentList(challNo);
		
		
		// ArrayList의 지네릭을 별도로 설정하지 않고 마지막 인덱스에 c를 넣어서 보내보자
		
		challAtList.add(c);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
				
		response.setContentType("application/json; charset=UTF-8");
		new Gson().toJson(challAtList, response.getWriter());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
