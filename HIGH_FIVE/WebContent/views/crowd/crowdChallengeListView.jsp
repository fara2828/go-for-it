
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    

<%@ page import="java.util.ArrayList, com.highfive.crowdChallenge.model.vo.CrowdChallenge" %>

<% 
	ArrayList<CrowdChallenge> list = (ArrayList<CrowdChallenge>)request.getAttribute("list"); 
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>크라우드 챌린지 리스트</title>
<style>
	* {
  box-sizing: border-box;
}

body {
  margin: 0;
  min-width: 992px;
  font-family: "Helvetica";
}

.navbar{
  height: 60px;
  padding-left: 30px;
}

.navbar li{
  list-style-type: none;
  float: left;
  margin-right: 30px;
}

.navbar a{
  text-decoration: none;
  color: black;
  font-style: bold;
  font-size: 13px;
}

.hero_header{
  height: 450px;
  width: 100%;
}

body h1{
  text-align: center;
  margin-top: 60px;
  margin-bottom: 60px;
  font-size: 24px;
  font-style: bold;
  color: #545454;
}

.outer{
	width:1000px;
	margin:auto;
}

.listOuter{
	display : flex; 
	margin: auto; 
	width : 1000px; 
	justify-content: space-between; 
	flex-wrap: wrap;
}

.titleOuter{
	display : flex; 
	margin: auto; 
	justify-content: center;

}

#goodIdeaBar {
		accent-color:red; 
		height: 25px;
}
	
#makeItBar{
		accent-color:green;
		height: 25px;
}

#crowdExp{
	background-color:rgb(166, 229, 253); 
	color:rgb(122, 121, 121); 
	border-radius : 5px; 
	width:80%;
	margin:auto;
}

</style>
<script src="https://kit.fontawesome.com/aa839e973e.js" crossorigin="anonymous"></script>
</head>
<body>
	
	<%@ include file="../common/menubar2.jsp" %>
	
	<div class="outer">
    
	    <div class="titleOuter">
	      <div style="display:inline-flex;">
	        <h1>당신의 의견으로 챌린지가 만들어집니다!</h1>
	      </div>
	     
	      <%if(loginUser != null) {%>
	        <div>
	          <a class="btn btn-sm btn-info" href="<%= contextPath %>/enrollForm.cc" style="margin-top : 60px"><i class="fa-sharp fa-solid fa-plus" style="color:skyblue"></i></a>
	        </div>
	        <%} %>
	      </div>
	      
	       <div id="crowdExp">
		      <p>
		      	<br>
		      	 &nbsp;&nbsp;챌린지를 생성하기 전,<br><br>
	
				 &nbsp;&nbsp;이런 주제로 챌린지를 만들어도 될까,<br>
				 &nbsp;&nbsp;이런 챌린지는 왜 없을까,<br>
				 &nbsp;&nbsp;궁금했나요?<br>
				 &nbsp;&nbsp;내가 만들긴 귀찮지만 누가 만들어줬으면 좋겠는 챌린지가 있나요?<br><br>
				
				
				 &nbsp;&nbsp;질문하고, 좋은 아이디어에 투표해주세요!<br>
				 &nbsp;&nbsp;매 주 "만들어주세요"가 가장 많은 챌린지는 운영팀에 의해 신규 생성 및 운영됩니다<br><br>
		      </p>
	      	</div>
      
      	<br><br>
	    <div  class="listOuter" >
	    <%if(list.isEmpty()) {%>
	    	등록된 클라우드 챌린지가 없습니다.
	    <%} else { %>
	    	<% for(CrowdChallenge c : list) {%>	
	    		<br><br>
			    <div class="crowdChallenge">
			    <input type="hidden" value="<%=c.getCrowdNo() %>">
			    <input type="hidden" id="cno" value="<%=c.getUserNo() %>">
	            <div style="overflow : hidden; border-radius:20px;">
	              <img  width="300" height="300" src="<%=c.getCrowdThumbnail()%>">
	            </div><br>
	            <div align="center">
	              <div><%=c.getCrowdName()%></div><br>
	              <div><i class="fa-regular fa-thumbs-up" style="color:gray;"></i>  &nbsp;굿아이디어 &nbsp; <%=c.getCrowdGoodIdea() %></div>
	              	<div>
						<progress id="goodIdeaBar" value="<%=c.getCrowdGoodIdea() %>" max="100"></progress>
					</div>
	              <div><i class="fa-regular fa-heart " style=color:gray;"></i> &nbsp;만들어주세요 &nbsp; <%=c.getCrowdMakeIt() %></div>
	              	<div>
						  <progress id="makeItBar" value="<%=c.getCrowdMakeIt() %>" max="100"></progress>
					</div>
	              </div>
			      <div class="clearfix"></div>
			    </div>
			    <br><br>
			 <%} %>   
	    <%} %>
	  </div>
	  <br><br><br><br><br><br><br><br>
  </div>
   <script>
   	$(function(){
   		
   		$(document).on('click', '.crowdChallenge', function(){
   			
   			location.href = '<%=contextPath%>/detail.cc?cno='+ $(this).children().eq(0).val()
   						
   		});
   	})
   
   </script>
    
    

</body>
</html>