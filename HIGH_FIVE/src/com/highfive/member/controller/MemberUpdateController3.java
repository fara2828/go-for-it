package com.highfive.member.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.highfive.common.MyFileRenamePolicy;
import com.highfive.member.model.service.MemberService;
import com.highfive.member.model.vo.Member;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class MemberUpdateController3
 */
@WebServlet("/update3.me")
public class MemberUpdateController3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateController3() {
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
			String savePath = application.getRealPath("/resources/profile_upfiles/");
			
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
					
			String profile=multiRequest.getFilesystemName("profile");
			String userId=multiRequest.getParameter("userId");
			/*
			if(multiRequest.getFilesystemName("profile")==null) {
				profile=multiRequest.getParameter("originProfile");
			} else {
				profile=multiRequest.getFilesystemName("profile");				
			}
			*/
			
			System.out.println(profile);
			System.out.println(userId);

			
			Member updateMem1=new MemberService().insertProfile(profile, userId);

		
			if(updateMem1 != null) {
				//request.getRequestDispatcher("views/member/myPage.jsp").forward(request, response);
				session=request.getSession();
				session.setAttribute("alertMsg", "프로필 수정 성공");
				session.setAttribute("loginUser", updateMem1);
			
				response.sendRedirect(request.getContextPath()+"/myPage.me");
			} else {
				request.setAttribute("alertMsg", "프로필 수정에 실패하였습니다.");
				request.getRequestDispatcher("views/member/memberUpdateForm.jsp").forward(request, response);
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
