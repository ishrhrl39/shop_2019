<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>Ÿ�� ����� ����</title>
	<script type="text/javascript" src="/js/admin/admin_faq.js"></script>
	<link rel="stylesheet" href="/css/admin/admin_faq.css">
</head>
<body>
	<div id="faq_list_layer" align="center">
		<form id="faq_frm" method="post">
			<table>
				<thead>
					<tr>
						<th width="10%" style="text-align:center"><img src="/images/common/tit_faq_q.gif" /> ����</th>
						<td width="90%"><input type="text" name="title" class="form-control" placeHolder="������ �Է����ּ���." /></td>
					</tr>
					<tr>
						<td colspan="2" style="padding-top:10px;">
							<textarea class="form-control" name="content" placeHolder="������ �Է����ּ���."></textarea>
							<p align="right">
								<button type="button" class="btn btn-default" id="addFaqBtn">FAQ ���</button>
							</p>
						</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${faqList }" var="faq">
						<tr>
						</tr>	
					</c:forEach>
				</tbody>
			</table>
		</form>
	</div>
	
</body>
</html>