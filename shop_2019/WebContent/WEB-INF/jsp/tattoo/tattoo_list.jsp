<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<link rel="stylesheet" href="/css/tattoo/main.css">
		<script src="/js/tattoo/main.js"></script>
	</head>
	<body>
		<form action="/tattoo/list.do" method="post" id="tattooForm">
			<input type="hidden" name="goods" id="goods" value="${goods }" />
			<input type="hidden" name="tmpSearchValue" id="tmpSearchValue" value="${searchValue }" />
			<input type="hidden" name="tmpSearchKey" id="tmpSearchKey" value="${searchKey }" />
<%-- 			<input type="hidden" name="id" id="id" value="${id }" /> --%>
			<center>
				<table>
					<thead>
						<tr>
							<td colspan="3" align="right" style="padding-bottom:20px;">
								상품명 : <input name="nm" id="nm" type="text" size="20" maxlength="50" />
								<button type="button" id="searchBtn" class="btn btn-default" >검색</button>
								<button type="button" id="allSelectBtn" class="btn btn-default" >전체보기</button>
							</td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td colspan="3"  align="right">
								<c:if test="${loginUser.id == 'admin'}">
									<button type="button" id="goInsertGoodsBtn" class="btn btn-success">상품 등록</button>
									<button type="button" id="goDeleteGoodsBtn" class="btn btn-success">상품 삭제</button>
								</c:if>
							</td>
						</tr>
						
						<c:forEach var="result" items="${list}" varStatus="status">
							<c:if test="${status.index % 3 == 0 }">
								<tr>
							</c:if>
							<td>
								<table class="tattoo_goods_table"> 
									<tr>
										<td colspan="2" >
											<div class="imgGellery">
												<c:if test="${loginUser.id == 'admin'}">
													<input type="checkbox" id="checkGoods" name="checkGoods" value="${result.id}"/>
												</c:if>
												
												<img src = "${result.image}" width="100%"  style="cursor:pointer" onclick="moveDetail(${result.id})"/>
											</div>
										</td>
									</tr>
									<tr>
										<th>상품명</th>
										<td>${result.nm}</td>
									</tr>
									<tr>
										<th>가격</th>
										<td>
											<fmt:formatNumber value="${result.price}" pattern="#,###" />원
										</td>
									</tr>
								</table>
							</td>
							<c:if test="${status.index % 3 == 2 }">
								</tr>
							</c:if>
						</c:forEach>					
					</tbody>
					<tfoot>
						<tr>
							<td align="center" colspan="3">
								<br/>
								<c:if test="${pageVo.nowPage > 1 }">
									<a href="#" onclick="go('/tattoo/list.do?goods=${goods }&page=1')">[◀◀]</a>
									<a href="#" onclick="go('/tattoo/list.do?goods=${goods }&page=${pageVo.nowPage - 1}')">[◀]</a>
								</c:if>
								<c:forEach begin="${pageVo.start }" end="${pageVo.end }" step="1" var="num">
									<c:choose>
										<c:when test="${pageVo.nowPage == num}">
											<b><a href="#" onclick="go('/tattoo/list.do?goods=${goods }&page=${num }')">${num }</a></b>
										</c:when>
										<c:otherwise>
											<a href="#" onclick="go('/tattoo/list.do?goods=${goods }&page=${num }')">${num }</a>
										</c:otherwise>
									</c:choose>
								</c:forEach>
								<c:if test="${pageVo.nowPage < pageVo.maxPage }">
									<a href="#" onclick="go('/tattoo/list.do?goods=${goods }&page=${pageVo.nowPage + 1}')">[▶]</a>
								</c:if>
								
								<c:if test="${pageVo.nowPage < pageVo.maxPage }">
									<a href="#" onclick="go('/tattoo/list.do?goods=${goods }&page=${pageVo.maxPage}')">[▶▶]</a>
								</c:if>
								<br/><br/>&nbsp;
							</td>
						</tr>
					</tfoot>
				</table>
			</center>
		</form>
	</body>
</html>