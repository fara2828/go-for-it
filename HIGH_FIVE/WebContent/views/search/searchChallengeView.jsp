<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList, com.highfive.challenge.model.vo.Challenge" %>
<%
	ArrayList<Challenge> cList = (ArrayList<Challenge>)request.getAttribute("cList");
	int cCount = (int)request.getAttribute("cCount");
	String keyword = (String)request.getAttribute("keyword");

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.outer{
	width:1000px;
	margin:auto;
}
</style>
</head>
<body>

	<%@ include file="../common/menubar2.jsp" %>
	
	<div class="outer">
		<h1><%=keyword%>에 관련 된 검색결과는 총<%=cCount%>개 입니다.</h1>
		<hr>
		<br>
		
		<div class="searchChallenge">
			<%for(Challenge c : cList) {%>
				<div class="challengeList">
				<input type="hidden" value="<%=c.getChallNo()%>">
				<br><br>
				<div>
					<img id="ChallengeImg" src="<%= c.getChallThumbnail() %>" style="width:50px; height:50px">	
				</div>
				<div>
					<h4><%= c.getChallName()%></h4>
				</div>
				<div>
					<p><% if(c.getChallIntroduction().length() > 60){%>
						<%= c.getChallIntroduction().substring(0, 60) %>...
					<% } else { %>
						<%= c.getChallIntroduction() %>
					<% } %></p>	
				</div>
				</div>
			<%} %>
		</div>
		<br><br><br>
		
		<script>
		
		$(function(){
	   		
	   		$(document).on('click', '.challengeList', function(){
	   			
	   			location.href = '<%=contextPath%>/detail.ch?cno='+ $(this).children().eq(0).val()
	   						
	   		});
	   		
	   	})
		
		
		</script>
	
	
	
	
	
	
	</div>
	
	
</body>
</html>