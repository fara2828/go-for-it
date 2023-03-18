<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@page import="com.highfive.certBoard.model.vo.*" %>
<%@page import="com.highfive.challenge.model.vo.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ include file="../common/menubar2.jsp" %>

    
<%
	Challenge c = (Challenge)request.getAttribute("c");	
	CertChall cc = (CertChall)request.getAttribute("cc");
   // 게시글 번호,카테고리명, 제목, 내용, 작성자 아이디, 작성일 
 	ArrayList<Attachment> challAtList  = (ArrayList<Attachment>)request.getAttribute("challAtList");
 	ArrayList<Attachment> certAtList  = (ArrayList<Attachment>)request.getAttribute("certAtList");
   	ArrayList<Challenge> cList = (ArrayList<Challenge>)request.getAttribute("cList"); 	  	
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인증상세페이지</title>
</head>
<script src="https://kit.fontawesome.com/aa839e973e.js" crossorigin="anonymous"></script>
<style>
	
   cert-area { 
   	
		width: 1000px;
		font-size: 20px;
		box-sizing: border-box;
		align:center;
		margin: auto;

	}

	.outer {
		width: 1200px;
		border: 1px dashed gray;
		margin : auto 10px;
		padding: 30px;		
		align:center;
		margin: auto;
	

	}
	
	.certExp>div {	
		align: left;
		display: inline-block;
		margin 10px;
		border: 1px solid red;

	}
	.certDetail {
	
	}
	.selectPhoto{
		align :center;			
		display: inline-block;
		margin right: 10px;
		border: 1px solid red;
		
	}

	.likeButton {
		display: inline-block;
        padding: 10px 10px;
        background-color:aliceblue;
		
        text-align: center;
        cursor: pointer;
        margin-right: 20px;
        border-radius: 5px;
        width: 150px;

	}
	
	.textBox{
		padding: 30px 30px;
		border: 10px 10px;
		margin: 20px 20px;
		background-color: lightgray;
		border-radius: 5px;
		align: left;
		width: 100%;
		height: 300%;
		

	
	}
	
	 th, td {

	padding-top: 10px;
    padding-bottom: 20px;
    padding-right: 40px;
    }
    
    table img {
    	margin: 20px;
    	border-radius: 5px;
    	width :350px;
    	height: 200px;
    
    }
    	
    	
     .myButton{ 
 		    background-color: #FFA500;
     		color: maroon;
     		padding: 5px 10px;
     		text-align: center;
     		text-decoration: none;
     		display: inline-block;
     		border-radius: 5px;
   	
    }
    	#myButtonDiv a:hover{ 
			
   		font-weight: bold;
   		opacity : 0.5;
   		top: -10px;
   		font-style: italic;

    }
    
    
    

</style>

<body>
<div class="cert-area">
	<div class="cert" width="1000px" align="center">
		<h1>🐱‍👤인증하기</h1>
	</div>
	<br>
	
	<form action="<%=contextPath%>/insert.ce" id="enroll-form" method="post" enctype="multipart/form-data">
		
		<%if(loginUser !=null){ %>
			<input type="hidden" id="loginUserNo" value="<%=loginUser.getUserNo()%>">		
		<% } else{ %>
			<input type="hidden" id="loginUserNo" value="">
		<% } %>	

		<div class="outer">
			<table>
				<tr>
					<td colspan="4">
						<div>
							<h1>📌<%=c.getChallName() %></h1>
						</div>
					</td>
				</tr>
				
				<tr>
					<td class="likeButton">
						<div>
							<%=c.getChallCategory()%>
						</div>
					</td>
					<td>
						주 <%=c.getChallFrequency()%> 회
					</td>
					<td>
					</td>	
				</tr>
				<tr>
					<td class="likeButton">			
						인증일자
					</td>
					<td>
					<%=cc.getCertDate()%>
					</td>
					<td>
					</td>				
				</tr>
				
				<tr>	
					<td class="likeButton">
						인증방법
					</td>
					<td colspan="2">
						<%=c.getChallHowto()%>
					</td>
							
				</tr>
		</table>
				
		<!--&& ATTACHMENT - SELECT문: 
		사용자가 선택한 챌린지 제목을 fk로 가지고 있는, 이미지 가져오기  -->
		
		<!-- && CHALLENGE -SELECT문: 
		사용자가 선택한 챌린지 제목으로 CHALLENGE_EXP가져오기
		 -->
	  <table>
		 		<tr>
					<td colpan="4">
					</td>
				</tr>
		 		<br><br>
		 		<tr>
					<td colpan="4">
						<h3 class="certDetail">🖌인증방법 예시</h3>					
					</td>						
				</tr>	
				<tr>
					<td colspan="3">		
						<div class="textBox" ><%=c.getChallPhothExp() %></div>
					<td>
				</tr>

					<!--select되는만큼 인증사진 / 예시 넣기..-->
				<% if (challAtList != null) { 
					 for ( Attachment challAt  : challAtList) {  %>								 
					<tr>	
						<td>
							<div class="challExpPhoto">					
								<img src="<%=challAt.getFilePath()%>">
							</div>
						</td>		
					</tr>
					<% } %>
				<% } %>						
				
				
				<tr>
					<td>
						<div class="certDetail"><h3>🎞인증사진</h3><br>
					</td>
				</tr>
				<tr>
					<td>	
						<% if (certAtList !=null) { 	
							for( Attachment certAt : certAtList) { %>
								<div class="certExp">
									<img src="<%=certAt.getFilePath()%>/<%=certAt.getChangeName()%>">
								</div>
											
							<% } %>
						<%} else {%>					
							<div><p>첨부파일이 존재하지 않습니다</p></div>
				   		<% } %>
					</td>	
				</tr>			
					<tr>
						<td>					
							<div class="certDetail"><h3>⌨인증글</h3>	
							</td>			
						</tr>		
					<tr>
						<td>
							<div class="textBox"> 		
								<%=cc.getCertExp() %>
							</div>					
						</td>			
					</tr>	
			
					<tr>
						<td>
							<a href="javascript:history.back();" class="myButton">뒤로가기</a>	
						</td>			
					</tr>	
			</table>
		</div>
	</form>



	<script>
	function loadImg(inputFile, num){
				
				
				if(inputFile.files.length ==1){
				
					 var reader = new FileReader();
					
					reader.readAsDataURL(inputFile.files[0]);
					 
					 reader.onload = function(e){
						 switch(num){
						case 1: 
							 $('#contentImg1').attr('src', e.target.result);
							 break;
						 case 2: 
							 $('#contentImg2').attr('src', e.target.result);
							 break;
						 case 3: 
							 $('#contentImg3').attr('src', e.target.result);
							 break;
						 
					 	}
						
					 }
				  } else {
					 switch(num){
					 case 1: 
						 $('#titleImg').attr('src', 'https://thumbs.dreamstime.com/b/no-image-available-icon-photo-camera-flat-vector-illustration-132483141.jpg');
						 break;
					 case 2: 
						 $('#contentImg1').attr('src', 'https://thumbs.dreamstime.com/b/no-image-available-icon-photo-camera-flat-vector-illustration-132483141.jpg');
						 break;
					 case 3: 
						 $('#contentImg2').attr('src', 'https://thumbs.dreamstime.com/b/no-image-available-icon-photo-camera-flat-vector-illustration-132483141.jpg');
						 break;
					 case 4: 
						 $('#contentImg3').attr('src', 'https://thumbs.dreamstime.com/b/no-image-available-icon-photo-camera-flat-vector-illustration-132483141.jpg');
						 break;
				 } 
				 
			}
	
		}
		
		
		
	
	
	</script>







</div>
</body>
</html>