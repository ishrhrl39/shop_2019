<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/js/mypage/payment.js"></script>
<link rel="stylesheet" href="/css/admin/account_list.css">
<title></title>

</head>
<body>
	<form id="paymentForm" action="/mypage/myInfo.do?cmd=payment" method="post">
		<input type="hidden" name="cmd" id="cmd" value="" />
	
		<!-- 검색 -->
		<div id="searchLayout" align="right">
			<table>
				<tr>
					<td>
						<select name="searchColumn" id="searchColumn" class="form-control">
							<option value="TATTOO_NM">타투명</option>
						</select>									
					</td>
					<td>
						<input type="text" class="form-control" name="searchValue" id="searchValue" maxlength="50" value="${searchValue }" />		
					</td>
					<td>
						<button type="button" class="btn btn-success" id="searchBtn">검색</button>
						<c:if test="${mode == 'S' }">
							<a href="/mypage/myInfo.do?cmd=payment"><button type="button" class="btn btn-default">전체보기</button></a>
						</c:if>					
					</td>
				</tr>
			</table>
		</div>
	
		<!-- 회원목록 -->
		<table id="accountList" class="table table-striped table-hover table-bordered">
			<thead>
				<tr>
					<th>
						<div class="btn-group">
							&nbsp;
						</div>
					</th>
					<th>상품명</th>
					<th>가격</th>
					<th>상품 색상</th>
					<th>담당자명</th>
					<th>예약일시</th>
					<th>결제상태</th>
					<th>결제일자</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list }" var="payment">
					<tr>
						<td><input type='checkbox' name='payment_sn' value='${payment.PAYMENT_SN }' /></td>
						<td><a href="#" onclick="openTattooDetail('${payment.TATTOO_ID}')">${payment.TATTOO_NM }</a></td>
						<td><fmt:formatNumber value="${payment.PRICE }" pattern="#,###"/>원</td>
						<td>${payment.COLOR_NAME }</td>
						<td>${payment.TATTOOIST_NAME }</td>
						<td>
							<fmt:parseDate value="${payment.RESERVED_DT}" var="reservedDt" pattern="yyyyMMddHHmmss"/>
							<fmt:formatDate value="${reservedDt}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</td>
						<td>
							<c:choose>
								<c:when test="${payment.PAYMENT_CMPL_YN == 'N'}">
									결제진행 중
								</c:when>
								<c:when test="${payment.PAYMENT_CMPL_YN == 'X'}">
									결제취소
								</c:when>
								<c:otherwise>
									결제완료
								</c:otherwise>
							</c:choose>
						</td>
						<td>
							<fmt:parseDate value="${payment.REG_DTM}" var="regDtm" pattern="yyyyMMddHHmmss"/>
							<fmt:formatDate value="${regDtm}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="8" align="center">
						<c:choose>
							<c:when test="${mode != 'S' }">
								<div id="paging">
									<!-- 맨 앞으로 가기 -->
									<c:if test="${pageVo.nowPage != 1}">
										<a href="#" class="pagingIcon" onclick="goLocByPaging('/mypage/myInfo.do?cmd=payment','1')">◀◀</a>
									</c:if>
								
									<!-- 이전 페이지 가기 -->
									<c:if test="${pageVo.start > 1 }">
										<a href="#" class="pagingIcon" onclick="goLocByPaging('/mypage/myInfo.do?cmd=payment', '${paging.START - 1}')">◀</a>
									</c:if>
									
									<!-- 페이징 목록 -->
									<c:forEach begin="${pageVo.start }" end="${pageVo.end}" var="page" >
										<c:if test="${page <= pageVo.maxPage }">
											<a href="#" onclick="goLocByPaging('/mypage/myInfo.do?cmd=payment', '${page}')">
												<c:choose>
													<c:when test="${pageVo.nowPage == page }">
														<b>${page}</b>
													</c:when>
													<c:otherwise>
														${page}
													</c:otherwise>
												</c:choose>
											</a>
										</c:if>
									</c:forEach>
									
									<!-- 다음 페이지 가기 -->
									<c:if test="${pageVo.end < pageVo.maxPage }">
										<a style="margin-left:5px;" href="#" class="pagingIcon" onclick="goLocByPaging('/mypage/myInfo.do?cmd=payment', '${paging.END + 1}')">▶</a>
									</c:if>
									
									<!-- 마지막 페이지 가기 -->
									<c:if test="${paging.maxPage > 1 && now != paging.maxPage}">
										<a href="#" class="pagingIcon" onclick="goLocByPaging('/mypage/myInfo.do?cmd=payment', '${paging.MAX_PAGE }')">▶▶</a>
									</c:if>
								</div>
							</c:when>
							<c:otherwise>
								<a href="/mypage/myInfo.do?cmd=payment"><button type="button" class="btn btn-default">전체보기</button></a>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</tfoot>
		</table>
	</form>
</body>
</html>