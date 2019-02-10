<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<script src="/js/tattoo/tattoo_payment.js"></script>
		<meta charset="EUC-KR">
		<link rel="stylesheet" href="/css/tattoo/main.css">
		<script src="/js/mypage/payment.js"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	</head>
	<body>
		<form id="orderForm">
			<input type="hidden" id="tattooId" name="tattooId" value="${tattooId}"/>
			<input type="hidden" id="tattoPrice" name="tattoPrice" value="${tattoPrice}"/>
			<input type="hidden" id="color" name="color" value="${color}"/>
			<input type="hidden" id="tattooName" name="tattooName" value="${tattooName}"/>
			<input type="hidden" id="tattooist" name="tattooist" value="${tattooist}"/>
			
			<h2> Order </h2>
			<h3> 주문리스트 </h3>
			<table>
				<tbody>
					<tr>
						<th>이름</th>
						<td><input type="text" id="name" name="name" value="${name}"/></td>
					</tr>
					<tr>
						<th>이메일</th>
						<td><input type="text" id="email" name="email" value="${email}"/></td>
					</tr>
					<tr>
						<th>연락처</th>
						<td><input type="text" id="phone" name="phone" value="${phone}"/></td>
					</tr>
					<tr>
						<th>예약 날짜</th>
						<td><input type="text" name="reserve_dt" id="datepicker1" class="datepicker" readonly="readonly"></td>
						<th>예약 시간</th>
						<td><input type="text" name="reserve_tm" id="reserve_tm" /></td>
					</tr>
				</tbody>
			</table>
			
			<p>예약상품 할인적용</p>
			<table>
				<thead>
					<tr>
						<th>상품금액</th>
						<th>할인금액</th>
						<th>결제 예정금액</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${realTattooPrice}</td>
						<td>-</td>
						<td>${salePrice}</td>
						<td>=</td>
						<td>${tattoPrice}</td>
					</tr>
				</tbody>
			</table>
			
			<p>예약 정보</p>
			<table>
				<tbody>
					<tr>
						<th>결제 방법</th>
						<td>무통장입금(기업은행:111-11-111111 예금주:한예나)</td>
					</tr>
					<tr>
						<td>
							· 선택된 입금계좌로 인터넷 뱅킹, 은행 방문 등을 통해 입금해 주세요.  
							· 반드시 입금 기한 내에 정확한 결제금액을 입금해 주세요.
							· 입금 기한이 지나면 주문은 자동취소됩니다.
						</td>
					</tr>
				</tbody>
			</table>
			
			<p>예약자 동의</p>
			<table>
				<tbody>
					<tr>
						<th>주문동의</th>
						<td><input type="checkbox" id="orderAgree" value="Y"/>상기 결제정보를 확인하였으며, 구매진행에 동의합니다.</td>
					</tr>
				</tbody>
			</table>
			<table>
				<tbody>	
					<tr>
						<th> 최종 결제금액 </th>
						<td>${tattoPrice} 원 </td>
					</tr>
				</tbody>
			</table>
		</form>
		<div>
			<button type="button" id="orderBtn" name="orderBtn">예약하기</button>
		</div>
	</body>
</html>