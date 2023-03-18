<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>챌린지를 만들어용</title>
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
            
            <hr>

            <div class="title-area">
                <h4>챌린지 제목 <i class="fa-solid fa-check" style="color: tomato;"></i></h4>
                <input class="form-control" type="text" name="challName" placeholder="직접입력" required>
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
            <input class="form-control" type="date" name="challStart" id="challStart" required>

            <hr>

            <h4>챌린지 기간 <i class="fa-solid fa-check" style="color: tomato;"></i></h4>
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
            <textarea class="form-control" style="resize: none;" name="challHowto" cols="55" rows="10" required placeholder="챌린지 인증 방법을 작성해주세요
            ex) 오늘 날짜와 걸음 수가 적힌 만보기 캡쳐 화면 업로드
            
            -챌린지가 시작되면 인증 방법을 수정할 수 없습니다. 신중히 작성해주세요.
            -참가자들이 혼란을 겪지 않도록 정확한 기준과 구체적인 인증방법을 적어주세요.
            -유저 챌린지에서 발생한 분쟁은 Go for It!이 관여하지 않습니다."></textarea>

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
            <textarea class="form-control" style="resize: none;" name="challIntroduction" cols="55" rows="10" required></textarea>

            <hr>

            <h4>챌린지 소개 사진(썸네일) <i class="fa-solid fa-check" style="color: tomato;"></i></h4>
            <div class="form-group" align="center">
                <img width="600" height="400" id="thumbnailImg">
            </div>
            
            <hr>
            <h4>약속해주세요🙂</h4>
            <div>
                <label>
                    <input type="checkbox" id="check1">
                    모두에게 기분 좋은 챌린지가 되도록 노력해주실거죠?<br>
                </label> <br>
                <label>
                    <input type="checkbox" id="check2">
                    참가자들의 의지가 모인 챌린지예요. 책임감 있게 관리해 주실 수 있죠?
                </label> <br>
                <label>
                    <input type="checkbox" id="check3">
                    공정한 인증샷 검토를 부탁드릴게요!! <br>
                    (유저가 개설한 챌린지의 인증샷 검토는 Go for It!에서 검토하지 않아요. 챌린지를 개설한 리더가 직접 검토해요)
                </label>
            </div>

            <hr>
            
            <h4>공개여부</h4>
            <div class="category-area" align="center">
                <div class="form-check-inline">
                    <label class="form-check-label">
                        <input type="radio" class="form-check-input" name="challPublic" value="Y" checked>
                        <span>공개</span>
                    </label>
                    <label class="form-check-label">
                        <input type="radio" class="form-check-input" name="challPublic" value="N">
                        <span>비공개</span>
                    </label>
                </div> 
            </div>

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


            <!-- The Modal -->
            <div class="modal" id="passwordModal">
                <div class="modal-dialog modal-lg">
                <div class="modal-content">
            
                    <!-- Modal Header -->
                    <div class="modal-header">
                    비공개 챌린지
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>
            
                    <!-- Modal body -->
                    <div class="modal-body" align="center">
                        비공개 챌린지 입니다. <br>
                        참여를 위한 비밀번호를 등록해주세요. <br><br>
                        비밀번호<input type="password" id="challPwd" name="challPwd"><button type="button" id="showButton" style="width:80px" class="btn btn-sm btn-outline-secondary">SHOW</button><br>
                        비밀번호 확인<input type="password" id="checkPwd"> <br>
                        <button type="submit" id="pwdBtn" class="btn btn-primary" onclick="return checkPwd();">챌린지 만들기</button>
                    </div>
                </div>
                </div>
            </div>


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

        function submitCheck() {

            var checkedArr = [];
            checkedArr[0] =  document.getElementById('check1').checked;
            checkedArr[1] =  document.getElementById('check2').checked;
            checkedArr[2] =  document.getElementById('check3').checked;

            if(checkedArr[0] == true && checkedArr[1] == true && checkedArr[2] == true) {
                
                if($('input[name=challPublic]:checked').val() == 'N') {

                    $('#submitBtn').attr('data-toggle', 'modal');
                $('#submitBtn').attr('data-target', '#passwordModal');

                    $('#pwdBtn').on('click', function() {
                        if($('challPwd').val() != '' && $('#checkPwd').val() != '') {
                            if($('#challPwd').val() == $('#checkPwd').val()) {
                                alert('비공개 챌린지 생성이 완료되었습니다! 내 챌린지 목록에서 확인해주세요.');
                                return true;
                            } else {
                                alert('입력하신 비밀번호가 다릅니다!');
                                return false;
                            }
                        }
                    });
                   
                } else {
                    alert('챌린지 생성이 완료되었습니다!');
                    return true;
                } 
                
            } else {
                alert('모든 항목을 약속해 주세요!');
            }

            return false;
        }

        function checkPwd() {

            if($('challPwd').val() != '' && $('#checkPwd').val() != ''){
                if($('#challPwd').val() == $('#checkPwd').val()) {
                    return true;
                } else {
                    alert('입력하신 비밀번호가 다릅니다!');
                    return false;
                }
            }

            $('#submitBtn').removeAttr('data-toggle');
            $('#submitBtn').removeAttr('data-target');

        }

        $('#showButton').click(function() {
        var btnText = $(this).text();
        if(btnText == 'SHOW') {
            $(this).text('HIDE');
            $('#challPwd').attr('type', 'text');
        } else {
            $(this).text('SHOW');
            $('#challPwd').attr('type', 'password');
        }

    });
    </script>
</body>
</html>