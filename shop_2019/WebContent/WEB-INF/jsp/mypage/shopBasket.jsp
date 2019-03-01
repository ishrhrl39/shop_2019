<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link rel="stylesheet" href="/css/mypage/basket.css">
		<script src="/js/mypage/basket.js"></script>
	</head>
	<body>
		<form id="basketForm" method="post" >
			<input type="hidden" id="basketSn" name="basketSn" />
			<b class="title"> Cart </b>
			<table style="width:100%"  class="backetTable">
				<thead>
					<tr>
						<th width="25%">사진</th>
						<th width="25%">타투명</th>
						<th width="25%">가격</th>
						<th width="25%"><input type="checkbox" id="allBasketcheck" name="allBasketcheck"/> </th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="basket">
						<tr>
							<td><img src="${basket.image}" width="80" />
								<br/>
							    <a href = "#" onclick="onBasketSubmit('${basket.BASKET_SN}')">예약하기</a></td>
							<td>${basket.nm} </td>
							<td>${basket.price}원 </td>
							<td><input type="checkbox"  class="basketCheck" name="basketCheck" value="${basket.BASKET_SN}"/></td>
						</tr>
						<tr>
							<td colspan="4" class="option"  >
								<img src="/images/common/basket_option.gif"/> 
								<b>타투색상 : </b>${basket.COLOR} <br/>
								<span class="subOption">
									<b>타투이스트명 : </b>${basket.TATTOOIST_NAME}
								</span>
							</td> 
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="4" align="center">
							<button type="button" id="basketDelBtn" name="basketDelBtn" class="btn btn-default">장바구니 비우기</button>
							<button type="button" id="goMain" name="goMain" class="btn btn-default">계속 쇼핑하기</button>
						</td>
					</tr>
				</tfoot>
			</table>
			
		</form>
	</body>
</html>