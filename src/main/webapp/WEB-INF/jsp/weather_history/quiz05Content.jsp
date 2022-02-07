<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="content col-10 p-5">
	<h1>과거 날씨</h1>
	<table class="table text-center">
		<thead>
			<tr>
				<th>날짜</th>
				<th>날씨</th>
				<th>기온</th>
				<th>강수량</th>
				<th>미세먼지</th>
				<th>풍속</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="weather" items="${weatherHistory}">
				<tr>
					<td><fmt:formatDate value="${weather.date}"
							pattern="yyyy년 M월 d일" /></td>
					<td><c:choose>
							<c:when test="${weather.weather == '맑음'}">
								<img alt="맑음" src="/images/sunny.jpeg">
							</c:when>
							<c:when test="${weather.weather == '비'}">
								<img alt="비" src="/images/rainy.jpeg">
							</c:when>
							<c:when test="${weather.weather == '흐림'}">
								<img alt="흐림" src="/images/cloudy.jpeg">
							</c:when>
							<c:when test="${weather.weather == '구름조금'}">
								<img alt="구름조금" src="/images/partlyCloudy.jpeg">
							</c:when>
						</c:choose></td>
					<td>${weather.temperatures}℃</td>
					<td>${weather.precipitation}mm</td>
					<td>${weather.microDust}</td>
					<td>${weather.windSpeed}km/h</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>