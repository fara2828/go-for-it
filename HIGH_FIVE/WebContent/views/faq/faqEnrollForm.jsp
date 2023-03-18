<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.highfive.faq.model.vo.Faq" %>
<%
	ArrayList<Faq> fList = (ArrayList<Faq>)request.getAttribute("fList");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FAQ Enroll Form</title>
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
    }

    .nicknamebar >div {
        float: left;
        font-size:larger;

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

    /* 아코디언 */
    /* Style the buttons that are used to open and close the accordion panel */
	.accordion {
	  background-color: #eee;
	  color: #444;
	  cursor: pointer;
	  padding: 18px;
	  width: 100%;
	  text-align: left;
	  border: none;
	  outline: none;
	  transition: 0.4s;
	}
	
	/* Add a background color to the button if it is clicked on (add the .active class with JS), and when you move the mouse over it (hover) */
	.active, .accordion:hover {
	  background-color: rgb(186, 186, 186);
	}
	
	/* Style the accordion panel. Note: hidden by default */
	.panel {
	  padding: 0 18px;
	  background-color: white;
	  display: none;
	  overflow: hidden;
	}
</style>
</head>
<body>
	<%@ include file="../common/menubar2.jsp" %>
	
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
                        <a href="" id="oneq">1:1문의</a> <br><br>
                        <a href="" id="notice">공지사항</a> <br><br>
                    </div>
            </div>
        </div>
        <div class="contentbar">
            <div class="contenttitlebar">
            	<h3>&nbsp;&nbsp;&nbsp;&nbsp;FAQ 작성(관리자)</h3>
            	<hr>

                
            <div class="userinfolist">
                <form action="insertFaq" method="post">
                	<input type="hidden" name="faqNo">
                    <th>제목</th>
                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="textarea" style="width:400px;" name="faqTitle" required>
                    </td>
                    <br><br>
                    <th>내용</th> <br>
                    <td><input type="textarea" style="width:470px; height: 270px;" name="faqContent" required></td>
                    <br><br>
                    <button type="submit" class="btn btn-sm btn-info">등록하기</button>
                    <button type="button" class="btn btn-sm btn-secondary" onclick="history.back()">뒤로가기 </button>
                </form>
            </div>

        </div>		
                

	
	
	
</body>
</html>