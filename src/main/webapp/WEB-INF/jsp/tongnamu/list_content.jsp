<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="content">
	<div class="title_area d-flex justify-content-center align-items-center">
		<h1>예약 목록 보기</h1>
	</div>
	<div class="d-flex justify-content-center">
		<table class="table text-center w-75">
			<thead>
				<tr>
					<th>이름</th>
					<th>예약날짜</th>
					<th>숙박일수</th>
					<th>숙박인원</th>
					<th>전화번호</th>
					<th>예약상태</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="booking" items="${bookingList}">
				<tr>
					<td>${booking.name}</td>
					<td>
						<fmt:formatDate value="${booking.date}" pattern="yyyy년 M월 dd일"/>
					</td>
					<td>${booking.day}</td>
					<td>${booking.headcount}</td>
					<td>${booking.phoneNumber}</td>
					<td>${booking.state}</td>
					<td><button type="button" value="${booking.id}" class="del-btn btn btn-danger">삭제</button></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

<script>
$(document).ready(function() {
	$('.del-btn').on('click', function() {
		let id = $(this).attr('value');
		console.log(id);
		
		$.ajax({
			type: "POST"
			, url: "/tongnamu/delete_booking"
			, data: {"id": id}
			, success: function(data) {
				if (data.result) {
					// alert("성공");
					location.reload();
				}
			}
			, error: function(e) {
				alert("error");
			}
		})	
	});
});
</script>