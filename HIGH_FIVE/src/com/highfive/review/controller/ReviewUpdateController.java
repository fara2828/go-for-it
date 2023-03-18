package com.highfive.review.controller;

import java.io.File;
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
@WebServlet("/update.re")
public class ReviewUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewUpdateController() {
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
			
			
			
			int challNo= Integer.parseInt(multiRequest.getParameter("challNo"));
			int reviewNo= Integer.parseInt(multiRequest.getParameter("reviewNo"));
			
			String reviewTitle = multiRequest.getParameter("reviewTitle");
			String reviewContent = multiRequest.getParameter("textContent");
			
			
		
			Review r = new Review();
			r.setReviewNo(reviewNo);
			r.setChallNo(challNo);
			r.setReviewTitle(reviewTitle);
			r.setReviewContent(reviewContent);
			r.setUserNo(userNo);
			r.setNickName(nickName);
			
			
			ArrayList<Attachment> list = new ArrayList();
			// Attachment vo에 새 필드를추가하거나
			// ArrayList 마지막 인덱스에 판단을 할수있는 int배열을 추가하거나
			// switch문을 돌면서 2,3 case 마다 하나씩 +1되도록 하거나...........
			// 1,2,3만 쓰고 0은 버리자
			int[] arr = new int[4];
			
			for(int i=1; i<=3; i++) {
				String key = "reUpfile"+i;
				if(multiRequest.getOriginalFileName(key) !=null) {
					Attachment at =new Attachment();
					at.setOriginName(multiRequest.getOriginalFileName(key));
					at.setChangeName(multiRequest.getFilesystemName(key));
					at.setFilePath("resources/review_upfiles");
				
					if(multiRequest.getParameter("originFileNo"+i) != null) {
						arr[i]= 2;
						at.setFileNo(Integer.parseInt(multiRequest.getParameter("originFileNo"+i)));
						
						new File(savePath + multiRequest.getParameter("originFileName"+i)).delete();
					} else {
						arr[i]=3;
						at.setReviewNo(reviewNo);
					}
					
					list.add(at);
					
				} else {
				
					arr[i]= 1;
				
				}
			}

			if(!(list.isEmpty())) {				
				String thumbnail = list.get(0).getFilePath()+"/"+list.get(0).getChangeName();
				r.setReviewThumbnail(thumbnail);
				
			}
	
			
			
			// 4) 서비스 요청
			// 경우에 따라서 모두 한개의 트랜잭션으로 묶어야함
			// Service단 가기전에 생각하면 좋음
			// case 1 : 새로운 첨부파일 X => b, null =>   UPDATE
			// case 2 : 새로운 첨부파일 O, 기존 첨부파일 O => UPDATE, ATTACHMENT UPDATE
			// case 3 : 새로운 첨부파일 O, 기존 첨부파일 X =>  UPDATE, ATTACHMENT INSERT
			
			int result = new ReviewService().updateReview(r, list, arr);
			if(result ==4) {
				
				
				request.getSession().setAttribute("alertMsg", "리뷰 수정 성공");
				response.sendRedirect(request.getContextPath()+"/list.re");	
				
				
			}
			}else { 				
			  request.setAttribute("errorMsg", "게시글 작성실패");
			  request.getRequestDispatcher("views/common/errorPage.jsp").forward(request,response);
			
		}
			
	
			
			
				// --------------------
					
					
			
			//첨부파일이 있을 경우 인증 list에서 썸네일을 보여주기 위해
			// 첫번째 선택된 첨부파일을 인증list의 썸네일로 지정한다
            // cc vo객체의 thumbnail에 담아서 보낸다
					

			
				
		
			// 썸네일있는지 여부에 따라 실행되는 sql문이 달라야하므로(위치홀더 개수가 
			// 여기서 판별하고 있는지 없는지에 따라 다른 메소드 호출
			// 리뷰를 insert한 후 user_like 컬럼에도 0으로 인서트 하기!!!!!!!!!
	
			
		
				
	}

		
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
