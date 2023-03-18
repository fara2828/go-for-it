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
<title>Insert title here</title>
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
	                        <a href="<%= contextPath %>/list.no?cpage=1" id="notice">공지사항</a> <br><br>
	                    </div>
	            </div>
	            
	        </div>

        <div class="contentbar">
        
            <div class="contenttitlebar">
            	<h3>&nbsp;&nbsp;&nbsp;&nbsp;고객센터 FAQ</h3>
            	<hr>
                <% if(loginUser != null && loginUser.getUserType().equals("A")) { %>
                    <a class="btn btn-sm btn-info" href="<%= contextPath %>/enrollform.faq">FAQ작성</a>
                    <!-- <a class="btn btn-sm btn-danger" href="<%= contextPath %>/deleteform.faq?fno=< %= fList.getFaqNo() %>">FAQ삭제</a> -->
                <% } %>
            </div>
            <br><br>
                
            <div class="userinfolist">
            <!-- accordion -->
            <% if(fList.isEmpty()) { %>
            	<div>FAQ 내용이 존재하지 않습니다.</div>
            	
            	
            <% } else { %>
            	<% for(Faq faqList : fList) { %>                                    
                <button class="accordion"><%= faqList.getFaqTitle() %>
                </button>
                <div class="panel">
                    <p><%= faqList.getFaqContent() %>
                    <div align="right" style="font-size:5px;">FAQ.NO : <%= faqList.getFaqNo() %>&nbsp;&nbsp;/&nbsp;&nbsp;등록일 : <%= faqList.getEnrollDate() %></div>
                    <% if(loginUser != null && loginUser.getUserType().equals("A")) { %>
                    	<br>
                       <a class="btn btn-sm btn-danger" href="<%= contextPath %>/deleteform.faq?fno=<%= faqList.getFaqNo() %>">FAQ삭제</a>
                    </p>
                    <% } %>
                    <br>
                </div>
            	<% } %>
            <% } %>
            </div>
            
            <!-- 비회원일경우 -->
            <% } else { %>
            
            <div class="navibar">
	            <br>
	            <div id="navibar5">
	                <h5 id="qna">Q&A</h5> <br>
	                    <div>
	                        <a href="<%= contextPath %>/faq" id="faq">FAQ</a> <br><br>
	                        <a href="<%= contextPath %>/list.co?cpage=1" id="oneq">1:1문의</a> <br><br>
	                        <a href="<%= contextPath %>/list.no?cpage=1" id="notice">공지사항</a> <br><br>
	                    </div>
	            </div>
	            
	        </div>

        <div class="contentbar">
        
            <div class="contenttitlebar">
            	<h3>&nbsp;&nbsp;&nbsp;&nbsp;고객센터 FAQ</h3>
            	<hr>
                <% if(loginUser != null && loginUser.getUserType().equals("A")) { %>
                    <a class="btn btn-sm btn-info" href="<%= contextPath %>/enrollform.faq">FAQ작성</a>
                    <!-- <a class="btn btn-sm btn-danger" href="<%= contextPath %>/deleteform.faq?fno=< %= fList.getFaqNo() %>">FAQ삭제</a> -->
                <% } %>
            </div>
            <br><br>
                
            <div class="userinfolist">
            <!-- accordion -->
            <% if(fList.isEmpty()) { %>
            	<div>FAQ 내용이 존재하지 않습니다.</div>
            	
            	
            <% } else { %>
            	<% for(Faq faqList : fList) { %>                                    
                <button class="accordion"><%= faqList.getFaqTitle() %>
                </button>
                <div class="panel">
                    <p><%= faqList.getFaqContent() %>
                    <div align="right" style="font-size:5px;">FAQ.NO : <%= faqList.getFaqNo() %>&nbsp;&nbsp;/&nbsp;&nbsp;등록일 : <%= faqList.getEnrollDate() %></div>
                    <% if(loginUser != null && loginUser.getUserType().equals("A")) { %>
                    	<br>
                       <a class="btn btn-sm btn-danger" href="<%= contextPath %>/deleteform.faq?fno=<%= faqList.getFaqNo() %>">FAQ삭제</a>
                    </p>
                    <% } %>
                    <br>
                </div>
            	<% } %>
            <% } %>
            </div>

			<% } %>
        
        </div>
    
	</div>

        <script>
            var acc = document.getElementsByClassName("accordion"); //아코디언클래스리스트를 가져온다.
            var i;
            
            for (i = 0; i < acc.length; i++) {
              acc[i].addEventListener("click", function() { //클릭이벤트를 추가한다. 
                /* Toggle between adding and removing the "active" class,
                to highlight the button that controls the panel */
                this.classList.toggle("active"); //클래스를 추가하거나 삭제함. 
            
                /* Toggle between hiding and showing the active panel */
                var panel = this.nextElementSibling; //현재 아코디언의 다음노트를 가져온다. panel이 옴 
                if (panel.style.display === "block") { //출력모드가 블럭인지 none인지 체크한다.
                  panel.style.display = "none";
                } else {
                  panel.style.display = "block";
                }
              });
            }
        </script>



</body>
</html>