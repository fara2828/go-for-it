<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.highfive.member.model.vo.Member, java.util.ArrayList" %>
<%
   String alertMsg = (String)session.getAttribute("alertMsg"); 
   Member member = (Member)session.getAttribute("loginUser");
   String contextPath= request.getContextPath();
   ArrayList<Member> mList = (ArrayList<Member>)request.getAttribute("mList");
   
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Management</title>
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
        .thead > tr > td {
            width : 250px;
            height : 50px;
            text-align: center;
            background-color: rgb(215, 215, 215);
            font-weight: 500px;
            font-size: 30px;
        }
        .tbody > tr > td {
            width : 250px;
            height : 30px;
            text-align: center;
            font-size : 20px;
        }
    </style>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<h1>ManagingMember</h1>
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
            <legend>탈퇴 회원관리 &nbsp;&nbsp;&nbsp;</legend>
            <form action="firmUpDeleteMember" method="post" id="firmUpDeleteMember">
            <table>
                <thead class="thead">
                    <tr>
                        <td>선택</td>
                        <td>회원번호</td>
                        <td>아이디</td>
                        <td>회원명</td>
                        <td>닉네임</td>
                        <td>이메일</td>
                        <td>등급</td>
                    </tr>
                </thead>
                <br>
                <tbody class="tbody">
                	<% if(member == null) { %>
                		탈퇴한 유저가 없습니다.
                	<% } else { %>
                		<% for(Member mem : mList) { %>
		                	<tr>
		                		<!-- input에서의 name은 상태 N인 회원 전체를, value는 그중에 체크한 getUserNo들을 전달하는 느낌 -->
		                        <td><input type="checkbox" name="dropUsers" value="<%= mem.getUserNo() %>"></td>
		                        <td><%= mem.getUserNo() %></td>
		                        <td><%= mem.getUserId() %></td>
		                        <td><%= mem.getUserName() %></td>
		                        <td><%= mem.getNickName() %></td>
		                        <td><%= mem.getEmail() %></td>
		                        <td><%= mem.getUserLevel() %></td>
		                    </tr>
		                 <% } %>
                	<% } %>
                </tbody>
            </table>
            <br><br>
                <button type="submit" class="btn btn-primary">회원탈퇴</button>
            </form>
    </div>	

</body>
</html>