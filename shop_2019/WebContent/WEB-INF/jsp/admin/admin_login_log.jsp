<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/css/admin/account_list.css">
<title></title>
</head>
<body>

	<!-- 로그인 이력 -->
	<table id="loginLogTable" class="table table-striped table-hover table-bordered">
		<thead>
			<tr>
				<th>아이디</th>
				<th>로그인 일자</th>
				<th>로그인 시간</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${loginLogList }" var="loginLog">
				<tr>
					<td>${loginLog.id }</td>
					<td>${loginLog.login_dt }</td>
					<td>${loginLog.login_tm }</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="11" align="center">
					<div id="paging">
						<!-- 맨 앞으로 가기 -->
						<c:if test="${now != 1}">
							<a href="#" class="pagingIcon" onclick="goLocByPaging('1')">◀◀</a>
						</c:if>
					
						<!-- 이전 페이지 가기 -->
						<c:if test="${paging.START > 1 }">
							<a href="#" class="pagingIcon" onclick="goLocByPaging('${paging.START - 1}')">◀</a>
						</c:if>
						
						<!-- 페이징 목록 -->
						<c:forEach begin="${paging.START }" end="${paging.END}" var="page" >
							<c:if test="${page <= paging.MAX_PAGE }">
								<a href="#" onclick="goLocByPaging('${page}')">
									<c:choose>
										<c:when test="${now == page }">
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
						<c:if test="${paging.END < paging.MAX_PAGE }">
							<a style="margin-left:5px;" href="#" class="pagingIcon" onclick="goLocByPaging('${paging.END + 1}')">▶</a>
						</c:if>
						
						<!-- 마지막 페이지 가기 -->
						<c:if test="${paging.MAX_PAGE > 1 && now != paging.MAX_PAGE}">
							<a href="#" class="pagingIcon" onclick="goLocByPaging('${paging.MAX_PAGE }')">▶▶</a>
						</c:if>
					</div>
				</td>
			</tr>
		</tfoot>
	</table>
</body>
</html>