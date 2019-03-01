<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<script src="/js/tattoo/tattoo_detail.js"></script>
		<link rel="stylesheet" href="/css/tattoo/tattoo_detail.css">
	</head>
	<body>
		
		<form id="reserveForm" action="#" method="post">
			<input type="hidden" name="tattooName" value="${one.nm}"/>
			<input type="hidden" name="tattoPrice" value="<fmt:formatNumber value="${one.price- one.price*one.sale/100}" pattern="#,###" />"/>
			<input type="hidden" name="tattooId" value="${one.id}"/>
			<input type="hidden" name="tattooImage" value="${one.image}"/>
			<input type="hidden" name="realTattooPrice" value="<fmt:formatNumber value="${one.price}" pattern="#,###" />"/>
			<input type="hidden" name="salePrice" value="<fmt:formatNumber value="${one.price*one.sale/100}" pattern="#,###" />"/>
			<div class="col-sm-12">
				<div class="col-sm-3">
					<img src = "${one.image}" width="100%" />
				</div>
				<div class="col-sm-9">
					<table id="sub_table">
						<tbody>
							<tr>
								<th> Ÿ���� </th>
								<td> ${one.nm} </td>
							</tr>
							<tr>
								<th> ���� </th>
								<c:choose>
									<c:when test="${one.sale == ''}">
										<td> ${one.price}</td>			
									</c:when>
									<c:otherwise>
										<td> 
											<span class="cancel_price"><fmt:formatNumber value="${one.price}" pattern="#,###" /></span>
											(���ΰ�:<fmt:formatNumber value="${one.price- one.price*one.sale/100}" pattern="#,###" />)
										</td>					
									</c:otherwise>
								</c:choose>
							
							</tr>
							<tr>
								<th> ���� </th>
								<td> 
									<select id="color" name="color"  class="form-control" >
										<c:forEach items="${tattooColorList }" var="tattooColor">
											<option value="${tattooColor.SEQ }">${tattooColor.COLOR }</option>												
										</c:forEach>
									</select>
							 	</td>
							</tr>
							<tr>
								<th> ���� �Ⱓ </th>
								<td> ${one.sale_start_dt} ~ ${one.sale_end_dt}</td>
							</tr>
							<tr>
								<th> �� ���� </th>
								<td> ${one.content} </td>
							</tr>
							<tr>
								<th> ������� </th>
								<td> ${fn:substring(one.reg_dtm,0,8)} </td>
							</tr>
							<tr>
								<th> �������� </th>
								<td> ${fn:substring(one.upd_dtm,0,8)}</td>
							</tr>
							<tr>
								<th> Ÿ���̽�Ʈ  </th>
								<td>
									<select id="tattooist" name="tattooist"  class="form-control" >
										<c:forEach items="${tattooistList }" var="tattooist">
											<option value="${tattooist.NAME }">${tattooist.NAME }</option>												
										</c:forEach>
									</select>
								
								</td>
							</tr>
							<tr>
								<td colspan="2" align="center">
									<br/>
									<button type ="button" id="reserveBtn" name="reserve" class="btn btn-default"> �����ϱ� </button>
									<button type ="button" id="basketBtn" name="basket" class="btn btn-default"> ��ٱ��� </button>
									<br/>
									&nbsp;
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</form>
	</body>
</html>