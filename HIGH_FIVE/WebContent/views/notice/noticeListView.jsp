<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.highfive.notice.model.vo.Notice, com.highfive.common.model.vo.PageInfo" %>    
<%
	ArrayList<Notice> list= (ArrayList<Notice>)request.getAttribute("list");
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
<title>공지사항 리스트</title>
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
    
    .list-area{
		text-align: center;
		border: 3px solid pink;
		font-size:15px;
	}
	.list-area>tbody>tr:hover{
		cursor:pointer;
		background: lightgrey;
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
                <h5 id="qna">Q&A</h5> 
                <br>
                <div>
                    <a href="<%= contextPath %>/faq" id="faq">FAQ</a> 
                    <br><br>
                    <a href="<%= contextPath %>/list.co?cpage=1" id="oneq">1:1문의</a> 
                    <br><br>
                    <a href="<%= contextPath %>/list.no?cpage=1" id="list.no">공지사항</a> 
                    <br><br>
                </div>
            </div>
        </div>

        <div class="contentbar">
        
            <div class="contenttitlebar">
            	<h3>&nbsp;&nbsp;&nbsp;&nbsp;공지사항</h3>
            	<hr>
            </div>

			<div class="outer">
				
				<table class="list-area" align="center">
					<thead>
						<tr>
							<th>글번호</th>					
							<th width="80">분류</th>	
							<th width="400">제목</th>	
							<th width="200">작성일</th>	
						</tr>
					</thead>
					<tbody>
						<!-- 공지사항이 있을 수도 있고 없을 수도 있음 -->
						<% if(list.isEmpty()) { %>
							
						<% } else { %>
							<% for(Notice n : list) { %>
								<tr>
									<th><%= n.getNo() %></th>
									<td><%= n.getKind() %></td>
									<td><%= n.getTitle() %></td>
									<td><%= n.getEnrollDate() %></td>
								</tr>
							<% } %>
						<% } %>
					</tbody>
				</table>
	
			<br><br><br>
			</div>
	
			<div align="center" class="paging-area">
				
				<% if(currentPage!=1) { %>
				<button class="btn btn-sm btn-info" onclick="location.href='<%=contextPath%>/list.no?cpage=<%=currentPage-1 %>'">&lt;</button>
				<% } %>
				
				<% for(int i=startPage; i<=endPage; i++) {%>
		
					<% if(currentPage !=i) { %>				
					<button class="btn btn-sm btn-info" onclick="location.href='<%=contextPath%>/list.no?cpage=<%=i%>'"><%=i %></button>
		
					<% } else{ %>
					<button class="btn btn-sm btn-info" disabled><%=i %></button>					
		
					<% } %>
				<% } %>
		
				<% if(currentPage!=maxPage) { %>
				<button class="btn btn-sm btn-info" onclick="location.href='<%=contextPath%>/list.no?cpage=<%=currentPage+1 %>'">&gt;</button>
				<% } %>
			</div>
	
			<% if(loginUser.getUserType().equals("A")) { %>
				
				<div style="width:850px; font-size:22px;" align="right">
					
					<a class="btn btn-sm btn-info" href="<%=contextPath %>/insert.no">글작성</a>
				
				</div>
				
			<% } %>

        </div>

    	<!-- 비회원 -->
    	<% } else{ %>
    	
    	<div class="navibar">

            <br>
            <hr>
            <div id="navibar5">
                <h5 id="qna">Q&A</h5> 
                <br>
                <div>
                    <a href="<%= contextPath %>/faq" id="faq">FAQ</a> 
                    <br><br>
                    <a href="<%= contextPath %>/list.co?cpage=1" id="oneq">1:1문의</a> 
                    <br><br>
                    <a href="<%= contextPath %>/list.no?cpage=1" id="list.no">공지사항</a> 
                    <br><br>
                </div>
            </div>
        </div>

        <div class="contentbar">
        
            <div class="contenttitlebar">
            	<h3>&nbsp;&nbsp;&nbsp;&nbsp;공지사항</h3>
            	<hr>
            </div>

		<div class="outer">
			
			<table class="list-area" align="center">
				<thead>
					<tr>
						<th>글번호</th>					
						<th width="80">분류</th>	
						<th width="400">제목</th>	
						<th width="200">작성일</th>	
					</tr>
				</thead>
				<tbody>
					<!-- 공지사항이 있을 수도 있고 없을 수도 있음 -->
					<% if(list.isEmpty()) { %>
						
					<% } else { %>
						<% for(Notice n : list) { %>
							<tr>
								<th><%= n.getNo() %></th>
								<td><%= n.getKind() %></td>
								<td><%= n.getTitle() %></td>
								<td><%= n.getEnrollDate() %></td>
							</tr>
						<% } %>
					<% } %>
				</tbody>
			</table>

		<br><br><br>
		</div>

	
			<div align="center" class="paging-area">
				
				<% if(currentPage!=1) { %>
				<button class="btn btn-sm btn-info" onclick="location.href='<%=contextPath%>/list.no?cpage=<%=currentPage-1 %>'">&lt;</button>
				<% } %>
				
				<% for(int i=startPage; i<=endPage; i++) {%>
		
					<% if(currentPage !=i) { %>				
					<button class="btn btn-sm btn-info" onclick="location.href='<%=contextPath%>/list.no?cpage=<%=i%>'"><%=i %></button>
		
					<% } else{ %>
					<button class="btn btn-sm btn-info" disabled><%=i %></button>					
		
					<% } %>
				<% } %>
		
				<% if(currentPage!=maxPage) { %>
				<button class="btn btn-sm btn-info" onclick="location.href='<%=contextPath%>/list.no?cpage=<%=currentPage+1 %>'">&gt;</button>
				<% } %>
			</div>
		</div>
		
    	<% } %>
    </div>
    
    
	<script>
		$(function(){
			
			$('.list-area>tbody>tr').click(function(){
				var nno=$(this).children().eq(0).text();
			
				//get 방식: /detail.no?nno=글번호
				location.href="<%=contextPath%>/detail.no?nno="+nno;
			});
			
		})
	</script>

</body>
</html>