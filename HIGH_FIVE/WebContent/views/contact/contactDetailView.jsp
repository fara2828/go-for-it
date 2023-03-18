<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.highfive.contact.model.vo.Contact, com.highfive.certBoard.model.vo.*" %>
<%
	Contact c = (Contact)request.getAttribute("c");
	Contact answerC = (Contact)request.getAttribute("contact");
    Attachment at = (Attachment)request.getAttribute("at");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1:1 문의 내용</title>
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

    <div class="container">
		 <% if(loginUser != null) { %>
		 
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
            	<h3>&nbsp;&nbsp;&nbsp;&nbsp;1:1 문의</h3>
            	<hr>
            </div>

			<div class="outer">

				<table id="detail-area" align="center" border="1">
			
					<tr>
						<th width="120">제목</th>
						<td width="380" colspan="3"><%=c.getQuestionTitle() %></td>
					</tr>
					<tr>
			
						<th>작성일</th>
						<td><%=c.getContactDate() %></td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="3">
							<p style="height: 150px;"><%=c.getQuestionContent() %></p>
						</td>
					</tr>
					
                    <tr>
                        <th>첨부파일</th>
                        <td colspan="3">
                                <% if(at == null) { %>
                                <!-- 첨부파일이 없을수도 있다. -->
                                    	첨부파일이 없습니다.
                                <% } else { %>
                                <!-- 첨부파일이 있을수도 있다. -->
                                <!-- /jsp/resources/board_upfiles/kakao_20221116172603_48915.jpg -->
                                    <a download="<%= at.getOriginName() %>" href="<%= contextPath %>/<%= at.getFilePath() %>/<%= at.getChangeName() %>"><%= at.getOriginName() %></a>
                                <% } %>
                        </td>                       
                    </tr>
			
				</table>

				<br><br>		
				<% if(c.getAnswerYN().equals("Y")) { %>	
				
				<table id="detail-area" align="center" border="1">
					<tr>
						<th width="120">답변내용</th>
						<td width="380" colspan="3">
							<p style="height: 150px;"><%=c.getAnswerContent() %></p>
						</td>
					</tr>				
				</table>
				<% } %>				
				<div align="center">
					<a class="btn btn-sm btn-secondary" href="<%=contextPath%>/list.co?cpage=1">목록가기</a>
				</div>
				
			</div>
        </div>
    
    <% } else { %>
    
            <div class="navibar">

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
            	<h3>&nbsp;&nbsp;&nbsp;&nbsp;1:1 문의</h3>
            	<hr>
            </div>

			<div class="outer">

				<table id="detail-area" align="center" border="1">
			
					<tr>
						<th width="120">제목</th>
						<td width="380" colspan="3"><%=c.getQuestionTitle() %></td>
					</tr>
					<tr>
			
						<th>작성일</th>
						<td><%=c.getContactDate() %></td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="3">
							<p style="height: 150px;"><%=c.getQuestionContent() %></p>
						</td>
					</tr>
                    <tr>
                        <th>첨부파일</th>
                        <td colspan="3">
                                <% if(at == null) { %>
                                <!-- 첨부파일이 없을수도 있다. -->
                                    	첨부파일이 없습니다.
                                <% } else { %>
                                <!-- 첨부파일이 있을수도 있다. -->
                                <!-- /jsp/resources/board_upfiles/kakao_20221116172603_48915.jpg -->
                                    <a download="<%= at.getOriginName() %>" href="<%= contextPath %>/<%= at.getFilePath() %>/<%= at.getChangeName() %>"><%= at.getOriginName() %></a>
                                <% } %>
                        </td>
                    </tr>
			
				</table>
				
				<br>
				
	            <div>
                	내용<p type="textarea" style="width : 700px; height : 200px;" name="answerContent" value=""><%= c.getAnswerContent() %></p>
            	</div>		
			
				<div align="center">
					<a class="btn btn-sm btn-secondary" href="<%=contextPath%>/list.co?cpage=1">목록가기</a>
				</div>
				
			</div>
        </div>
    <% } %>
    

    </div>
</body>
</html>