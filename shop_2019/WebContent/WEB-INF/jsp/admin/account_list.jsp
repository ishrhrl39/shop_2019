<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/js/admin/account.js"></script>
<link rel="stylesheet" href="/css/admin/account_list.css">
<title></title>

</head>
<body>
	<table id="accountList" class="table table-striped table-hover table-bordered">
		<thead>
			<tr>
				<th>&nbsp;</th>
				<th>아이디</th>
				<th>이름</th>
				<th>이메일</th>
				<th>생년월일</th>
				<th>성별</th>
				<th>휴대폰번호</th>
				<th>성인여부</th>
				<th>가입일자</th>
				<th>최종수정일자</th>
				<th>탈퇴여부</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${userList }" var="user">
				<tr>
					<td><input type='checkbox' name='user' id='user' value='${user.id }' /></td>
					<td>${user.id }</td>
					<td>${user.name }</td>
					<td>${user.email }</td>
					<td>${user.birth }</td>
					<c:choose>
						<c:when test="${birth.gender == 'f' }">
							<td>여</td>
						</c:when>
						<c:otherwise>
							<td>남</td>
						</c:otherwise>
					</c:choose>
					<td>${user.tel }</td>
					<c:choose>
						<c:when test="${user.adult_yn == 'Y' }">
							<td>성인</td>
						</c:when>
						<c:otherwise>
							<td>미성년자</td>
						</c:otherwise>
					</c:choose>
					<td>${user.reg_dtm }</td>
					<td>${user.upd_dtm }</td>
					<c:choose>
						<c:when test="${user.use_yn == 'y' }">
							<td>사용 중</td>
						</c:when>
						<c:otherwise>
							<td>탈퇴</td>
						</c:otherwise>
					</c:choose>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="11">
					<div id="paging">
						<c:if test="${paging.START > 1 }">
							<a href="#" onclick="goLocByPaging('${paging.START - 1}')">◀</a>
						</c:if>
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
						<c:if test="${paging.END < paging.MAX_PAGE }">
							<a href="#" onclick="goLocByPaging('${paging.END + 1}')">▶</a>
						</c:if>
					</div>
				</td>
			</tr>
		</tfoot>
	</table>
</body>
</html>