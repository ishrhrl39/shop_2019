<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<script src="/js/tattoo/main.js"></script>
</head>
<body>
	<input type="hidden" name="goods" id="goods" value="${goods }" />
	<table>
		<tr>
			<td colspan="3"  align="right">
				<c:if test="${loginUser.id == 'admin'}">
					<button type="button" id="goInsertGoodsBtn" class="btn btn-success">상품등록</button>
				</c:if>
			</td>
		</tr>
	</table>
</body>
</html>