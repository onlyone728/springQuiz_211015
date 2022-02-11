<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기</title>
<!-- bootstrap CDN link -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

  <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>즐겨찾기 목록</h1>
		
		<table class="table mt-3">
			<thead>
				<tr>
					<th>No.</th>
					<th>이름</th>
					<th>주소</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="favorite" items="${favoriteList}" varStatus="status">
				<tr>
					<td>${status.count}</td>
					<td>${favorite.name}</td>
					<td><a href="${favorite.url}" target="_blank">${favorite.url}</a></td>
					<td>
						<%-- 1) name="deleteBtn", value="${favorite.id}" 속성 추가 --%>
						<%-- <button type="button" name="deleteBtn" class="deleteBtn btn btn-danger" value="${favorite.id}">삭제</button>--%>
						
						<%-- 2) data를 이용해서 태그에 임시 저장해놓기 --%>
						<button type="button" class="del-btn btn btn-danger" data-favorite-id="${favorite.id}">삭제</button>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<script>
	$(document).ready(function() {
		/* $('.deleteBtn').on('click', function() {
			// alert("삭제 버튼 클릭");
			let deleteBtn = $(this);
			let tr = deleteBtn.parent().parent();
			let td = tr.children();
			
			let id = td.eq(0).text();
			console.log(id);
			
			$.ajax({
				type: "POST"
				, url: "/lesson06/delete_favorite"
				, data: {"id": id}
				, success: function(data){
					location.reload();
				}
				, error: function(e) {
					alert("error");
				}
			})
		 }) */
		
		 // 1) name="deleteBtn", value="${favorite.id}" 속성 추가
		 /* $('td').on('click', 'button[name=deleteBtn]', function(e) {
			 let id = e.target.value;
			 
			 // let id = $(this).attr('value');
			 alert(id);
		 }); */
		 
		 // 2) data를 이용해서 태그에 임시 저장해놓기
		 // tag : data-favorite-id 속성	data- 뒤부터는 우리가 이름을 정한다.(반드시 '-')
		 // 자바스크립트 : $(this).data('favorite-id');
		 $('.del-btn').on('click', function() {
			 let id = $(this).data('favorite-id');
			 // alert(id);
			 
			 $.ajax({
				type: "POST"
				, url: "/lesson06/delete_favorite"
				, data: {"id": id}
			 	, success: function(data) {
			 		// alert(data.result);
			 		if (data.result == 'success') {
			 			alert("성공");
			 		    location.reload();
			 		} else {
			 			alert("삭제하는데 실패했습니다. 관리자에게 문의해주세요.");
			 		}
			 	}
			 	, error: function(e) {
			 		alert('error');
			 	}
			 });
		 });
	});
	</script>
</body>
</html>