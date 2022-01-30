<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="content">
	<h1 class="display-4 py-3">${storeName} - 리뷰</h1>
	<c:choose>
		<c:when test="${!empty reviewList}">
			<c:forEach var="review" items="${reviewList}">
				<div class="info-box">
					<div>
						<span class="font-weight-bold">${review.userName}</span>
						<c:set var="point" value="${review.point}" />
						<c:forEach begin="1" end="5" step="1">
							<c:choose>
								<c:when test="${point > 0.5}">
									<img src="/images/star_fill.png" width="15">
									<c:set var="point" value="${point - 1}" />
								</c:when>
								<c:when test="${point == 0.5}">
									<img src="/images/star_half.png" width="15">
									<c:set var="point" value="${point - 0.5}" />
								</c:when>
								<c:when test="${point == 0}">
									<img src="/images/star_empty.png" width="15">
								</c:when>
							</c:choose>
						</c:forEach>
					</div>	
					<small class="text-secondary">
						<fmt:formatDate value="${review.createdAt}" pattern="yyyy월 M월 d일" />
					</small>
					<div>${review.review}</div>
					<small class="menu">${review.menu}</small>
				</div>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<h2 class="d-flex justify-content-center py-5">
				작성된 리뷰가 없습니다.
			</h2>
		</c:otherwise>
	</c:choose>
</div>