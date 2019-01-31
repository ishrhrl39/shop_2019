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
	</head>
	<body>
		<form id="reserveForm" action="/tattoo/payment.do">
			<input type="hidden" name="tattooName" value="${one.nm}"/>
			<input type="hidden" name="tattoPrice" value="${one.prcie}"/>
			<input type="hidden" name="tattooId" value="${one.id}"/>
			<input type="hidden" name="tattooImage" value="${one.image}"/>
			<table>
				<tbody>
					<tr>	
						<td>
							<img src = "${one.image}" width="50%" />
						</td>
						<td>
							<table>
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
												<td> ${one.price}(���ΰ�:<fmt:formatNumber value="${one.price- one.price*one.sale/100}" pattern="#,###" />)</td>					
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
													<option value="${tattooist.SEQ }">${tattooist.NAME }</option>												
												</c:forEach>
											</select>
										</td>
									</tr>
								</tbody>
							</table>
							<div>
								<button type ="button" id="reserveBtn" name="reserve"> �����ϱ� </button>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</body>
</html>