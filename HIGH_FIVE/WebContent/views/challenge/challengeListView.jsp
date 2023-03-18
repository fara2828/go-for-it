<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ page import="java.util.ArrayList, com.highfive.challenge.model.vo.Challenge" %>
<%
	ArrayList<Challenge> list = (ArrayList<Challenge>)request.getAttribute("list");
%>   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>챌린지목록~~~~~~~</title>

<%@ include file="../common/menubar2.jsp" %>
<style>
	body { 
		width: 1200px;
		margin: auto;
	}

	.outer {
		margin : auto;
	}

	.item-area {
		display: inline-flex;
	}
	.img-area img {
		width: 250px;
		height: 250px;
		margin-left: 10px;
		margin-right: 10px;
		border-radius: 5%;
	}

	.list-text-area {
		margin-top: 10px;
	}

	.select-area {
		margin-right: 80px;
	}

	.item-area a {
		text-decoration: none;
		color: rgb(100, 100, 100);   
	}

	.item-area:hover a p {
		color: rgb(10, 10, 10);
	}

	.item-area h4 {
		color: rgb(81, 116, 220); 
	}

	.item-area:hover h4{
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

    .title-area input {
        width: 100%;
    }
</style>
<script src="https://kit.fontawesome.com/aa839e973e.js" crossorigin="anonymous"></script>

</head>
<body>
   
	<div class="outer" align="center">
        <div class="header">
            <h1>😎챌린지 목록😎</h1>
        </div>


		<div class="category-area" align="center">
			<div class="form-check-inline">
				<label class="form-check-label">
					<input type="radio" class="form-check-input" name="challCategory" value="all" checked>
					<span>
						전체
					</span>
				</label>
				<label class="form-check-label">
					<input type="radio" class="form-check-input" name="challCategory" value="루틴만들기">
					<span>
						루틴만들기
					</span>
				</label>
				<label class="form-check-label">
					<input type="radio" class="form-check-input" name="challCategory" value="스터디">
					<span>
						스터디
					</span>
				 </label>
				<label class="form-check-label">
					<input type="radio" class="form-check-input" name="challCategory" value="외국어">
					<span>
						외국어
					</span>
				 </label>
				<label class="form-check-label">
					<input type="radio" class="form-check-input" name="challCategory" value="운동">
					<span>
						운동
					</span>
				 </label>
				<label class="form-check-label">
					<input type="radio" class="form-check-input" name="challCategory" value="멘탈케어">
					<span>
						멘탈케어
					</span>
				 </label>
				 <!-- 
				<label class="form-check-label">
					<input type="radio" class="form-check-input" name="challCategory" value="헬스케어">
					<span>
						헬스케어
					</span>
				 </label>
				  -->
				<label class="form-check-label">
					<input type="radio" class="form-check-input" name="challCategory" value="취미">
					<span>
						취미
					</span>
				 </label>
				<label class="form-check-label">
					<input type="radio" class="form-check-input" name="challCategory" value="기타">
					<span>
						기타
					</span>
				 </label>
			</div>
		</div>

		<% if(loginUser != null) { %>
		<div>
			<a class="btn btn-info" href="<%= contextPath %>/make.ch"><i class="fa-solid fa-plus"></i></a>
		</div>
		<% } %>
		

		<div class="select-area" align="right">
            <select name="order" id="order-select" onchange="orderBy();">
                <option value="CHALL_COUNT" selected>인기순</option>
                <option value="CHALL_POSTDATE">최신순</option>
                <option value="CHALL_PARTICIPANT_NOW">참여자순</option>
            </select>
        </div>

		<br>

		<div class="list-area">
			
		</div>
	</div>
    
    <script>
        
        function orderBy() {
            var orderBy = $('#order-select').val();
			var where = $('input[name="challCategory"]:checked').val();

            $.ajax({
                url : 'olist.ch',
                data : {
                    orderByQuery : $('#order-select').val(),
					whereQuery : $('input[name="challCategory"]:checked').val()
                },
                success : function(list) {

                    var result = '';
                    for(var i in list) {
						
                        result += '<div class="item-area">'
								+ '<a href="<%= contextPath %>/detail.ch?cno=' + list[i].challNo + '">'
								+ '<div class="img-area">'
								+ '<img src="' + list[i].challThumbnail + '">'
								+ '</div>'
								+ '<div class="list-text-area">'
								+ '<h4>' + list[i].challName + '</h4>'
								+ '<p>' + list[i].challStart + '~' + list[i].challEnd + '<br>'
								+ list[i].challDayCount +' 일 동안<br>'
								+ '주 ' + list[i].challFrequency + '회 인증'
								+ '</p>'
								+ '</div>' + '</a>'
								+ '</div>';
									

						if(i % 4 == 3) {
							result += '<br><br><br>';
						}
                    }

                    $('.list-area').html(result);

                },
                error : function() {
                    console.log('실패');
                }
            })

        }
        
		$('input[name="challCategory"]').change(function() {
			orderBy();
		});

        $(function() {
            orderBy();
        });
    </script>
	
</body>
</html>