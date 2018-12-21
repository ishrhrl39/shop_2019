<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link rel="stylesheet" href="/css/account/account.css">
		<script type="text/javascript" src="/js/account/account.js"></script>
	</head>
	<body>
		<center>
			<form id="findIdForm">
				<table class="find_table">
					<thead>
						<tr>
							<td colspan='2'>
								아이디 찾기
							</td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td colspan="2">
								<p>회원가입 시, 입력하신 이름, 생년월일, 휴대폰 번호로 아이디를 확인하실 수 있습니다.</p>
							</td>
						</tr>
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
						<tr>
							<td colspan="2" align="center">
								<button type="button" id="findId" class="btn btn-success">Ok</button>
								<button type="button" id="login" class="btn btn-success">Login</button>
							</td>
						</tr>
					</tbody>
				</table>
			</form>
			<hr>
			<form id="findPwdForm">
				<table class="find_table">
					<thead>
						<tr>
							<td colspan="2">
								비밀번호 찾기
							</td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td colspan="2">
								<p>가입하신 아이디 + 이메일 또는 휴대폰 번호 입력,
							      본인인증을 통해 이메일로 임시 비밀번호를 보내드립니다.<br/>
							      확인 후 로그인하셔서 반드시 비밀번호를 변경하시기 바랍니다.</p>
							</td>
						</tr>
						<tr>
							<th>아이디</th>
							<td><input type="text" id="id" name="id"/></td>
						</tr>
						<tr>
							<th>이메일</th>
							<td><input type="text" id="email" name="email"/></td>
						</tr>
						<tr>
							<td colspan="2" align="center">
								<button type="button" id="findPwd" class="btn btn-success">Ok</button>
								<button type="button" id="login2" class="btn btn-success">Login</button>
								<div>
									<span id="confirming" style="display:none;"> 발송중입니다</span>
									<span id="confirmed" style="display:none;"> 발송완료하였습니다.</span>
								</div>
							</td>
						</tr>
					</tbody>
				</table>
			</form>
		</center>
	</body>
</html>