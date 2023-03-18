<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지 화면</title>
<link rel="stylesheet" href="//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
<script src="//apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
<link rel="stylesheet" href="jqueryui/style.css">
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
    .contenttitlebar {
        height: 8%;
    }

    .nicknamebar {
        height: 7%;
    }

    .userinfolist {
        height: 80%;
        background-color: lightgrey;
    }

    .nicknamebar >div {
        float: left;
        font-size:larger;

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

    /*userinfolist 클래스 내 상단 이미지 관련 div*/
    .userinfopics{
        height:60%;
    }

    .userinfopics > div{
        float: left;
    }

    /*userinfolist 클래스 내 상단 좌측 관련 div*/
    .userprofilepic{
        width: 40%;
        height:100%;
    }

    .mypageprofile {
        width: 100%;
        height: 100%;
        object-fit: cover;
        padding: 10px;
    }

    /*userinfolist 클래스 내 상단 우측 관련 div*/
    .useractivitypic{
        width: 60%;
        height: 100%;
       
    }

    .thunderpic{
        width: 100%;
        height: 60%;
        text-align: center;
    }

    .challengeactivity{
        width: 100%;
        height: 40%;
        text-align: center;
    }

    /*userinfolist 클래스 내 하단 회원정보 관련 div*/
    .userinformation{
        height:40%;
    }


    table {
        width: 80%;
        border: 1px solid #444444;
        background-color: white;
    }

    .userinformation > div {
        height: 20%;
    }
    
    .red { color: red; }
	.orange { color: orange; }
	.yellow { color: yellow; }
	.green { color: green; }
	.blue { color: blue; }
	.navy { color: navy; }
	.purple { color: purple; }

    .jb-text {
        padding: 15px 20px;
        background-color: white;
        position: absolute;
        display: none;
        margin-left:30px;
      }
      .jb-title:hover + .jb-text {
        display: block;
      }

</style>
<script src="https://kit.fontawesome.com/aa839e973e.js" crossorigin="anonymous"></script>

</head>
<body>

	<%@ include file="../common/menubar2.jsp" %>

    <%
    String nickname=(loginUser.getNickName()==null) ? "": loginUser.getNickName();
    
    %>

    <%
    int level=loginUser.getUserLevel();
    String levelName="";
    switch(level) {
        case 1: levelName="입문";break;
        case 2: levelName="하수";break;
        case 3: levelName="중수";break;
        case 4: levelName="고수";break;
        case 5: levelName="숙련";break;
        case 6: levelName="장인";break;
        case 7: levelName="신";break;
    }
    %>


    <% if(loginUser != null) {%>
		<input type="hidden" id="loginUserInput" value="<%= loginUser.getUserNo() %>">
	<% } else { %>
			<input type="hidden" id="loginUserInput" value="">
	
	<% } %>

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
            	<h3>&nbsp;&nbsp;&nbsp;&nbsp;회원 정보</h3>
            	<hr>
            </div>
            
            <div class="userinfolist">
                <div class="userinfopics">
                    <div class="userprofilepic">
                        <% if(loginUser.getProfile() == null) { %>	
                            <img class="mypageprofile" src="https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__340.png" onerror="this.onerror=null; this.src='https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__340.png';">  
                        <% } else { %>
                            <img class="mypageprofile" src="<%= contextPath %>/resources/profile_upfiles/<%= loginUser.getProfile() %>" onerror="this.onerror=null; this.src='https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__340.png';">
                        <% } %>

                    </div>
                    <div class="useractivitypic">
                        <div class="thunderpic">
                            
                            
                            <h5>
                                <b><%=loginUser.getNickName()%></b>님의 현재 에너지 등급은 <span id="level-name"><b><%=levelName%></b></span>입니다.
                            </h5>
                            <div class="jb-title" style="text-align: right;">
                            <small>
                                	에너지등급 안내<i class="fa-solid fa-circle-info"></i>
                            </small>
                            </div>
                            <div class="jb-text" style="text-align: right;">
                                인증할수록 등급이 올라갑니다. 
                                <table align="center">
                                    <tbody>
                                        <tr>
                                            <td><i class="fa-solid fa-bolt fa-3x red" ></i></td>
                                            <td><i class="fa-solid fa-bolt fa-3x orange" ></i></td>
                                            <td><i class="fa-solid fa-bolt fa-3x yellow" ></i></td>
                                            <td><i class="fa-solid fa-bolt fa-3x green" ></i></td>
                                            <td><i class="fa-solid fa-bolt fa-3x blue" ></i></td>
                                            <td><i class="fa-solid fa-bolt fa-3x navy" ></i></td>
                                            <td><i class="fa-solid fa-bolt fa-3x purple" ></i></td>
                                        </tr>
                                        <tr>
                                            <td>입문</td>
                                            <td>하수</td>
                                            <td>중수</td>
                                            <td>고수</td>
                                            <td>숙련</td>
                                            <td>장인</td>
                                            <td>신</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                            
                            <br>
                            <i id="level-icon" class="fa-solid fa-bolt fa-6x" ></i>
                            <hr>
                        </div>
                        <div class="challengeactivity">
                            <h5>
                                <챌린지 현황>
                            </h5>
                            <br>
                            <table align="center" id="challengeMadeUser">
                                <thead>
                                    <tr>
                                        <td>참가중</td><td>완료</td><td>생성</td>
                                    </tr>
                                </thead>
                                <tbody>
                                   
                                </tbody>
                            </table>
                            <hr>
                        </div>
                    </div>
                </div>
            	<div class="userinformation">
                    
                    <div class="userinfos">
                        <p> &nbsp;&nbsp; <b>가입일</b>  <%=loginUser.getEnrollDate()%></p>
                    </div>
                    <div class="userinfos">
                        <p>
                            &nbsp;&nbsp;&nbsp; <i class="fa-solid fa-cake-candles fa-2x"></i> &nbsp;&nbsp;&nbsp; <%=loginUser.getBirthDate()%>
                        </p>
                    </div>
                    <div class="userinfos">
                        <p>
                            &nbsp;&nbsp;&nbsp; <i class="fa-solid fa-envelope fa-2x"></i> &nbsp;&nbsp;&nbsp;<%=loginUser.getEmail() %>
                        </p>
                    </div>
                    <div class="userinfos">
                        <p>
                            &nbsp;&nbsp;&nbsp; <i class="fa-solid fa-phone fa-2x"></i> &nbsp;&nbsp;&nbsp;<%=loginUser.getPhone() %>
                        </p>
                    </div>
                    <div class="userinfos">
                        <p>
                            &nbsp;&nbsp;&nbsp; <i class="fa-solid fa-house fa-2x"></i> &nbsp;&nbsp;&nbsp;<%=loginUser.getAddress() %>
                        </p>
                    </div>

                </div>

                

            </div>
        </div>

    </div>
    
    <script>

    var loginUser = $('#loginUserInput').val();

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
    
	$(function () {
        madeByUser();

		var level = '<%= loginUser.getUserLevel() %>';
		switch(level) {
			case '1': $('#level-icon').addClass('red'); break;
			case '2': $('#level-icon').addClass('orange'); break;
			case '3': $('#level-icon').addClass('yellow'); break;
			case '4': $('#level-icon').addClass('green'); break;
			case '5': $('#level-icon').addClass('blue'); break;
			case '6': $('#level-icon').addClass('navy'); break;
			case '7': $('#level-icon').addClass('purple'); break;
		}
		
		switch(level) {
		case '1': $('#level-name').addClass('red'); break;
		case '2': $('#level-name').addClass('orange'); break;
		case '3': $('#level-name').addClass('yellow'); break;
		case '4': $('#level-name').addClass('green'); break;
		case '5': $('#level-name').addClass('blue'); break;
		case '6': $('#level-name').addClass('navy'); break;
		case '7': $('#level-name').addClass('purple'); break;
	}
	})
    
    </script>

</body>
</html>