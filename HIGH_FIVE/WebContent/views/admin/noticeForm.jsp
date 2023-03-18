<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.highfive.notice.model.vo.Notice" %>
<%
    String alertMsg = (String)session.getAttribute("alertMsg"); 
    String contextPath= request.getContextPath();
    ArrayList<Notice> noticeList = (ArrayList<Notice>)request.getAttribute("noticeList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Notice</title>
<style>
    .logo {
        font-size : 50px;
    }
    #logout {
        font-size : 20px;
        margin-top: 10px;
        margin-left : 1200px;
    }
    #wrap {
        height: 1000px;
    }
    #header {
        width : 100%;
        height : 20%;
    }
    .title {
        font-size : 20px;
        margin-left: 500px;
    }
    .box {
        overflow : scroll;
        height : 100px;
        border : 1px solid rgb(155, 155, 155);
        width : 1200px;
    }
    .thead > tr > td {
        width : 450px;
        height : 50px;
        text-align: center;
        background-color: rgb(215, 215, 215);
        font-weight: 500px;
        font-size: 30px;
    }
    .tbody > tr > td {
        width : 450px;
        height : 30px;
        text-align: center;
        font-size : 20px;
    }
	tbody>tr>td:not(:first-child):hover{
		cursor:pointer;
	}
	
	tbody > tr:hover {
		background : lightgray;
	}

	
</style>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

	
	    <div id="wrap">
        <div id="header">
            <hr>
            <div align="center">
                <a href="<%= contextPath %>" class="logo">Go For It</a>
            </div>
            <div id="user-info">
                <div align="center">
                        <div id="logout">
                            <a href="<%= contextPath %>/logout">로그아웃</a>
                        </div>
                </div>
            </div>
        </div>
        <fieldset class="title">
            <legend>공지사항 &nbsp;&nbsp;&nbsp;</legend>
            <form action="firmUpDeleteNotice" method="post" id="firmUpDeleteNotice">
            <table>
                <thead class="thead">
                    <tr>
						<td>선택</td>
                        <td>번호</td>
                        <td>제목</td>
                    </tr>
                </thead>
                <br>
                <tbody class="tbody">
                	<% if(noticeList == null) { %>
                	<% } else { %>
                		<% for(Notice n : noticeList) { %>
		                	<tr>
		                		<!-- input에서의 name은 상태 N인 회원 전체를, value는 그중에 체크한 getUserNo들을 전달하는 느낌 -->
	                			<td><input type="checkbox" name="dropUsers" value="<%= n.getNo() %>"></td>		                    
		                        <td><%= n.getNo() %></td>
		                        <td><%= n.getTitle() %></td>
		                    </tr>
		                 <% } %>
                	<% } %>
                </tbody>
            </table>
            <br><br>
            <div class="newnoticebutton">
                <button type="submit" class="btn btn-primary">공지 삭제</button>
            	<button type="button" class="btn btn-secondary" onclick="newNotice();">새 공지사항 생성</button>
            </div>
            </form>
        </fieldset>
    </div>
    
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
	
    <script>
           function newNotice(){
               location.href = "<%= contextPath %>/insert.no"
           }
    </script>
    
    <script type="text/javascript">
	  $(document).ready(function() {
	    $(' tbody').on('click', 'tr td:not(:first-child)', function () {
			var nno=$('.tbody>tr').children().eq(1).text();
			
			//get 방식: /detail.no?nno=글번호
			location.href="<%=contextPath%>/detail.no?nno="+nno;
	    });
	  });
	</script>
    

	
</body>
</html>