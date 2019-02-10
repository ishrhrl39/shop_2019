<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<link rel="stylesheet" href="/css/tattoo/main.css">
		<script src="/js/mypage/payment.js"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	</head>
	<body>
		<form action="/mypage/myInfo.do?cmd=payment" method="post" id="paymentForm">
			<input type="hidden" name="tattoo_nm" id="tattoo_nm" value="${tattoo_nm }" />
			<input type="hidden" name="tmpSearchValue" id="tmpSearchValue" value="${searchValue }" />
			<input type="hidden" name="tmpSearchKey" id="tmpSearchKey" value="${searchKey }" />
			<table>
				<thead>
					<tr>
						<td colspan="3" align="right">
							��ǰ�� : <input name="nm" id="nm" type="text" size="20" maxlength="50" />
							<button type="button" id="searchBtn" >�˻�</button>
							<button type="button" id="allSelectBtn" >��ü����</button>
						</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th>���Ź�ȣ</th>
						<th>��ǰ��</th>
						<th>���Ű���</th>
						<th>��ǰ����</th>
						<th>�����</th>
						<th>��������</th>
					</tr>
					<c:forEach var="result" items="${list}" varStatus="status">
						<tr>
							<td>${result.PAYMENT_SN }</td>
							<td>${result.TATTOO_NM }</td>
							<td>${result.PRICE }</td>
							<td>${result.COLOR }</td>
							<td>${result.TATTOOIST_NAME }</td>
							<td>${result.REG_DTM }</td>
						</tr>
					</c:forEach>					
				</tbody>
				<tfoot>
					<tr>
						<td align="center" colspan="3">
							<br/>
							<c:if test="${pageVo.nowPage > 1 }">
								<a href="#" onclick="go('/mypage/myInfo.do?cmd=payment&page=1')">[����]</a>
								<a href="#" onclick="go('/mypage/myInfo.do?cmd=payment&page=${pageVo.nowPage - 1}')">[��]</a>
							</c:if>
							<c:forEach begin="${pageVo.start }" end="${pageVo.end }" step="1" var="num">
								<c:choose>
									<c:when test="${pageVo.nowPage == num}">
										<b><a href="#" onclick="go('/mypage/myInfo.do?cmd=payment&page=${num }')">${num }</a></b>
									</c:when>
									<c:otherwise>
										<a href="#" onclick="go('/mypage/myInfo.do?cmd=payment&page=${num }')">${num }</a>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							<c:if test="${pageVo.nowPage < pageVo.maxPage }">
								<a href="#" onclick="go('/mypage/myInfo.do?cmd=payment&page=${pageVo.nowPage + 1}')">[��]</a>
							</c:if>
							
							<c:if test="${pageVo.nowPage < pageVo.maxPage }">
								<a href="#" onclick="go('/mypage/myInfo.do?cmd=payment&page=${pageVo.maxPage}')">[����]</a>
							</c:if>
							<br/><br/>&nbsp;
						</td>
					</tr>
				</tfoot>
		<form>
			<h3> 주문리스트 </h3>
			<table>
				
				<thead>
					<tr>
					</tr>
				</thead>
				<tbody>
					
					<tr>
						<td>
							
						</td>
					</tr>
				
				</tbody>
			</table>
		</form>
	</body>
</html>