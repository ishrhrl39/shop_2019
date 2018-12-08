<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<script type="text/javascript" src="/js/account/login.js"></script>
	</head>
	<body>
		<form id="loginForm">
			<table>
				<tbody>
					<tr>
						<td><input type="text" id="id" name="id" placeholder="id" value="${cookieId}" /></td> 
					</tr>
					<tr>
						<td><input type="password" id="pass_wd" name="pass_wd" placeholder="Password"/></td> 
					</tr>
					<tr>
						<td>
							<c:choose>
								<c:when test="${cookieId != ''}">
									<input type="checkbox" id="saveSession" name="saveSession" value="y" checked="checked" />
								</c:when>
								<c:otherwise>
									<input type="checkbox" id="saveSession" name="saveSession" value="y" />
								</c:otherwise>
							</c:choose>
							 아이디 저장<br/>
							<button type="button" id="login">Login</button>
						</td>
					</tr>
					<tr>
						<td><button type="button" id="joinUs">Join Us!</button></td>
					</tr>
					<tr>
						<td><a href="/account/account.do?cmd=findlist">아이디/비밀번호 찾기</a></td>
					</tr>
				</tbody>
			</table>
		</form>
	</body>
</html>