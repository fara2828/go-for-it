package com.highfive.admin.controller.detail.contact;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.highfive.admin.service.AdminDetailService;
import com.highfive.contact.model.vo.Contact;

/**
 * Servlet implementation class WritingContactController
 */
@WebServlet("/wirtingContact")
public class WritingContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WritingContactController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int contactNo = Integer.parseInt(request.getParameter("contactNo"));
		String answerContent = request.getParameter("answerContent");		
		
		Contact contact = new Contact();
		contact.setAnswerContent(answerContent);
		contact.setContactNo(contactNo);
		
		//int result1 = new AdminDetailService().answerContact(contact);
		//System.out.println(result1);
		int result2 = new AdminDetailService().answerUpdateContact(contact);
		
		if(result2 > 0) {
			
			request.setAttribute("contact", contact);
			request.setAttribute("alertMsg", "문의사항 글 등록이 완료되었습니다.");
			response.sendRedirect(request.getContextPath() + "/adminPage");
			
		} else {
			
			request.setAttribute("errorMsg", "문의사항 등록실패");
			request.getRequestDispatcher("views/common/errorPage.jsp");
			
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
