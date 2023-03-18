<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.highfive.challenge.model.vo.Challenge" %>
<%
	// ArrayList<Challenge> list = (ArrayList<Challenge>)request.getAttribute("list");
%>   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GO FOR IT</title>
</head>
<style>

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

	.carousel-inner {
		height: 400px;
		width: 800px;
		background-color: rgba(86, 86, 86, 0.271);
	}

	.carousel-item {
		height: 100%;
		width: 100%;
	}
	.carousel-item img{
		width: 600px;
		height: 100%;
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

	.back-img {
		width: 100%;
		height: 100%;
	}
</style>
<body>
	<%@ include file="views/common/menubar2.jsp" %>
	
	<div id="demo" class="carousel slide" data-ride="carousel">

		<!-- Indicators -->
		<ul class="carousel-indicators">
		  <li data-target="#demo" data-slide-to="0" class="active"></li>
		  <li data-target="#demo" data-slide-to="1"></li>
		  <li data-target="#demo" data-slide-to="2"></li>
		</ul>
	  
		<!-- The slideshow -->
		<div class="carousel-inner">
		  
		</div>
	  
		<!-- Left and right controls -->
		<a class="carousel-control-prev" href="#demo" data-slide="prev">
		  <span class="carousel-control-prev-icon"></span>
		</a>
		<a class="carousel-control-next" href="#demo" data-slide="next">
		  <span class="carousel-control-next-icon"></span>
		</a>

	</div>

	<br>

	<div class="outer" align="center">
		<div class="category-area" align="center">
			<div class="form-check-inline">
				<label class="form-check-label">
					<input type="radio" class="form-check-input" name="challCategory" value="all">
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

		<br>

		<div class="list-area">
			<h1 align="left" style="padding-left: 100px;">루틴만들기</h1>
			<div id="list-area0">

			</div>

			<h1 align="left" style="padding-left: 100px;">스터디</h1>
			<div id="list-area1">

			</div>

			<h1 align="left" style="padding-left: 100px;">외국어</h1>
			<div id="list-area2">

			</div>

			<h1 align="left" style="padding-left: 100px;">운동</h1>
			<div id="list-area3">

			</div>

			<h1 align="left" style="padding-left: 100px;">멘탈케어</h1>
			<div id="list-area4">

			</div>
			
			<!-- 
			<h1 align="left" style="padding-left: 100px;">헬스케어</h1>
			<div id="list-area5">

			</div>
			 -->

			<h1 align="left" style="padding-left: 100px;">취미</h1>
			<div id="list-area6">

			</div>

			<h1 align="left" style="padding-left: 100px;">기타</h1>
			<div id="list-area7">

			</div>
		</div>
	</div>

	<script>
		function carouselView() {
			$.ajax({
				url : 'carousel.ch',
				success : function(list) {
					var result = '';
					for(var i=0; i<list.length; i++) {
						if(i == 0) {
							result += '<div align="center" class="carousel-item active">'
									+ '<a href="<%= contextPath %>/detail.ch?cno='+ list[i].challNo +'">'
						  			+ '<img src="' + list[i].challThumbnail + '" alt="Los Angeles" id="item1">'
									+ '<div class="carousel-caption">'
						  			+ '<h3>' + list[i].challName +'</h3>'
									+ '<p>' + list[i].challIntroduction + '</p>'
									+ '</div></a></div>'
						} else {
							result +='<div align="center" class="carousel-item">' 
									+ '<a href="<%= contextPath %>/detail.ch?cno='+ list[i].challNo +'">'
						  			+ '<img src="' + list[i].challThumbnail + '" alt="Los Angeles" id="item1">'
									+ '<div class="carousel-caption">'
									+ '<h3>' + list[i].challName +'</h3>'
									+ '<p>' + list[i].challIntroduction + '</p>'
									+ '</div></a></div>'
						}
					}
					
					$('.carousel-inner').html(result);
					
				}
			});
		}

		function orderBy() {
            var orderBy = $('#order-select').val();
			var where = $('input[name="challCategory"]:checked').val();

            $.ajax({
                url : 'olist.ch',
                data : {
                    orderByQuery : 'CHALL_COUNT',
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

		function indexList() {
			$.ajax({
				url : 'index.ch',
				success : function(list) {

					var result = ''
					var id = '#list-area';
					for(var i=0; i<list.length; i++) {
						result = '';
						for(var j=0; j<list[i].length; j++) {
						
							result += '<div class="item-area">'
								+ '<a href="<%= contextPath %>/detail.ch?cno=' + list[i][j].challNo + '">'
								+ '<div class="img-area">'
								+ '<img src="' + list[i][j].challThumbnail + '">'
								+ '</div>'
								+ '<div class="list-text-area">'
								+ '<h4>' + list[i][j].challName + '</h4>'
								+ '<p>' + list[i][j].challStart + '~' + list[i][j].challEnd + '<br>'
								+ list[i][j].challDayCount +' 일 동안<br>'
								+ '주 ' + list[i][j].challFrequency + '회 인증'
								+ '</p>'
								+ '</div>' + '</a>'
								+ '</div>';

						}
						id = '#list-area' + i;
						
						$(id).html(result);
					}

				}
			})
		}

		$('input[name="challCategory"]').change(function() {
			orderBy();
		});

		$(function() {
			carouselView();
			indexList();
		})
	</script>
</body>
</html>