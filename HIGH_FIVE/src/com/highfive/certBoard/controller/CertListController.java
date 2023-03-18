package com.highfive.certBoard.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.highfive.certBoard.model.service.CertService;
import com.highfive.certBoard.model.vo.CertChall;

// 인증글등록 버튼 클릭시, 해당 버튼이 클릭된 CHALL_NO를 input태그로 미리 넘겨받아야함
// 주은님이랑 이야기하기!!
// challenge에 더미자료 넣은거 있는지


/**
 * Servlet implementation class CertListController
 */
@WebServlet("/list.ce")
public class CertListController extends HttpServlet {
	private static final long serialVersionUID = 1L;	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CertListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 화면 띄우기 전에 테이블로부터 사진들을 조회해서 가져가야함
		
		// 주은님과 이야기하여 넘겨받은 challNo 에서 뽑기
		
		
		int challNo = Integer.parseInt(request.getParameter("challNo"));
		ArrayList<CertChall> list = new CertService().selectThumbnailList(challNo);
		
		// insertController 

		request.setAttribute("list", list);
		
		// listView 상단에 뜨는 총 인증수 보여주는 기능
		
		int result = new CertService().selectCertCount(challNo);
		
		request.setAttribute("certCount", result);

		request.getRequestDispatcher("views/certChall/certListView.jsp").forward(request,response);
		
		
	}

	/*
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
