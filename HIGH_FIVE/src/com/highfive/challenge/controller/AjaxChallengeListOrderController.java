package com.highfive.challenge.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.highfive.challenge.model.service.ChallengeService;
import com.highfive.challenge.model.vo.Challenge;

/**
 * Servlet implementation class challengeListController
 */
@WebServlet("/olist.ch")
public class AjaxChallengeListOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxChallengeListOrderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String orderQuery = request.getParameter("orderByQuery");
		String whereQuery = request.getParameter("whereQuery");
		
		ArrayList<Challenge> list = new ChallengeService().selectChallengeList(orderQuery, whereQuery);
		
		response.setContentType("application/json; charset=UTF-8");
		
		new Gson().toJson(list, response.getWriter());
		//response.getWriter().print(list);
		// request.setAttribute("list", list);
		
		//request.getRequestDispatcher("views/challenge/challengeListView.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
