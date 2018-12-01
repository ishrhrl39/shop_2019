<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/js/admin/account.js"></script>
<link rel="stylesheet" href="/css/admin/account_list.css">
<title></title>

</head>
<body>
	<form id="adminAccountForm" action="/admin/userList.do" method="post">
		<input type="hidden" name="cmd" id="cmd" value="" />
		<input type="hidden" name="mode" id="mode" value="${mode}" />
	
		<!-- 검색 -->
		<div id="searchLayout" align="right">
			<table>
				<tr>
					<td>
						<select name="searchColumn" id="searchColumn" class="form-control">
							<option value="id">아이디</option>
							<option value="name">이름</option>
							<option value="email">이메일</option>
							<option value="tel">휴대폰번호</option>
						</select>									
					</td>
					<td>
						<input type="text" class="form-control" name="searchValue" id="searchValue" maxlength="50" />		
					</td>
					<td>
						<button type="button" class="btn btn-success" id="searchBtn">검색</button>
						<c:if test="${mode == 'S' }">
							<a href="/admin/userList.do"><button type="button" class="btn btn-default">전체보기</button></a>
						</c:if>					
					</td>
				</tr>
			</table>
		</div>
	
		<!-- 회원목록 -->
		<table id="accountList" class="table table-striped table-hover table-bordered">
			<thead>
				<tr>
					<th>
						<div class="btn-group">
							<button type="button" class="btn btn-default" id="deleteBtn">탈퇴</button>
							<button type="button" class="btn btn-warning" id="useYesBtn">사용</button>
						</div>
					</th>
					<th>아이디</th>
					<th>이름</th>
					<th>이메일</th>
					<th>생년월일</th>
					<th>성별</th>
					<th>휴대폰번호</th>
					<th>성인여부</th>
					<th>가입일자</th>
					<th>최종수정일자</th>
					<th>탈퇴여부</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${userList }" var="user">
					<tr>
						<td><input type='checkbox' name='user' id='user' value='${user.id }' /></td>
						<td><a href="#" onclick="openUserDetail('${user.id}')">${user.id }</a></td>
						<td>${user.name }</td>
						<td>${user.email }</td>
						<td>${user.birth }</td>
						<c:choose>
							<c:when test="${birth.gender == 'f' }">
								<td>여</td>
							</c:when>
							<c:otherwise>
								<td>남</td>
							</c:otherwise>
						</c:choose>
						<td>${user.tel }</td>
						<c:choose>
							<c:when test="${user.adult_yn == 'Y' }">
								<td>성인</td>
							</c:when>
							<c:otherwise>
								<td>미성년자</td>
							</c:otherwise>
						</c:choose>
						<td>${user.reg_dtm }</td>
						<td>${user.upd_dtm }</td>
						<c:choose>
							<c:when test="${user.use_yn == 'y' }">
								<td>사용 중</td>
							</c:when>
							<c:otherwise>
								<td>탈퇴</td>
							</c:otherwise>
						</c:choose>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="11" align="center">
						<c:choose>
							<c:when test="${mode != 'S' }">
								<div id="paging">
									<!-- 맨 앞으로 가기 -->
									<c:if test="${now != 1}">
										<a href="#" class="pagingIcon" onclick="goLocByPaging('1')">◀◀</a>
									</c:if>
								
									<!-- 이전 페이지 가기 -->
									<c:if test="${paging.START > 1 }">
										<a href="#" class="pagingIcon" onclick="goLocByPaging('${paging.START - 1}')">◀</a>
									</c:if>
									
									<!-- 페이징 목록 -->
									<c:forEach begin="${paging.START }" end="${paging.END}" var="page" >
										<c:if test="${page <= paging.MAX_PAGE }">
											<a href="#" onclick="goLocByPaging('${page}')">
												<c:choose>
													<c:when test="${now == page }">
														<b>${page}</b>
													</c:when>
													<c:otherwise>
														${page}
													</c:otherwise>
												</c:choose>
											</a>
										</c:if>
									</c:forEach>
									
									<!-- 다음 페이지 가기 -->
									<c:if test="${paging.END < paging.MAX_PAGE }">
										<a style="margin-left:5px;" href="#" class="pagingIcon" onclick="goLocByPaging('${paging.END + 1}')">▶</a>
									</c:if>
									
									<!-- 마지막 페이지 가기 -->
									<c:if test="${paging.MAX_PAGE > 1 && now != paging.MAX_PAGE}">
										<a href="#" class="pagingIcon" onclick="goLocByPaging('${paging.MAX_PAGE }')">▶▶</a>
									</c:if>
								</div>
							</c:when>
							<c:otherwise>
								<a href="/admin/userList.do"><button type="button" class="btn btn-default">전체보기</button></a>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</tfoot>
		</table>
	</form>
</body>
</html>