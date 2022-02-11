<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="content2">
	<h1 class="display-4 mb-3">물건 올리기</h1>
	<div class="input-box">	
		<form action="/hongdangmu/afterAddGoods" method="post" >
			<div class="d-flex mb-3">
				<select id="sellerId" name="sellerId" class="form-control col-2 mr-3">
					<option>-아이디 선택-</option>
					<c:forEach var="seller" items="${seller}">
					<option value="${seller.id}">${seller.nickname}</option>
					</c:forEach>
				</select>
				<input type="text" class="form-control col-6" name="title" id="title" placeholder="제목">
				<div class="input-group col-3">
					<input type="number" class="form-control" name="price" id="price" placeholder="가격">
					<div class="input-group-append">
						<span class="input-group-text">원</span>
					</div>
				</div>
			</div>
			<textarea rows="10" class="form-control mb-3" name="description"></textarea>
			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text">이미지 url</span>
				</div>
				<input type="url" name="picture" class="form-control">
			</div>
			<input type="submit" value="저장" class="btn btn-block">
		</form>
	</div>	
</div>