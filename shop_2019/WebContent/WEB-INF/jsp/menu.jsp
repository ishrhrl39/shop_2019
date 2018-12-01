<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">	
	</head>
	<body>
		<div id="top_menu">
			<c:choose>
				<c:when test="${loginUser != null }">
					<c:if test="${loginUser.id == 'admin'}">
						<a href="/admin/index.do">관리자 페이지</a>
					</c:if>
					<a href="/account/login.do?cmd=logout">로그아웃</a>
				</c:when>
				<c:otherwise>
					<a href="/account/login.do">로그인</a>
					<a href="/account/account.do">회원가입</a>
				</c:otherwise>
			</c:choose>
		</div>
	</body>
</html>