<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/js/admin/stl.js"></script>
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
	
		<!-- 무통장 결제 목록 -->
		<table id="stlList" class="table table-striped table-hover table-bordered">
			<thead>
				<tr>
					<th>회원ID</th>
					<th>회원명</th>
					<th>연락처</th>
					<th>이메일</th>
					<th>결제상품</th>
					<th>색상</th>
					<th>예약일자</th>
					<th>타투이스트</th>
					<th>결제금액</th>
					<th>결제날짜</th>
					<th>-</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list }" var="stl">
					<tr>
						<td>${stl.USER_ID }</td>
						<td>${stl.NAME }</td>
						<td>${stl.TEL }</td>
						<td>${stl.EMAIL }</td>
						<td><a target="_blank" href="/tattoo/detail.do?id=${stl.TATTOO_ID }">${stl.TATTOO_NM }</a></td>
						<td>${stl.COLOR }</td>
						<td>
							<fmt:parseDate value="${stl.RESERVED_DT}" var="reservedDt" pattern="yyyyMMddHHmmss"/>
							<fmt:formatDate value="${reservedDt}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</td>
						<td>${stl.TATTOOIST_NAME }</td>
						<td><fmt:formatNumber value="${stl.STL_MONEY }" pattern="#,###"/>원</td>
						<td>
							<fmt:parseDate value="${stl.STL_DTM}" var="stlDtm" pattern="yyyyMMddHHmmss"/>
							<fmt:formatDate value="${stlDtm}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</td>
						<td>
							<c:choose>
								<c:when test="${stl.PAYMENT_CMPL_YN == 'N'}">
									<button type="button" class="btn btn-default" onclick="updateStlSts('${stl.PAYMENT_SN}','Y')">결제처리</button>
									<button type="button" class="btn btn-default" onclick="updateStlSts('${stl.PAYMENT_SN}','X')">결제취소</button>
								</c:when>
								<c:when test="${stl.PAYMENT_CMPL_YN == 'X'}">
									<font color='red'>결제취소</font>
								</c:when>
								<c:otherwise>
									결제완료
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="11" align="center">
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
					</td>
				</tr>
			</tfoot>
		</table>
	</form>
	
</body>
</html>