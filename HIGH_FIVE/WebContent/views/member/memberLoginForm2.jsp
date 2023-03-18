<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.highfive.member.model.vo.Member" %>
<% 
	String contextPath = request.getContextPath();
	String alertMsg = (String)session.getAttribute("alertMsg");
	//String userId = loginUser.getUserId();
	//String email = loginUser.getEmail();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberLoginForm</title>
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script> -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<style>
	.wrap {
		margin : auto;
		margin-top: 10%;
		margin-left : 40%;
	}

	.loginForm input {
		border-radius: 2%;
		width : 330px;
		height : 50px;
	}

	#logo {
		text-decoration : none;
		font-size : 50px;
		margin: auto;
		margin-left: 70px;
	}
	
	

</style>
</head>
<body>
	<script>
		var msg = '<%= alertMsg %>';
		if(msg != 'null'){
			alert(msg);
			<% session.removeAttribute("alertMsg"); %>
		}
	</script>
	
	<div class="wrap">
		<a href="<%= contextPath %>" id="logo">Go For It</a>
		<form action="/HIGH_FIVE/login.me" class="loginForm" method="post">
			<div>
			<br>
				<input type="text" class="input" name="userId" position="top" placeholder="아이디" required>
			</div>
			<div>
				<input type="password" class="input" name="userPwd" position="bottom" placeholder="비밀번호" required>
			</div>
			<button class="btn btn-primary" type="submit" style="width : 330px; height : 50px;">로그인</button>
			
		</form>

		<br><br>

		<div class="buttons">
		<button type="button" class="btn btn-info" onclick="forgetId();">아이디찾기</button>
		<button type="button" class="btn btn-info" onclick="forgetPwd();">비밀번호찾기</button>
		<button type="button" class="btn btn-info" onclick="enrollpage();">회원가입</button>
		</div>


		<script>		
			function forgetId(){
				location.href = "<%= contextPath %>/searchIdForm"
			}

			function forgetPwd(){
				location.href = "<%= contextPath %>/searchPwdForm"
			}


			function enrollpage(){
				location.href = "<%= contextPath %>/enrollForm"
			}
		</script>

	</div>







</body>
</html>