<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.highfive.contact.model.vo.Contact, com.highfive.common.model.vo.*" %>    
<%
	ArrayList<Contact> list= (ArrayList<Contact>)request.getAttribute("list");
	PageInfo pi=(PageInfo)request.getAttribute("pi");
	
	int currentPage=pi.getCurrentPage();
	int startPage= pi.getStartPage();
	int endPage=pi.getEndPage();
	int maxPage=pi.getMaxPage();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1:1문의</title>
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

    .currentbar {
        height: 10%;
        background-color: lightgrey;
    }

    .userinfolist {
        height: 70%;
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

	.list-area{
	text-align: center;
	border: 3px solid pink;
	font-size:15px;
	}
	.list-area>tbody>tr:hover{
		cursor:pointer;
		background: lightgrey;
	}


	.contenttitlebar{
		height:8%;
	}

	.contactsearch{
		height:15%;
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

			<div class="contacttable">
				<table class="list-area" align="center">
					<thead>
						<tr>
							<th width="100">번호</th>					
							<th width="400">제목</th>	
							<th width="100">작성자</th>	
							<th width="150">작성일</th>
							<th width="150">답변상태</th>
						</tr>
					</thead>
					<tbody>
						<% if(list.isEmpty()) { %>
							<tr>
								<td colspan="5">문의가 존재하지 않아요 x</td>
							</tr>
						<% } else { %>
							<% for(Contact c : list) { %>
								<tr class="exist">
									<td><%= c.getContactNo() %></td>
									<td><%= c.getQuestionTitle() %></td>
									<td><%= c.getNickName() %></td>
									<td><%= c.getContactDate() %></td>
									<td><% if(c.getAnswerYN().equals("N")) {%> 
											처리 중
										<% } else { %>
											답변 완료
										<% }%>
									</td>
								</tr>
							<% } %>
						<% } %>
					</tbody>
				</table>
			</div>

			<br><br>
			<div align="center" class="paging-area">
				<% if(currentPage!=1) { %>
					<button class="btn btn-sm btn-info" onclick="location.href='<%=contextPath%>/list.co?cpage=<%=currentPage-1 %>'">&lt;</button>
				<% } %>
					
				<% for(int i=startPage; i<=endPage; i++) {%>
						
					<% if(currentPage !=i) { %>				
						<button class="btn btn-sm btn-info" onclick="location.href='<%=contextPath%>/list.co?cpage=<%=i%>'"><%=i %></button>
					<% } else{ %>
						<button class="btn btn-sm btn-info" disabled><%=i %></button>									
					<% } %>
				<% } %>
								
				<% if(currentPage!=maxPage) { %>
					<button class="btn btn-sm btn-info" onclick="location.href='<%=contextPath%>/list.co?cpage=<%=currentPage+1 %>'">&gt;</button>
				<% } %>
			</div>
			<div class="contactwrite" align="right">
				<% if(loginUser != null) { %>
					<button type="button" class="btn btn-primary" onclick="contactPage();">작성하기</button>
				<% } %>
			</div>
			<div class="contactsearch" align="center">
				<form action="search.co" id="search_form">
                    <div id="search_text">
                        <input type="text" name="query" style="width: 300px;" placeholder="키워드를 입력하세요.">
                    </div>
                    <div id="search_btn">
                        <input type="submit" value="검색">
                    </div>
                </form>
			</div>
			
			<!-- noUser -->
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

			<div class="contacttable">
				<table class="list-area" align="center">
					<thead>
						<tr>
							<th width="100">번호</th>					
							<th width="400">제목</th>	
							<th width="100">작성자</th>	
							<th width="150">작성일</th>
							<th width="150">답변상태</th>
						</tr>
					</thead>
					<tbody>
						<% if(list.isEmpty()) { %>
							<tr>
								<td colspan="5">문의가 존재하지 않아요 x</td>
							</tr>
						<% } else { %>
							<% for(Contact c : list) { %>
								<tr class="exist">
									<td><%= c.getContactNo() %></td>
									<td><%= c.getQuestionTitle() %></td>
									<td><%= c.getNickName() %></td>
									<td><%= c.getContactDate() %></td>
									<td><% if(c.getAnswerYN().equals("N")) {%> 
											처리 중
										<% } else { %>
											답변 완료
										<% }%>
									</td>
								</tr>
							<% } %>
						<% } %>
					</tbody>
				</table>
			</div>

			<br><br>
			<div align="center" class="paging-area">
				<% if(currentPage!=1) { %>
					<button class="btn btn-sm btn-info" onclick="location.href='<%=contextPath%>/list.co?cpage=<%=currentPage-1 %>'">&lt;</button>
				<% } %>
					
				<% for(int i=startPage; i<=endPage; i++) {%>
						
					<% if(currentPage !=i) { %>				
						<button class="btn btn-sm btn-info" onclick="location.href='<%=contextPath%>/list.co?cpage=<%=i%>'"><%=i %></button>
					<% } else{ %>
						<button class="btn btn-sm btn-info" disabled><%=i %></button>									
					<% } %>
				<% } %>
								
				<% if(currentPage!=maxPage) { %>
					<button class="btn btn-sm btn-info" onclick="location.href='<%=contextPath%>/list.co?cpage=<%=currentPage+1 %>'">&gt;</button>
				<% } %>
			</div>

		<% } %>
	</div>
	
	<script>
	
		function contactPage(){
            location.href = "<%= contextPath %>/insert.co"
        }
		
		$(function(){
			
			$('.list-area > tbody > .exist').click(function(){
				var nno=$(this).children().eq(0).text();
				
				if(nno!=null) location.href="<%=contextPath%>/detail.co?nno="+nno;
			});
		
		})
	</script>

</body>
</html>