<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<link rel="stylesheet" href="/css/tattoo/tattoo_insert.css">
<script src="/js/tattoo/tattoo_insert.js"></script>
<script src="https://cloud.tinymce.com/5/tinymce.min.js?apiKey=os0yrpga0flzo6qubjpyaz714soim54cd5m0cmb1rcwilpw7"></script>
<script type="text/javascript">
	tinymce.init({
		   selector: 'textarea',
		   plugins: 'a11ychecker advcode formatpainter linkchecker media mediaembed pageembed permanentpen powerpaste tinycomments tinydrive tinymcespellchecker',
		   toolbar: 'a11ycheck code formatpainter insertfile pageembed permanentpen tinycomments',
		   tinycomments_mode: 'embedded',
		   tinycomments_author: 'Author name'
		});
</script>
</head>
<body>
	<form id="insertTattooFrm" method="post" enctype="multipart/form-data" action="/tattoo/list.do?cmd=insertProc">
		<h1 id="title">상품 등록</h1>
		<div id="insertTattooLayout" align="center" >
			<input type="hidden" name="goods" id="goods" value="${goods }" />
			<table id="tattooTable">
				<tr>
					<th>상품명</th>
					<td><input type="text" name="nm" id="nm" class="form-control" maxlength="50" placeHolder="상품명을 입력하십시오." /></td>
				</tr>
				<tr>
					<th>상품 메인이미지</th>
					<td>
						<div class="box">
							<span class="filetype">
							<input type="text" class="file-text" readonly="readonly" />
							<span class="file-btn">찾아보기</span>
							<span class="file-select"><input type="file" id="image" name="image" class="input-file" size="3"></span>
							</span>
						</div>
					</td>
				</tr>
				<tr>
					<th>상품 가격</th>
					<td><input type="text" name="price" id="price" maxlength="8"  placeHolder="상품 가격을 입력하십시오." />원</td>
				</tr>
				<tr>
					<th>상품 색상</th>
					<td>
						<input type="hidden" id="color_list" name="color_list" value="all"  />
						
						<input type="radio" name="sale_option" checked="checked" value="all" />ALL 
						<input type="radio" name="sale_option" value="op" />OPTION
						<select id="color" name="color" size="8" multiple="multiple" class="form-control" >
							<c:forEach items="${colorList }" var="tattooColor">
								<option value="${tattooColor.SEQ }">${tattooColor.COLOR }</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<th>할인률</th>
					<td>
						<select id="sale" name="sale" class="form-control" >
							<c:forEach begin="10" end="100" step="10" var="percent">
								<option value="${percent }">${percent }%</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<th>할인 기간</th>
					<td>
						<!-- sale_start_dt, sale_end_dt -->
						<input type="text" name="sale_start_dt" id="datepicker1" class="datepicker" readonly="readonly"> ~
  						<input type="text" name="sale_end_dt" id="datepicker2" class="datepicker"  readonly="readonly">
					</td>
				</tr>
				<tr>
					<th>상품내용</th>
					<td>
						<textarea id="content" name="content"></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button type="button" id="insertBtn" class="btn btn-primary">상품등록</button>
						<button type="button" id="previewContentBtn" class="btn btn-default">미리보기</button>
						<button type="button" id="cancelInsertBtn" class="btn btn-default">목록보기</button>
					</td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>