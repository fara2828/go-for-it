<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.highfive.member.model.vo.Member, java.util.ArrayList, com.highfive.challenge.model.vo.Challenge" %>
<%
   String alertMsg = (String)session.getAttribute("alertMsg"); //서비스 요청 전: alertmsg=null 요청 후 성공시: alertmsg=메시지문구

   Member loginUser = (Member)session.getAttribute("loginUser"); //로그인 전: null 후: menubar.jsp가 로딩될 때 로그인한 회원 정보

   String contextPath = request.getContextPath();

   String confirmMsg = (String)session.getAttribute("confirmMsg"); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>메인 화면</title>

<style>
    .wrap {
        width : 1000px;
        height: 150px;
        margin : auto;
    }
    
    .wrap >div {
        width: 100%;
    }
    
    #header > div {
        height : 40px;
        float : left;
    }
    
    #header_1 { 
        width : 20%; 
        font-size: 200%;
        margin : auto;
        margin-top : 20px;
        
        text-align : center;
    }
    #header_2 { 
        width : 50%;
        margin-top : 30px;
    }
    #header_3 { 
        width : 30%;
        margin-top : 20px; 
    }
    
    /* 검색창 위치 조절*/
    
    #search_form {
        margin-left : 100px;
    }
    #search_form > div {
        
        float : left;            
    }
    
    
    /*프로필 사진 동그라미*/
    .box {
        width: 50px;
        height: 50px; 
        border-radius: 70%;
        overflow: hidden;
    }
    .profile {
        width: 100%;
        height: 100%;
        object-fit: cover;
    }
    
    /*navi area부분*/
    .nav-area > .menu {
        display : table-cell;
        height : 50px;
        width : 25%;
        float: left;
        font-size: 120%;
    }
    
    .login-area >div {
        float: left;
    }
    
    </style>

<!-- jQuery -->
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script> -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<link href="css/style.css" rel="stylesheet">

</head>
<body>
    
	<% if(loginUser != null) { %>
    	<input type="hidden" value="<%= loginUser.getUserType() %>" id="userType">
    <% } %>
    
    
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
	
	<script>
		var confirmMsg = '<%= confirmMsg %>'; 
		
		var userType = $('#userType').val();
		
		if(confirmMsg != 'null' && userType == 'U') {
			if(confirm(confirmMsg)) {
				
				location.href = '<%= contextPath %>' + '/joinNowDetail.ch';
			}

			<% session.removeAttribute("confirmMsg"); %>
		}
	</script>
	
    <div class="wrap">

        <!-- header -->
        <div id="header">
            <div id="header_1">
                <a href="<%= contextPath %>" id="logo">Go For It</a>
            </div>
            <div id="header_2">
                <form action="<%=contextPath%>/search.do" id="search_form">
                    <div id="search_text">
                        <input type="text" name="query" style="width: 300px;">
                    </div>
                    <div id="search_btn">
                        <input type="submit" value="검색">
                    </div>
                </form>
            </div>
            <div id="header_3" class="login-area">
                <% if(loginUser == null) { %> 
                <!-- before login -->               
                    <button type="button" class="btn btn-primary" onclick="loginPage();">로그인</button>
                    <button type="button" class="btn btn-primary" onclick="enrollpage();">회원가입</button>
                    <button type="button" class="btn btn-primary" onclick="qnaCenter();">고객센터</button>
                    
                <% } else { %>
                    <!-- after login -->         
 					<div class="box" style="background: #BDBDBD;">
                       <% if(loginUser.getProfile() == null) { %>   
                            <img class="profile" src="https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__340.png" onerror="this.onerror=null; this.src='https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__340.png';">  
                        <% } else { %>
                            <img class="profile" src="<%= contextPath %>/resources/profile_upfiles/<%= loginUser.getProfile() %>" onerror="this.onerror=null; this.src='https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__340.png';">
                        <% } %>
                    </div>
                    <div id="user-info">
                        <div align="center">
                            <b><%= loginUser.getNickName() %></b>님 환영합니다. <br>
                           <% if (loginUser.getUserType().equals("A")){ %>
                           		<a href="<%= contextPath %>/adminPage">관리자페이지</a>
								<a href="<%= contextPath %>/logout">로그아웃</a>
                           <%} else {%>
                            	<a href="<%= contextPath %>/myPage.me">마이페이지</a>
                            	<a href="<%= contextPath %>/logout">로그아웃</a>
                            	<a href="<%= contextPath %>/faq">고객센터</a>
							<%} %>
                        </div>
                    </div>
                <% } %>
                
            <br clear="both">
                
            </div>
       
                <script>
                    function loginPage(){
                        location.href = "<%= contextPath %>/loginForm"
                    }
                    
                    function enrollpage(){
                        location.href = "<%= contextPath %>/enrollForm"
                    }

                    function qnaCenter(){
                        location.href = "<%= contextPath %>/faq"
                    }
                </script>
        </div>

        <br><br>
        <br clear="both">
        <!-- navi-area -->
        <% if(loginUser != null) { %> 
	       
	        <div class="nav-area" align="center">
	            <div class="menu"><a href="<%= contextPath %>/myList.ch">나의챌린지</a></div>
	            <!-- 11.10 2번째강의 - 회원가입기능만들것(WebContent의 views의 member에 memberEnrollForm 파일로이동 -->
	            <div class="menu"><a href="<%= contextPath %>/list.ch">챌린지</a></div>
	            <div class="menu"><a href="<%= contextPath %>/list.re">후기게시판</a></div>
	            <!-- a태그요청 -> get방식 -->
	            <div class="menu"><a href="<%=contextPath%>/list.cc">크라우드캠페인</a></div>
	        </div>
	        <br clear="both">
	 
        <% } else { %>
        	<div class="nav-area" align="center">
	            <div class="menu"><a onclick="notLogin();" href="#">나의챌린지</a></div>
	            <!-- 11.10 2번째강의 - 회원가입기능만들것(WebContent의 views의 member에 memberEnrollForm 파일로이동 -->
	            <div class="menu"><a href="<%= contextPath %>/list.ch">챌린지</a></div>
	            <div class="menu"><a href="<%= contextPath %>/list.re">후기게시판</a></div>
	            <!-- a태그요청 -> get방식 -->
	            <div class="menu"><a href="<%=contextPath%>/list.cc">크라우드캠페인</a></div>
	        </div>
	        <br clear="both">
        <% } %>
    </div>
    <script>
        function notLogin() {
            alert('로그인 후 이용가능합니다!');
        }
    </script>

</body>
</html>