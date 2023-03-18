<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.highfive.challenge.model.vo.Challenge, java.util.ArrayList, com.highfive.certBoard.model.vo.Attachment" %>
<%
	Challenge c = (Challenge)request.getAttribute("challenge");
	ArrayList<Attachment> list = (ArrayList<Attachment>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나는 챌린지 상세보기얌</title>
</head>
<script src="https://kit.fontawesome.com/aa839e973e.js" crossorigin="anonymous"></script>
<%@ include file="../common/menubar2.jsp" %>
<style>
    body { 
		width: 1200px;
		margin: auto;
	}

	.outer {
		margin : auto;
	}

    .info {
        background-color: rgb(225, 225, 225);
    }

    .profile img {
        width: 100px;
        height: 100px;
        border-radius: 50%;
    }

    .title {
        display: inline-flex;
    }

    .title i {
        color: tomato;
        padding-right: 20px;
    }

    .profile :hover {
        cursor: pointer;
    }

    .thumbnail img {
        width: 500px;
        height: 300px;
        border-radius: 5px;
    }

    .introduce i {
        color: steelblue;
    }

    .how-to i {
        color: lightslategray;
    }
    
    .photo-imgs {
        display: inline-flex;
    }

    .photo-imgs img {
        width: 300px;
        height: 200px;
        margin: 10px;
        border-radius: 5px;
    }

    .button-area {
        margin-right: 10px;
    }

	.red { color: red; }
	.orange { color: orange; }
	.yellow { color: yellow; }
	.green { color: green; }
	.blue { color: blue; }
	.navy { color: navy; }
	.purple { color: purple; }

	img {
		cursor: pointer;
	}
		
	#certTopList img{
	    width: 250px;
        height: 150px;
        border-radius: 5px;
		
		object-fit: cover;

	}

	   
	#myButtonDiv a{ 
     		text-decoration: none;
 		    background-color: aliceblue;
     		color: black;
     		padding: 15px;
     		text-align: center;
     		border-radius: 5px;
     		font-size: 20px;
   			display: inline-block;
   			margin:0 auto;
   			font-weight: bold;
   			 transition: 0.3;
    }
    
    	   
	#myButtonDiv a:hover{ 
			
   		font-weight: bold;
   		opacity : 0.5;
   		top: -10px;
   		font-style: italic;

    }
    
	
	
		
	
	 #certTopList tr {
	 
	  border-bottom: 1px dashed lightgray;
  	  valign: middle;
	 }
	 #certTopList div {
	 	
	 	height: 200px;
		display: table-cell; 
		vertical-align: middle;
		align:center;
		
			 	
	 }

	#moreCertDiv i:hover {
		cursor: pointer;
		color:red;
	
	
	}

	#certTopList {
		border-collapse: collapse;
		width : 1000px;
		border: none;
		font-size: 20px;
		transition: 1s;
		

	}
	 
	#certTopList tr:hover{
		cursor : pointer;
		background-color:#f3e9e9 !important;
		font-weight: bolder;
		font-size: 22px;
	
	}  
</style>

<body>	

	<div class="outer">
		<div class="header">
            <div class="title">
                <i class="fa-solid fa-fire fa-3x"></i>
				<h1><%= c.getChallName() %></h1>
                
                <% if(loginUser !=null ){ %>
					&nbsp;&nbsp;&nbsp;                  
	                <div id="myButtonDiv" style="display: flex; justify-content: center">
						<a href='enrollForm.ce?challNo=<%=c.getChallNo()%>'>📣인증하러 가기</a>
            		</div>
            	<%} %>
            	
            </div>

            <div class="profile" align="center" data-toggle="modal" data-target="#myModal">
                <img src="<%= contextPath %>/resources/profile_upfiles/<%= c.getProfile() %>">
                <p><%= c.getNickName() %></p>
            </div>

            <div class="info">  
                <p>
                    카테고리 : <%= c.getChallCategory() %><br>
                    인증빈도 : 주 <%= c.getChallFrequency() %>일 <br>
                    기간 : <%= c.getChallStart() %> ~ <%= c.getChallEnd() %>, 총<%= c.getChallDayCount() %>일<br>
                </p>
                <div class="how-to">
                    <p>
                        인증방법 : <%= c.getChallHowto() %><br>
                    </p>
                </div>
            </div>

            <div class="thumbnail" align="center">
                <img src="<%= c.getChallThumbnail() %>" onclick="window.open(this.src)">
            </div>
           
        </div>

		<hr>

		<div class="content">
			<div>
                <div class="title introduce">
                <i class="fa-solid fa-lightbulb fa-3x"></i><h1>챌린지 소개</h1>
                </div>
                <div>
                    <p><%= c.getChallIntroduction() %></p>
                </div>
            </div>

			<br><br>

			<div>
                <div class="title how-to">
                    <i class="fa-solid fa-circle-check fa-3x"></i><h1>이렇게 참여해요</h1>
                </div>
                <div>
                    <p><%= c.getChallHowto() %></p>
                </div>
            </div>

			<br><br>

			<div>
                <div class="title photo">
                    <i class="fa-solid fa-circle-info fa-3x"></i><h1>인증방법 예시</h1>
                </div>
                <br>
                <div align="center">
                    <div class="photo-imgs">
                        <% for(Attachment at : list) { %>			
							<img width="150" height="120" src="<%= at.getFilePath() %>" onclick="window.open(this.src)">
						<% } %>
					</div>
                </div>
                <br>
                <div>
                    <p><%= c.getChallPhothExp() %></p>
                </div>
            </div>

		</div>
		
		<hr>

		<br><br>
		<div class="footer">
			<div id="moreCertDiv">
				<h1>📋인증글 보기<i id="moreCert" class="fa-solid fa-circle-plus fas fa-sync fa-spin" style="color:#99ccff"></i></h1>
			</div>
			<br><br>
			<hr>
			<table id="certTopList">			
			
			
			</table>

		</div>



            <br><br>

            <div class="button-area" align="center">
		        <button class="btn btn-primary" id="enjoyButton" disabled onclick="enjoyChallenge();">참여하기</button>
				<% if(loginUser != null && c.getUserNo() == loginUser.getUserNo()) { %>
					<a class="btn btn-danger" id="enjoyButton" href="<%= contextPath %>/delete.ch?cno=<%= c.getChallNo() %>">삭제하기</a>
				<% } %>
			</div>
        </div>		
	</div>

	<% if(loginUser != null) {%>
		<input type="hidden" id="loginUserInput" value="<%= loginUser.getUserNo() %>">
	<% } else { %>
			<input type="hidden" id="loginUserInput" value="">
	
	<% } %>
	<!-- The Modal -->
	<div class="modal" id="myModal">
		<div class="modal-dialog modal-sm">
		<div class="modal-content">
	
			<!-- Modal Header -->
			<div class="modal-header">
				<%= c.getNickName() %>
			<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
	
			<!-- Modal body -->
			<div class="modal-body">
				<div style="display:flex; justify-content: space-around;">
					<img src="<%= contextPath %>/resources/profile_upfiles/<%= c.getProfile() %>" style="width:150px; height:150px;  border-radius: 50%;">
					<div>
						<p>에너지 등급</p>
						<i id="level-icon" class="fa-solid fa-bolt fa-5x" ></i>
					</div>
				</div>

				<br>

				<table class="table" id="challengeMadeUser">
					<thead align="center"> 
						<tr>
                            <th>참가중</th>
                            <th>완료</th>
                            <th>생성</th>
                        </tr>
					</thead>
					<tbody align="center">
						
					</tbody>
				</table>
			</div>
		</div>
		</div>
	</div>

	<!-- The Modal -->
	<div class="modal" id="passwordModal">
		<div class="modal-dialog modal-lg">
		<div class="modal-content">
	
			<!-- Modal Header -->
			<div class="modal-header">
			비공개 챌린지
			<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
	
			<!-- Modal body -->
			<div class="modal-body" align="center">
				비공개 챌린지 입니다. <br>
				참여를 위해서 비밀번호를 입력해주세요. <br><br>
				<input type="password" id="challPwd">
				<button id="pwdBtn" class="btn btn-primary">참여하기</button>
			</div>
		</div>
		</div>
	</div>

	<script>
		var loginUser = $('#loginUserInput').val();
		function move(certNo){
			console.log('sdsddsds');
			
			location.href= "<%=contextPath%>"+"/detail.ce?certNo="+certNo+"&challNo=<%=c.getChallNo()%>";
			//location.href="detail.ce&cno='+certList[i].certNo+'";
			
			
		}
		
		function enjoyCheck() {
			$.ajax({
				url : 'enjoyCheck.ch',
				data : {
					cno : '<%= c.getChallNo()%>',
					userNo : loginUser
				},
				type : 'get',
				success : function(result) {
		
					if(result.result == 0 && result.participant == true) {
						$('#enjoyButton').removeAttr('disabled');
					} else if(result.participant == false) {
						$('#enjoyButton').html('정원 초과');
						$('#enjoyButton').attr('disabled', true);	
					} else {
						$('#enjoyButton').html('참여중');
					}
				},
				error : function() {

				}
				
			});
		}

		function enjoyChallenge() {
			if('<%= c.getChallPublic() %>' == 'Y') {
				$.ajax({
					url : 'enjoy.ch',
					data : {
						cno : '<%= c.getChallNo()%>',
						userNo : loginUser
					},
					success : function(result) {
						if(result > 0) {
							alert('참여가 완료되었습니다!');
							$('#enjoyButton').attr('disabled', true);		
							location.reload();
						} else {
							alert('참여 실패!!');
						}
					},
					error : function() {

					}
				});
			} else {
				// 눌렀을 때 비밀번호 입력 모달
				$('#enjoyButton').attr('data-toggle', 'modal');
				$('#enjoyButton').attr('data-target', '#passwordModal');

				$('#pwdBtn').click(function() {
					// 이 안에서 다시 ajax? 
					$.ajax({
						url : 'enjoyPrivate.ch',
						data : {
							cno : '<%= c.getChallNo()%>',
							password : $('#challPwd').val()
						},
						success : function(result) {
							if(result == 1) {
								$.ajax({
									url : 'enjoy.ch',
									data : {
										cno : '<%= c.getChallNo()%>',
										userNo : loginUser
									},
									success : function(result) {
										if(result > 0) {
											// $('#enjoyButton').attr('disabled', true);						
											alert('참여가 완료되었습니다!');
											location.reload();
										} else {
											alert('참여 실패!!');
										}
									},
									error : function() {

									}
								});
							} else {
								alert('비밀번호가 틀렸습니다.');
							}
						},
						error : function() {

						}
					});
				});	
			}	
		}

		function madeByUser() {
			$.ajax({
				url : 'madeByUser.ch',
				data : {
					userNo : loginUser
				},
				success : function(result) {
					// 참가중 완료 생성

					var addHtml = ''
					addHtml += '<td>' + result.enjoyCount + '</td>'
							 + '<td>' + result.endCount + '</td>'
							 + '<td>' + result.madeCount + '</td>';
					$('#challengeMadeUser > tbody').html(addHtml);	
						
				},
				error : function() {

				}
			});
		}
		
		
		function certTopList(){
			$.ajax({
				url : 'topList.ce',
				data : {
					 cno : '<%= c.getChallNo() %>'
				},
				success : function(certList) {
				console.log(certList);
					
					// 참가중 완료 생성
					var result = '';
					
					for(var i=0; i<certList.length; i++){
		
	
						if(certList[i].certThumbnail != null) {
							result	+= '<tr onclick="move(' + certList[i].certNo + ')">'
								 + '<td width="25%" height ="100px" align="center"><div>' + certList[i].nickName + '</div></td>'
								 + '<td width="30%" ><div><img src="<%=contextPath%>/' + certList[i].certThumbnail+ '"></div></td>'
								 + '<td width="45%"><div>' + certList[i].certExp + '</div></td>'
							     +'<tr>'
							     + '<input type="hidden" name="clickCertChall" value="'+ certList[i].certNo +'">';
						} else {
							console.log('dd');
							result	+= '<tr onclick="move(' + certList[i].certNo + ')">'
								 + '<td width="10%" align="center"><div>' + certList[i].nickName + '</div></td>'
								 + '<td width="45%"><div><img src="<%=contextPath%>/' + certList[i].certThumbnail+ '"></div></td>'
								 + '<td width="45%"><div>' + certList[i].certExp + '</div></td>'
							     +'<tr>'
							     + '<input type="hidden" name="clickCertChall" value="'+ certList[i].certNo +'">';
						
						}
						
						
						
						
					}
						$('#certTopList').html(result);	
							
				},
				error : function() {

				}
			});
			
			
		}		
		
		<%-- $(function(){
			$(document).on('click', '.moveToDetail', function(){
				console.log($(this).children('input').val());
				var certNo= $(this).children('input').val();
				location.href= "<%=contextPath%>"+"/detail.ce?certNo="+certNo+"&challNo=<%=c.getChallNo()%>";
			})
		}) --%>
		

		
		
		
		
		$('#moreCert').click(function(){
			location.href= 	"<%=contextPath%>"+"/list.ce?challNo=<%=c.getChallNo()%>";

		});
		
	  
		
		$(function () {

			if(loginUser != '') {
				enjoyCheck();
				madeByUser();
			}
			

			certTopList();
			
			
			var level = '<%= c.getUserLevel() %>';
			switch(level) {
				case '1': $('#level-icon').addClass('red'); break;
				case '2': $('#level-icon').addClass('orange'); break;
				case '3': $('#level-icon').addClass('yellow'); break;
				case '4': $('#level-icon').addClass('green'); break;
				case '5': $('#level-icon').addClass('blue'); break;
				case '6': $('#level-icon').addClass('navy'); break;
				case '7': $('#level-icon').addClass('purple'); break;
			}
		});
		
	</script>

</body>
</html>