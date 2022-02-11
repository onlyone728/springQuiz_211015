<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="content">
	<div class="title_area d-flex justify-content-center align-items-center">
		<h1>예약 하기</h1>
	</div>
	<div class="reservation-form col-5">
		<div class="form-group">
			<label for="name">이름</label>
			<input type="text" id="name" class="form-control">
		</div>
		
		<div class="form-group">
			<label for="date">예약날짜</label>
			<input type="text" id="date" class="form-control">
		</div>
		
		<div class="form-group">
			<label for="day">숙박일수</label>
			<input type="number" id="day" class="form-control">
		</div>
		
		<div class="form-group">
			<label for="headcount">숙박인원</label>
			<input type="number" id="headcount" class="form-control">
		</div>
		
		<div class="form-group">
			<label for="phoneNumber">전화번호</label>
			<input type="text" id="phoneNumber" class="form-control" placeholder="예)010-0000-0000">
		</div>
		
		<button type="button" id="reservation-btn" class="btn btn-warning btn-block">예약하기</button>
	</div>
</div>

<script>
$(document).ready(function() {
	// datepicker 추가
	$('#date').datepicker({
		dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'] // 요일을 한글로 변경
    	, dateFormat: 'yy-mm-dd'
    	, showButtonPanel: true // 오늘 버튼 노출
        , minDate:0 // 오늘과 그 이후만 선택 가능
	});
	
	// validation check
	$('#reservation-btn').on('click', function() {
		let name = $('#name').val().trim();
		let date = $('#date').val().trim();
		let day = $('#day').val().trim();
		let headcount = $('#headcount').val().trim();
		let phoneNumber = $('#phoneNumber').val().trim();
		
		if (name == '') {
			alert("이름을 입력해주세요.");
			return;
		}
		if (date == '') {
			alert("예약날짜를 선택해주세요.");
			return;
		}
		if (day == '') {
			alert("숙박일수를 입력해주세요.");
			return;
		}
		if (headcount == '') {
			alert("숙박인원을 입력해주세요.");
			return;
		}
		if (phoneNumber == '') {
			alert("전화번호를 입력해주세요.");
			return;
		}
		
		$.ajax({
			type: "POST"
			, url: "/tongnamu/add_reservation"
			, data: {"name": name, "date": date, "day": day, "headcount": headcount, "phoneNumber": phoneNumber}
			, success: function(data) {
				if (data.result) {
					alert("이름 : " + name + "\n예약날짜 : " + date + "\n숙박일수 : " + day 
							+ "\n숙박인원 : " + headcount + "\n전화번호 : " + phoneNumber + "\n예약이 접수되었습니다.");
					location.href = "/tongnamu/reservation_list";
				}
			}
			, error: function(e) {
				alert("error");
			}
		});
	});
});
</script>