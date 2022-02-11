<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="content">
	<c:forEach var="item" items="${usedGoodsList}">
		<div class="item-box">
			<a href="#"> 
				<c:choose>
					<c:when test="${item.picture == null or item.picture == ''}">
						<div class="img-box d-flex align-items-center justify-content-center">
							<span class="no-img">이미지 없음</span>
						</div>
					</c:when>
					<c:otherwise>
						<div class="img-box">
							<img src="${item.picture}" alt="상품사진" width="400">
						</div>
					</c:otherwise>
				</c:choose>
				<div class="title">${item.title}</div>
				<div class="price">${item.price}원</div> 
				<small class="nickname"><%-- ${item.nickname} --%></small>
			</a>
		</div>
	</c:forEach>
</div>