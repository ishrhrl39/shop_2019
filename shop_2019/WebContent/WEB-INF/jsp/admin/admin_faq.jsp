<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>타투 담당자 관리</title>
	<script type="text/javascript" src="/js/admin/admin_faq.js"></script>
	<link rel="stylesheet" href="/css/admin/admin_faq.css">
</head>
<body>
	<div id="faq_list_layer" align="center">
		<form id="faq_frm" method="post">
			<table>
				<thead>
					<tr>
						<th width="10%" style="text-align:center"><img src="/images/common/tit_faq_q.gif" /> 제목</th>
						<td width="90%"><input type="text" name="title" id="title2" class="form-control" placeHolder="제목을 입력해주세요." /></td>
					</tr>
					<tr>
						<td colspan="2" style="padding-top:10px;">
							<textarea class="form-control" name="content" id="content" placeHolder="내용을 입력해주세요."></textarea>
							<p align="right">
								<button type="button" class="btn btn-default" id="addFaqBtn">FAQ 등록</button>
							</p>
						</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td colspan="2">
							<b>FAQ 목록</b>
							<div id="btnList">
								<button type="button" class="btn btn-default" id="deleteFaqBtn">삭제</button>
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
												제목	<img src="/images/common/tit_faq_q.gif" />
											</td>
											<td>
												<input type="text" class="form-control" name="title_${faq.NO }" value="${faq.TITLE }" />
											</td>
											<td>
												&nbsp;&nbsp;<button type="button" class="btn btn-default" onclick="updateFaq('${faq.NO}')">수정</button>
											</td>
										</tr>
										<tr>
											<td colspan="2" rowspan="2">
												<textarea class="form-control"  name="content_${faq.NO }" placeHolder="내용을 입력해주세요.">${faq.CONTENT }</textarea>
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