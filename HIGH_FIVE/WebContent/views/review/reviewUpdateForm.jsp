<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.highfive.challenge.model.vo.*" %>
<%@ page import="com.highfive.review.model.vo.*" %>
<%@ page import="com.highfive.certBoard.model.vo.*" %>

<%@ page import="java.util.ArrayList" %>
<%@ include file="../common/menubar2.jsp" %>

 <%
 
	Review r=(Review)(request.getAttribute("r"));
	Challenge c =(Challenge)(request.getAttribute("c")); 
	ArrayList<Attachment> rAtList =(ArrayList<Attachment>)(request.getAttribute("rAtList")); 
	
	System.out.println(rAtList);
 %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세보기</title>
<style>
	

	body { 
		width: 1200px;
		margin: auto;
	
	}

	.outer {
		border: 1px dashed gray;
		margin : auto 10px;
		padding: 30px;
	

	}


	.list-area{
		text-align :center; 
		border : 1px solid white;
	}
	
	.list-area>tbody>tr:hover{
		cursor : pointer;
		background: darkgreen
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
		margin-right: 10px;
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
        font-weight: bolder;

	}
	
	.textBox{
		padding: 30px 30px;
		border: 10px 10px;
		margin: 20px 20px;
		background-color: lightgray;
		border-radius: 5px;
		align: left;
		width: 200%;
		height: 300%

	
	}
	
	 th, td {

	padding-top: 10px;
    padding-bottom: 20px;
    padding-right: 40pxx;
    }
    
    img {
    	border-radius: 5px;
    
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
    .likeButton {
        padding: 10px 10px;
        background-color:aliceblue;
		
        text-align: center;
        cursor: pointer;
        margin-right: 20px;
        border-radius: 5px;

	}
	#likeIcon{

	  -webkit-appearance: none;
	  -moz-appearance: none;
	  appearance: none;
	
	}
		.outer img{
		 width: 250px;
        height: 150px;
        border-radius: 5px;
		
		object-fit: cover;
	
	}
	
	
	.filebox .upload-name {
	   display: inline-block;
	   height: 40px;
	   padding: 0 10px;
	   vertical-align: middle;
	   border: 1px solid #dddddd;
	   width: 78%;
	   color: #999999;
	}
	
	.filebox label {
	    display: inline-block;
	    padding: 5px 10px;
	    color: #fff;
	    vertical-align: middle;
	    background-color: #999999;
	    cursor: pointer;
	    height: 40px;
	    margin-left: 10px;
	}
	.filebox input[type="file"] {
	    position: absolute;
	    width: 0;
	    height: 0;
	    padding: 0;
	    overflow: hidden;
	    border: 0;
	}

	.selectPhoto{
				align :center;			
		display: inline-block;
		margin right: 10px;
		border: 1px solid red;
		
	}
	.img-area img {
		width: 200px;
		height: 150px;
		border-radius: 5%;
		object-fit: cover;
	}
	
</style>


</head>
<body>


	<form action="<%=contextPath%>/update.re" id="update-form" method="post" enctype="multipart/form-data">
		<div class="outer" align="center">

			<input type="hidden" name="challNo" value="<%= r.getChallNo() %>"><br>
			<input type="hidden" name="reviewNo" value="<%= r.getReviewNo() %>"><br>
			
			<h3 align = "left">&nbsp;&nbsp;✉<input type="text" name="reviewTitle" required value="<%= r.getReviewTitle() %>"></h3>
			<br>
	
			<table id="detail-area" align="center" width="1100px">
				<tr>
					<td class="likeButton" width="20%">
						<div>
							참여 챌린지명
						</div> 
					</td>
					<td  width="80%"><%=c.getChallName() %></td>
				</tr>
				<tr >
					<td  class="likeButton" >
						<div>카테고리
						</div>
					</td>
					<td>
						<div>
							<%=c.getChallCategory()%>
						</div>
					</td>
				</tr>
				<tr>	
					<td  class="likeButton" >
						<div>
							시작일  
						</div>
					</td>
					<td><%=c.getChallStart()%></td>
				</tr>
				<tr>
					<td  class="likeButton" >
						<div>종료일 
						</div>
					 </td>
					<td><%=c.getChallEnd()%></td>
	
				</tr>
				<tr>
					<td  class="likeButton" >작성자</td>
					<td><%=r.getNickName() %></td>
				</tr>
				<tr>
					<td  class="likeButton" >작성일</td>
					<td><%=r.getReviewDate() %></td>
				</tr>
				<br>
				<hr>
			</table>
			<hr>
			<br>
			<div>
			<h3 align="left">✔리뷰내용</h3>
			<div align="left">
			<textarea name="textContent" required rows="10" cols="100"><%= r.getReviewContent() %></textarea>
			</div>
			</div>
			<br><hr><br>
			<h3 align="left">✔상세이미지</h3>
			<table id="img-area" align="center" width="1100px">		
			<tr>
					
						<% if(rAtList != null) { %>
							<% for(int i=0; i<rAtList.size(); i++){ %>
								
					
								<input type="hidden" name="originFileNo<%=i+1%>" value="<%= rAtList.get(i).getFileNo() %>">
								<input type="hidden" name="originFileName<%=i+1%>" value="<%= rAtList.get(i).getOriginName() %>">
					
							<% } %>
						<% } %>
					<% if(rAtList != null) { %>
						<% for(int i=0; i<rAtList.size(); i++){ %>
							<tr>
								<td>
									<div class="filebox">
								    	<input class="upload-name" id="upload-name<%=i+1%>" value="<%=rAtList.get(i).getOriginName() %>" >
								    	<label for="reUpfile<%=i+1%>">파일찾기</label> 
					
										<input type="file" name="reUpfile<%=i+1%>" id="reUpfile<%=i+1%>" onchange="loadImg(this,<%=i+1%>)">
								</div>
								</td>
								<td>
									<div class="img-area">
										<img width="150" height="120" id="contentImg<%=i+1%>" src="<%=rAtList.get(i).getFilePath()%>/<%=rAtList.get(i).getChangeName()%>">
									</div>	
								</td>
								
							</tr>
						<% } %>
						
						<% for (int i=rAtList.size(); i<3;i++){ %>
							<tr>
								<td>
									<div class="filebox">
								    	<input class="upload-name" id="upload-name<%=i+1%>" value="첨부파일" placeholder="첨부파일" >
								    	<label for="reUpfile<%=i+1%>">파일찾기</label> 						
										<input type="file" name="reUpfile<%=i+1%>" id="reUpfile<%=i+1%>" onchange="loadImg(this,<%=i+1%>)">
									</div>
								</td>
								<td>
									<div class="img-area">
										<img width="150" height="120" id="contentImg<%=i+1%>" src="">
									</td>
								</div>		
							</tr>
						<% } %>
					<% } else {%>
						<% for (int i=0; i<3;i++){ %>
							<tr>
								<td>
									<div class="filebox">
								    	<input class="upload-name" id="upload-name<%=i+1%>" value="첨부파일" placeholder="첨부파일" >
								    	<label for="reUpfile<%=i+1%>">파일찾기</label> 	
										<input type="file" name="reUpfile<%=i+1%>" id="reUpfile<%=i+1%>"></td>
									<td>
										<div class="img-area">
										<img width="150" height="120" id="contentImg<%=i+1%>" src="">
									</td>
								</div>
							</tr>		
						<% } %>
					<% } %>
			
						
						

				</table>

				<br>
				<div align="center">
					<button type="submit">수정하기</button>
					<button type="reset">취소하기</button>
				</div>
				
			<br>
					
					
			<br>
			<div align="center">
				<a href="<%=contextPath%>/list.re" class= "btn btn-sm  btn-primary">목록으로</a>				
			</div>
		
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
						 $('#titleImg').attr('src', 'https://t4.ftcdn.net/jpg/05/17/53/57/240_F_517535712_q7f9QC9X6TQxWi6xYZZbMmw5cnLMr279.jpg');
						 break;
					 case 2: 
						 $('#contentImg1').attr('src', 'https://t4.ftcdn.net/jpg/05/17/53/57/240_F_517535712_q7f9QC9X6TQxWi6xYZZbMmw5cnLMr279.jpg');
						 break;
					 case 3: 
						 $('#contentImg2').attr('src', 'https://t4.ftcdn.net/jpg/05/17/53/57/240_F_517535712_q7f9QC9X6TQxWi6xYZZbMmw5cnLMr279.jpg');
						 break;
					 case 4: 
						 $('#contentImg3').attr('src', 'https://t4.ftcdn.net/jpg/05/17/53/57/240_F_517535712_q7f9QC9X6TQxWi6xYZZbMmw5cnLMr279.jpg');
						 break;
				 } 
				 
			}
	
		}


			
		$("#file1").on('change',function(){
			var fileName1 = $("#file1").val();
			$("#upload-name1").val(fileName1);
		});
		
		$("#file2").on('change',function(){
			var fileName2 = $("#file2").val();
			$("#upload-name2").val(fileName2);
		});
		
		$("#file3").on('change',function(){
			var fileName3 = $("#file3").val();
			$("#upload-name3").val(fileName3);
		});
		
		
		
</script>
</body>

	