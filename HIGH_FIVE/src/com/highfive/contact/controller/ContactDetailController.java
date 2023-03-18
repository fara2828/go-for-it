package com.highfive.contact.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.highfive.certBoard.model.vo.Attachment;
import com.highfive.contact.model.service.ContactService;
import com.highfive.contact.model.vo.Contact;

/**
 * Servlet implementation class ContactDetailController
 */
@WebServlet("/detail.co")
public class ContactDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int contactNo= Integer.parseInt(request.getParameter("nno"));	
		
		Contact c=new ContactService().selectContact(contactNo);
		
		Attachment at= new ContactService().selectAttachment(contactNo);

		request.setAttribute("at", at);
		request.setAttribute("c", c);
		request.getRequestDispatcher("views/contact/contactDetailView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
