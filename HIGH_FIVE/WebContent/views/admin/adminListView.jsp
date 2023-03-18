<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.highfive.member.model.vo.Member, java.util.ArrayList" %>
<%@ page import="com.highfive.challenge.model.vo.Challenge" %>
<%@ page import="com.highfive.contact.model.vo.Contact, com.highfive.member.model.vo.Member" %>
<%@ page import="com.highfive.faq.model.vo.Faq, com.highfive.notice.model.vo.Notice" %>
<%@ page import="com.highfive.crowdChallenge.model.vo.CrowdChallenge" %>
<%
   String alertMsg = (String)session.getAttribute("alertMsg"); //서비스 요청 전: alertmsg=null 요청 후 성공시: alertmsg=메시지문구
   Member loginUser = (Member)session.getAttribute("loginUser"); //로그인 전: null 후: menubar.jsp가 로딩될 때 로그인한 회원 정보
   Challenge challenge = (Challenge)session.getAttribute("challenge");
   String contextPath= request.getContextPath();
   ArrayList<Member> mList = (ArrayList<Member>)request.getAttribute("mList");
   ArrayList<Challenge> challList = (ArrayList<Challenge>)request.getAttribute("challList");
   ArrayList<Contact> conList = (ArrayList<Contact>)request.getAttribute("conList");
   ArrayList<Faq> faqList = (ArrayList<Faq>)request.getAttribute("faqList");
   ArrayList<Notice> noticeList = (ArrayList<Notice>)request.getAttribute("noticeList");
   ArrayList<CrowdChallenge> crowdList=(ArrayList<CrowdChallenge>)request.getAttribute("crowdList");
   ArrayList<Member> levelList=(ArrayList<Member>)request.getAttribute("levelList");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자</title>
    <style>
    	.logo {
    		font-size : 50px;
    	}
        #logout {
            font-size : 20px;
            margin-top: 10px;
            margin-left : 1200px;
        }
        #wrap {
            height: 1000px;
        }
        #header {
            width : 100%;
            height : 20%;
        }
        .title {
            font-size : 20px;
            margin-left: 500px;
        }
        .box {
            overflow : scroll;
            height : 100px;
            border : 1px solid rgb(155, 155, 155);
            width : 1200px;
        }



    </style>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<script>
		//script태그 안에서도 스크립틀릿 같은 jsp요소 사용가능
		var msg='<%=alertMsg%>'; //'메시지문구'/null
		
		if(msg !='null') {
			alert(msg);
			
			//session에 들어있는 alertMsg키 값에 대한 밸류를 지워야함
			//menubar.jsp가 로딩될 때마다 alert이 계속 뜰 것임
			<% session.removeAttribute("alertMsg"); %>
		}
	</script>
    <div id="wrap">
        <div id="header">
            <hr>
            <div align="center">
                <a href="<%= contextPath %>" class="logo">Go For It</a>
            </div>
            <div id="user-info">
                <div align="center">
                        <div id="logout">
                            <a href="<%= contextPath %>/logout">로그아웃</a>
                        </div>
                </div>
            </div>
        </div>
        <fieldset class="title">
            <legend>탈퇴 대기중인 회원 목록 &nbsp;&nbsp;&nbsp; <button class="btn btn-primary" onclick="deleteAdmin();">더보기</button></legend>
            <div class="box">
            	<% for(Member m : mList) { %>
            		<%= "번호 : " + m.getUserNo() + ",  아이디 : " + m.getUserId() + ",  이름 : " + m.getUserName() + ",  닉네임 : " + m.getNickName() %><br>
            	<% } %>
            </div>
        </fieldset>
        <fieldset class="title">
            <legend>탈퇴된 챌린지 관리 &nbsp;&nbsp;&nbsp; <button class="btn btn-primary" onclick="challengeListAdmin();">더보기</button></legend>
            <div class="box">
            <% if(challList == null) { %>
            	챌린지 목록이 비었습니다.
            <% } else { %>            
            	<% for(Challenge chall : challList) { %>
            		<%= "번호 : " + chall.getChallNo() + ",  챌린지이름 : " + chall.getChallName() + ",  등록일 : " + chall.getChallPostDate() %><br>
            	<% } %>
            <% } %>
            </div>
        </fieldset>
        <fieldset class="title">
            <legend>크라우드 챌린지 &nbsp;&nbsp;&nbsp; <button class="btn btn-primary" onclick="crowdChallAdmin();">더보기</button></legend>
            <div class="box"> 
            <% if(crowdList == null) { %>
            	크라우드챌린지 목록이 비었습니다.
            <% } else { %>            
            	<% for(CrowdChallenge crowd : crowdList) { %>
            		<%= "챌린지 제목 : " + crowd.getCrowdName() +", 카테고리 : " + crowd.getCrowdCategory() + ", 작성일 : " + crowd.getCrowdPostDate()  %><br>
            	<% } %>
            <% } %>                    
            </div>
        </fieldset>
        <fieldset class="title">
            <legend>1:1문의 &nbsp;&nbsp;&nbsp; <button class="btn btn-primary" onclick="contackAdmin();">더보기</button></legend>
            <div class="box">
            <% if(conList == null) { %>
            	1:1문의내역이 없습니다.
            <% } else { %>            
            	<% for(Contact contact : conList) { %>
            		<%= "문의번호 : " + contact.getContactNo() + ",  문의자 : " + contact.getUserName() + ",  답변완료 : " + contact.getAnswerYN() %><br>
            	<% } %>
            <% } %>    
        </fieldset>
        <fieldset class="title">
            <legend>FAQ &nbsp;&nbsp;&nbsp; <button class="btn btn-primary" onclick="faqAdmin();">더보기</button></legend>
            <div class="box">
            <% if(faqList == null) { %>
            	FAQ내역이 없습니다.
            <% } else { %>            
            	<% for(Faq faq : faqList) { %>
            		<%= "FAQ번호 : " + faq.getFaqNo() + ",  제목 : " + faq.getFaqTitle() + ",  등록일 : " + faq.getEnrollDate() + ",  작성여부 : " + faq.getStatus() %><br>
            	<% } %>
            <% } %>            
            </div>
        </fieldset>
        <fieldset class="title">
            <legend>공지사항 &nbsp;&nbsp;&nbsp; <button class="btn btn-primary" onclick="noticeAdmin();">더보기</button></legend>
            <div class="box">
            <% if(faqList == null) { %>
            	공지사항내역이 없습니다.
            <% } else { %>            
            	<% for(Notice notice : noticeList) { %>
            		<%= "공지사항 번호 : " + notice.getNo() + ",  종류 : " + notice.getKind() + ",  제목 : " + notice.getTitle() + ",  등록상태 : " + notice.getStatus() %><br>
            	<% } %>
            <% } %>              
            </div>
        </fieldset>
        <fieldset class="title">
            <legend>등급별 회원조회 &nbsp;&nbsp;&nbsp; <button class="btn btn-primary" onclick="selectUserLevelAdmin();">더보기</button></legend>
            <div class="box">
            <% for(Member level : levelList) { %>
            <%= " 아이디 : " + level.getUserId() + ", 닉네임 : " + level.getNickName()+ ", 등급 : " + level.getUserLevel() %><br>
            <% } %>            
            </div>
        </fieldset>
    </div>

    <script>
        function deleteAdmin(){
        	location.href = "<%= contextPath %>/deleteMemberAdmin"
        }
        function challengeListAdmin(){
            location.href = "<%= contextPath %>/deleteChallengeAdmin"
        }
        function crowdChallAdmin(){
            location.href = "<%= contextPath %>/crowdChallFormAdmin"
        }
        function contackAdmin(){
            location.href = "<%= contextPath %>/contactFormAdmin"
        }
        function faqAdmin(){
            location.href = "<%= contextPath %>/faqFormAdmin"
        }
        function noticeAdmin(){
            location.href = "<%= contextPath %>/noticeFormAdmin"
        }
        function selectUserLevelAdmin(){
            location.href = "<%= contextPath %>/selectMemberByLevel"
        }
    </script>



</body>
</html>