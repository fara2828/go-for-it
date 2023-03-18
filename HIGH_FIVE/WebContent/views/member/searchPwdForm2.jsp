<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.highfive.member.model.vo.Member" %>
<%
    String alertMsg = (String)session.getAttribute("alertMsg");
    Member loginUser = (Member)session.getAttribute("loginUser");
    String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>searchPwdForm</title>
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

	.inputWrap input {
		border-radius: 2%;
		width : 330px;
		height : 50px;
	}

	#logo {
        color : rgb(0, 122, 255);
		text-decoration : none;
		font-size : 45px;
		margin: auto;
		margin-left: 30px;
	}
	.font {
        font-size: 20px;
    }
	.gobacktomain {
        margin-left: 50px;
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
		<a id="logo">비밀번호 찾기</a>
		<form action="searchPwd" class="loginForm" method="post">
			<div class="inputWrap">
			<br><br>
				<input type="text" class="input" id="userId" name="userId" position="top" placeholder="아이디를 입력해주세요." required>
			</div>
            <br>
			<div class="inputWrap">
				<input type="email" class="input" id="email" name="email" position="bottom" placeholder="이메일주소를 입력해주세요." required>
			</div>
            <br>
			<button class="btn btn-primary font" type="submit" style="width : 330px; height : 50px;">비밀번호 찾기</button>
                
            <br><br><br><br>

            <div class="gobacktomain">
                <pre style="font-size : 15px;">메인으로 돌아가고싶으신가요?</pre>
                <a style="text-decoration: none; margin-left: 65px;" href="<%= contextPath %>/views/common/menubar2.jsp">돌아가기</a>
            </div>
		</form>



        
		<br><br>



</body>
</html>