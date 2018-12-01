<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/js/admin/account.js"></script>
<link rel="stylesheet" href="/css/admin/account_popup.css">
<title></title>

</head>
<body>
	<table id="accountPopup" class="table">
		<tr>
			<td colspan='2' class="title">
				회원정보 수정
			</td>
		</tr>
		<tr>
			<th width="30%">아이디</th>
			<td width="70%">${user.id }</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td>
				<input type="password" name="password" />
				<button type="button" class="btn btn-default">비밀번호 변경</button>
			</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>
				${userm.email }
			</td>
		</tr>
		<tr>
			<th>생년월일</th>
			<td>
				${userm.birth }
			</td>
		</tr>
	</table>
</body>
</html>