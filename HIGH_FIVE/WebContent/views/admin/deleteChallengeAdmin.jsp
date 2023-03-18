<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.highfive.challenge.model.vo.Challenge, java.util.ArrayList" %>
<%
    String alertMsg = (String)session.getAttribute("alertMsg"); 
    String contextPath= request.getContextPath();
    
    // if문에서 member는 값을 받지만 challenge에는 받지않았다... member의 경우 loginUser를 session으로 받았기 때문
    // 반면 challenge는 session을 받지 않았기 때문에 challenge로 받을 수 없다.
    Challenge challenge = (Challenge)session.getAttribute("challenge");
    ArrayList<Challenge> challList = (ArrayList<Challenge>)request.getAttribute("challList");
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ManagingChallenge</title>
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
        width : 450px;
        height : 50px;
        text-align: center;
        background-color: rgb(215, 215, 215);
        font-weight: 500px;
        font-size: 30px;
    }
    .tbody > tr > td {
        width : 450px;
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
	<h1>ManagingChallenge</h1>
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
            <legend>챌린지 관리 &nbsp;&nbsp;&nbsp;</legend>
            <form action="firmUpDeleteChallenge" method="post">
            <table>
                <thead class="thead">
                    <tr>
                        <td>선택</td>
                        <td>챌린지 제목</td>
                        <td>닉네임</td>
                        <td>카테고리</td>
                        <td>등록일</td>
                    </tr>
                </thead>
                <br>	
                <tbody class="tbody">
                	<% if(challList == null) { %>
                		<tr>
                			<td>챌린지 목록이 없습니다.</td>
                		</tr>
                	<% } else { %>
						<% for(Challenge chall : challList) { %>
						<tr>	
	                        <td><input type="checkbox" name="restoreChallenges" value="<%= chall.getChallNo() %>"></td>
	                        <td><%= chall.getChallName() %></td>
	                        <td><%= chall.getNickName() %></td>
	                        <td><%= chall.getChallCategory() %></td>
	                        <td><%= chall.getChallPostDate() %></td>
	                    </tr>	
                    	<% } %>
                    <% } %> 
                </tbody>
            	</table>
            <br><br>
                <button type="submit" class="btn btn-primary">복구</button>
            </form>
    </div>
</body>
</html>