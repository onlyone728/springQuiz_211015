<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="content col-10 p-5">
	<h1>날씨 입력</h1>
	<div class="mt-5">
		<form method="post" action="/lesson05/quiz05AfterAddWeather">
			<div class="form-row w-100">
				<div class="form-group col-4 d-flex">
					<label for="date" class="mt-2 col-4 d-flex justify-content-end">날짜</label>
					<input type="date" id="date" name="date" class="form-control col-8">
				</div>
				<div class="form-group col-4 d-flex">
					<label for="weather" class="mt-2 col-4 d-flex justify-content-end">날씨</label>
					<select id="weather" name="weather" class="form-control col-8">
						<option value="맑음">맑음</option>
						<option value="구름조금">구름조금</option>
						<option value="흐림">흐림</option>
						<option value="비">비</option>
					</select>
				</div>
				<div class="form-group col-4 d-flex">
					<label for="microDust"
						class="mt-2 col-4 d-flex justify-content-end">미세먼지</label> 
						<select	id="microDust" name="microDust" class="form-control col-8">
						<option value="좋음">좋음</option>
						<option value="보통">보통</option>
						<option value="나쁨">나쁨</option>
						<option value="최악">최악</option>
					</select>
				</div>
			</div>

			<div class="form-row w-100 mt-4">
				<div class="form-group col-4 d-flex">
					<label for="temperatures"
						class="mt-2 col-4 d-flex justify-content-end">기온</label>
					<div class="input-group w-100">
						<input type="text" id="temperatures" name="temperatures"
							class="form-control col-10">
						<div class="input-group-append">
							<span class="input-group-text">℃</span>
						</div>
					</div>
				</div>
				<div class="form-group col-4 d-flex">
					<label for="precipitation"
						class="mt-2 col-4 d-flex justify-content-end">강수량</label>
					<div class="input-group w-100">
						<input type="text" id="precipitation" name="precipitation"
							class="form-control col-10">
						<div class="input-group-append">
							<span class="input-group-text">mm</span>
						</div>
					</div>
				</div>
				<div class="form-group col-4 d-flex">
					<label for="windSpeed"
						class="mt-2 col-4 d-flex justify-content-end">풍속</label>
					<div class="input-group w-100">
						<input type="text" id="windSpeed" name="windSpeed"
							class="form-control col-10">
						<div class="input-group-append">
							<span class="input-group-text">km/h</span>
						</div>
					</div>
				</div>
			</div>
			<div class="d-flex justify-content-end mr-2 mt-4">
				<input type="submit" value="저장" class="btn btn-success">
			</div>
		</form>
	</div>
</div>


<script>
	$(document).ready(function() {
		// 모든 데이터피커에 적용
		$.datepicker.setDefaults({
			dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ] // 요일을 한글로 변경
			,
			dateFormat : 'yy-mm-dd'
		});

		// 오늘 날짜로 이동하는 함수
		$.datepicker._gotoToday = function(id) {
			$(id).datepicker('setDate', new Date()).datepicker('hide').blur();
		};

		$('#date').datepicker({
			showButtonPanel : true // 오늘 버튼 노출
		});
	});
</script>