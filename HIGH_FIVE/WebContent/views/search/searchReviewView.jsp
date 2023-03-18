<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList, com.highfive.review.model.vo.Review" %>
<%
	ArrayList<Review> rList  = (ArrayList<Review>)request.getAttribute("rList");
	int rCount = (int)request.getAttribute("rCount");
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
		<h1><%=keyword%>에 관련 된 검색결과는 총<%=rCount%>개 입니다.</h1>
		<hr>
		<br>
		
		<div class="searchChallenge">
			<%for(Review r : rList) {%>
				<div class="reviewList">
					<input type="hidden" value="<%=r.getChallNo()%>">
					<input type="hidden" value="<%=r.getReviewNo()%>">
					<br><br>
					<div>
						<img id="reviewImg" src="<%= r.getReviewThumbnail() %>" style="width:50px; height:50px">	
					</div>
					<div>
						<h4><%= r.getReviewTitle()%></h4>
					</div>
					<div>
						<p><% if(r.getReviewContent().length() > 60){%>
							<%= r.getReviewContent().substring(0, 60) %>...
						<% } else { %>
							<%= r.getReviewContent() %>
						<% } %></p>	
					</div>
				</div>
			<%} %>
		</div>
		<br><br><br>
		
		<script>
		
		$(function(){
	   		
	   		$(document).on('click', '.reviewList', function(){
	   			
	   			location.href = '<%=contextPath%>/detail.re?cno='+ $(this).children().eq(0).val() + '&rno=' + $(this).children().eq(1).val()
	   						
	   		});
	   		
	   	})
		
		
		</script>
	
	
	
	
	
	
	</div>
	
	
</body>
</html>