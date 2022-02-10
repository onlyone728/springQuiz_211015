<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 추가</title>
<!-- bootstrap CDN link -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

  <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>즐겨찾기 추가하기</h1>
		
		<div class="form-group">
			<label for="name">제목</label>
			<input type="text" id="name" class="form-control">
		</div>
		
		<div class="form-group">
			<label for="url">주소</label>
			<div class="form-inline">
				<input type="text" id="url" class="form-control col-11">
				<button type="button" id="isDuplicationBtn" class="btn btn-info ml-2">중복확인</button>
			</div>
			<small id="isDuplicationText" class="text-danger d-none">중복된 url입니다.</small>
			<small id="availableUrlText" class="text-success d-none">저장 가능한 url입니다.</small>
		</div>
		
		<button type="button" id="addBtn" class="btn btn-success btn-block">추가</button>
	</div>
	
	
	<script>
	$(document).ready(function(){
		
		// 중복 확인
		$('#isDuplicationBtn').on('click', function(e) {
			let url = $('#url').val().trim();
			if (url == '') {
				alert("검사할 URL을 입력해주세요.");
				return;
			}
			
			$.ajax({
				type: "POST"
				, url: "/lesson06/is_duplication"
				, data: {"url": url}
				, success: function(data) {
					data.result
					if (data.result) {
						// 중복일 때
						$('#isDuplicationText').removeClass("d-none");
						$('#availableUrlText').addClass("d-none");
					} else {
						// 중복이 아닐 때
						$('#availableUrlText').removeClass("d-none");
						$('#isDuplicationText').addClass("d-none");
					}
					
				}
				, error: function(e) {
					alert("error");
				}
			});
		});
		
		// 즐겨찾기 추가
		$('#addBtn').on('click', function(e) {
			// validation check
			let name = $('#name').val().trim();
			let url = $('#url').val().trim();
			
			if (name.length < 1) {
				alert('제목을 입력하세요.');
				return;
			}
			
			if (url.length < 1) {
				alert('url을 입력하세요.');
				return;
			}
			
			// http도 아니고, https도 아닐 때 => alert을 띄워야 함
			if (url.startsWith('http://') == false && url.startsWith('https://') == false) {
				alert('주소 형식이 잘못되었습니다.');
				return;
			}
			
			// Quiz02 - 중복확인 체크
			if ($('#availableUrlText').hasClass("d-none")) {
				// 저장 가능 URL 문구가 없으면 검사를 다시 해야함
				alert("중복 확인을 해주세요.");
				return;
			}
			
			// 서버 호출
			$.ajax({
				type: "POST"
				, url: "/lesson06/add_favorite"
				, data: {"name":name, "url":url}
				, success: function(data) {
					//alert(data.result);
					if (data.result == "success") {
						// 목록 화면으로 이동
						location.href = "/lesson06/favorite_list";
					}
				}
				, error: function(e) {
					alert("error");
				}
			});
		});
	});
	</script>
</body>
</html>