<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import = "com.hwisu.model.vo.Member, com.hwisu.model.service.*" %>

<%	
	Member loginUser = new LoginDummyService().LoginDummy("user02","pass02");
	session.setAttribute("loginUser",loginUser);
	
	String contextPath = request.getContextPath();
	
	String alertMsg = (String)session.getAttribute("alertMsg");
%>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>

<body>
	
	<script>
		var msg = '<%=alertMsg%>';
		
		if(msg != 'null'){
			
			alert(msg);
			
			<% session.removeAttribute("alertMsg");%>
		}
	</script>

</body>