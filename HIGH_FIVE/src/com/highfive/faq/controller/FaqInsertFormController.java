package com.highfive.faq.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.highfive.faq.model.service.FaqService;
import com.highfive.faq.model.vo.Faq;

/**
 * Servlet implementation class FaqInsertFormController
 */
@WebServlet("/insertFaq")
public class FaqInsertFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaqInsertFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");

		String faqNo = request.getParameter("faqNo");
		String faqTitle = request.getParameter("faqTitle");
		String faqContent = request.getParameter("faqContent");
		
		Faq faq = new Faq();
		faq.setFaqNo(faqNo);
		faq.setFaqTitle(faqTitle);
		faq.setFaqContent(faqContent);

		
		int result = new FaqService().insertFaq(faq);

		if(result > 0) {
			request.getSession().setAttribute("alertMsg", "FAQ등록에 성공했습니다.");
			response.sendRedirect(request.getContextPath() + "/faq");
		} else {
			request.setAttribute("alertMsg", "공지사항 등록이 실패되었습니다.");
			request.getRequestDispatcher("views/faq/faqListView.jsp").forward(request, response);
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
