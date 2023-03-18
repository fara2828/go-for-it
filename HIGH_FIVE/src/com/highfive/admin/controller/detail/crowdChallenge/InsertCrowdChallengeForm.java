package com.highfive.admin.controller.detail.crowdChallenge;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.highfive.crowdChallenge.model.service.CrowdChallengeService;
import com.highfive.crowdChallenge.model.vo.CrowdChallenge;

/**
 * Servlet implementation class InsertCrowdChallenge
 */
@WebServlet("/insert.crowdChallenge")
public class InsertCrowdChallengeForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertCrowdChallengeForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int crowdNo = Integer.parseInt(request.getParameter("cno"));

		CrowdChallenge crowdChallenge = new CrowdChallengeService().selectCrowdChallenge(crowdNo);
		
		//Attachment at = new 
		
		request.setAttribute("crowdChallenge", crowdChallenge);

		request.getRequestDispatcher("views/admin/insertCrowdChallenge.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
