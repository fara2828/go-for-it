
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.ArrayList, com.highfive.crowdChallenge.model.vo.CrowdChallenge" %>

<% 
	CrowdChallenge c = (CrowdChallenge)request.getAttribute("c"); 
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>클라우드 챌린지 상세페이지</title>
<style>
	.outer{
		width:1000px;
		margin:auto;
		margin-top: 5px;

	}

	#reply-area>table{
		text-area : center;
		border : 1px solid lgintgray;
	}

	#title{
		font-size: large;
	}

	.crwodOngoing{
		background-color: rgb(176, 225, 246);
		width:80%;
		height:120px;
	}

	#crowdCategory{
		width:fit-content;
		background-color:skyblue;
		border-radius : 5px;
	}

	.secondBox{
		display: flex;
		flex-direction: row;
		justify-content: space-between; 
		align-items: center;
		width: 50%;
	}

	#crowdPeriod{
		width:fit-content;
		background-color:lightslategray;
		color: aliceblue;
		border-radius : 5px;
	}

	#goodIdeaBar {
		accent-color:red; 
		height: 25px;
		margin-top : 5px;
	}
	
	#makeItBar{
		accent-color:green;
		height: 25px;
		margin-top : 5px;
	}
	.ongoingArea p {
		margin-top : 5px;
		margin-bottom : 5px;
	}
	
	.crowdongoing{
		display : flex;
		flex-direction: row-reverse;
		align-items: center;
	}

	#titleImg{
		 width:70%; 
		 height:50%; 
	}
	
	#goodIdeabt{
	border : 0;
	outline : 0;
	background-color:transparent;
	}
	
	#makeItbt{
	border : 0;
	outline : 0;
	background-color:transparent;
	}
	
	#replybtn{
	border : 1px solid  rgb(184, 184, 184);
	outline : 0;
	background-color: rgb(184, 184, 184);
	color:white;
	}
	
	

</style>
</head>
<script src="https://kit.fontawesome.com/aa839e973e.js" crossorigin="anonymous"></script>
<body>
	<%@ include file="../common/menubar2.jsp" %>
		
		<%if(loginUser != null) {%>
			<input type="hidden" id="loginUserNo" value="<%= loginUser.getUserNo()%>">
		<%}else{ %>
			<input type="hidden" id="loginUserNo" value="">
		<%} %>
		
		<div class="outer" align="center">
			<div id="title"><!--제목-->
				<h2><%=c.getCrowdName()%></h2>
			</div><br>
			<div class="secondBox">
				<div>
					<div id="crowdCategory">&nbsp;<%=c.getCrowdCategory()%>&nbsp;<!--카테고리--></div><br>
					<div id="crowdPeriod">&nbsp;<%=c.getCrowdPeriod()%>주 동안&nbsp;<!--date--></div><br>
					<!-- 프로필 이미지 들어갈거임 -->
					<div><%=c.getNickName()%></div>
				</div><br>
			<%if(loginUser != null) {%>
				<div class="crwodOngoing" >
					<div>
						<div style="display:flex; justify-content: space-evenly; margin-top:15px;">
							<br>
							<div id="goodIdea" style="display : flex;" class="ongoingArea"><p><i class="fa-regular fa-thumbs-up" style="color:gray;"></i>&nbsp;굿아이디어</p>&nbsp; <p><%=c.getCrowdGoodIdea()%></p></div>
							<div style="display : flex;">
								<div>
									<progress id="goodIdeaBar" value="<%=c.getCrowdGoodIdea() %>" max="100"></progress>
								</div>
								<div>
									<button id="goodIdeabt"  type="button">👍</button>
								</div>
								
							</div>
						</div>
						<div style="display:flex; justify-content: space-evenly; margin-top:15px;">
							<div id="makeIt" style="display : flex;" class="ongoingArea"><p><i class="fa-regular fa-heart " style=color:gray;"></i>&nbsp;만들어주세요</p> &nbsp; <p><%=c.getCrowdMakeIt()%></p></div>
							<div style="display : flex;">
								<div>
									<progress id="makeItBar" value="<%=c.getCrowdMakeIt() %>" max="100"></progress>
								</div>
								<div>
									<button id="makeItbt"  type="button" style="margin-top : 3px;">❤</button>
								</div>
								
							</div>
						</div>
					</div>
				</div>
			<%} else {%>
				<div class="crwodOngoing" >
					<div>
						<div style="display:flex; justify-content: space-evenly; margin-top:15px;">
							<br>
							<div id="goodIdea" style="display : flex;" class="ongoingArea"><p><i class="fa-regular fa-thumbs-up" style="color:gray;"></i>&nbsp;굿아이디어</p>&nbsp; <p><%=c.getCrowdGoodIdea()%></p></div>
							<div>
								<progress id="goodIdeaBar"value="<%=c.getCrowdGoodIdea() %>" max="100" ></progress>
							</div>
						</div>
						<div style="display:flex; justify-content: space-evenly; margin-top:15px;">
							<div id="makeIt" style="display : flex;" class="ongoingArea"><p><i class="fa-regular fa-heart " style=color:gray;"></i>&nbsp;만들어주세요</p> &nbsp; <p><%=c.getCrowdMakeIt()%></p></div>
							<div>
								<progress id="makeItBar"value="<%=c.getCrowdMakeIt() %>" max="100"></progress>
							</div>
						</div>
					</div>
				</div>
			<%}%>
		</div>
		<br><br>
			<div>
				<img id="titleImg" src="<%= c.getCrowdThumbnail()%> " onclick="window.open(this.src);" style="border-radius:10px;">
			</div>
		<br>
		<hr>
		<br>
		
		<div>
		<h2><i class="fa-regular fa-comments" style="color:gray;"></i> 챌린지 아이디어!</h2>
		</div>
		<br><br>
		
		<div>
			<pre><%=c.getCrowdExp() %></pre>
		</div>
		<br><br>
		
		
		<div align="center">
			<a href="<%=contextPath%>/list.cc" class="btn btn-sm btn-info">목록</a>
			<%if(loginUser != null && loginUser.getUserNo() == c.getUserNo()) {%>
				<a href="<%=contextPath%>/delete.cc?cno=<%=c.getCrowdNo()%>"	class="btn btn-sm btn-danger">삭제하기</a>
			<%} %>
		</div>
		<br><br>
		
		<div>
			조회수 : <%=c.getCrowdCount() %>
		</div>
		
	</div>

	
	<br><br><br>
	
	<!--댓글창 !! 일단화면만-->

		<div id="reply-area" align="center" >
			<div>
			<table border="1" align="center">
				<thead >
					<%if(loginUser != null) {%>
					<!--로그인O-->
					<tr>
						<th>댓글작성</th>
						<td>
							<textarea name="" id="replyContent" cols="50" rows="3" style="resize: none;"></textarea>
						</td>
						<td colspan="2"><button id="replybtn" onclick='insertReply();'>댓글등록</button></td>
						<td id="replyCount"></td>
					</tr>
					<%} else {%>
					<!--로그인X-->
					<tr>
						<th colspan="2">댓글작성</th>
						<td>
							<textarea readonly cols="50" rows="3" style="resize: none;">로그인 후 이용가능한 서비스입니다.</textarea>
						</td>
						<td><button id="replybtn" >댓글등록</button></td>
						<td id="replyCount"></td>
					</tr>
					<% } %>
				</thead>
				<tbody>

				</tbody>
			</table>
			<br><br>
		</div>
		</div>
	<script>
		var loginUserNo = $('#loginUserNo').val();
		
		
		//댓글 목록
		function selectReplyList(){
			$.ajax({
				url:'rlist.cc',
				data : {cno : <%=c.getCrowdNo()%>},
				success:function(list){
					console.log(list);
					
					var result = '';
					
					for(var i in list){
						
						var userNo = list[i].userNo;
						var rNum = list[i].CrowdCommentNo;
						
						
						if(loginUserNo != ''){}
							if(loginUserNo != '' && userNo == loginUserNo){
								result += '<tr id="reply'+rNum+'">'
										+ '<input type="hidden" class="replyNo" value="'+list[i].CrowdCommentNo+'">'
										+ '<td>' + list[i].nickName +'</td>'
										+ '<td colspan="2">' + list[i].CrowdCommentText + '<button id="rdelete'+rNum+'" onclick="deleteReply(this);" style="border : 0; outline : 0; background-color:transparent; color:red;" >'+'X'+'</button>' + '</td>'
										+ '<td>' + list[i].crowdReplyDate + '</td>'
										+ '</tr>'
							
							}else {
								result += '<tr>'
										+ '<input type="hidden" class="replyNo" value="'+list[i].CrowdCommentNo+'">'
									    + '<td>' + list[i].nickName +'</td>'
									    + '<td colspan="2">' + list[i].CrowdCommentText + '</td>'
									    + '<td>' + list[i].crowdReplyDate + '</td>'
									    + '</tr>'
							}
					
					
					}
				
					$('#reply-area tbody').html(result);
				},
				error:function(){
					console.log('댓글 읽어오기 실패');
				}
			});
		};
		
		//댓글 갯수
		function replyCount(){
			$.ajax({
				url : 'rCount.cc',
				data : {
					cno : <%=c.getCrowdNo()%>
				},
				type : 'post',
				success : function(result){
					$('#replyCount').text(" 댓글 수: " + result);	
				},
				error:function(){
					console.log("실패");
				}
			});
		};
		
		//댓글 작성
		function insertReply(){
			$.ajax({
				url : 'rinsert.cc',
				data : {
					cno : <%=c.getCrowdNo()%>,
					content : $('#replyContent').val()	
				},
				type: 'post',
				success : function(result){
					
					$('#replyContent').val('');
					
					selectReplyList();
				},
				error : function(){
					console.log('댓글작성실패요');
				}
				
			})
		};
		
		//댓글 삭제
		function deleteReply(e){
			
			$.ajax({
				url : 'rdelete.cc',
				data: {
					cno : <%= c.getCrowdNo()%>,
					userNo : loginUserNo,
					replyNo : e.parentNode.previousSibling.previousSibling.value
				},
				type:'post',
				success : function(result){
					if(result > 0){
						selectReplyList();
						
						alert("댓글이 삭제 되었습니다.");
						
					}
					
				},
				error : function(){
					console.log('댓글삭제실패');
				}
			
			})
			
		};
		
		
		$(function(){
			
			selectReplyList();
			replyCount();
			
			setInterval(function(){
				selectReplyList();
				replyCount();
			},1000);
			
			console.log(<%=c.getCrowdCount() %>);
			
			//굿아이디어 버튼
			$('#goodIdeabt').click(function(){
			
				$.ajax({
					url : 'goodidea.cc',
					data : {cno : <%=c.getCrowdNo()%>,
						    userNo : loginUserNo
							},
					type : 'post',
					success : function(result){
						console.log(result);
						 
						$('#goodIdea').text('굿아이디어 '+result);
						
						$('#goodIdeaBar').val(result);
					},
					error:{
						
					}
					
				})
				
			});
			
			//만들어주세요 버튼
			$('#makeItbt').click(function(){
				
				$.ajax({
					url : 'makeit.cc',
					data : {cno : <%=c.getCrowdNo()%>,
						    userNo : loginUserNo
							},
					type : 'post',
					success : function(result){
						 
						$('#makeIt').text('만들어주세요 '+result);
						
						$('#makeItBar').val(result);
					},
					error:{
						
					}
					
				})
				
			});
			
		})
			
		
		
	</script>

	

</body>
</html>