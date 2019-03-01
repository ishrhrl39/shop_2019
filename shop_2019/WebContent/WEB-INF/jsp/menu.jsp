<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">	
	</head>
	<body>
	<nav class="navbar navbar-default" style="z-index:9999">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> 
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/index.do">YENA</a>
			</div>
	
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1" >
				<ul class="nav navbar-nav" >
					<li><a href="#"></a></li>
				</ul>
				<ul class="nav navbar-nav navbar-left">
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<c:choose>
						<c:when test="${loginUser != null }">
							<c:if test="${loginUser.id == 'admin'}">
								<li><a href="/admin/index.do">관리자 페이지</a></li>
							</c:if>
							<li><a href="/account/login.do?cmd=logout">로그아웃</a></li>
							<li class='dropdown'>
								<a href="/mypage/myInfo.do?cmd=list" class='dropdown-toggle' data-toggle='dropdown' role='button' aria-haspopup='true' aria-expanded='false'>마이페이지</a>
								<ul class='dropdown-menu'>
									<li><a href='/mypage/myInfo.do'>내 정보 관리</a></li>
									<li><a href='/mypage/basket.do'>장바구니</a></li>
									<li><a href='/mypage/myInfo.do?cmd=payment'>구매 이력</a></li>
									<li><a href='/mypage/myInfo.do?cmd=drop'>회원탈퇴</a></li>
								</ul>															
							</li>
						</c:when>
						<c:otherwise>
							<li><a href="/account/login.do">로그인</a></li>
							<li><a href="/account/account.do">회원가입</a></li>
						</c:otherwise>
					</c:choose>
					
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid --> 
	</nav>
	
	
	</body>
</html>