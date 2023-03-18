package com.highfive.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.highfive.common.MyFileRenamePolicy;
import com.highfive.member.model.service.MemberService;
import com.highfive.member.model.vo.Member;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class MemberInsertController
 */
@WebServlet("/insertMember")
public class MemberInsertController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInsertController2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		if(ServletFileUpload.isMultipartContent(request)) {
			
			// 용량제한
			int maxSize = 1024* 1024* 10;
			
			// 서버경로
			String savePath = request.getSession().getServletContext().getRealPath("/resources/profile_upfiles/");
			
			// MultipartRequest객체생성
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
		
			String userId = multiRequest.getParameter("userId"); // 1
			String userPwd = multiRequest.getParameter("userPwd");
			String userName = multiRequest.getParameter("userName");
			String nickName = multiRequest.getParameter("nickName");
			String email = multiRequest.getParameter("email"); 	
			String birthDate = multiRequest.getParameter("birthDate");		
			String gender = multiRequest.getParameter("gender");
			String post = multiRequest.getParameter("postcode");
			String address = multiRequest.getParameter("address");
			String addressDetail = multiRequest.getParameter("addressDetail");
			String phone = multiRequest.getParameter("phone");
			String profile = multiRequest.getFilesystemName("fileImage"); // 12
			String checkPwd = multiRequest.getParameter("checkPwd");
			String checkNickName = multiRequest.getParameter("checkNickName");
			
			Member member = new Member();
			member.setUserId(userId); // 1
			member.setUserPwd(userPwd);
			member.setUserName(userName);
			member.setNickName(nickName);
			member.setEmail(email);
			member.setBirthDate(birthDate);
			member.setGender(gender);
			member.setPost(post);
			member.setAddress(address);
			member.setAddressDetail(addressDetail);
			member.setPhone(phone);
			member.setProfile(profile); // 12
			member.setCheckPwd(checkPwd);
			member.setCheckNickName(checkNickName);
			
			int result = 0;
			if(checkPwd.equals(userPwd) /*&& !nickName.equals(checkNickName)*/) {
				
				result = new MemberService().insertMember(member);
				
			}	
			
			if(result > 0) {
				
				request.getSession().setAttribute("alertMsg", "회원가입에 성공했습니다.");
				response.sendRedirect(request.getContextPath());
	
			} else {
				
				request.setAttribute("errorMsg", "회원가입에 실패했습니다.");
				RequestDispatcher view = request.getRequestDispatcher("views/common/errorpage.jsp");
				view.forward(request, response);
				
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
