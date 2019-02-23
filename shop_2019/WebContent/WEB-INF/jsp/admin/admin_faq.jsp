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
						<td width="90%"><input type="text" name="title" id="title2" class="form-control" placeHolder="������ �Է����ּ���." /></td>
					</tr>
					<tr>
						<td colspan="2" style="padding-top:10px;">
							<textarea class="form-control" name="content" id="content" placeHolder="������ �Է����ּ���."></textarea>
							<p align="right">
								<button type="button" class="btn btn-default" id="addFaqBtn">FAQ ���</button>
							</p>
						</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td colspan="2">
							<b>FAQ ���</b>
							<div id="btnList">
								<button type="button" class="btn btn-default" id="deleteFaqBtn">����</button>
							</div>
						</td>
					</tr>
					<c:forEach items="${faqList }" var="faq">
						<tr>
							<td colspan="2">
								<div class="faq">
									<table style="width:100%;">
										<tr>
											<td>
												<input type="checkbox" name="faqNo" class="faqNo" value="${faq.NO }" />
												����	<img src="/images/common/tit_faq_q.gif" />
											</td>
											<td>
												<input type="text" class="form-control" name="title_${faq.NO }" value="${faq.TITLE }" />
											</td>
											<td>
												&nbsp;&nbsp;<button type="button" class="btn btn-default" onclick="updateFaq('${faq.NO}')">����</button>
											</td>
										</tr>
										<tr>
											<td colspan="2" rowspan="2">
												<textarea class="form-control"  name="content_${faq.NO }" placeHolder="������ �Է����ּ���.">${faq.CONTENT }</textarea>
											</td>
										</tr>
									</table>
								</div>
							</td>
						</tr>	
					</c:forEach>
				</tbody>
			</table>
		</form>
	</div>
	
</body>
</html>