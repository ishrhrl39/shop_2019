<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
						<td><input type="text" id="id" name="id" placeholder="id"/></td> 
					</tr>
					<tr>
						<td><input type="password" id="pass_wd" name="pass_wd" placeholder="Password"/></td> 
					</tr>
				</tbody>
			</table>
			<button type="button" id="login">Login</button>
			<button type="button" id="joinUs">Join Us!</button>
			<div>
				<a href="/account/account.do?cmd=findlist">아이디/비밀번호 찾기</a>
			</div>
		</form>
	</body>
</html>