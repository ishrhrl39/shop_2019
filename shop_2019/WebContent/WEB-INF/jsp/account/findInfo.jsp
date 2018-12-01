<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<script type="text/javascript" src="/js/account/account.js"></script>
	</head>
	<body>
		<form id="findForm">
			<p>회원가입 시, 입력하신 이름, 생년월일, 휴대폰 번호로 아이디를 확인하실 수 있습니다.</p>
			<table>
				<tbody>
					<tr>
						<th>이름</th>
						<td><input type="text" id="name" name="name"/></td>
					</tr>
					<tr>
						<th>생년월일</th>
						<td><input type="text" id="birth" name="birth"/></td>
					</tr>
					<tr>
						<th>휴대폰 번호</th>
						<td><input type="text" id="tel" name="tel"/></td>
					</tr>
				</tbody>
			</table>
			<div>
				<button type="button" id="findId">Ok</button>
			</div>
			<div>
				<button type="button" id="login">Login</button>
			</div>
		</form>
	</body>
</html>