package com.highfive.admin.controller.list;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.highfive.admin.service.AdminArrayService;
import com.highfive.challenge.model.vo.Challenge;

/**
 * Servlet implementation class DeleteChallengeAdminController
 */
@WebServlet("/deleteChallengeAdmin")
public class DeleteChallengeAdminFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteChallengeAdminFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		ArrayList<Challenge> challList = new AdminArrayService().selectChallenge();
		
		request.setAttribute("challList", challList);
		
		
		request.getRequestDispatcher("views/admin/deleteChallengeAdmin.jsp").forward(request, response);
	
		System.out.println(challList);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}