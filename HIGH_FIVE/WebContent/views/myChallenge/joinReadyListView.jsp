<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.highfive.challenge.model.vo.*" %>    
<%
	ArrayList<Challenge> joinReadyList = (ArrayList<Challenge>)request.getAttribute("joinReadyList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>참여 예정 챌린지~~~</title>

<%@ include file="../common/menubar2.jsp" %>
<style>
    body { 
		width: 1200px;
		margin: auto;
	}

	.outer {
		margin : auto;
	}

    .title-area {
        display: inline-flex;
        width: 100%;
    }

    .title-area p {
        margin-top: auto;
        margin-bottom: auto;
        margin-left: 12px;
        font-size: 18px;
    }

    .inline-flex {
        display: inline-flex;
    }

    .img-area img{
        width: 350px;
        height: 250px;
        margin-left: 10px;
        margin-right: 10px;
        border-radius: 5%;
    }

	.list-area {
		display: block;
	}

</style>
<script src="https://kit.fontawesome.com/aa839e973e.js" crossorigin="anonymous"></script>

</head>
<body>
	<div class="outer" align="center">

		<div class="title-area" align="left">
			<h1>참여예정 챌린지</h1>
			<p><%= joinReadyList.size() %> 건</p>
		</div>

        <div class="list-area">
			<% if(joinReadyList.size() == 0) { %>
				<p>참여예정 챌린지가 없습니다. </p>
			<% } else { %>
				<% for(int i = 0; i < joinReadyList.size(); i++ ) { %>
					<div class="content inline-flex">
						<a href="<%= contextPath %>/detail.ch?cno=<%= joinReadyList.get(i).getChallNo() %>">
							<div class="img-area">
								<img src="<%= joinReadyList.get(i).getChallThumbnail() %>">
							</div>
							<div class="content-text-area">
								<p align="center">
									<% if(joinReadyList.get(i).getChallPublic().equals("N")) { %> 
										<i class="fa-solid fa-lock"></i> 
									<% } %>
									<%= joinReadyList.get(i).getChallName() %>(<%= joinReadyList.get(i).getChallStart() %> ~ <%= joinReadyList.get(i).getChallEnd() %>)
								</p>
							</div>
						</a>
					</div>
					<% if(i % 3 == 2) { %>
						<br>
					<% } %>
				<% } %>
			<% } %>
		</div>
    </div>

</body>
</html>