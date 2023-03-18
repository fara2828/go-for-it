<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberEnrollForm</title>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"
   	    integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
<style>
    .goforit{
        font-size : 35px;
        color : rgb(0, 122, 255);
        margin-top: 20px;
    }
    hr {
        width : 720px;
    }
    .box {
        overflow : scroll;
        height : 100px;
        border : 1px solid rgb(155, 155, 155);
        width : 700px;
    }
    .enrollTag {
        display: block;
        margin-bottom: 12px;
        font-size: 20px;
        line-height: 20px;
        font-weight: 800px;
    }
    .enrollInput {
        width : 350px;
        height : 25px;
        margin-left: -350px;
        margin-top: -5px;
    }
    .searchPost {
        width : 350px;
        height : 25px;
        margin-left: -245px;
        margin-top: -5px;
    }
    .birthdate {
        width : 350px;
        height : 25px;
        margin-left: -355px;
        margin-top: -5px;
    }
    .submit {
        background-color: rgb(0, 122, 255);
        color :rgb(255, 255, 255);
        width : 200px;
        height : 40px;
        font-size: 120%;
        border-color: rgb(0, 122, 255);
    }
    #address {
        width : 350px;
        height : 25px;
        margin-left: -350px;
        margin-top: -5px;        
    }
    #post {
        width : 350px;
        height : 25px;
        margin-left: -250px;
        margin-top: -5px;  
    }
    #postButton {
        width : 100px;
        height : 25px;
        margin-left: 0px;
        margin-top: -5px;  
    }
    .fileInput {
        width : 300px;
        height : 25px;
        margin-left: -410px;
        margin-top: -5px;   
    }
    .genderDetail {
        width : 350px;
        height : 25px;
        margin-left: -550px;
        margin-top: -5px;   
    }

    .l2{
        margin-right: 675px;
    }
    .l3{
        margin-right: 660px;
    }
    .l4{
        margin-right: 645px;
    }
    .l5{
        margin-right: 630px;
    }
    .l6{
        margin-right: 615px;
    }
</style>
</head>
<body>

    <!-- 이용약관 -->
    <div class="Whole" align="center">
        <div class="Tos">
            <p class="goforit">Go For It 회원가입</p>
            <form action="insertMember" method="post" id="enrollForm" enctype="multipart/form-data">
            
            <hr>
                <br>
                <input type="checkbox" name="checkbox" id="using"  class="label" required>
                    <label for="using">Go For It 이용약관 동의 (필수)
                        <br>
                            <div class="box">
                                Go For It 서비스 및 제품(이하 ‘서비스’)을 이용해 주셔서 감사합니다. 
                                본 약관은 다양한 Go For It 서비스의 이용과 관련하여 Go For It 서비스를 제공하는 Go For It 
                                과 이를 이용하는 Go For It 서비스 회원(이하 ‘회원’) 또는 비회원과의 관계를 설명하며, 아울러 
                                여러분의 Go For It 서비스 이용에 도움이 될 수 있는 유익한 정보를 포함하고 있습니다.
                            </div>
                    </label>

                    <br>

                    <input type="checkbox" name="checkbox" id="colPriInfo" class="label" class="label" required>
                    <label for="colPriInfo" class="label" required>개인정보 수집 및 이용동의 (필수)
                        <br>
                            <div class="box">
                                이용자는 회원가입을 하지 않아도 정보 검색, 뉴스 보기 등 대부분의 Go For It 서비스를 
                                회원과 동일하게 이용할 수 있습니다. 이용자가 챌린지 프로그램서비스를 이용하기 위해 
                                회원가입을 할 경우, Go For It은 서비스 이용을 위해 필요한 최소한의 개인정보를 수집합니다.
                            </div>
                    </label>

                    <br>

                    <input type="checkbox" name="checkbox" id="location" class="label"  class="label" required>
                    <label for="location" class="label" required>개인정보 수집 및 이용동의 (필수)
                        <br>
                            <div class="box">
                                이 약관에 명시되지 않은 사항은 위치정보의 보호 및 이용 등에 관한 법률,
                                개인정보보호법, 정보통신망 이용촉진 및 정보보호 등에 관한 법률,
                                전기통신기본법, 전기통신사업법 등 관계법령과 회사의 이용약관 및
                                개인정보처리방침, 회사가 별도로 정한 지침 등에 의합니다.
                            </div>
                    </label>
                <hr>

        </div>
            <!-- 가입 양식 -->
            <div class="enroll">
                <div class="userId">
                    <p class="l3">아이디</p> 
                        <input type="text" class="enrollInput checkId" placeholder="한글, 숫자 또는 영문 2 - 16글자 이내로 입력해주세요." id="userId" name="userId" minlength="2" maxlength="16" required>
						<br><label id="idCheck"></label>
                </div>
                <div class="userPwd">
                    <p class="l4">비밀번호</p> 
                        <input type="password" class="enrollInput" placeholder="8글자이상 33글자 이내로 입력해주세요." id="userPwd" name="userPwd" minlength="8" maxlength="33" required>
                </div>
                <div class="userPwdCheck">
                    <p class="l6">비밀번호확인</p> 
                        <input type="password" class="enrollInput" placeholder="비밀번호를 다시 입력해주세요." id="checkPwd" name="checkPwd" required>
                		<br><label id="pwd"></label>
                </div>
                <div class="userName">
                    <p class="l2">이름</p> 
                        <input type="text" class="enrollInput" placeholder="이름을 입력해주세요." name="userName" required>
                </div>
                <div class="nickname">
                    <p class="l3">닉네임</p> 
                        <input type="text" class="enrollInput" placeholder="별칭을 16글자 이내로 입력해주세요." id="nickName" name="nickName" maxlength="16" required>
                		<br><label id="nick"></label>
                </div>
                <div class="email">
                    <p class="l5">이메일주소</p> 
                        <input type="email" class="enrollInput" placeholder="이메일을 입력해주세요." name="email" required>
                </div>
                <div class="birthday">
                    <p class="l4">생년월일</p> 
                        <input type="date" class="birthdate" name="birthDate" required>                        
                </div>
                <!-- selectGender
                <div class="genderDiv">
                    <p class="l2">성별</p>
                        <select name="gender" id="gen" class="gender">
                            <option name="none" value="none" >선택</option>
                            <option name="male" value="male">남성</option>
                            <option name="female" value="female">여성</option>
                        </select>
                -->
                <div class="genderDiv">
                    <p class="l2">성별</p>
                <div class="genderDetail">
                        <input type="radio" name="gender" value="M" required>남성 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="radio" name="gender" value="F" required>여성 
                </div>                        



                <br>
                </div>             
                <!-- address --> 
                <div class="postcode">
                    <p class="l4">우편번호</p> 
                        <input type="text" class="enrollInput" placeholder="우편번호" name="postcode" id="post" readonly>
                        <input type="button" name="postcode" value="우편번호 찾기" onclick="getAddress()" id="postButton" required>
                </div>
                <div class="address">
                    <p class="l2">주소</p> 
                    <input type="text" class="searchPost" placeholder="우편번호찾기를 통해 주소를 입력해주세요." name="address" id="address" readonly>
                </div>
                <div class="detailAddress">
                    <p class="l5">나머지주소</p> 
                    <input type="text" class="enrollInput" placeholder="나머지 주소를 입력해주세요." name="addressDetail">
                </div>
                
                
                <div class="phone">
                    <p class="l4">휴대전화</p>
                    <input type="text" class="enrollInput" placeholder="나머지 주소를 입력해주세요." name="phone" maxlength="11" required>
                </div>
                <div class="file">
                    <p class="l4">등록할 이미지</p>
                    <input type="file" class="fileInput" name="fileImage">
                </div>
                
                
                <br>
                
                <div>
                    <button type="submit" class="submit" >Go For It 가입하기</button>                
                </div>
                
                <br>
                
                <div>
                    <pre style="font-size : 15px;">메인으로 돌아가고싶으신가요?</pre>
                    <a style="text-decoration: none;" href="<%= contextPath %>/views/common/menubar2.jsp">돌아가기</a>
                </div>
                
                <br>
                
            </form>
        </div>
    </div>
    <!-- <input type="button" onclick="sample6_execDaumPostcode()" value="주소 검색"> -->
    <!-- ...
        <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
        <script>
            const postcode = new daum.Postcode({
                oncomplete: function(data) {
                    // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                    // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                    // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                    var addr = ''; // 주소 변수
                    var extraAddr = ''; // 참고항목 변수

                    //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                    if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                        addr = data.roadAddress;
                    } else { // 사용자가 지번 주소를 선택했을 경우(J)
                        addr = data.jibunAddress;
                    }

                    // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                    if(data.userSelectedType === 'R'){
                        // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                        // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                        if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                            extraAddr += data.bname;
                        }
                        // 건물명이 있고, 공동주택일 경우 추가한다.
                        if(data.buildingName !== '' && data.apartment === 'Y'){
                            extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                        }
                        // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                        if(extraAddr !== ''){
                            extraAddr = ' (' + extraAddr + ')';
                        }
                        // 조합된 참고항목을 해당 필드에 넣는다.
                        // document.getElementById("extraAddr").value = extraAddr;

                    } else {
                        // document.getElementById("extraAddr").value = '';
                    }

                    // 우편번호와 주소 정보를 해당 필드에 넣는다.
                    document.getElementById('zonecode').value = data.zonecode;
                    document.getElementById("address").value = addr;
                    // 커서를 상세주소 필드로 이동한다.
                    document.getElementById("address_detail").focus();
                }
            });

            // 버튼이 클릭되었을 때 오픈 팝업은 이와 같이 적용하면 됩니다.
            const openDaumPostcodePopup = function() {
                postcode.open();
            }
        </script>
    -->

    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script>
    // address
    function getAddress() {
        
        new daum.Postcode({
            oncomplete: function(data) { //선택시 입력값 세팅
                document.getElementById("post").value = data.zonecode;
                document.getElementById("address").value = data.address; // 주소 넣기
                document.querySelector("input[name=addressDetail]").focus(); //상세입력 포커싱
            }
        }).open();
    }
    
	/*    
    function idCheck(){
    	
    	var $userId = $('#enrollForm input[name=userId]');
    	var regExp = /^[a-zA-Z가-힣]{4,16}$/;
    	
        if($checkId == "") {
            $('#idCheck').html('필수 입력사항입니다.');
            $('#idCheck').css('color', 'rgb(47, 54, 82)');
        } else if(!regExp.test($checkId)){
            $('#idCheck').html('4-16자의 영문 대소문자와 한글만 사용 가능합니다.');
            $('#idCheck').css('color', 'rgb(47, 54, 82)');
        } else {
	*/
    </script>
    
  	<script>
	// checkId
    $('#userId').focusout(function() {
    	var regExp = /^[a-zA-Z가-힣0-9]{4,16}$/;
        //$('#idCheck').click(function(){
        var $checkId = $('#userId').val();
        
        if($checkId.length == 0) {
            $('#idCheck').html('필수 입력사항입니다.');
            $('#idCheck').css('color', 'red');
        } else if(!regExp.test($checkId)){
            $('#idCheck').html('4-16자의 영문 대소문자와 한글 또는 숫자만 사용 가능합니다.');
            $('#idCheck').css('color', 'red');
        } else {
            $.ajax({
                url : '<%= contextPath %>/idCheck',
                data : { 'checkId' : $checkId },
                success : function(result){
                    if(result == 'NNNNN'){
                    	$('#idCheck').html('이미 존재하거나 탈퇴한 아이디입니다.');
                        $('#idCheck').css('color', 'red');
                    } else {
                    	if(confirm('사용 가능한 아이디입니다.')){
	                    	//$('enrollForm button[type=submit]').Attr('disabled', false);
	                    	$('#idCheck').html('사용가능한 아이디입니다.');
	                        $('#idCheck').css('color', 'blue');
	                        // $checkId.focus();
                    	}
                    }
            	}
            })
        }
    });
  	</script>

    <script>
 	// checkPwd
	$(document).ready(function () {
		$('#checkPwd').focusout(function () {
			var userPwd = $('#userPwd').val();
			var checkPwd = $('#checkPwd').val();
			if (userPwd != checkPwd) {
				$('#pwd').html('비밀번호가 일치하지 않습니다.');
				$('#pwd').css('color', 'red');
				return false
			} else {
				$('#pwd').html('비밀번호가 일치합니다.');
				$('#pwd').css('color', 'blue');  
				return true;
			}
		});
	});
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