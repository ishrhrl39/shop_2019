<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<script src="/js/tattoo/tattoo_payment.js"></script>
		<meta charset="EUC-KR">
		<link rel="stylesheet" href="/css/tattoo/payment.css">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	</head>
	<body>
		<form id="orderForm">
			<input type="hidden" id="basketSn" name="basketSn" value="${basketSn}" />
			<input type="hidden" id="tattooId" name="tattooId" value="${tattooId}"/>
			<input type="hidden" id="tattoPrice" name="tattoPrice" value="${tattoPrice}"/>
			<input type="hidden" id="color" name="color" value="${color}"/>
			<input type="hidden" id="tattooName" name="tattooName" value="${tattooName}"/>
			<input type="hidden" id="tattooist" name="tattooist" value="${tattooist}"/>
			
			<b class="title"> Order </b>
			<p class="header">주문리스트</p>
			<table style="width:100%"  class="orderTable">
				<thead>
					<tr>
						<th><center>사진</center></th>
						<th><center>도안명</center></th>
						<th><center>타투색상</center></th>
						<th><center>가격</center></th>
						<th><center>타투이스트</center></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td align="center"><img src="${tattooImage}" width="80" /></td>
						<td align="center">${tattooName} </td>
						<td align="center">${colorName} </td>
						<td align="center">${tattoPrice}원 </td>
						<td align="center">${tattooist} </td>
					</tr>
				</tbody>
			</table>
			
			<p class="header">예약자정보</p>
			<table class="orderTable">
				<tbody>
					<tr>
						<td>이름</td>
						<td><input type="text" id="name" name="name" value="${name}"/></td>
					</tr>
					<tr>
						<td>이메일</td>
						<td><input type="text" id="email" name="email" value="${email}"/></td>
					</tr>
					<tr>
						<td>연락처</td>
						<td><input type="text" id="phone" name="phone" value="${phone}"/></td>
					</tr>
					<tr>
						<td>예약 날짜</td>
						<td><input type="text" name="reserve_dt" id="datepicker1" class="datepicker" readonly="readonly"></td>
					</tr>
					<tr>
						<td>예약 시간</td>
						<td>
							<select name="reserve_tm" id="reserve_tm">
								<c:forEach begin="0" end="23" var="h">
									<option value="${h }">${h }</option>
								</c:forEach>
							</select>시
						</td>
					</tr>
				</tbody>
			</table>
			
			<p class="header">예약상품 할인적용</p>
			<table class="orderTable">
				<thead>
					<tr>
						<td>상품금액</td>
						<td>&nbsp;</td>
						<td>할인금액</td>
						<td>&nbsp;</td>
						<td>결제 예정금액</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${realTattooPrice}원</td>
						<td><img src="/images/common/bul_h23_minus.png"/></td>
						<td><span class="fc-red">${salePrice}</span>원</td>
						<td><img src="/images/common/bul_h23_equal.png"/></td>
						<td><span class="fc-red">${tattoPrice}</span>원</td>
					</tr>
				</tbody>
			</table>
			
			<p class="header">예약 정보</p>
			<table class="orderTable">
				<tbody>
					<tr>
						<td>결제방법</td>
						<td>무통장입금(기업은행:111-11-111111 예금주:한예나)</td>
					</tr>
					<tr>
						<td colspan="2">
							· 선택된 입금계좌로 인터넷 뱅킹, 은행 방문 등을 통해 입금해 주세요. <br/>
							· 반드시 입금 기한 내에 정확한 결제금액을 입금해 주세요.<br/>
							· 입금 기한이 지나면 주문은 자동취소됩니다.
						</td>
					</tr>
				</tbody>
			</table>
			
			<p class="header">예약자 동의</p>
			<table class="orderTable">
				<tbody>
					<tr>
						<td width="25%">주문동의</td>
						<td><input type="checkbox" id="orderAgree" value="Y"/>상기 결제정보를 확인하였으며, 구매진행에 동의합니다.</td>
					</tr>
				</tbody>
			</table>
			
			<table class="orderTable" id="totalPriceTable">
				<tbody>	
					<tr>
						<td width="25%">최종 결제금액 </td>
						<td align="left"><span class="fc-red">${tattoPrice}</span> 원 </td>
					</tr>
				</tbody>
			</table>
			<center>
				<button type="button" id="orderBtn" name="orderBtn">예약하기</button>
			</center>
		</form>
		
	</body>
</html>