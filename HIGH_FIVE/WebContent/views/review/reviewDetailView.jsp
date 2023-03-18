<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.highfive.challenge.model.vo.*" %>
<%@ page import="com.highfive.review.model.vo.*" %>
<%@ page import="com.highfive.certBoard.model.vo.*" %>

<%@ page import="java.util.ArrayList" %>
<%@ include file="../common/menubar2.jsp" %>
 <%
 	Challenge c = (Challenge)request.getAttribute("c");
	// 게시글 번호,카테고리명, 제목, 내용, 작성자 아이디, 작성일 
	Review r = (Review)request.getAttribute("r");
	ArrayList<Attachment> rAtList= (ArrayList<Attachment>)request.getAttribute("rAtList");
 	// 파일번호, 원본명, 수정명, 저장경로 
 	ArrayList<ReviewReply> rpList = (ArrayList<ReviewReply>)request.getAttribute("rpList");
 
 %>
 <script src="https://kit.fontawesome.com/aa839e973e.js" crossorigin="anonymous"></script>   
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
    padding-right: 20px;
    padding-left: 20px;
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
	
	.outer img{
		 width: 250px;
        height: 150px;
        border-radius: 5px;
		
		object-fit: cover;
	
	}
	
	#likeTable td{
		
		padding: 5px 5px 5px 5px
	
	}
	
	#reviewTable div {
		padding: 20px;
		width : 800px;
		height: 500px;
		background-color: #EAEAEA;
		border-radius: 5px;
	
	
	}
</style>


</head>
<body>
	<%if(loginUser !=null){ %>
		<input type="hidden" id="loginUserNo" value="<%=loginUser.getUserNo()%>">

	<% } else{ %>
		<input type="hidden" id="loginUserNo" value="">
	<% } %>	
	
	<h1 align = "left">&nbsp;&nbsp;✉<%=r.getReviewTitle()%></h1>
	<br>
	<div class="outer">
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
		<hr>
		</table>
		<table id="reviewTable">
			<hr>
			<tr>	
				<td><h3>리뷰내용</h3></td>
			</tr>
			<tr>
				<td style="padding:30px" colsapn="3">
					<div>
					<%=r.getReviewContent() %>
					</div>
				</td>
			</tr>
			<tr>
				<% if(r.getReviewThumbnail() !=null ) { %>
					<td><h3>상세이미지</h3></td>
			</tr>
			<tr>
					<td>
						<% for(int i=0; i<rAtList.size(); i++) {%>
					
							<img width="180" height="150" onclick="window.open(this.src);" src="<%=rAtList.get(i).getFilePath()%>/<%=rAtList.get(i).getChangeName() %>">
						<% } %>
					</td>
				<% } %>						
			</tr>

		<br>
				
		</table>
		
		<br>
		<div align="center">
			<a href="<%=contextPath%>/list.re" class= "likeButton">목록으로</a>
		<hr>
		<table align="left" id="likeTable">
			<tr id="likeAndCount">				
				<td id="myLikeTag">&nbsp;&nbsp;<i class="fa-regular fa-heart" onclick="updateLike();" style="color:red"></i></td>
				<td>좋아요&nbsp; </td>
				<td id="selectCountLike"></td>
				<td>&nbsp;&nbsp;조회수</td>
				<td id="selectCount">&nbsp;<%=r.getReviewCount() %></td>
			</tr>
		</table>	
		<br><br>			

	<!--로그인한 사용자고, 현재 이 게시글의 작성자의 경우에만 수정하기 버튼 활성화  -->
		<% if(loginUser !=null && loginUser.getUserNo()==r.getUserNo()){ %>
			<a href="<%=contextPath %>/updateEnrollForm.re?rno=<%=r.getReviewNo()%>&cno=<%=r.getChallNo() %>" class="myButton">수정하기</a>
			<a href="<%=contextPath %>/delete.re?rno=<%=r.getReviewNo()%>" class="myButton">삭제하기</a>
	
		<%} %>

	
		</div>
	
	</div>
	
	<br><br><br>
	<!-- 댓글창! 일단 화면만 -->
	<div id="reply-area" align="center">
		<table>
			<thead align="left">
				<% if(loginUser != null) {%>
				<tr>
					<th>댓글작성</th>
					<td width=60%>
						<textarea name="rCommentText" id="rCommentText" cols="50" rows="3" ></textarea>

					</td>
					<td colspan="2"><button class="myButton" onclick="insertReply();">댓글등록</button></td>

						
				</tr>

				<% } else { %>

				<tr>
					<th>댓글작성</th>
					<td>
						<textarea name="" cols="70" rows="3" style="resize:none;">로그인 후 이용가능한 서비스입니다.</textarea>

					</td>
					<td><button>댓글등록</button></td>
				</tr>

				<% }%>
			</thead>
			<tbody align="left">

			</tbody>	

		</table>
	</div>
	<br><br><br>
	<script>
		var loginUserNo = $('#loginUserNo').val();
		
		function selectReplyList(){
			$.ajax({

				url: 'rplist.re',
				data: {rno: <%=r.getReviewNo()%>},

				success: function(list){
					console.log(list);
					
					//console.log(result);
					//댓굴 개수만큼 반복 => 누적(문자열)					
					var result = '';
					for(var i in list){
						
						 if(loginUserNo !="" && list[i].userNo==loginUserNo){
							result += '<tr>'
								+ '<td>'+list[i].nickName +'</td>'
								+ '<td>'+list[i].rCommentText+'</td>'
								+ '<td>'+list[i].replyDate +'</td>'
								+ '<td><button class="myButton" onclick="deleteReply(this);">댓글삭제<input type="hidden" name="deleteReplyNo" value="'+list[i].rCommentNo+'"></button></td>'
								+ '</tr>'	
							
									
						 } else {
							result += '<tr>'
									+ '<td>'+list[i].nickName +'</td>'
									+ '<td>'+list[i].rCommentText+'</td>'
									+ '<td>&nbsp;&nbsp;&nbsp;'+list[i].replyDate +'</td>'
									+ '</tr>'		
						 }			
								

					}
					$('#reply-area tbody').html(result);
				},
				error: function(){
					console.log('댓글 읽어오기 실패');

				}				
			});
		};
	
	
		function insertReply(){
			$.ajax({
				url: 'rpinsert.re',
				
				data: {
					rno : '<%=r.getReviewNo() %>',
					userNo : loginUserNo,					
					rCommentText : $('#rCommentText').val()
					
				},
				type : 'post',
				success: function(result){
					if(result>0){
						alert('댓글작성에 성공하셨습니다');
						$('#rCommentText').val('');
						selectReplyList();
						
					}
				},
				error: function(){
					console.log('댓글작성 실패');
				}
			})			
		};
		
		function updateLike(){
			
			<% if(loginUser !=null){ %>
			
			$.ajax({
				url: 'updateLike.re',
				
				data: {
					rno : '<%=r.getReviewNo() %>',
					userNo : loginUserNo
				},
				type : 'post',
				success: function(result){
					console.log("좋아요클릭 성공")
					console.log(result);
					
					
					var countReviewLike = result[0]+'개';
					var myLikeYN = result[1];
					
					$('#selectCountLike').html(countReviewLike);
					
					var result = "";
					
					if(myLikeYN==1){
						
						result = '&nbsp;&nbsp;<i class="fa-solid fa-heart" onclick="updateLike();" style="color:red"></i>'
						
					} else {
						
						 result = '&nbsp;&nbsp;<i class="fa-regular fa-heart" onclick="updateLike();" style="color:red"></i>'
						
					}
				
					$('#myLikeTag').html(result);
					
					
				},
				error: function(){
					console.log('좋아요클릭 실패');
				}
			});
			

			
		<%} else {%>	
			
			alert("좋아요를 누르려면 로그인해주세요");
		
		<%} %>
		
		
		}
		
		function deleteReply(e){
			console.log(e);

			console.log(e.children[0].value);
			$.ajax({
				url: 'deleteReply.re',
				
				data: {
					rCommentNo : e.children[0].value,					
					userNo : loginUserNo
				
				},
				type : 'post',
				success: function(result){
					console.log("댓글삭제 성공")
	
					alert("댓글삭제 성공")
					selectReplyList();
					setInterval(selectReplyList, 1000);
				},
				error: function(){
					console.log('댓글삭제 실패');
				}
			});
		}
		
		
	$(function(){
			
			selectReplyList();
			setInterval(selectReplyList, 1000);
			// 1초마다 selectReplyList를 호출하게			
	<% if (loginUser !=null) {%>
		 	$.ajax({
                url : 'myLike.re',
                data : {
                	 rno :  <%=r.getReviewNo()%>,
                	 userNo : loginUserNo
                },
                success : function(myLikeYN) {
					console.log(myLikeYN)
					result = "";	
					if(myLikeYN==1){
						
						result = '&nbsp;&nbsp;<i class="fa-solid fa-heart" onclick="updateLike();" style="color:red"></i>'
						
					} else {
						
						 result = '&nbsp;&nbsp;<i class="fa-regular fa-heart" onclick="updateLike();" style="color:red"></i>'
						
					}
				
					$('#myLikeTag').html(result);
								
                	
                },
                error : function() {
                    console.log('실패');
                }
            });
		<% } %>	
			
        	$.ajax({
                url : 'selectLike.re',
                data : {
                	 rno :  <%=r.getReviewNo()%>,
                },
                success : function(result) {
					var countReviewLike = result+' 개';				
					
					$('#selectCountLike').html(countReviewLike);				
                	
                },
                error : function() {
                    console.log('실패');
                }
            })
            	
			
		});
		
	
	
	
		
	</script>
	