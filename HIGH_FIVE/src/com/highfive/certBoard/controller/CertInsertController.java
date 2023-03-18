package com.highfive.certBoard.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.highfive.certBoard.model.service.CertService;
import com.highfive.certBoard.model.vo.Attachment;
import com.highfive.certBoard.model.vo.CertChall;
import com.highfive.common.MyFileRenamePolicy;
import com.highfive.member.model.vo.Member;
import com.oreilly.servlet.MultipartRequest;


/**
 * Servlet implementation class CertInsertController
 */
@WebServlet("/insert.ce")
public class CertInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CertInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");	
		
		if(ServletFileUpload.isMultipartContent(request)) {
			// System.out.println("certInsertController: ismultipart블럭");
			int maxSize = (byte) 10*1024*1024; // 10 Mbyte
			HttpSession session = request.getSession();
			ServletContext application = session.getServletContext();

			String savePath = application.getRealPath("/resources/cert_upfiles");


			MultipartRequest multiRequest = new MultipartRequest(request, savePath,  maxSize, "UTF-8", new MyFileRenamePolicy());

			
			int challNo = Integer.parseInt(multiRequest.getParameter("challNo"));
			String certDate = multiRequest.getParameter("certDate");
			String certExp = multiRequest.getParameter("textContent");
			int userNo= Integer.parseInt(multiRequest.getParameter("userNo"));
		
						
			
			
			CertChall cc= new CertChall();
			cc.setUserNo(userNo);
			cc.setChallNo(challNo);
			cc.setCertExp(certExp);
			
						
			ArrayList<Attachment> list = new ArrayList();
			
			
			for(int i=1; i<=3; i++) {
				String key = "file"+i;
			
				if(multiRequest.getOriginalFileName(key) !=null) {
		
					Attachment at = new Attachment();
					at.setChallNo(challNo);
					at.setOriginName(multiRequest.getOriginalFileName(key));
					at.setChangeName(multiRequest.getFilesystemName(key));		
					at.setFilePath("resources/cert_upfiles/");
					list.add(at);
				}		
			}
			
			
			//첨부파일이 있을 경우 인증 list에서 썸네일을 보여주기 위해
			// 첫번째 선택된 첨부파일을 인증list의 썸네일로 지정한다
            // cc vo객체의 thumbnail에 담아서 보낸다
			if(!list.isEmpty()) {				
				String thumbnail = list.get(0).getFilePath()+"/"+list.get(0).getChangeName();
				cc.setCertThumbnail(thumbnail);
				
			}
					
		
			
		
				int result = new CertService().insertCert(cc, list);	
			
				if(result>0) {		
					//------------- DB에 어떻게 다녀올 것인가-----------------------
					// insert가 성공하면, session에 챌린지 관련 정보를 담은 후 -> listView에서 모달창을 보여줌		
					
					// 1) 챌린지 진행 및 인증현황: challenge-cert_chall
					// "선택된 챌린지" 필요 인증갯수, "선택된 챌린지" 나의 인증갯수
					HashMap<String, Integer> certProgress=	new CertService().selectCertProgress(userNo, challNo);

					// 2. member테이블 update필요여부 판단 
					// cert_chall테이블 userNo로 해당 유저의 전체 인증수  select
					int certTotal = new CertService().selectCertTotal(userNo);
					
					// 레벨 승급기준을 int형 배열에 담음
					int[] levelArr = {10,20,30,40,50,60};
					int updateMemberLevel = 0;
					int newLevel =0;	
					
					
					for(int i=0; i<levelArr.length ; i++) {
						
						if(levelArr[i]==certTotal) {
							// 만약에 레벨승급 기준과 해당 user의 현 시점 인증글 수가 일치한다면
							// member테이블에서 memlevel을 +1 update
							
							updateMemberLevel = new CertService().updateMemberLevel(userNo);							
												
						}				
						
					}
						if(updateMemberLevel>0) {
		
							
						// -------------view단으로 어떻게 값을 전달, 뿌려줄 것인가 -------------------	
							
						// 만약 레벨 수정에 성공했다면
						// loginUser의 정보는 session에 담아서 전 세션에서 사용 중인 상태이므로
						// loginUser객체의 멤버레벨을 나타내는 memLevel필드를 setter를 이용하여 수정
						// 수정 후 , loginUser객체를 session에서 뽑은 후, 업데이트된 loginUser로 overwrite 
													
							
						Member updatedLoginUser= (Member)(session.getAttribute("loginUser"));
						
						newLevel = updatedLoginUser.getUserLevel()+1;
						updatedLoginUser.setUserLevel(newLevel);	
						
						request.getSession().setAttribute("loginUser", updatedLoginUser);
						
						// 그리고 레벨승급했다는 ALERT창을 띄우고 sendRedirect해준다 
					
					}	
						
						
						request.getSession().setAttribute("certProgress", certProgress);
						request.getSession().setAttribute("newLevel", newLevel);
						response.sendRedirect(request.getContextPath()+"/list.ce?challNo="+challNo);
				} else { 				
					request.setAttribute("errorMsg", "게시글 작성실패");
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
