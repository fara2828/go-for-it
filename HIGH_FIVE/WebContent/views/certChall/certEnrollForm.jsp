<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@page import="com.highfive.certBoard.model.vo.*" %>
<%@page import="com.highfive.challenge.model.vo.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ include file="../common/menubar2.jsp" %>

    
<%
	// 인증하기 게시판을 들어오려면 나의챌린지 -> 챌린지상세보기 -> 인증하러가기로 가야함
	// 따라서, 챌린지 상세보기에서  challNo를 가져온다
	// 일단 1이라고 가정하고 진행
	Challenge c = (Challenge)request.getAttribute("c");
   // 게시글 번호,카테고리명, 제목, 내용, 작성자 아이디, 작성일 
 	ArrayList<Attachment> challAtList  = (ArrayList<Attachment>)request.getAttribute("challAtList");
   	ArrayList<Challenge> cList = (ArrayList<Challenge>)request.getAttribute("cList");
   	int currChallNo =Integer.parseInt(request.getParameter("challNo"));
 
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<style>

	body { 
		width: 1200px;
		margin: auto;

		line-height: 200%;

	}

	.outer {
		margin : auto;
		border: 1px dashed gray;
		padding :20px;

	}


	* {
		  box-sizing: border-box;
	}
	

	.certExp>div {	
		align: left;
		display: inline-block;
		margin right: 10px;
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
	
		
	table {
	  width: 100%;
	
	}
	
	table {
		border-spacing; 30px;		
		padding : 10px
		
    }
	
	
	th, td {
		padding: 10px;
    }
    
    #certEnrollFrom {
    	padding: 30px;
    	margin: 20px
    
    }
    
    
	.textBox{
		padding: 10px 10px;
		border: 10px 10px;
		margin: 20px 20px;
		background-color: lightgray;
		border-radius: 5%;
		align: left;
		width: 100%;
		height: 200%;

	
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
	
	
	  .myButton{ 
 		    border: white;
 		    background-color: #FFA500;
     		color: maroon;
     		padding: 10px 15px;
     		text-align: center;
     		text-decoration: none;
     		display: inline-block;
     		border-radius: 5px;
   	
    }
    
    textarea {
	
    width: 1000px;
    height: 200px;
  	}
  	
  	. selectText{
  	
  	 margin-left: 20px;
  	
  	}
  	.img-area img {
		width: 200px;
		height: 150px;
		border-radius: 5%;
		object-fit: cover;
	}
	
</style>

<body>


<h1 align= "center">🗓챌린지 인증하기</h1>

<form action="<%=contextPath%>/insert.ce" id="enroll-form" method="post" enctype="multipart/form-data">
	<div class="outer" >
	<table id="certEnrollForm">
		<tr>			
			<td colspan="3">
				<h2>인증할 챌린지</h2>
			</td>
 <!--loginUser의 참여중 챌린지 모두 select해와서 whilte로 있는만큼 뿌리기  -->
		</tr>		
		<tr>
			<td colspan="3">
				<select name="challNo" id="challName" onchange="changeEnrollForm();">
				<% if (cList != null ){ %>
					<% for ( Challenge ch: cList) {%>	
						<% if(ch.getChallNo() == currChallNo) { %>
						<option selected value="<%=ch.getChallNo()%>"><%=ch.getChallName()%> </option>		
								
						<% } else { %>				
						<option value="<%=ch.getChallNo()%>"><%=ch.getChallName()%> </option>
						<% } %>
					<% } %>
				<% } else {  %>
						참여중인 챌린지가 없습니다	
						
				<% } %>		
				</select>
			</td>	
		</tr>	

		<tr>
			<td colspan="3">			
				<div class="certDetail">
					<h2>인증일자</h2>
				</div>
			</td>
		</tr>
		<tr>
			<td colspan="3">
					<input name="certDate" id="certDate" type="date" disabled>										 
			
			</td>				
		</tr>
		
		<tr>
		<tr>
		
		<script>
			document.getElementById('certDate').valueAsDate = new Date();
		</script>

		
			<br><br>
		<tr>	
			<td colspan="3">
			<div class="certDetail">
				<h2>인증하기</h2>
			</div>
			</td>
		</tr>	
		
<!--&& ATTACHMENT - SELECT문: 
사용자가 선택한 챌린지 제목을 fk로 가지고 있는, 이미지 가져오기  -->

<!-- && CHALLENGE -SELECT문: 
사용자가 선택한 챌린지 제목으로 CHALLENGE_EXP가져오기
 -->
<!--AJAXㄱㅏ즈아~!  --> 
		<tr>
			<td colpan="3">
				<div>✔챌린지 카테고리</div>
				<div class="textBox" id="certCategory"></div>
			</td>	
		</tr>	
		<tr>
			<td colpan="3">
				<div>✔인증방법</div>
				<div  class="textBox" id="certHowto"></div>
			</td>	
		</tr>	
			


 		<tr>
			<td colpan="3">
				<div class="certDetail">✔인증방법 예시<br></div>
				<div id="certExp"></div>
				<input type="hidden" id=certExpForCont>
			</td>	
		</tr>	
		
		</table>
		<div>
						<!--select되는만큼 인증사진 / 예시 넣기..-->
		<div id="certExpPhoto">
		</div>
		
		</div>
 				
		<tr>
			<td>
				<div class="certDetail">🎞사진 등록하기<br>
			</td>
		</tr>
		<tr>
			<td>
				<div class="filebox">
				    <input class="upload-name"  id="upload-name1" value="첨부파일" placeholder="첨부파일" >
				    <label for="file1">파일찾기</label> 
				    <input type="file" name="file1" id="file1" onchange="loadImg(this,1);">
				</div>
			</td>
			<td>
				<div class="img-area">
					<img src=""  class="contentImg" id="contentImg1">
				</div>
			</td>
		</tr>	

		<tr>
			<td>
	
				<div class="filebox">
				    <input class="upload-name"  id="upload-name2"  value="첨부파일" placeholder="첨부파일" ">
				    <label for="file2">파일찾기</label> 
				    <input type="file" name="file2" id="file2" onchange="loadImg(this,2);">
				</div>
				<td>
					<div class="img-area">
					<img src="" class="contentImg" id="contentImg2">
					</div>
				</td>
				
				
			</td>			
		</tr>	
	
		<tr>
			<td>
				<div class="filebox">
				    <input class="upload-name" id="upload-name3" value="첨부파일" placeholder="첨부파일" >
				    <label for="file3">파일찾기</label> 
				    <input type="file" name="file3"  id="file3" onchange="loadImg(this,3);">
				</div>
				<td>
					<div class="img-area">
					<img src="" class="contentImg" id="contentImg3">
					</div>
				</td>	
			</td>			
		</tr>
	</table>
	<table>
			<tr>
				<td>					
					<div class="certDetail">글 작성하기<br>		
				</td>			
			</tr>		
			<tr>
				<td>
					<div class="selectText"> 		
						<textarea id="textContent" name="textContent" type="text"></textarea>
					</div>					
				</td>			
			</tr>	
	
			<tr>
				<td>
					<div align="center">
					<button class="myButton" type="submit">등록하기</button>	
					<a class="myButton" href="javascript:history.back();">돌아가기</a>	
					</div>
				</td>			
			</tr>
	
			<tr>
				<td>
					<input type="hidden" name="userNo" value="<%=loginUser.getUserNo() %>" >
				</td>			
			</tr>
	</div>
	</table>	
	</form>
	</div>

	<script>

	function changeEnrollForm(){
		
		var changeChallNo =Number($('select[name=challNo] option:selected').val());
		console.log(changeChallNo);
		
		$.ajax({
			url: 'changeEnrollForm.ce', 
			data : {
				     challNo : changeChallNo 
					},
			
			success: function(challAtList){
				
				// challAtList마지막 인덱스에는 Challenge가,
				// 그 전 인덱스에는 Attachment가 들어있음
				
				console.log(challAtList);
				var certExpPhoto = '';
				
				
					if(challAtList.length-1>0){
						for(var i=0; i<(challAtList.length)-1; i++){
							certExpPhoto += 
									 '<td>'
									+ '<div class="challExpPhoto img-area">'
									+ '<img src="' + challAtList[i].filePath + '">'
									+ '</div>'
									+ '</td>';
						}
					}
					
					$('#certExpPhoto').html(certExpPhoto);
		
									
					
					var certExp = challAtList[challAtList.length-1].challPhothExp;

					$('#certExp').html(certExp);

					var certCategory = challAtList[challAtList.length-1].challCategory;

					$('#certCategory').html(certCategory);

					var certHowto = challAtList[challAtList.length-1].challHowto;

					$('#certHowto').html(certHowto);				
						
				},

			error: function(){
				console.log('참여중인 챌린지가 없습니다');				
			}			
		});
		
	};


	
	
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
		
	$(function(){
		
		
		
		<% if (cList.isEmpty()){ %>
				
			 alert('인증가능한 챌린지가 없습니다.');
			 location.href = history.back();
			 
		<% } else { %>
		 
			changeEnrollForm();
			
			$('.contentImg').attr('src', 'https://t4.ftcdn.net/jpg/05/17/53/57/240_F_517535712_q7f9QC9X6TQxWi6xYZZbMmw5cnLMr279.jpg');
		
		<%} %>
	});
	

	
	
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
</html>


