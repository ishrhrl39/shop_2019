<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<script type="text/javascript" src="/js/mypage/pwdUpdate.js"></script>
	</head>
	<body>
		<center>
			<table  id="myTable">
				<tbody>
					<tr>
						<th>새 비밀번호  </th>
						<td><input type="password" id="newPwd" name="newPwd"></td>
					</tr>
					<tr>
						<th>새 비밀번호 확인  </th>
						<td><input type="password" id="reNewPwd" name="reNewPwd"></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<div id="updateLayout">
								<button type="button" id="pwdUpdateBtn" class="btn btn-success">비밀번호 수정</button>
								<button type="button" id="cancelPwdUpdateBtn" class="btn btn-default">닫기</button>
							</div >
						</td>
					</tr>
				</tbody>
			</table>
		</center>
	</body>
</html>