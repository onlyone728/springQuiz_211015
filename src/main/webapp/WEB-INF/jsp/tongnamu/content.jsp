<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="content">
 <div class="banner">
 	<img id="banner-img" alt="이미지" src="/images/test06_banner1.jpeg" width="100%">
 </div>
 
 <section class="bottom-section d-flex">
 	<div class="box-1 col-4 d-flex justify-content-center align-items-center">
 		<a href="/tongnamu/reservation" class="display-4">실시간<br>예약하기</a>
 	</div>
 	<div class="box-2 col-4 p-3">
 		<h2>예약 확인</h2>
 		<div class="form-group form-inline text-right">
 			<label for="name" class="mr-2 col-3">이름 : </label>
 			<input type="text" id="name" class="form-control col-7">
 		</div>
 		<div class="form-group form-inline">
 			<label for="phoneNumber" class="mr-2 col-3">전화번호 : </label>
 			<input type="text" id="phoneNumber" class="form-control col-7" placeholder="예)010-0000-0000">
 		</div>
 		
 		<button type="button" id="search-btn" class="btn btn-success">조회하기</button>
 	</div>
 	<div class="box-1 col-4">
 		<div class="txt-box">
	 		<div class="txt-1">예약문의 : </div>
	 		<div class="txt-2">010-<br>0000-1111</div>
 		</div>
 	</div>
 </section>
</div>

<script>
$(document).ready(function() {
	// banner img 
	/* let bannerArr = ['/images/test06_banner1.jpeg', 
		'/images/test06_banner2.jpeg', 
		'/images/test06_banner3.jpeg', 
		'/images/test06_banner4.jpeg']
	let currentIndex = 1;
	setInterval(function() {
        $('#banner-img').attr('src', bannerArr[currentIndex]);
        currentIndex++;

        if (currentIndex > bannerArr.length) { 
            currentIndex = 0;
        }
    }, 3000); */
	
	// 예약 확인
	$("#search-btn").on('click', function() {
		// 유효성 체크
		let name = $('#name').val().trim();
		let phoneNumber = $('#phoneNumber').val().trim();
		
		if (name == '') {
			alert("이름을 입력하세요.");
			return;
		}
		if (phoneNumber == '') {
			alert("전화번호를 입력하세요.");
			return;
		}
		
		$.ajax({
			type: "POST"
			, url: "/tongnamu/search_reservation"
			, data: {"name": name, "phoneNumber": phoneNumber}
			, success: function(data) {
				if (data.name == undefined || data == null) {
					alert("확인된 예약이 없습니다.");
					location.reload();
				} else {
					alert("이름 : " + data.name + "\n예약날짜 : " + data.date + "\n숙박일수 : " + data.day 
							+ "\n숙박인원 : " + data.headcount + "\n상태 : " + data.state);
					location.reload();
				}
			}
			, error: function(e) {
				alert("error");
			}
		});
	});
});
</script>