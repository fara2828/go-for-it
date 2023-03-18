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
 * Servlet implementation class MemberUpdateController2
 */
@WebServlet("/update2.me")
public class MemberUpdateController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateController2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
				
		String userId= request.getParameter("userId");
    	String userPwd=request.getParameter("userPwd");
		String userName= request.getParameter("userName"); 
		String nickName= request.getParameter("nickName");
		String email=request.getParameter("email");
		String birthDate=request.getParameter("birthDate");
		String gender=request.getParameter("gender");
		String post= request.getParameter("post");
		String address=request.getParameter("address");
		String phone=request.getParameter("phone");
		String addressDetail=request.getParameter("addressDetail");

		

		Member m= new Member();
		
		m.setUserId(userId);
		m.setUserPwd(userPwd);
		m.setUserName(userName);
		m.setNickName(nickName);
		m.setEmail(email);
		m.setBirthDate(birthDate);
		m.setGender(gender);
		m.setPost(post);
		m.setAddress(address);
		m.setAddressDetail(addressDetail);
		m.setPhone(phone);

		
		Member updateMem=new MemberService().updateMember(m);

	
		if(updateMem != null) {
			HttpSession session=request.getSession();
			session.setAttribute("alertMsg", "회원정보 수정 성공~");
			session.setAttribute("loginUser", updateMem);
			
			response.sendRedirect(request.getContextPath()+"/myPage.me");
		} else {
			request.setAttribute("alertMsg", "회원정보 수정에 실패하였습니다.");
			request.getRequestDispatcher("views/member/memberUpdateForm.jsp").forward(request, response);
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
