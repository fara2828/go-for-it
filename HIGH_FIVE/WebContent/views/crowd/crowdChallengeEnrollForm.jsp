<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>클라우드 챌린지 생성하기</title>
<style>
	.outer{
		width:1000px;
		margin:auto;
		margin-top: 5px;
	}

	<!--
	#enroll-form input, #enroll-form textarea{ 
		width: 100%;
	}
	-->
	#enroll-form>table{
		border : 1px solid darkgreen;
	}
	
	#modalbtn{
		display:none;
	}
	
</style>
<script src="https://kit.fontawesome.com/aa839e973e.js" crossorigin="anonymous"></script>
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<%@ include file="../common/menubar2.jsp" %>
	
	<div class="outer">
	
	<br>
	<h2 align="center">크라우드 챌린지 생성하기</h2>
	<br>
	
	<form action="<%=contextPath%>/insert.cc" id="enroll-form" method="POST" enctype="multipart/form-data">
	
		<!-- 챌린지 카테고리, 제목, 인증 빈도, 챌린지 기간, 인증 방법, 썸네일 사진, 챌린지 아이디어 소개, 등록하기 버튼 -->
		<!-- 작성자의 회원번호를 hidden으로 같이 넘겨서 테이블에 INSERT하게 만든다. -->
			<input type="hidden" name="userNo" value="<%=loginUser.getUserNo() %>" >
			
				<div>
				<h4>카테고리<i class="fa-solid fa-check" style="color:tomato;"></i></h4>
					<select id="category" name="category" required>
						<option>루틴만들기</option>
						<option>스터디</option>
						<option>외국어</option>
						<option>운동</option>
						<option>멘탈케어</option>
						<option>헬스케어</option>
						<option>취미</option>
						<option>기타</option>
					</select>
				</div>
				
				<br>
				<hr>
				
				<div>
				<h4>제목<i class="fa-solid fa-check" style="color:tomato;"></i></h4>
				<input id="title" type="text" name="title" required>
				</div>
				
				<br>
				<hr>
				
				<div>
				<h4>챌린지 기간<i class="fa-solid fa-check" style="color:tomato;"></i></h4>
					<select id="period" width="150" name="period">챌린지 기간
						<option value="1" selected>1주 동안</option>
						<option value="2">2주 동안</option>
						<option value="3">3주 동안</option>
						<option value="4">4주 동안</option>
						<option value="5">5주 동안</option>
						<option value="6">6주 동안</option>
						<option value="7">7주 동안</option>
						<option value="8">8주 동안</option>
					</select>	
				</div>
				
				<br>
				<hr>
				
				<div>
				<h4>챌린지 소개<i class="fa-solid fa-check" style="color:tomato;"></i></h4>
				<textarea id="content" name="content" id="30" cols="30" rows="20" style="resize:none;" required 
				placeholder="
				챌린지 인증 방법을 작성해주세요
				ex) 오늘 날짜와 걸음 수가 적힌 만보기 캡쳐 화면 업로드
				
				-챌린지가 시작되면 인증 방법을 수정할 수 없습니다. 신중히 작성해주세요.
				-참가자들이 혼란을 겪지 않도록 정확한 기준과 구체적인 인증방법을 적어주세요.
				-유저 챌린지에서 발생한 분쟁은 Go for It!이 관여하지 않습니다."></textarea>
				</div>
				
				<br>
				<hr>
				
				<h4>클라우드 캠페인 소개사진<i class="fa-solid fa-check" style="color:tomato;"></i></h4>
					<div>
						<img id="thumbnailImg" width="250" height="180">
					</div>
				<br>
				<hr>
				
				<div id="file-area">
						<input id="thumbnail" type="file" name="thumbnail" id="thumbnail" required onchange="loadImg(this);">
				</div>
				
				<br>
				<hr>
				
				<div align="center">
						<button id="btn1" type="submit" data-toggle="modal" data-target="#myModal">생성하기</button>
						<button type="reset">취소하기</button>
				</div>
				
				
				<div class="container">
					
					<button id="modalbtn" type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
				    	Open modal
				  	</button>
					
					<!-- The Modal -->
					  <div class="modal fade" id="myModal">
					    <div class="modal-dialog modal-sm">
					      <div class="modal-content">
					      
					        <!-- Modal Header -->
					        <div class="modal-header">
					          <h4 class="modal-title">X</h4>
					          <button type="button" class="close" data-dismiss="modal">&times;</button>
					        </div>
					        
					        <!-- Modal body -->
					        <div class="modal-body">
					          	입력하지 않은 사항을 확인해주세요.
					        </div>
					        
					        <!-- Modal footer -->
					        <div class="modal-footer">
					          <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
					        </div>
					        
					      </div>
					    </div>
					  </div>
				  
				</div>
				
				
		</form>
		
		<script>
		
			$(function(){
				$('#file-area').hide();
				
				$('#thumbnailImg').attr('src', 'data:image/png;base64,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');
				
				$('#thumbnailImg').click(function(){
					$('#thumbnail').click();
				});
				
				
				$('#btn1').click(function(){
					
					if($('#category').val()=="" || $('#title').val() ==""|| $('#period').val()==""||$('#content').val()==""||$('#thumbnail').val()==""){
						
						$('modalbtn').click();
					}
				});
				
			
			});
			
			function loadImg(inputFile){
				
				if(inputFile.files.length == 1){ //파일이 첨부되어있다.
					
					//file속성 : 업로드된 파일의 정보들을 배열형식으로 여러개 묶어서 반환..
					//선택된 파일을 읽어들여서 영역에 맞는 미리보기
					
					//파일을 읽어들일 FileReader객체 생성
					var reader = new FileReader(); //자바 스크립트의 생성자 함수
					
					//FileReader객체로부터 파일을 읽어들이는 메소드 호출
					//인자값으로 전달해줌.....
					reader.readAsDataURL(inputFile.files[0]);
					
					//파일 읽기가 완료되면 실행할 함수를 정의
					reader.onload = function(e){
						$('#thumbnailImg').attr('src', e.target.result);
					}
					
				}
			}
		</script>
	</div>
	
</body>
</html>