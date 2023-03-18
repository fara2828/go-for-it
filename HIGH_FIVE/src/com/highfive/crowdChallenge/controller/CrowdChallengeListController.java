package com.highfive.crowdChallenge.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.highfive.crowdChallenge.model.service.CrowdChallengeService;
import com.highfive.crowdChallenge.model.vo.CrowdChallenge;

/**
 * Servlet implementation class CrowdChallengeListController
 */
@WebServlet("/list.cc")
public class CrowdChallengeListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrowdChallengeListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    //ArrayList crowdNoList = new CrowdChallengeService().selectCrowdNoList();
	   
	    ArrayList<CrowdChallenge> ccList = new CrowdChallengeService().selectCrowdList();
		
		request.setAttribute("list", ccList);
		request.getRequestDispatcher("views/crowd/crowdChallengeListView.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
