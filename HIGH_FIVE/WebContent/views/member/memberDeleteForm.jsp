<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴 화면</title>
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


    .contentbar >div {
        width: 100%;
    }

    .userdeleteform {
        margin: auto;
        font-size: small;
    }
    
        /*navibar div*/
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
<body>
	<%@ include file="../common/menubar2.jsp" %>

	<%
		String userId= loginUser.getUserId();
		String userName= loginUser.getUserName();


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
            <div class="contenttitlebar">
            	<h3>&nbsp;&nbsp;&nbsp;&nbsp;탈퇴 안내</h3>
            	<hr>
            </div>
            <br>
            <div class="userdeleteform">
            	<p>
                회원탈퇴를 신청하기 전에 안내 사항을 꼭 확인해주세요.<br><br>

                <b>사용하고 계신 아이디<span style="color: orange">(<%=userId%>)</span> 는 탈퇴할 경우 재사용 및 복구가 불가능합니다.</b><br>
                탈퇴한 아이디는 본인과 타인 모두 재사용 및 복구가 불가하오니 신중하게 선택하시기 바랍니다.<br><br>

                <b> 탈퇴 후 회원정보 및 개인형 서비스 이용기록은 모두 삭제됩니다.</b> <br>
                회원정보 등 개인 서비스 이용기록은 모두 삭제되며, 삭제된 데이터는 복구되지 않습니다.<br>
                삭제되는 내용을 확인하시고 필요한 데이터는 미리 백업을 해주세요. <br><br>

                <b> 탈퇴 후에도 게시판형 서비스에 등록한 게시물은 그대로 남아 있습니다. </b><br>
                올린 게시글 및 댓글은 탈퇴 시 자동 삭제되지 않고 그대로 남아 있습니다. <br>
                삭제를 원하는 게시글이 있다면 반드시 탈퇴 전 비공개 처리하거나 삭제하시기 바랍니다. <br>
                탈퇴 후에는 회원정보가 삭제되어 본인 여부를 확인할 수 있는 방법이 없어, 게시글을 임의로 삭제해드릴 수 없습니다. <br><br>

                탈퇴 후에는 해당 아이디<span style="color: orange">(<%=userId%>)</span>로 다시 가입할 수 없으며 아이디와 데이터는 복구할 수 없습니다.
                게시판형 서비스에 남아 있는 게시글은 탈퇴 후 삭제할 수 없습니다. <br><br>

                <input type="checkbox" id="dropoutAgree" name="dropoutAgree" onclick="myFunction()">안내 사항을 모두 확인하였으며, 이에 동의합니다. <br><br>
                </p>
                

                
			</div>
            
            <button type="button" class="btn btn-ssm btn-danger btn3" id="deletebutton1" disabled data-toggle="modal" data-target="#deleteUserForm" >확인</button>
			
			
							<!-- 회원 탈퇴 모달 창 -->
	<div class="modal" id="deleteUserForm">
	  <div class="modal-dialog">
	    <div class="modal-content">
	
	      <!-- Modal Header -->
	      <div class="modal-header">
	        <h4 class="modal-title">회원 탈퇴</h4>
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
	      </div>
	
	      <!-- Modal body -->
	      <div class="modal-body" align="center">
			<form action="<%=contextPath %>/delete2.me" method="post">

					<div>보안상 현재 비밀번호를 재입력해주세요.</div>
                    <br>
					<div><input type="password" required name="userPwd"></div>


					<br>

					<button type="submit" class="btn btn-ssm btn-danger btn3">탈퇴확인</button>
					<input type="hidden" name="userId" value="<%=userId %>">
	        </form>
	      </div>
	

	
	    </div>
	  </div>
	</div>
	
	<script>
		
        function myFunction() {
        	
        	var checkBox = document.getElementById("dropoutAgree");
            // If the checkbox is checked, 
            if (checkBox.checked == true){
            	document.getElementById("deletebutton1").disabled = false;
            } else {
            	document.getElementById("deletebutton1").disabled = true;
            }
        }

    </script>
			
</body>
</html>
</body>
</html>