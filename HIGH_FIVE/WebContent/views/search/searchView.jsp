<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.ArrayList, com.highfive.crowdChallenge.model.vo.CrowdChallenge, com.highfive.challenge.model.vo.Challenge, com.highfive.review.model.vo.Review" %>

<% 
	ArrayList<Challenge> challengeList = (ArrayList<Challenge>)request.getAttribute("cList");
	ArrayList<CrowdChallenge> crowdList = (ArrayList<CrowdChallenge>)request.getAttribute("ccList");
	ArrayList<Review>  reviewList = (ArrayList<Review>)request.getAttribute("rList");
	String keyword = (String)request.getAttribute("keyword");
	int challCount = (int)(request.getAttribute("challCount"));
	int crowdCount = (int)(request.getAttribute("crowdCount"));
	int reviewCount = (int)(request.getAttribute("reviewCount"));
	int count = (int)(request.getAttribute("count"));
%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색</title>
<style>
 div p{
 	 overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
  width: 100px;
  height: 20px;
 }
 
 * {
  box-sizing: border-box;
}

.outer{
	width:1000px;
	margin:auto;
}


</style>
</head>
<body>

	<%@ include file="../common/menubar2.jsp" %>
	<div class="outer">
		<h2><%= keyword %>에 관련된 검색결과는 총<%=count%>건 입니다.</h2>
		<br><br>
				
		<div id="challCount">
			<div>
				<h3>챌린지 검색결과 <%=challCount%>개 </h3>
				<a href="<%=contextPath%>/search.cl?keyword=<%=keyword%>"> 더보기 </a>
				<hr>
				<div>
				<%if(challengeList == null) {%>
					<div>
						<p>검색된 챌린지가 없습니다.</p>
					</div>
				<%}else{ %>
					<%for( Challenge  cl : challengeList ) {%>
						<br><br>
						<div class="challengeList">
							<input type="hidden" value="<%=cl.getChallNo()%>">
							<div>
								<img id="ChallengeImg" src="<%= cl.getChallThumbnail() %>" style="width:50px; height:50px">			
							</div>
							<div>
								<h4><%= cl.getChallName()%></h4>
							</div>
							<div>
								<p><%= cl.getChallIntroduction()%></p>	
							</div>
						</div>
					<%} %>
				<%} %>
				</div>
			</div>
		</div>
		<br><br><br><br><br>
		
		<div id="crowdCount">
			<div>
				<h3>크라우드 챌린지 검색 결과<%=crowdCount%></h3>
				<a href="<%=contextPath%>/search.cc?keyword=<%=keyword%>"> 더보기 </a>
				<hr>
				<div>
					<%if(crowdList == null) {%>
						<div>
							<p>검색된 크라우드 챌린지가 없습니다</p>
						</div>
					<%}else{%>
						<%for(CrowdChallenge c : crowdList ) {%>
							<br><br>
							<div class="crowdList">
								<input type="hidden" value="<%=c.getCrowdNo()%>">
								<div>
									<img id="crowdImg" src="<%= c.getCrowdThumbnail() %>" style="width:50px; height:50px">			
								</div>
								<div>
									<h4><%= c.getCrowdName() %></h4>
								</div>
								<div>
									<p><%= c.getCrowdExp()%></p>	
								</div>
							</div>
						<%} %>
					<%} %>
				</div>
			</div>
		</div>
		<br><br><br><br><br>
		
		<div id="reviewCount">
			<div>
				<h3>후기 검색 결과<%=reviewCount %></h3>
				<a href="<%=contextPath%>/search.re?keyword=<%=keyword%>"> 더보기 </a>
				<hr>
				<div>
					<%if(reviewList == null) {%>
						<div>
							<p>검색된 후기가 없습니다.</p>
						</div>
					<%}else{ %>
						<%for(Review r : reviewList ) {%>
							<br><br>
							<div class="reviewList">
								<input type="hidden" value="<%=r.getReviewNo()%>">
								<input type="hidden" value="<%=r.getChallNo()%>">								
								<div>
									<img id="reviewImg" src="<%= r.getReviewThumbnail()%>" style="width:50px; height:50px">			
								</div>
								<div>
									<h4><%= r.getReviewTitle() %></h4>
								</div>
								<div>
									<p><%= r.getReviewContent()%></p>	
								</div>
							</div>
						<%} %>
					<%} %>
				</div>
			</div>
		</div>
		<br><br><br><br><br>
	
	
	
	</div>
	<script>
	$(function(){
   		
   		$(document).on('click', '.challengeList', function(){
   			
   			location.href = '<%=contextPath%>/detail.ch?cno='+ $(this).children().eq(0).val()
   						
   		});
   		
		$(document).on('click', '.crowdList', function(){
   			
   			location.href = '<%=contextPath%>/detail.cc?cno='+ $(this).children().eq(0).val()
   						
   		});
		
		$(document).on('click', '.reviewList', function(){
   			
   			location.href = '<%=contextPath%>/detail.re?cno='+ $(this).children().eq(0).val() + '&rno=' + $(this).children().eq(1).val()
   						
   		});
		
		
   	})
	
	</script>
	

</body>
</html>