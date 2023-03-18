<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.highfive.member.model.vo.Member, java.util.ArrayList" %>
<%
    String alertMsg = (String)session.getAttribute("alertMsg"); 
    Member loginUser = (Member)session.getAttribute("loginUser");
    String contextPath= request.getContextPath();
    ArrayList<Member> levelList = (ArrayList<Member>)request.getAttribute("levelList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>관리자</title>
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
        
        fieldset {
        	text-align: right;
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
        <fieldset>
            <legend align="center">등급별 회원 조회

                <form action="detailLevelAdmin" method="post">
                    
				<div>
                    <input type="radio" name="level" id="level8" value="8"><label for="level8">전체보기</label>
                    <input type="radio" name="level" id="level1" value="1"><label for="level1">입문</label>
                    <input type="radio" name="level" id="level2" value="2"><label for="level2">하수</label>
                    <input type="radio" name="level" id="level3" value="3"><label for="level3">중수</label>
                    <input type="radio" name="level" id="level4" value="4"><label for="level4">고수</label>
                    <input type="radio" name="level" id="level5" value="5"><label for="level5">숙련</label>
                    <input type="radio" name="level" id="level6" value="6"><label for="level6">장인</label>
                    <input type="radio" name="level" id="level7" value="7"><label for="level7">신</label>
                    <button type="submit">조회하기</button>
				</div>
                
                </form>

            </legend>
            <table align="center" border="1">
                <thead class="thead">
                    <tr>
                        <td>아이디</td><td>닉네임</td><td>등급</td>
                    </tr>
                </thead>
                <br>
                <tbody class="tbody">
					<% if(levelList != null) { %>
                		<% for(Member m : levelList) { %>
		                	<tr>
		                		<!-- input에서의 name은 상태 N인 회원 전체를, value는 그중에 체크한 getUserNo들을 전달하는 느낌 -->
	                			<td><%= m.getUserId() %></td>		                    
		                        <td><%= m.getNickName() %></td>
		                        <td><%= m.getUserLevel() %></td>
		                    </tr>
		                 <% } %>
                	<% } %>
                </tbody>
            </table>
        </fieldset>
    </div>
    

</body>
</html>