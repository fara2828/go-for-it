<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.highfive.challenge.model.vo.Challenge, java.util.ArrayList" %>
<%@ page import="com.highfive.contact.model.vo.Contact, com.highfive.member.model.vo.Member" %>
<%
    String alertMsg = (String)session.getAttribute("alertMsg"); 
    String contextPath= request.getContextPath();
    ArrayList<Contact> conList = (ArrayList<Contact>)request.getAttribute("conList");
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ContactForm</title>
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
    .tbody>tr:hover {
    	cursor : pointer;
    	background : rgb(225, 225, 225);
    }
</style>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	
	<h1>ContactForm</h1>
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
            <legend>1:1문의 &nbsp;&nbsp;&nbsp;</legend>
            <table>
                <thead class="thead">
                    <tr>
                        <td>문의번호</td>
                        <td>작성자</td>
                        <td>제목</td>
                        <td>답변완료</td>
                    </tr>
                </thead>
                <br>
                <tbody class="tbody">              
                	<% if(conList.isEmpty()) { %>
                			게시글이 비었습니다.
	                	<% } else { %>
                		<% for(Contact c : conList) { %>
	                	<tr>
	                		<input type="hidden" value="<%= c.getContactNo() %>">
	                        <td><%= c.getContactNo() %></td>
	                        <td><%= c.getUserName() %></td>
	                        <td><%= c.getQuestionTitle() %></td>
	                        <td><%= c.getAnswerYN() %></td>
	                    </tr>
                    	<% } %>
                    <% } %>
                </tbody>

            </table>
            <br><br>
    </div>	
    
    <script>
    	$(function(){
    		
    		
    		$(document).on('click', '.tbody>tr', function(){
    			var contactNo = $(this).children('input').val();
    			//var contactNo = $(this).children().eq(0).text();
    			
    			
    			location.href = "<%= contextPath %>/detailContact?contactNo=" + contactNo; 
    					//$(this).children().eq(0).text();
    			
    		})
    	})
    </script>
    
    
    
    
    
    
    
    
</body>
</html>