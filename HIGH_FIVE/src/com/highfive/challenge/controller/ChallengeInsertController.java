package com.highfive.challenge.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.highfive.certBoard.model.vo.Attachment;
import com.highfive.challenge.model.service.ChallengeService;
import com.highfive.challenge.model.vo.Challenge;
import com.highfive.common.MyFileRenamePolicy;
import com.highfive.crowdChallenge.model.service.CrowdChallengeService;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class ChallengeInsertController
 */
@WebServlet("/insert.ch")
public class ChallengeInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChallengeInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Challenge c = new Challenge();

		// 2)  첨부파일~ multipart/form-data
		if(ServletFileUpload.isMultipartContent(request)) {
			
			// MultipartRequest 객체생성
			int maxSize = 1024 * 1024 * 10;
			
			// 저장 경로 제시
			String savePath = request.getServletContext().getRealPath("/resources/challenge/thumbnail/");
			
			// 2.MultipartRequest(객체 생성)
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			
			int userNo = Integer.parseInt(multiRequest.getParameter("userNo"));
			
			String challCategory = multiRequest.getParameter("challCategory");
			String challName = multiRequest.getParameter("challName");
			int challFrequency = Integer.parseInt(multiRequest.getParameter("challFrequency"));
			String challStart = multiRequest.getParameter("challStart");
			
			
			// 끝나는 날짜는 기간을 입력받아 계산해줘야함
			int end = Integer.parseInt(multiRequest.getParameter("challEnd"));	// 주단위를 가져옴

			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");	// DB에 저장할 데이터 포멧 설정

			Date startDate = null;	// 시작 날짜를 가지고 있는 Date 객체를 생성
			try {
				startDate = dateFormat.parse(challStart);	// Date객체에 challStart날짜를 대입
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			Calendar cal = Calendar.getInstance();		// 날짜 계산을 위한 객체 생성
			cal.setTime(startDate);			// 계산 시작 날짜를 세팅
			cal.add(Calendar.DATE, (end * 7));		//주단위 날짜 계산해서 현재 날짜에 더해줌
			
			Date endDate = new Date(cal.getTimeInMillis());	// 현재 날짜를 가지고 있는 걸로 Date객체 생성
			String challEnd = dateFormat.format(endDate);	// Date객체의 format를 적용하여 String에 담음
			
			int challParticipate = Integer.parseInt(multiRequest.getParameter("challParticipate"));
			String challHowto = multiRequest.getParameter("challHowto");
			String challThumbnail = "";
			String challIntroduction = multiRequest.getParameter("challIntroduction");
			
			
			ArrayList<Attachment> list = new ArrayList();	//첨부파일 리스트
			
			// file1 ~ file3은 attachment에, file4는 challenge에
			for(int i=1; i<=4; i++) {
				String key = "file" + i;	//key값 구하기
				
				// 키값으로 파일 존재여부 확인하기
				if(multiRequest.getOriginalFileName(key) != null) {
					
					// 첨부파일이 존재하면 파일1,2,3은 attachment에 파일4는 challenge에
					if(i == 4) {
						challThumbnail = "resources/challenge/thumbnail/" + multiRequest.getFilesystemName(key);
					} else {
					
						Attachment at = new Attachment();
						at.setFilePath("resources/challenge/thumbnail/" + multiRequest.getFilesystemName(key));
						at.setOriginName(multiRequest.getOriginalFileName(key));
						at.setChangeName(multiRequest.getFilesystemName(key));
						
						list.add(at);
					}
					
					
				}
			}
			
			String challPublic = multiRequest.getParameter("challPublic");
			String challPhothExp = multiRequest.getParameter("challPhothExp");
			
			System.out.println("crowdNo : " + request.getParameter("challNo"));
			//int crowdNo = Integer.parseInt(request.getParameter("challNo"));
			
			// 객체 set
			c.setChallCategory(challCategory);
			c.setUserNo(userNo);
			c.setChallName(challName);
			c.setChallFrequency(challFrequency);
			c.setChallStart(challStart);
			c.setChallEnd(challEnd);
			c.setChallParticipant(challParticipate);
			c.setChallHowto(challHowto);
			c.setChallIntroduction(challIntroduction);
			c.setChallThumbnail(challThumbnail);
			c.setChallPublic(challPublic);
			c.setChallPhothExp(challPhothExp);
			
			// 비공개 챌린지의 경우만 비번 set
			if(challPublic.equals("N")) {
				c.setChallPwd(multiRequest.getParameter("challPwd"));
			}
			
			int result = new ChallengeService().insertChallenge(c, list);
			
			if(result > 0) {

				//new CrowdChallengeService().deleteCrowdChallenge(crowdNo);
					
				response.sendRedirect(request.getContextPath() + "/list.ch");
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
