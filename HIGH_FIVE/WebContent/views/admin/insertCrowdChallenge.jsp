<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.highfive.crowdChallenge.model.vo.CrowdChallenge" %>
<%
	CrowdChallenge crowdChallenge = (CrowdChallenge)request.getAttribute("crowdChallenge");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>InsertCrowdChallenge</title>
<%@ include file="../common/menubar2.jsp" %>

<style>
    body { 
		width: 1200px;
		margin: auto;
	}

	.outer {
		margin : auto;
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


<body>

    <div class="outer">
        <h1 align="center" style="color: #007bff;">챌린지 만들기</h1>
        
        <form action="<%= contextPath %>/insert.ch" id="enroll-form" method="post" enctype="multipart/form-data">
            <h4>챌린지 카테고리 <i class="fa-solid fa-check" style="color: tomato;"></i></h4>
            <div class="category-area" align="center">
                <div class="form-check-inline">
                    <label class="form-check-label">
                        <input type="radio" class="form-check-input" name="challCategory" value="루틴만들기" checked>
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
                    <label class="form-check-label">
                        <input type="radio" class="form-check-input" name="challCategory" value="헬스케어">
                        <span>
                            헬스케어
                        </span>
                     </label>
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
            
            <hr>

            <div class="title-area">
                <h4>챌린지 제목 <i class="fa-solid fa-check" style="color: tomato;"></i></h4>
                <input class="form-control" type="text" name="challName" placeholder="직접입력" value="<%= crowdChallenge.getCrowdName() %>" readonly>
            </div>

            <hr>

            <h4>인증 빈도 <i class="fa-solid fa-check" style="color: tomato;"></i></h4>
            <div class="form-group">
                <select class="form-control" id="frequency" name="challFrequency">
                    <option value="1" selected>주 1일</option>
                    <option value="2">주 2일</option>
                    <option value="3">주 3일</option>
                    <option value="4">주 4일</option>
                    <option value="5">주 5일</option>
                    <option value="6">주 6일</option>
                    <option value="7">매일</option>
                    <option value="8">평일 매일</option>
                    <option value="9">주말 매일</option>
                </select>
            </div>

            <hr>
            
            <h4>시작일 <i class="fa-solid fa-check" style="color: tomato;"></i></h4>
            <input class="form-control" type="date" name="challStart" id="challStart" value="<%= crowdChallenge.getCrowdPostDate() %>" readonly>

            <hr>

            <h4>챌린지 기간 <i class="fa-solid fa-check" style="color: tomato;" value="<%= crowdChallenge.getCrowdPeriod() %>" readonly></i></h4>
            <div class="form-group">
                <select class="form-control" id="endDate" name="challEnd">
                    <option value="1" selected>1주 동안</option>
                    <option value="2">2주 동안</option>
                    <option value="3">3주 동안</option>
                    <option value="4">4주 동안</option>
                    <option value="5">5주 동안</option>
                    <option value="6">6주 동안</option>
                    <option value="7">7주 동안</option>
                    <option value="8">8주 동안</option>
                </select>
            </div>

            <hr>

            <h4>모집 인원 <i class="fa-solid fa-check" style="color: tomato;"></i></h4>
            <div class="form-group" style="display: flex;">
                <input type="number" class="form-control" name="challParticipate" required>명
            </div>

            <hr>

            <h4>인증 방법 <i class="fa-solid fa-check" style="color: tomato;"></i></h4>
            <textarea class="form-control" style="resize: none;" name="challHowto" cols="55" rows="10" required value="#"></textarea>

            <hr>
 
            <h4>인증샷 예시</h4>
            <h5>인증샷 찍는 방법 <i class="fa-solid fa-check" style="color: tomato;"></i></h5>
            <textarea name="challPhothExp" class="form-control" style="resize: none;" cols="55" rows="10" required placeholder="인증샷 예시에 대한 설명을 적어주세요."></textarea>
            <br>
            <h5>인증샷 사진 예시</h5>
            <div align="center" class="form-group">
                <img width="33%" height="300" id="contentImg1">
                <img width="33%" height="300" id="contentImg2">
                <img width="33%" height="300" id="contentImg3">
            </div>

            <hr>

            <h4>챌린지 소개 <i class="fa-solid fa-check" style="color: tomato;"></i></h4>
            <textarea class="form-control" style="resize: none;" name="challIntroduction" cols="55" rows="10" required><%= crowdChallenge.getCrowdExp() %></textarea>

            <hr>

            <h4>챌린지 소개 사진(썸네일) <i class="fa-solid fa-check" style="color: tomato;"></i></h4>
            <div class="form-group" align="center">
                <img width="600" height="400" id="thumbnailImg">
            </div>
            
            <hr>


            <hr>        

            <br><br><br>

            <div align="center">
                <button type="submit" class="btn btn-primary btn-block" id="submitBtn" onclick="return submitCheck();">챌린지 만들기</button>
            </div>
            
            <div id="file-area">
                <input type="file" name="file1" id="file1" onchange="loadImg(this, 1);">
                <input type="file" name="file2" id="file2" onchange="loadImg(this, 2);">
                <input type="file" name="file3" id="file3" onchange="loadImg(this, 3);">
                <input type="file" name="file4" id="file4" required onchange="loadImg(this, 4);">
            </div>

			
            <input type="hidden" name="challPublic" value="Y">

            <input type="hidden" name="userNo" value="<%= loginUser.getUserNo() %>">
        </form>
    </div>

    <script>

        $(function() {

            document.getElementById('challStart').value = new Date().toISOString().substring(0, 10);

            $('#file-area').hide();

            $('#contentImg1').click(function() {
                $('#file1').click();
            });

            $('#contentImg2').click(function() {
                $('#file2').click();
            });

            $('#contentImg3').click(function() {
                $('#file3').click();
            });

            $('#thumbnailImg').click(function() {
                $('#file4').click();
            });

        });

        function loadImg(inputFile, num) {
            
            if(inputFile.files.length == 1) {
                // 파일 선택 후 미리보기

                var reader = new FileReader();  // 파일리더 객체 생성

                reader.readAsDataURL(inputFile.files[0]);   //inputFile.files[0] 에 파일이 담겨져있음

                // e.target.result에 각 파일의 url이 담김
                reader.onload = function(e) {    // 파일 읽기가 완료되면 실행할 함수를 정의
                    switch(num) {
                        case 1: $('#contentImg1').attr('src', e.target.result); break;
                        case 2: $('#contentImg2').attr('src', e.target.result); break;
                        case 3: $('#contentImg3').attr('src', e.target.result); break;
                        case 4: $('#thumbnailImg').attr('src', e.target.result); break;
                    }

                };
            } else {
                switch(num) {   //no img 표시
                    case 1: $('#contentImg1').attr('src', 'https://adventure.co.kr/wp-content/uploads/2020/09/no-image.jpg'); break;
                    case 2: $('#contentImg2').attr('src', 'https://adventure.co.kr/wp-content/uploads/2020/09/no-image.jpg'); break;
                    case 3: $('#contentImg3').attr('src', 'https://adventure.co.kr/wp-content/uploads/2020/09/no-image.jpg'); break;
                    case 4: $('#thumbnailImg').attr('src', 'https://adventure.co.kr/wp-content/uploads/2020/09/no-image.jpg'); break;
                }
            }
        };

    </script>  


</body>
</html>