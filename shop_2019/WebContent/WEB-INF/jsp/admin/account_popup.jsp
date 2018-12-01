<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/js/admin/account_popup.js"></script>
<link rel="stylesheet" href="/css/admin/account_popup.css">
<title></title>

</head>
<body>
	<form id="accountPopupForm">
		<input type='hidden' id='id' name='id' value="${user.id }" />
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
					<input type="password" name="pass_wd" id="pass_wd" />
					<button type="button" class="btn btn-default" id="updatePassWdBtn">비밀번호 변경</button>
				</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>
					${user.email }
				</td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td>
					${fn:substring(user.birth,0,4)}년 ${fn:substring(user.birth,4,6)}월 ${fn:substring(user.birth,6,8)}일
				</td>
			</tr>
			<tr>
				<th>성별</th>
				<td>
					${user.gender }
				</td>
			</tr>
			<tr>
				<th>휴대폰 번호</th>
				<td>
					${user.tel }
				</td>
			</tr>
			<tr>
				<th>성인여부</th>
				<td>
					<c:choose>
						<c:when test="${user.adult_yn == 'Y' }">
							성인
						</c:when>
						<c:otherwise>
							미성년자
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr>
				<th>가입일자</th>
				<td>${user.reg_dtm }</td>
			</tr>
			<tr>
				<th>최종수정일자</th>
				<td>${user.upd_dtm }</td>
			</tr>
			<tr>
				<th>최종수정일자</th>
				<td>${user.upd_dtm }</td>
			</tr>
			<tr>
				<th>탈퇴여부</th>
				<td>
					<c:choose>
						<c:when test="${user.use_yn == 'y' }">
							사용 중
						</c:when>
						<c:otherwise>
							탈퇴
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr>
				<td colspan='2' align="center">
					<button type="button" class="btn btn-success" onclick="javascript:self.close()">닫기</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>