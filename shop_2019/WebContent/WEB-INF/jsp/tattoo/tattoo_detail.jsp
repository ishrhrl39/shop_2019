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
									<th> 타투명 </th>
									<td> ${one.nm} </td>
								</tr>
								<tr>
									<th> 가격 </th>
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
									<th> 색깔 </th>
									<td> 
										<select id="color" name="color"  class="form-control" >
											<option value="rd">Red</option>
											<option value="yl">Yellow</option>
											<option value="gr">Green</option>
											<option value="bl">Blue</option>
											<option value="bk">Black</option>
											<option value="wt">White</option>
										</select>
								 	</td>
								</tr>
								<tr>
									<th> 세일 기간 </th>
									<td> ${one.sale_start_dt} ~ ${one.sale_end_dt}</td>
								</tr>
								<tr>
									<th> 상세 설명 </th>
									<td> ${one.content} </td>
								</tr>
								<tr>
									<th> 등록일자 </th>
									<td> ${fn:substring(one.reg_dtm,0,8)} </td>
								</tr>
								<tr>
									<th> 수정일자 </th>
									<td> ${fn:substring(one.upd_dtm,0,8)}</td>
								</tr>
								<tr>
									<th> 타투이스트  </th>
									<td>
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