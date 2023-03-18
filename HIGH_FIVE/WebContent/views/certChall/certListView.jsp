<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.ArrayList, com.highfive.certBoard.model.vo.CertChall" %>
<%@ page import="java.util.HashMap" %>


<%@ include file="../common/menubar2.jsp" %>

<%
	ArrayList<CertChall> list = (ArrayList<CertChall>)request.getAttribute("list");
	int certCount = (int)(request.getAttribute("certCount"));		

 %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<style>

   body {   
   
		width: 1200px;
		margin: auto;
		line-height: 200%;

	}

	.outer {
		margin : auto;
		width: 1000px;
	}


	
	.item-area {
		display: inline-flex;
	}
	.img-area img {
		width: 300px;
		height: 250px;
		margin-left: 10px;
		margin-right: 10px;
		border-radius: 5%;
		object-fit: cover;
	}

	.item-area img {
	  transition: all 0.2s linear;
	}
	.item-area:hover img {
	  transform: scale(1.4);
	}

	
	.item-area {

	  margin: 0px auto;
	  overflow: hidden;
	}


	.item-area a {
		text-decoration: none;
		color: rgb(100, 100, 100);   
	}
	
	.img-area a {
		text-decoration: none;
		color: rgb(100, 100, 100);   
	}
	

	.item-area:hover a p {
		color: rgb(10, 10, 10);
	}

	.item-area h6 {
		color: rgb(100, 100, 100);; 
	}

	.item-area:hover h6{
		color: rgb(49, 81, 179); 
	}

	.form-check-label input[type=radio] {
        display: none;
    }

    .form-check-label input[type="radio"] + span {
        display: inline-block;
        padding: 10px 10px;
        border: 1px solid #dfdfdf;
        background-color: #ffffff;
        text-align: center;
        cursor: pointer;
        margin-right: 20px;
        border-radius: 10%;
    }

    .form-check-label input[type="radio"]:checked + span {
        background-color: #007bff;
        color: #ffffff;
    }


	
	
    th, td {
	padding-top: 20px;
    padding-bottom: 20px;
    padding-left: 30px;
    padding-right: 40px;
    }
    
    #tdBottom{
    	padding-right: 20px 20px 0px 30px;
    	margin-right: 10px;
       	align: bottom;
  	    valign: bottom;
  	    font-size: 16px;

    }
    
    #tdUp{
    	padding-right: 20px 20px 0px 30px;
    	margin-right:10px;
    	align: top;
    	valign: top;
    	font-size: 16px;
    }
    
    
    
    
    .withBorder	{
		border-collapse: collapse;
		width : 1000px;
		border: none;
		font-size: 20px;
		transition: 1s;
		border-spacing: 30px;		
		border: 1px dotted gray;
		padding : 10px 20px 20px 20px;

	}
	 
	 .withBorder tr:hover{
		cursor : pointer;
		background-color:#f3e9e9 !important;
		font-weight: bolder;
		font-size: 22px;
	
	}  
    

	 .withBorder div {
	 	
	 	height: 100px;
		display: table-cell; 
		vertical-align: middle;
		align:center;
		
			 	
	 }
    
    
    
   .myButton{ 
 		    background-color: #FFA500;
     		color: maroon;
     		text-align: center;
     		text-decoration: none;
     		display: inline-block;
     		border-radius: 5px;
     		font-size: 15px;
     		padding-top : 0px;
     		margin-top: 0px;
     		border-top: 0px; 
     		align: right; 		
     		
   	
    }
    
    h6 {
    	line-height: 150%;
    
    }
    
    
    
	  .img-area img {
	  transform: scale(1);
	  -webkit-transform: scale(1);
	  -moz-transform: scale(1);
	  -ms-transform: scale(1);
	  -o-transform: scale(1);
	  transition: all 0.3s ease-in-out;   
		
	}
	.img-area img:hover {
	  transform: scale(1.1);
	  -webkit-transform: scale(1.1);
	  -moz-transform: scale(1.1);
	  -ms-transform: scale(1.1);
	  -o-transform: scale(1.1);
	  overflow: hidden;
	}
 
    #popup_layer {position:fixed;top:0;left:0;z-index: 10000; width: 100%; height: 100%; background-color: rgba(0, 0, 0, 0.4);} 


.popup_box{position: relative;top:50%;left:50%; width:550px;transform:translate(-50%, -50%);z-index:1002;box-sizing:border-box;background:#fff;box-shadow: 2px 5px 10px 0px rgba(0,0,0,0.35);-webkit-box-shadow: 2px 5px 10px 0px rgba(0,0,0,0.35);-moz-box-shadow: 2px 5px 10px 0px rgba(0,0,0,0.35);}

.popup_box #popup_cont {padding:20px;line-height:1.4rem;font-size:14px;word-break: break-word;}
.popup_box #popup_cont h2 {padding:15px 0;color:#333;margin:0;}
.popup_box #popup_cont p{ border-top: 1px solid #666;padding-top: 10px; font-size: bolder; }

.popup_box .popup_btn {display:table; table-layout: fixed; width:100%; height:30px; border-radius: 10px; background:#aliceblue;word-break: break-word; display: flex; justify-content: center; border-color: white;}
.popup_box .popup_btn a {position: relative; display: table-cell; height:70px; color:#fff; font-size:17px;text-align:center;vertical-align:middle;text-decoration:none; background:#102c5c;}
.popup_box .popup_btn a:before{content:'';display:block;position:absolute;top:26px;right:29px;width:1px;height:21px;background:#fff;-moz-transform: rotate(-45deg); -webkit-transform: rotate(-45deg); -ms-transform: rotate(-45deg); -o-transform: rotate(-45deg); transform: rotate(-45deg);}
.popup_box .popup_btn a:after{content:'';display:block;position:absolute;top:26px;right:29px;width:1px;height:21px;background:#fff;-moz-transform: rotate(45deg); -webkit-transform: rotate(45deg); -ms-transform: rotate(45deg); -o-transform: rotate(45deg); transform: rotate(45deg);}


.popup_overlay{position:fixed;top:0px;right:0;left:0;bottom:0;z-index:1001;;background:rgba(0,0,0,0.5);}    

#popup_layer {
	display:none;
}

 .myButton{ 
 		    background-color: #FFA500;
ㅡ     		color: maroon;
     		text-align: center;
     		text-decoration: none;
     		display: inline-block;
     		border-radius: 5px;
     		font-size: 15px;
     		border-color : white
     		
     		
   	
    }


</style>
<script src="https://kit.fontawesome.com/aa839e973e.js" crossorigin="anonymous"></script>



<body>


<div id="popup_layer">
  <div class="popup_box">
      <!--팝업 컨텐츠 영역-->
      <div id="popup_cont">
          <h5>🎉 <%=loginUser.getNickName() %>님, 인증에 성공하였어요!!</h5>
          <p>
        
          </p>
      </div>
      <!--팝업 버튼 영역-->
      <div class="popup_btn" border="0px">
      	<button class="myButton" onclick="hidePop();" align="center" width="10px" height="5px">닫기</button>
      </div>
      <br>
  </div>
</div>
  
<div class="outer" align="center">
        <div class="header">        
  			<h1 align= "center">👌👌인증하기</h1>
  		</div>  		
		<div class="list-area" align="right">		
			<table>
				<tr>
					<td style="padding: 0px 0px 0px 70px">
						<div class="item-area" align="right" width="70px" height="20px">
							<a href="javascript:history.back();" class="myButton" width="10px" height="5px">돌아가기</a>
						</div>
					</td>
				</tr>
				<tr>
					<td>			
				 		<h4 style="color: 646464;">인증글 <%=certCount %> 개</h4>
					</td>
				</tr>
			</table>
		</div>
		
		<br>
		
		
		<% if(list.isEmpty()){ %>		
			등록된 게시글이 없습니다.			
		<% } else { %>
			<div class="list-area">					
				<table class="withBorder">
				
					<% for (CertChall cc : list){ %>		
						<tr class="img-area">					
							<input type="hidden" value="<%=cc.getCertNo()%>">
							<input type="hidden" value="<%=cc.getChallNo()%>">
						<% if (cc.getCertThumbnail() != null) { %>
							<td rowspan="3" width="25%"> 
								<img src="<%=cc.getCertThumbnail()%>" alt="">
							</td>
									
						<% } else { %>
							<td rowspan="3" width="25%"> 
								<img src="https://thumbs.dreamstime.com/b/no-image-available-icon-photo-camera-flat-vector-illustration-132483141.jpg" alt="">
								
							</td>
						<% } %>
						
							<td rowspan="3" width="50%"> 
								<div class="item-area">	
									<h6><%=cc.getCertExp() %></h6> 
								</div>		
							</td>
							</tr>
							<tr>	
								<td id="tdBottom" width="25%">
									<div class="item-area" align="left" valign="bottom">	
										<%=cc.getNickName() %>
									</div>							
								</td>
							</tr>
							<tr>	
								<td id="tdUp" align="left" valign="top">
									<div class="item-area" >	
										<%=cc.getCertDate() %>
									</div>		
								</td>
							</tr>	
					<% } %>	
									
			
				</table>
			</div>			
		<% } %>		

	<script>
		$(function(){
            
            <% if(request.getSession().getAttribute("certProgress") != null ){%>            
                  
        		<%        	
	        	HashMap<String, Integer> certProgress=	(HashMap<String, Integer>)(request.getSession().getAttribute("certProgress"));  %>	

	        	var challWeeks = Number(<%= certProgress.get("challWeeks")%>);
	        	var challFrequency = Number(<%= certProgress.get("challFrequency")%>);
	        	var requiredCerts  = Number(<%= certProgress.get("requiredCerts")%>);
	        	var countCert  = Number(<%= certProgress.get("countCert")%>);
        	 	var progressPerc = Math.ceil(countCert/requiredCerts*100)
    			
	            <% if(request.getSession().getAttribute("newLevel")!=null){ %>
	           		
	                var newLevel = <%= (int)(request.getSession().getAttribute("newLevel"))%>;
	            	
	                
	                 
	                switch (newLevel){
	                
	                case 1 : newLevel ="입문";
	                		break;
	                case 2 : newLevel ="하수";
	                		break;
	                case 3 : newLevel ="중수";
	                		break;
	                case 4 : newLevel ="고수";
	                		break;
	                case 5 : newLevel ="숙련";
	                		break;
	                case 6 : newLevel ="장인";
	                		break;
	                case 7 : newLevel ="신";
	                		break;
	                	                
	                
	                }
	                
	                
		           	   if(newLevel !=0){
		           	
		           		   $("#popup_layer").show();
		           		   
		           		   var pop_content = '<h5>축하합니다! <br>'
		           		   
		           		   
		           		   
		           		   					+ newLevel+' 로 레벨업 되었어요!<h5>'
		           		   					+ '<br><h6 style="line-height:200%"> 챌린지 목표 인증글 수  :'+(challWeeks*challFrequency) +'개'
		           		   					+ '<br> 나의 인증글 수 : '+ countCert +'개'
		           		   					+'<br> 인증 달성률 : '+progressPerc
		           		   					+'%</h6>'
		           		 
		           		   					
		           		   	
		           		   					
		           		/* 여기까지 */   					
		           		   					
		           		   					
		           		   					
		           		   $('#popup_cont p').html(pop_content);
		           		   console.log($('#popup_cont p'));
		    			 //alert('축하합니다 레벨이'+newLevel+'로 승급되었어요!\n 목표 인증글 수  :'+challWeeks*challFrequency +'\n 인증 달성률 :'+ceil((countCert/requiredCerts)*100)+'%');
		    			// session에 들어있는 alertMsg키값에 대한 벨류를 지워줘야함
		    			// menubar.jsp가 로딩될때마다 alert가 계속 뜰것이므로
		    			//==> XX.removeAttribute("키값");
						} else {
							   console.log($('#popup_cont p'));
								console.log(challWeeks);
								console.log(challFrequency);
							
							 $("#popup_layer").show();
			           		   
			           		   var pop_content = 
			           		   					'<h6 style="line-height:200%"><br> 목표 인증글 수  :'+(challWeeks*challFrequency) +'개'
			           		   					+ '<br> 나의 인증글 수 : '+ countCert +'개'
			           		   					+'<br>인증 달성률 :'+progressPerc
			           		   					+'%</h6>'
			           		   
			           		   $('#popup_cont p').html(pop_content);
							//alert(' 목표 인증글 수 :'+challWeeks*challFrequency +'\n 인증 달성률 :'+ (countCert/requiredCerts)*100);	

						}	 
							<% session.removeAttribute("newLevel");%>
		           	 
	    			
				<% } %>
						<% session.removeAttribute("certProgress") ;%>
    		<%}%>

    		
    		
    		
    		
			
		$('.img-area').click(function(){

				location.href = '<%=contextPath%>/detail.ce?certNo='+$(this).children().eq(0).val()+'&challNo='+$(this).children().eq(1).val();
				
			});
			
			
		});
		
		
		function hidePop(){
			

    		   $("#popup_layer").hide();
    		  
			
		}
		
			
	
		
		
	</script>
  
  
  </body>
</html>