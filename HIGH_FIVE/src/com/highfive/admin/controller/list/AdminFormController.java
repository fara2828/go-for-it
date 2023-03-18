package com.highfive.admin.controller.list;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.highfive.admin.service.AdminArrayService;
import com.highfive.challenge.model.vo.Challenge;
import com.highfive.contact.model.vo.Contact;
import com.highfive.crowdChallenge.model.vo.CrowdChallenge;
import com.highfive.faq.model.vo.Faq;
import com.highfive.member.model.vo.Member;
import com.highfive.notice.model.vo.Notice;

/**
 * Servlet implementation class AdminFormController
 */
@WebServlet("/adminPage")
public class AdminFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		// 챌린지 객체
		//Challenge challenge = new AdminArrayService().selectChallengeAdmin();

		// 챌린지 세션에 담기
		//HttpSession session = request.getSession();
		// 화면에 보여지는 7개 값 담기(ArrayList만)
		ArrayList<Member> mList = new AdminArrayService().selectMembers();
		ArrayList<Challenge> challList = new AdminArrayService().selectChallenge();
		ArrayList<Contact> conList = new AdminArrayService().selectContact();
		ArrayList<Faq> faqList = new AdminArrayService().selectFaq();
		ArrayList<Notice> noticeList = new AdminArrayService().selectNotice();
		ArrayList<CrowdChallenge> crowdList= new AdminArrayService().selectCrowd();
		ArrayList<Member> levelList= new AdminArrayService().selectLevel();		
		
		//session.setAttribute("challenge", challenge);
		request.setAttribute("mList", mList);
		request.setAttribute("challList", challList);
		request.setAttribute("conList", conList);
		request.setAttribute("faqList", faqList);
		request.setAttribute("noticeList", noticeList);
		request.setAttribute("crowdList", crowdList);
		request.setAttribute("levelList", levelList);	
		
		
		request.getRequestDispatcher("views/admin/adminListView.jsp").forward(request, response);
		
		
		
		
	}	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
