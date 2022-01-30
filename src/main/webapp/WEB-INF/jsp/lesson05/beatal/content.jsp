<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="content">
	<h1 class="display-4 py-3">우리동네 가게</h1>
	<c:forEach var="store" items="${storeList}">
		<div class="info-box">
			<a href="/lesson05/quiz06/review?storeId=${store.id}&storeName=${store.name}">
				<h3>${store.name}</h3>
				<div>전화번호 : ${store.phoneNumber}</div>
				<div>주소 : ${store.address}</div>
			</a>
		</div>
	</c:forEach>
</div>