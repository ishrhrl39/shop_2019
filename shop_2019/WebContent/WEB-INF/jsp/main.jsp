<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>타투 쇼핑몰</title>
</head>
<body>
	<div class="index_layout">	
		<span class="title">판매 랭킹</span><br/>
		<c:set var="index" value="1" />
		<c:forEach items="${paymentBestList }" var="tattoo">
			<div class="col-sm-2" style="margin-bottom:10px;">
				<a href="/tattoo/detail.do?id=${tattoo.id }">
					<div class="payment_item">
						<span class="rank">${index }위</span>
						<img src="${tattoo.image }" width="100%" height="240" border="0" />
						<div class="content">
							<b>${tattoo.nm }</b><br/>
							<c:choose>
								<c:when test="${tattoo.sale == 0 }">
									<fmt:formatNumber value="${tattoo.price}" pattern="#,###" />원
								</c:when>
								<c:otherwise>
									<span class="cancel_price"><fmt:formatNumber value="${tattoo.price}" pattern="#,###" />원</span><br/>
									<fmt:formatNumber value="${tattoo.price- tattoo.price*tattoo.sale/100}" pattern="#,###" />원
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</a>
			</div>
			<c:set var="index" value="${index + 1 }" />
		</c:forEach>
	</div>
	<div class="index_layout">	
		<span class="title">이벤트 상품</span><br/>
		<c:set var="index" value="1" />
		<c:forEach items="${saleBestList }" var="tattoo">
			<div class="col-sm-2" style="margin-bottom:10px;">
				<a href="/tattoo/detail.do?id=${tattoo.id }">
					<div class="payment_item">
						<span class="rank">${index }위</span>
						<img src="${tattoo.image }" width="100%" height="240" border="0" />
						<div class="content">
							<b>${tattoo.nm }</b><br/>
							<c:choose>
								<c:when test="${tattoo.sale == 0 }">
									<fmt:formatNumber value="${tattoo.price}" pattern="#,###" />원
								</c:when>
								<c:otherwise>
									<span class="cancel_price"><fmt:formatNumber value="${tattoo.price}" pattern="#,###" />원</span><br/>
									<fmt:formatNumber value="${tattoo.price- tattoo.price*tattoo.sale/100}" pattern="#,###" />원
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</a>
			</div>
			<c:set var="index" value="${index + 1 }" />
		</c:forEach>
	</div>
	<div class="index_layout">	
		<span class="title">신상품 목록</span><br/>
		<c:set var="index" value="1" />
		<c:forEach items="${newTattooList }" var="tattoo">
			<div class="col-sm-2" style="margin-bottom:10px;">
				<a href="/tattoo/detail.do?id=${tattoo.id }">
					<div class="payment_item">
						<span class="rank">${index }위</span>
						<img src="${tattoo.image }" width="100%" height="240" border="0" />
						<div class="content">
							<b>${tattoo.nm }</b><br/>
							<c:choose>
								<c:when test="${tattoo.sale == 0 }">
									<fmt:formatNumber value="${tattoo.price}" pattern="#,###" />원
								</c:when>
								<c:otherwise>
									<span class="cancel_price"><fmt:formatNumber value="${tattoo.price}" pattern="#,###" />원</span><br/>
									<fmt:formatNumber value="${tattoo.price- tattoo.price*tattoo.sale/100}" pattern="#,###" />원
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</a>
			</div>
			<c:set var="index" value="${index + 1 }" />
		</c:forEach>
	</div>
</body>
</html>