<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>FAQ 목록</title>
</head>
<body>
	<h1></h1>
	<div class="container">
		<div class="page-header">
			<h1>
				FAQ <small>Frequently Asked Questions</small>
			</h1>
		</div>
		<div class="row">
			<div id="faq" class="col-md-9">
				<div class="panel-group" id="accordion">
					<c:forEach items="${faqList }" var="faq">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a class="accordion-toggle" data-toggle="collapse"
										data-parent="#accordion" href="#collapse-${faq.NO}"> ${faq.TITLE }</a>
								</h4>
							</div>
							<div id="collapse-${faq.NO }" class="panel-collapse collapse">
								<div class="panel-body">
									${faq.CONTENT}
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</body>
</html>