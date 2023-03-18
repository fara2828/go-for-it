package com.highfive.admin.controller.detail.contact;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.highfive.certBoard.model.vo.Attachment;
import com.highfive.contact.model.service.ContactService;
import com.highfive.contact.model.vo.Contact;

/**
 * Servlet implementation class DetailContact
 */
@WebServlet("/detailContact")
public class DetailContactAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailContactAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int contactNo = Integer.parseInt(request.getParameter("contactNo"));
		
		Attachment at = new ContactService().selectAttachment(contactNo);
		
		ArrayList<Contact> contact = new ContactService().selectContactListNoPaging(contactNo);
		
		request.setAttribute("at", at);
		
		request.setAttribute("contact", contact);

		if(contactNo > 0) {
			Contact conNum = new ContactService().selectContact(contactNo);
			request.setAttribute("conNum", conNum);
			
			request.getRequestDispatcher("views/admin/contactWrite.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMsg", "게시글조회 실패");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
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
