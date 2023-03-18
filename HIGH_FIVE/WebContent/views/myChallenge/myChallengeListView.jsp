<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.highfive.challenge.model.vo.*" %>
<%
	ArrayList<Challenge> madeByMeList = (ArrayList<Challenge>)request.getAttribute("madeByMeList");
	ArrayList<Challenge> joinNowList = (ArrayList<Challenge>)request.getAttribute("joinNowList");
	ArrayList<Challenge> readyList = (ArrayList<Challenge>)request.getAttribute("readyList");
	ArrayList<Challenge> endList = (ArrayList<Challenge>)request.getAttribute("endList");

 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 챌린지</title>
</head>
<%@ include file="../common/menubar2.jsp" %>
<style>
    body { 
		width: 1200px;
		margin: auto;
	}

	.outer {
		margin : auto;
	}

    .title-area {
        display: inline-flex;
        width: 100%;
    }

    .title-area p {
        margin-top: auto;
        margin-bottom: auto;
        margin-left: 12px;
        font-size: 18px;
    }

    .inline-flex {
        display: inline-flex;
    }

    .img-area img{
        width: 350px;
        height: 250px;
        margin-left: 10px;
        margin-right: 10px;
        border-radius: 5%;
    }
</style>
<script src="https://kit.fontawesome.com/aa839e973e.js" crossorigin="anonymous"></script>

<body>


    <div class="outer" align="center">

        <div class="madeByMe">
			<div class="title-area" align="center">
				<a href="<%= contextPath %>/madeByMeDetail.ch"><h1>내가 만든 챌린지</h1></a>
				<p><%= madeByMeList.size() %> 건</p>
			</div>

			<% if(madeByMeList.size() == 0) { %> 
				<div class="list-area">
					<p align="center"> 내가 만든 챌린지가 없습니다.</p>
				</div>
			<% } else { %> 
				<div class="list-area inline-flex">
					<% if(madeByMeList.size() < 3 ) { %> 
						<% for(Challenge c : madeByMeList) { %>
							<div class="content">
								<a href="<%= contextPath %>/detail.ch?cno=<%= c.getChallNo() %>">
									<div class="img-area">
										<img src="<%= c.getChallThumbnail() %>">
									</div>
									<div class="content-text-area">
										<p align="center">
											<% if(c.getChallPublic().equals("N")) { %> 
												<i class="fa-solid fa-lock"></i> 
											<% } %>
											<%= c.getChallName() %>(<%= c.getChallStart() %> ~ <%= c.getChallEnd() %>)
										</p>
									</div>
								</a>
							</div>
						<% } %>
					<% } else { %>
						<% for(int i=0; i<3; i++) { %>
							<div class="content">
								<a href="<%= contextPath %>/detail.ch?cno=<%= madeByMeList.get(i).getChallNo() %>">
									<div class="img-area">
										<img src="<%= madeByMeList.get(i).getChallThumbnail() %>">
									</div>
									<div class="content-text-area">
										<p align="center">
											<% if(madeByMeList.get(i).getChallPublic().equals("N")) { %> 
												<i class="fa-solid fa-lock"></i> 
											<% } %>
											<%= madeByMeList.get(i).getChallName() %>(<%= madeByMeList.get(i).getChallStart() %> ~ <%= madeByMeList.get(i).getChallEnd() %>)
										</p>
									</div>
								</a>
							</div>
						<% } %>
					<% } %>

				</div>
			<% } %>
        </div>

		<hr>

		<div class="joinNow">
			<div class="title-area" align="center">
				<a href="<%= contextPath %>/joinNowDetail.ch"><h1>참여중인 챌린지</h1></a>
				<p><%= joinNowList.size() %> 건</p>
			</div>

			<% if(joinNowList.size() == 0) { %> 
				<div class="list-area">
					<p align="center">참여중인 챌린지가 없습니다.</p>
				</div>
			<% } else { %> 
				<div class="list-area inline-flex">
					<% if(joinNowList.size() < 3 ) { %> 
						<% for(Challenge c : joinNowList) { %>
							<div class="content">
								<a href="<%= contextPath %>/detail.ch?cno=<%= c.getChallNo() %>">
									<div class="img-area">
										<img src="<%= c.getChallThumbnail() %>">
									</div>
									<div class="content-text-area">
										<p align="center">
											<% if(c.getChallPublic().equals("N")) { %> 
												<i class="fa-solid fa-lock"></i> 
											<% } %>
											<%= c.getChallName() %>(<%= c.getChallStart() %> ~ <%= c.getChallEnd() %>)
										</p>
									</div>
								</a>
							</div>
						<% } %>
					<% } else { %>
						<% for(int i=0; i<3; i++) { %>
							<div class="content">
								<a href="<%= contextPath %>/detail.ch?cno=<%= joinNowList.get(i).getChallNo() %>">
									<div class="img-area">
										<img src="<%= joinNowList.get(i).getChallThumbnail() %>">
									</div>
									<div class="content-text-area">
										<p align="center">
											<% if(joinNowList.get(i).getChallPublic().equals("N")) { %> 
												<i class="fa-solid fa-lock"></i> 
											<% } %>
											<%= joinNowList.get(i).getChallName() %>(<%= joinNowList.get(i).getChallStart() %> ~ <%= joinNowList.get(i).getChallEnd() %>)
										</p>
									</div>
								</a>
							</div>
						<% } %>
					<% } %>

				</div>
			<% } %>
        </div>

		<hr>

		<div class="joinReady">
			<div class="title-area" align="center">
				<a href="<%= contextPath %>/joinReadyDetail.ch"><h1>참여예정 챌린지</h1></a>
				<p><%= readyList.size() %> 건</p>
			</div>

			<% if(readyList.size() == 0) { %> 
				<div class="list-area">
					<p align="center">참여예정 챌린지가 없습니다.</p>
				</div>
			<% } else { %> 
				<div class="list-area inline-flex">
					<% if(readyList.size() < 3 ) { %> 
						<% for(Challenge c : readyList) { %>
							<div class="content">
								<a href="<%= contextPath %>/detail.ch?cno=<%= c.getChallNo() %>">
									<div class="img-area">
										<img src="<%= c.getChallThumbnail() %>">
									</div>
									<div class="content-text-area">
										<p align="center">
											<% if(c.getChallPublic().equals("N")) { %> 
												<i class="fa-solid fa-lock"></i> 
											<% } %>
											<%= c.getChallName() %>(<%= c.getChallStart() %> ~ <%= c.getChallEnd() %>)
										</p>
									</div>
								</a>
							</div>
						<% } %>
					<% } else { %>
						<% for(int i=0; i<3; i++) { %>
							<div class="content">
								<a href="<%= contextPath %>/detail.ch?cno=<%= readyList.get(i).getChallNo() %>">
									<div class="img-area">
										<img src="<%= readyList.get(i).getChallThumbnail() %>">
									</div>
									<div class="content-text-area">
										<p align="center">
											<% if(readyList.get(i).getChallPublic().equals("N")) { %> 
												<i class="fa-solid fa-lock"></i> 
											<% } %>
											<%= readyList.get(i).getChallName() %>(<%= readyList.get(i).getChallStart() %> ~ <%= readyList.get(i).getChallEnd() %>)
										</p>
									</div>
								</a>
							</div>
						<% } %>
					<% } %>

				</div>
			<% } %>
        </div>

		<hr>

		<div class="joinEnd">
			<div class="title-area" align="center">
				<a href="<%= contextPath %>/joinEndDetail.ch"><h1>참여완료 챌린지</h1></a>
				<p><%= endList.size() %> 건</p>
			</div>

			<% if(endList.size() == 0) { %> 
				<div class="list-area">
					<p align="center">참여완료 챌린지가 없습니다.</p>
				</div>
			<% } else { %> 
				<div class="list-area inline-flex">
					<% if(endList.size() < 3 ) { %> 
						<% for(Challenge c : endList) { %>
							<div class="content">
								<a href="<%= contextPath %>/detail.ch?cno=<%= c.getChallNo() %>">
									<div class="img-area">
										<img src="<%= c.getChallThumbnail() %>">
									</div>
									<div class="content-text-area">
										<p align="center">
											<% if(c.getChallPublic().equals("N")) { %> 
												<i class="fa-solid fa-lock"></i> 
											<% } %>
											<%= c.getChallName() %>(<%= c.getChallStart() %> ~ <%= c.getChallEnd() %>)
										</p>
									</div>
								</a>
							</div>
						<% } %>
					<% } else { %>
						<% for(int i=0; i<3; i++) { %>
							<div class="content">
								<a href="<%= contextPath %>/detail.ch?cno=<%= endList.get(i).getChallNo() %>">
									<div class="img-area">
										<img src="<%= endList.get(i).getChallThumbnail() %>">
									</div>
									<div class="content-text-area">
										<p align="center">
											<% if(endList.get(i).getChallPublic().equals("N")) { %> 
												<i class="fa-solid fa-lock"></i> 
											<% } %>
											<%= endList.get(i).getChallName() %>(<%= endList.get(i).getChallStart() %> ~ <%= endList.get(i).getChallEnd() %>)
										</p>
									</div>
								</a>
							</div>
						<% } %>
					<% } %>

				</div>
			<% } %>
		</div>

	</div>

</body>
</html>