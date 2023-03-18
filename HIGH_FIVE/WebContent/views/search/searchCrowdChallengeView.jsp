<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList, com.highfive.crowdChallenge.model.vo.CrowdChallenge" %>
<%
	ArrayList<CrowdChallenge> ccList  = (ArrayList<CrowdChallenge>)request.getAttribute("ccList");
	int ccCount = (int)request.getAttribute("ccCount");
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
		<h1><%=keyword%>에 관련 된 검색결과는 총<%=ccCount%>개 입니다.</h1>
		<hr>
		<br>
		
		<div class="searchChallenge">
			<%for(CrowdChallenge c : ccList) {%>
				<div class="crowdchallengeList">
				<input type="hidden" value="<%=c.getCrowdNo()%>">
				<br><br>
				<div>
					<img id="crowdChallengeImg" src="<%= c.getCrowdThumbnail() %>" style="width:50px; height:50px">	
				</div>
				<div>
					<h4><%= c.getCrowdName()%></h4>
				</div>
				<div>
					<p><% if(c.getCrowdExp().length() > 60){%>
						<%= c.getCrowdExp().substring(0, 60) %>...
					<% } else { %>
						<%= c.getCrowdExp() %>
					<% } %></p>	
				</div>
				</div>
			<%} %>
		</div>
		<br><br><br>
		
		<script>
		
		$(function(){
	   		
	   		$(document).on('click', '.crowdchallengeList', function(){
	   			
	   			location.href = '<%=contextPath%>/detail.cc?cno='+ $(this).children().eq(0).val()
	   						
	   		});
	   		
	   	})
		
		
		</script>
	
	
	
	
	
	
	</div>
	
	
</body>
</html>