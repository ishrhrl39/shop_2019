<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<script type="text/javascript" src="/js/mypage/account_drop.js"></script>
		<style type="text/css">
			#accountCheckTable td{
				height:40px;
			}
		</style>
	</head>
	<body>
		<center>
			<form id="withDrawFrm">
				<div id="withDraw_layout">
					<div id="alert_message">
						<b>회원탈퇴와 동시에 '포인트'는 자동소멸되며, 재가입을 하더라도 복구되지 않습니다.</b><br/>
						그 동안 홈페이지를 이용해 주신 분들께 감사의 말씀을 전해드립니다.
					</div>
					<table id="accountCheckTable">
						<tr>
							<th>아이디</th>
							<td>
								<input type="text" id="id" name="id" placeHolder="아이디를 입력하십시오."/>
							</td>
						</tr>
						<tr>
							<th>비밀번호</th>
							<td>
								<input type="password" id="pass_wd" name="pass_wd"  placeHolder="비밀번호를 입력하십시오."/>
							</td>
						</tr>
						<tr>
							<th>회원탈퇴사유</th>
							<td>
								<select id="withdraw_comment" name="withdraw_comment">
									<c:forEach items="${withDrawList }" var="withDraw">
										<option value="${withDraw.withdraw_cd }">${withDraw.withdraw_comment }</option>
									</c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<td colspan="2" align="center">
								<button type="button" id="dropBtn" class="btn btn-success">회원탈퇴하기</button>
								<button type="button" id="cancelDropBtn" class="btn btn-default">취소</button>
							</td>
						</tr>
					</table>
				</div>
			</form>
		</center>
	</body>
</html>