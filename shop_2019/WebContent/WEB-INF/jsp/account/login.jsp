<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<script type="text/javascript" src="/js/account/login.js"></script>
		<link rel="stylesheet" href="/css/account/login.css">
	</head>
	<body>
		<form id="loginForm" action="/account/login.do?cmd=login" method="post">
			<div>
				<center>
					<table>
						<tbody>
							<tr>
								<td style="padding-bottom:5px;">
									<input type="text" id="id" name="id" placeholder="id" class="form-control" value="${cookieId}" />
								</td> 
							</tr>
							<tr>
								<td>
									<input type="password" id="pass_wd" name="pass_wd" placeholder="Password" class="form-control"/>
								</td> 
							</tr>
							<tr>
								<td align="left">
									<c:choose>
										<c:when test="${cookieId != ''}">
											<input type="checkbox" id="saveSession" name="saveSession" value="y" checked="checked" />
										</c:when>
										<c:otherwise>
											<input type="checkbox" id="saveSession" name="saveSession" value="y" />
										</c:otherwise>
									</c:choose>
									 아이디 저장
								</td>
							</tr>
							<tr>
								<td align="right">
									<button type="button" id="login" class="btn btn-default btn-md">Login</button>
									<button type="button" id="joinUs" class="btn btn-default btn-md">Join Us!</button>
								</td>
							</tr>
							<tr>
								<td align="right">
									<a href="/account/account.do?cmd=findlist">아이디/비밀번호 찾기</a>
								</td>
							</tr>
						</tbody>
					</table>
				</center>
			</div>
		</form>
	</body>
</html>