<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.highfive.challenge.model.vo.Challenge, java.util.ArrayList" %>
<%@ page import="com.highfive.contact.model.vo.Contact, com.highfive.member.model.vo.Member" %>
<%@ page import="com.highfive.certBoard.model.vo.Attachment" %>
<%
    String alertMsg = (String)session.getAttribute("alertMsg"); 
    String contextPath= request.getContextPath();
    ArrayList<Contact> conList = (ArrayList<Contact>)request.getAttribute("contact");
    Attachment at = (Attachment)request.getAttribute("at");
    Contact con = (Contact)request.getAttribute("conNum");
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>contactWrite</title>
<style>

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

    .contentbar {
        width: 70%;
        height: 100%;
        margin-left:20px;   
    }
</style>
</head>
<body>
	
	<h1>ContactWrite</h1>
	<br>
        <div class="contentbar">
            <div class="contenttitlebar">
            	<div align="center">문의자 번호 : <%= con.getUserNo() %>&nbsp;&nbsp;&nbsp;&nbsp;/&nbsp;&nbsp;&nbsp;&nbsp;게시글 번호 : <%= con.getContactNo() %></div>
            	<hr>
            </div>

			<div class="outer">

				<table id="detail-area" align="center" border="1">
			
					<tr>
						<th width="120">제목</th>
						<td width="380" colspan="3"><%=con.getQuestionTitle() %></td>
					</tr>
					<tr>
			
						<th>작성일</th>
						<td><%=con.getContactDate() %></td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="3">
							<p style="height: 150px;"><%=con.getQuestionContent() %></p>
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
			</div>
        </div>	
        
        <br><br>
        
        <hr>

        <br><br>

		<!-- 작성폼 -->
		<form action="wirtingContact" method="post" align="center">
            <h3>문의 작성</h3>
            <input type="hidden" name="contactNo" value="<%= con.getContactNo() %>">
            <input type="hidden" name="questionTitle" value="<%= con.getQuestionTitle() %>">
            <input type="hidden" name="questionContent" value="<%= con.getQuestionContent() %>">
            <input type="hidden" name="answerYN" value="<%= con.getAnswerYN() %>">
            <input type="hidden" name="userNo" value="<%= con.getUserNo() %>">
            <div>
                내용<input type="textarea" style="width : 700px; height : 200px;" name="answerContent">
            </div>
                <br>
            <button type="submit">확인</button>
		</form>
		
	<script>
		//script태그 안에서도 스크립틀릿 같은 jsp요소 사용가능
		var msg='<%=alertMsg%>'; //'메시지문구'/null
		
		if(msg !='null') {
			alert(msg);
			
			//session에 들어있는 alertMsg키 값에 대한 밸류를 지워야함
			//menubar.jsp가 로딩될 때마다 alert이 계속 뜰 것임
			<% session.removeAttribute("alertMsg"); %>
		}
	</script>

	
</body>
</html>