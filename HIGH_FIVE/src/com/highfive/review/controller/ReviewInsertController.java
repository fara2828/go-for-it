package com.highfive.review.controller;

import java.io.IOException;
import java.util.ArrayList;

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
import com.highfive.member.model.vo.Member;
import com.highfive.review.model.service.ReviewService;
import com.highfive.review.model.vo.Review;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class ReviewInsertController
 */
@WebServlet("/insert.re")
public class ReviewInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int userNo= ((Member)(request.getSession().getAttribute("loginUser"))).getUserNo();
		String nickName= ((Member)(request.getSession().getAttribute("loginUser"))).getNickName();
		
		if(ServletFileUpload.isMultipartContent(request)) {
			int maxSize = (byte) 10*1024*1024; 
			HttpSession session = request.getSession();
			ServletContext application = session.getServletContext();

			String savePath = application.getRealPath("/resources/review_upfiles");

			MultipartRequest multiRequest = new MultipartRequest(request, savePath,  maxSize, "UTF-8", new MyFileRenamePolicy());
			
			
			
			int challNo= Integer.parseInt(multiRequest.getParameter("selectChallenge"));
			String reviewTitle = multiRequest.getParameter("reviewTitle");
			String reviewContent = multiRequest.getParameter("textContent");
			
			

			Review r = new Review();
			r.setChallNo(challNo);
			r.setReviewTitle(reviewTitle);
			r.setReviewContent(reviewContent);
			r.setUserNo(userNo);
			r.setNickName(nickName);
			

			
			ArrayList<Attachment> list = new ArrayList();
			
			
			for(int i=1; i<=3; i++) {
				String key = "file"+i;
			
				if(multiRequest.getOriginalFileName(key) !=null) {
					Attachment at = new Attachment();


					at.setOriginName(multiRequest.getOriginalFileName(key));
					at.setChangeName(multiRequest.getFilesystemName(key));		
					at.setFilePath("resources/review_upfiles/");
					list.add(at);
				}		
			}
			
			//첨부파일이 있을 경우 인증 list에서 썸네일을 보여주기 위해
			// 첫번째 선택된 첨부파일을 인증list의 썸네일로 지정한다
            // cc vo객체의 thumbnail에 담아서 보낸다
			if(!list.isEmpty()) {				
				String thumbnail = list.get(0).getFilePath()+"/"+list.get(0).getChangeName();
				r.setReviewThumbnail(thumbnail);
				
			}
					
			
		
			// 썸네일있는지 여부에 따라 실행되는 sql문이 달라야하므로(위치홀더 개수가 
			// 여기서 판별하고 있는지 없는지에 따라 다른 메소드 호출
			// 리뷰를 insert한 후 user_like 컬럼에도 0으로 인서트 하기!!!!!!!!!
	
				int result = new ReviewService().insertReview(r, list);	

							
				if(result>0) { // 성공 => list.bo?cpage=1
					request.getSession().setAttribute("alertMsg", "게시글 작성 성공");
					response.sendRedirect(request.getContextPath()+"/list.re");	
				} else { 				
					request.setAttribute("errorMsg", "게시글 작성실패");
				// errorPage만들고 보내기
					request.getRequestDispatcher("views/common/errorPage.jsp").forward(request,response);
				
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
