<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.highfive.challenge.model.vo.*" %>
<%@ page import="com.highfive.review.model.vo.*" %>
<%@ page import="com.highfive.certBoard.model.vo.*" %>

<%@ page import="java.util.ArrayList" %>
<%@ include file="../common/menubar2.jsp" %>


    
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
    
      	.img-area img {
		width: 150px;
		height: 150px;
		border-radius: 5%;
	}
	
    	.selectPhoto{
		align :center;			
		display: inline-block;
		margin right: 10px;
		border: 1px solid red;
		
	}
		
    	
     .myButton{ 
 		    background-color: #FFA500;
     		color: maroon;
     		padding: 5px 10px;
     		text-align: center;
     		text-decoration: none;
     		display: inline-block;
     		border-radius: 5px;
     		border : none;	
   	
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


	
</style>


</head>
<body>
	<div class="outer">
	<h2 align = "center"></h2>
	<br>

		<form action="<%=contextPath%>/insert.re" id="enroll-form" method="post" enctype="multipart/form-data">
			<table>
			<tr><td>
				<h4>리뷰를 작성할 챌린지</h4> 
				<h4><select id="selectChallenge" name="selectChallenge" onchange="changeEnrollForm();"></h4>
				</select>
				</td>
			<tr>			 
				<td width="70">	<h3 align = "left"><input type="text" name="reviewTitle" required value="리뷰 제목"></h3>
				</td>
			</tr>
		</table>
	<table id="detail-area">

			<tr>	
				<td  class="likeButton" >
					<div>카테고리
					</div>
				</td>

				<div>
					<td id="challCategory" width="200px"></td>
				</div>
			</tr>
			<tr>
					<td  class="likeButton" >
						<div>
							시작일  
						</div>
					</td>
					<td width="100" id="challStart"></td>
			</tr>
			<tr>
				<td  class="likeButton" >
						<div>종료일 
						</div>
					</td>
		
				<td width="70" id="challEnd"> </td>
			</tr>
			</table>
			<br><br>
			<table>	
			<tr>
			<td>
				<div class="certDetail"><h4>🎞사진 등록하기</h4><br>
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
	<br><br>
	<table>
		<tr>
				<td>					
					<h4><div class>글 작성하기</h4>
				</td>			
			</tr>		
			<tr>
				<td>
					<div class="selectText"> 		
						<textarea id="textContent" name="textContent" type="text" rows="20" cols="100"></textarea>
					</div>					
				</td>			
			</tr>	
	
			<tr>
				<td>
					<button type="submit" class="myButton">등록하기</button>		
				</td>			
			</tr>
	
			<tr>
				<td>
					<input type="hidden" name="userNo" value="<%=loginUser.getUserNo() %>" >
				</td>			
			</tr>
		<br>

		</table>
	</form>
		<br>
		<div align="center">
			<a href="<%=contextPath%>/list.re" class= "btn btn-sm  btn-primary">목록으로</a>
		</div>
	
	</div>
	
	<br><br><br>

	<script>
        function changeEnrollForm(){
			
			var challCategory = '';
			var challStart ='';
			var challEnd= '';

			$.ajax({
                url : 'changeEnrollForm.re',
                data : {
                    challNo : $('#selectChallenge').val()
                },
                
                success : function(c) {
                  console.log(c);      
				  console.log(c.challCategory);			
				 	var challCategory = c.challCategory; 
				 	
				    var challStart = c.challStart;
				    var challEnd =c.challEnd;
					

				   $('#challCategory').html(challCategory);
				   $('#challStart').html(challStart);
				   $('#challEnd').html(challEnd);
				
                },
                error : function() {
                    console.log('실패');
                }
            })
        }

        $(function() {
        		
        	$.ajax({
                url : 'enrollForm.re',
                data : {
                    userNo : <%=loginUser.getUserNo()%>
                },
                success : function(list) {
                
                	if(list.length!=0){	
		                console.log(list);		                		
	                    var challengeList = '';
	
								
							for(var i=0; i<list.length ; i++) {
								if(i==1){	
								
									challengeList += '<option selected value="'+list[i].challNo+'">' + list[i].challName + '</option>';
								
								} else {
									challengeList += '<option  value="'+list[i].challNo+'">' + list[i].challName + '</option>';
									  			      
								}
							}
						
							 $('#selectChallenge').html(challengeList);	  
					            
				           	 changeEnrollForm();
				            
							
							
							
		             } else {
		            	 
		            	 	 alert('후기작성 가능한 챌린지가 없습니다');
		            	 	 history.back();
						     challengeList += '<option selected>후기작성 가능한 챌린지가 없습니다</option>'
						    	 $('#selectChallenge').html(challengeList);	  
					 }	
		           	
		            
		           	
		            
					
				},
				
                error : function() {
                    console.log('실패');
                }
      		
			});



			$('.contentImg').attr('src', 'https://t4.ftcdn.net/jpg/05/17/53/57/240_F_517535712_q7f9QC9X6TQxWi6xYZZbMmw5cnLMr279.jpg');
		



        });



	
		
	
	
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
		
	