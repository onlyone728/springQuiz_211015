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
						<fmt:formatDate value="${booking.date}" pattern="yyyy년 M월 d일"/>
					</td>
					<td>${booking.day}</td>
					<td>${booking.headcount}</td>
					<td>${booking.phoneNumber}</td>
					<td>
						<c:choose>
							<c:when test="${booking.state == '대기중'}">
								<span class="text-info">${booking.state}</span>
							</c:when>
							<c:when test="${booking.state == '확정'}">
								<span class="text-success">${booking.state}</span>
							</c:when>
							<c:when test="${booking.state == '취소'}">
								<span class="text-danger">${booking.state}</span>
							</c:when>
						</c:choose>
					</td>
					<td>
						<button type="button" data-booking-id="${booking.id}" class="del-btn btn btn-danger">삭제</button>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

<script>
$(document).ready(function() {
	$('.del-btn').on('click', function() {
		let id = $(this).data('booking-id');
		// console.log(id);
		
		$.ajax({
			type: "DELETE"
			, url: "/tongnamu/delete_booking"
			, data: {"id": id}
			, success: function(data) {
				if (data.result == "success") {
					alert("예약이 취소되었습니다.");
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