package com.highfive.admin.controller.detail.level;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.highfive.admin.service.AdminArrayService;
import com.highfive.admin.service.AdminDetailService;
import com.highfive.member.model.vo.Member;

/**
 * Servlet implementation class DetailLevelAdmin
 */
@WebServlet("/detailLevelAdmin")
public class DetailLevelAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailLevelAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int level=Integer.parseInt(request.getParameter("level"));
		
		System.out.println(level);
		
		ArrayList<Member> levelList= new ArrayList<Member>();
		
		if(level==8) {
			levelList= new AdminArrayService().selectLevel();
		} else {			
			levelList= new AdminDetailService().selectLevel(level);
		}
		
		request.setAttribute("levelList", levelList);
		
		request.getRequestDispatcher("views/admin/selectMemberByLevel.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
