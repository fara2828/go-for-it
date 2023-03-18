package com.highfive.crowdChallenge.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.highfive.common.MyFileRenamePolicy;
import com.highfive.crowdChallenge.model.service.CrowdChallengeService;
import com.highfive.crowdChallenge.model.vo.CrowdChallenge;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class CrowdChallengeInsertController
 */
@WebServlet("/insert.cc")
public class CrowdChallengeInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrowdChallengeInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		//서버로 파일 올려주기
		if(ServletFileUpload.isMultipartContent(request)) {
			
			int maxSize = 1024 * 1024 * 10;
			
			//저장할 서버의 물리적 경로 제시
			String savaPath = request.getServletContext().getRealPath("/resources/thumbnail/");
			
			//MutipartRequest 객체 생성해야 했다.. ^^ ... 
			MultipartRequest multiRequest = new MultipartRequest(request, savaPath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			//MultiRequest로 부터 값 뽑기 =>getParameter 메소드 이용
			String category = multiRequest.getParameter("category");
			String crowdTitle = multiRequest.getParameter("title");
			String content = multiRequest.getParameter("content");
			int userNo = Integer.parseInt(multiRequest.getParameter("userNo"));
			int period = Integer.parseInt(multiRequest.getParameter("period"));
			
			//VO가공
			
			CrowdChallenge c = new CrowdChallenge();
			c.setUserNo(userNo);
			c.setCrowdCategory(category);
			c.setCrowdName(crowdTitle);
			c.setCrowdExp(content);
			c.setCrowdPeriod(period);
			
			String key = "thumbnail";
			
			if(multiRequest.getOriginalFileName(key) != null) {
				
				multiRequest.getOriginalFileName(key);
				String thumbnail= multiRequest.getFilesystemName(key);
				c.setCrowdThumbnail("resources/thumbnail/"+thumbnail);
				
			}
			
			int result = new CrowdChallengeService().insertCrowdChallenge(c);
			
			if(result > 0) {//성공 =>list.th로 요청(sendRedirect)
				response.sendRedirect(request.getContextPath() + "/list.cc");
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
