<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 작성</title>
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
	<%@ include file="../common/menubar2.jsp" %>

    <%
    String nickname=(loginUser.getNickName()==null) ? "": loginUser.getNickName();
    
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
            	<h3>&nbsp;&nbsp;&nbsp;&nbsp;공지사항 작성</h3>
            	<hr>
            </div>
            
            <form action="<%=contextPath%>/insert2.no" id="enroll-form" method="post">

				<input type="hidden" name="userNo" value="<%= loginUser.getUserNo() %>">
		
				<table align="center">
		
					<tr>
						<th>제목</th>
						<td><input type="text" name="title" required></td>
					</tr>
					<tr>
						<th>분류</th>
						<td>
							<select name='kind'>
							  <option value='' selected>-- 선택 --</option>
							  <option value='이벤트'>이벤트</option>
							  <option value='업데이트'>업데이트</option>
							  <option value='장애안내'>장애안내</option>
							</select>
						</td>
					</tr>
					<tr>
						<th>내용</th>
						<td>
							<textarea name="content" style="resize:none; width:500px;" required rows="15"></textarea>
						</td>
					</tr>
					
				</table>
				
				<br>
				
				<div align="center">
					<button type="submit">작성하기</button>
					<button type="reset">취소하기</button>
				</div>

			</form>    

        </div>

    </div>

</body>
</html>