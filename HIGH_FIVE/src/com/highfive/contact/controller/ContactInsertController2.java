package com.highfive.contact.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.highfive.certBoard.model.vo.Attachment;
import com.highfive.common.MyFileRenamePolicy;
import com.highfive.contact.model.service.ContactService;
import com.highfive.contact.model.vo.Contact;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class ContactInsertController2
 */
@WebServlet("/insert2.co")
public class ContactInsertController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactInsertController2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		if(ServletFileUpload.isMultipartContent(request)) {
			
			int maxSize = 10 * 1024 * 1024;
			
			HttpSession session = request.getSession();
			ServletContext application = session.getServletContext();
			String savePath = application.getRealPath("/resources/contact_upfiles/");
		
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			int userNo = Integer.parseInt(multiRequest.getParameter("userNo"));
			String questionTitle = multiRequest.getParameter("title");
			String questionContent = multiRequest.getParameter("content");
			
			//highfive_20221201162010_38332.jpg

			Contact c= new Contact();
			c.setQuestionTitle(questionTitle);
			c.setQuestionContent(questionContent);
			c.setUserNo(userNo);
			
			Attachment at = null;
			
			if(multiRequest.getOriginalFileName("upfile") != null) {
				
				at = new Attachment();
				
				at.setOriginName(multiRequest.getOriginalFileName("upfile"));
				
				at.setChangeName(multiRequest.getFilesystemName("upfile"));

				at.setFilePath("resources/contact_upfiles");	
				
			}
			
			int result= new ContactService().insertContact(c,at);
			
			if(result>0) {
				
				request.getSession().setAttribute("alertMsg", "게시글 작성 완료");
				response.sendRedirect(request.getContextPath()+"/list.co?cpage=1");
			
			} else {
				
				if(at!=null) {
					new File(savePath + at.getChangeName()).delete();
				}
				request.setAttribute("alertMsg", "게시글 작성 실패");
				request.getRequestDispatcher("views/contact/contactListView.jsp").forward(request, response);
			}
			
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
