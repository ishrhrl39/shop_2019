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
											<td> ${one.price}(<fmt:formatNumber value="${one.price- one.price*one.sale/100}" pattern="#,###" />)</td>					
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
					</td>
				</tr>
			</tbody>
		</table>
	</body>
</html>