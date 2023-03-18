package com.highfive.admin.controller.detail.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.highfive.admin.service.AdminDetailService;

/**
 * Servlet implementation class FirmUpDeleteMember
 */
@WebServlet("/firmUpDeleteMember")
public class FirmUpDeleteMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirmUpDeleteMember() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String[] firmUpDeleteMember = request.getParameterValues("dropUsers");
		
		// 삭제만 한다해도 관리자가 체크박스클릭 안하고 할수있으니까 null처리 해줘야? -> 아니다.. 잘못이해했다...
/*
		String dropUsers = "";
		if(firmUpDeleteMember != null) {
			// 배열을 String으로 바꾼것! -> setter에 넣을때 배열을 넣을 순 없으니...
			dropUsers = String.join("", firmUpDeleteMember);
		}
*/
		int result = 0;
		for(int i = 0; i < firmUpDeleteMember.length; i++) {
			String delMember = firmUpDeleteMember[i];
			result += new AdminDetailService().firmUpDeleteMember(delMember); 
		}
		if(result == firmUpDeleteMember.length) {
			
			request.getSession().setAttribute("alertMsg", "회원 탈퇴 완료.");
			//request.getRequestDispatcher("views/admin/adminListView.jsp");
			response.sendRedirect(request.getContextPath() + "/adminPage");
		
		} else {
			
			request.getSession().setAttribute("alertMsg", "회원탈퇴에 실패했습니다.");
			request.getRequestDispatcher("views/admin/adminListView.jsp");
		
		}
		
		//deleteMember.setUserNo(FirmUpDeleteMember)
		//int result = new AdminDetailService().FirmUpDeleteMember();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
