<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
<style>


    * {
        box-sizing: border-box;
    }

    body {
    margin: 0;
    min-width: 992px;
    font-family: "Helvetica";
    }

    /*센터부분 크기 조절, 자손 div정렬*/
    .container {
        width: 1000px;
        height: 800px;
        margin: auto;
    }

    .container >div{
        float: left;
    }

    /*내부 div 크기 조절*/
    .navibar {
        width: 20%;
        height: 60%;
        background-color: lightgrey;

        text-align: center;
    }

    .contentbar {
        width: 70%;
        height: 100%;
        margin-left:20px;   
    }

    /*content bar 내부 div 크기 조절*/
    .userinfobar {
        height: 8%;
    }

    .nicknamebar {
        height: 7%;
    }

    .currentbar {
        height: 10%;
        background-color: lightgrey;
    }

    .userinfolist {
        height: 70%;
        background-color: lightgrey;
    }

    .nicknamebar >div {
        float: left;
        font-size:larger;

    }
    .profile1 {
      width: 150px;
      height: 150px;
      object-fit: contain;
    }
    #navibar4 {
        margin-left: -30px;
    }
    #navi {
        margin-left: -58px;
    }
    #faq {
        margin-left: -43px;
    }
    #oneq {
        margin-left: -20px;
    }
    #notice {
        margin-left: -13px;
    }
    #navibar5 {
        margin-left: -20px;
    }

</style>
</head>
<body>
	<%@ include file="../common/menubar2.jsp" %>

    <%
		String userId= loginUser.getUserId();
    	String userPwd= loginUser.getUserPwd();
		String userName= loginUser.getUserName();
		String nickName= loginUser.getNickName();
		String email=loginUser.getEmail();
		String birthDate=loginUser.getBirthDate();
		String gender=loginUser.getGender();
		String post=loginUser.getPost();
		String address=loginUser.getAddress();
		String phone=loginUser.getPhone();		
		
		String profile=(loginUser.getProfile()==null) ? "": loginUser.getProfile();
		String addressDetail=(loginUser.getAddressDetail()==null) ? "": loginUser.getAddressDetail();
	%>

    <div class="container">
    
		<div class="navibar">
            <br>
            <div id="navibar">
                <h4 style="text-align:center; font-weight:bold;">마이페이지</h4>
            </div>
            <hr>
            <div id="navibar2">
                <a href="<%= contextPath %>/myPage.me">회원정보 조회</a>
            </div>
            <br>
            <div id="navibar3">
                <a href="<%= contextPath %>/update.me">회원정보 수정</a>
            </div>
            <br>
            <div id="navibar4">
                <a href="<%= contextPath %>/delete.me">회원 탈퇴</a>
            </div>

            <br>
            <hr>
            <div id="navibar5">
                <h5 id="qna">Q&A</h5> <br>
                    <div>
                        <a href="<%= contextPath %>/faq" id="faq">FAQ</a> <br><br>
                        <a href="<%= contextPath %>/list.co?cpage=1" id="oneq">1:1문의</a> <br><br>
                        <a href="<%= contextPath %>/list.no?cpage=1" id="list.no">공지사항</a> <br><br>
                    </div>
            </div>
        </div>

        <div class="contentbar">
            <h3> 회원 정보 수정</h3>

            <hr>
			
			<form action="<%= contextPath %>/update3.me" method="post" id="mypage-form" enctype="multipart/form-data">
	
					<table align="left">
						<tr>
							<td>프로필 사진</td>
							<td>
								<% if(loginUser.getProfile()==null) { %>
                            		<img class="profile1" src="https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__340.png" onerror="this.onerror=null; this.src='https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__340.png';">  
                        		<% } else { %>
                            		<img class="profile1" src="<%= contextPath %>/resources/profile_upfiles/<%= loginUser.getProfile() %>" onerror="this.onerror=null; this.src='https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__340.png';">
                        		<% } %>
							</td>
							
							<td><!-- /jsp/resources/board_upfiles/kakao_20221116172603_48915.jpg --></td>
						</tr>

						<tr>
							<td>사진첨부</td>
							
							<td><input type="file" name="profile">
							</td>
							<td><input type="hidden" name="userId" value="<%= userId %>"></td>
							<td><input type="hidden" name="userNo" value="<%= userName %>"></td>
							
						</tr>
						<tr>
							<td><button type="submit" class="btn btn-sm btn-primary">사진 변경 확인</button></td>
						</tr>
					</table>
			</form>

			<form action="<%= contextPath %>/update2.me" method="post" id="mypage-form">

					<table align="left">
						<tr>
							<td>*아이디</td>
							<td><input type="text" name="userId" value="<%= userId %>" readonly maxlength="12"></td>
							<td></td>
							<!-- 중복확인 나중에 AJAX배우고 다음주에 할 것-->
						</tr>
						<tr>
							<td>*이름</td>
							<td><input type="text" name="userName" value="<%= userName %>" maxlength="5"></td>
							<td></td>
							<!--아이디 중복 확인-->
						</tr>
						<tr>
							<td>비밀번호</td>
							<td><input type="password" id="userPwd" name="userPwd" value="<%=userPwd%>" maxlength="16" placeholder="비밀번호를 입력해주세요" required></td>
							<td></td>
						</tr>
						<tr>
							<td>닉네임</td>
							<td>
								<input type="text" id="nickName" name="nickName" value="<%=nickName%>" placeholder="별칭을 입력해주세요." required>
								<label id="nick"></label>
							</td>
							<td></td>
							<!--닉네임 중복 확인-->
						</tr>
						<tr>
							<td>이메일</td>
							<td><input type="email" name="email" value="<%=email%>" placeholder="이메일을 입력해주세요" required></td>
							<td></td>
							<!--이메일 인증-->
						</tr>
						<tr>
							<td>생일</td>
							<td><input type="date" name="birthDate" value="<%=birthDate%>" required></td>
							<td></td>
						</tr>
						<tr>
							<td>성별</td>
							<td>
								<input type="radio" name="gender" value="M" required>남성 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="radio" name="gender" value="F" required>여성
							</td>
							<td></td>
						</tr>
						<tr>
							<td>우편번호</td>
							<td>
								<input type="text" class="enrollInput" value="<%=post%>" placeholder="우편번호" name="post" id="post" readonly>
                           		<input type="button" name="postcode" value="우편번호 찾기" onclick="getAddress()" id="postButton">
							</td>
							<td></td>
						</tr>
						<tr>
							<td>주소</td>
							<td>
								<input type="text" class="searchPost" value="<%=address%>" placeholder="우편번호찾기를 통해 주소를 입력해주세요." name="address" id="address" readonly>
                        		<input type="button" onclick="sample6_execDaumPostcode()" value="주소 검색">
							</td>
							<td></td>
						</tr>
						<tr>
							<td>상세주소</td>
							<td><input type="text" name="addressDetail" value="<%=addressDetail%>" placeholder="상세주소를 입력해주세요"></td>
							<td></td>
						</tr>
						<tr>
							<td>전화번호</td>
							<td><input type="text" name="phone" value="<%=phone%>" placeholder="전화번호를 입력해주세요."></td>
							<td></td>
							<!--전번 인증-->
						</tr>
						<tr>
							<td><button type="submit" class="btn btn-sm btn-primary">정보변경 확인</button></td>
						</tr>
					</table>	
			</form>

        </div>

    </div>

	<script>
		$(":radio[name='gender'][value='<%=gender%>']").attr('checked', true);
	</script>
    
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
		function getAddress() {
		    
		    new daum.Postcode({
		        oncomplete: function(data) { //선택시 입력값 세팅
		            document.getElementById("post").value = data.zonecode;
		            document.getElementById("address").value = data.address; // 주소 넣기
		            document.querySelector("input[name=addressDetail]").focus(); //상세입력 포커싱
		        }
		    }).open();
		}
	</script>
	
	<script>
	// checkNickName
    $('#nickName').focusout(function() {
    	var regExp = /^[a-zA-Zㄱ-ㅎ가-힣0-9]{1,16}$/;
        //$('#idCheck').click(function(){
        var $checkNickName = $('#nickName').val();
        if($checkNickName.length == 0) {		
            $('#nick').html('필수 입력사항입니다.');
            $('#nick').css('color', 'red');
        } else if(!regExp.test($checkNickName)){
            $('#nick').html('16글자 이내로 입력해주세요.');
            $('#nick').css('color', 'red');
        } else {
            $.ajax({
                url : '<%= contextPath %>/checkNickName',
                data : { 'checkNickName' : $checkNickName },
                success : function(result){
                    if(result == 'NICKNAME'){
                    	$('#nick').html('이미 존재하는 닉네임입니다.');
                        $('#nick').css('color', 'red');
                    } else {
                    	if(confirm('사용 가능한 닉네임입니다.')){
	                    	//$('enrollForm button[type=submit]').Attr('disabled', false);
	                    	$('#nick').html('사용가능한 닉네임입니다.');
	                        $('#nick').css('color', 'blue');
	                        // $checkId.focus();
                    	}
                    }
            	}
            })
        }
    });
	</script>

</body>
</html>