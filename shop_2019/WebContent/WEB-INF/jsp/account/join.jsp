<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<script type="text/javascript" src="/js/account/account.js"></script>
	</head>
	<body>
		<form id="joinForm" action="/account/join.do">
		<input type="hidden" id="checkId" value="N"/>
		<input type="hidden" name="cmd" value="insertUser">
			<table>
				<tbody>
					<tr>
						<td><input type="text" id="name" name="name" maxlength="20" placeholder="이름"/></td>
					</tr>
					<tr>
						<td>
							<input type="text" id="id" name="id" maxlength="50" placeholder="아이디"/>
							<button type="button" id="duplCheckIdBtn" class="common_btn">중복확인</button>
						</td>
					</tr>
					<tr>
						<td><input type="password" id="pass_wd" name="pass_wd" maxlength="50" placeholder="비밀번호"/></td>
					</tr>
					<tr>
						<td><input type="password" id="repass_wd" name="repass_wd" maxlength="50" placeholder="비밀번호 확인"/></td>
					</tr>
					<tr>
						<td><input type="text" id="email" name="email" maxlength="25" placeholder="이메일"/></td>
					</tr>
					<tr>
						<td>
							<select id="year" name="year">
							</select>
							<select id="month" name="month">
							</select>
							<select id="date" name="date">
							</select>
						</td>
					</tr>
					<tr>
						<td>
							<input type="radio"  name ="gender" value="f" checked/>여
							<input type="radio"  name ="gender" value="m"/>남
						</td>
					</tr>
					<tr>
						<td><input type="text" id="tel" name="tel" maxlength="11" placeholder="휴대폰번호"/></td>
					</tr>
					<tr>
						<td><input type="checkbox" id="adult_yn" name ="adult_yn" value="Y"/>만 19세 이상입니다.</td>
					</tr>
					<tr>
						<td colspan="2">
							<p> 
								*회원가입에 필요한 최소한의 정보만 입력받음으로써 고객의 개인정보 수집을 최소화하고 
						   		 편리한 회원가입을 제공합니다 
					   		</p>
			   		 	</td>
					</tr>
					<tr>
						<td>
							<input type="checkbox" id="fullagree" value="Y"/>전체동의
						</td>
					</tr>
					<tr>
						<td>
							<input type="checkbox" id="useable" />이용악관
							<input type="checkbox" id="personalable"/>개인정보 수집 이용 안내
						</td>
					</tr>
				</tbody>
			</table>
			<div>
				<button type="button" id="joinBtn">동의하고 가입완료</button>
			</div>
		</form>
	</body>
</html>