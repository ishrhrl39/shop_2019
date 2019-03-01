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
		<form id="loginForm" action="/account/login.do?cmd=login" method="post" style="margin-top:-40px">
			<div class="container">
				<div class="row">
					<div class="col-md-5 mx-auto">
						<div id="first">
							<div class="myform form ">
								<div class="logo mb-3">
									<div class="col-md-6 text-center">
										<h1>Login</h1>
									</div>
								</div>
								<div class="form-group">
									<label for="id">ID</label> 
									<input type="text" name="id" class="form-control" id="id" placeholder="Enter Id">
								</div>
								<div class="form-group">
									<label for="pass_wd">Password</label>
									<input type="password" name="pass_wd" id="pass_wd" class="form-control" placeholder="Enter Password">
								</div>
								<div class="form-group">
									<c:choose>
										<c:when test="${cookieId != ''}">
											<input type="checkbox" id="saveSession" name="saveSession" value="y" checked="checked" />
										</c:when>
										<c:otherwise>
											<input type="checkbox" id="saveSession" name="saveSession" value="y" />
										</c:otherwise>
									</c:choose>
									 아이디 저장
								</div>
								<div class="col-md-12 text-center ">
										<div class="btn-group" role="group">
											<button type="button" id="login" class="btn btn-default btn-md">Login</button>
											<button type="button" id="joinUs" class="btn btn-default btn-md">Join Us!</button>
										</div>
								</div>
								
								<div class="col-md-6 mb-3">
									<p class="text-center">
										<a href="/account/account.do?cmd=findlist">아이디/비밀번호 찾기</a>
									</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</body>
</html>