package com.highfive.admin.controller.detail.faq;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.highfive.admin.service.AdminDetailService;

/**
 * Servlet implementation class FirmUpDeleteFaq
 */
@WebServlet("/firmUpDeleteFaq")
public class FirmUpDeleteFaq extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirmUpDeleteFaq() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String[] firmUpDeleteFaq = request.getParameterValues("dropFaqs");
		
		int result = 0;
		for(int i = 0; i < firmUpDeleteFaq.length; i++) {
			String delFaq = firmUpDeleteFaq[i];
			result += new AdminDetailService().firmUpDeleteFaq(delFaq);
		}
		
		if(result == firmUpDeleteFaq.length) {
			
			request.getSession().setAttribute("alertMsg", "FAQ 삭제" + result + "개 완료.");
			//request.getRequestDispatcher("views/admin/adminListView.jsp");
			response.sendRedirect(request.getContextPath() + "/adminPage");
		
		} else {
			
			request.getSession().setAttribute("alertMsg", "FAQ 삭제 실패");
			request.getRequestDispatcher("views/admin/adminListView.jsp");
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
