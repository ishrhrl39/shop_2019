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
		<h1 id="title">��ǰ ���</h1>
		<div id="insertTattooLayout" align="center" >
			<input type="hidden" name="goods" id="goods" value="${goods }" />
			<table id="tattooTable">
				<tr>
					<th>��ǰ��</th>
					<td><input type="text" name="nm" id="nm" class="form-control" maxlength="50" placeHolder="��ǰ���� �Է��Ͻʽÿ�." /></td>
				</tr>
				<tr>
					<th>��ǰ �����̹���</th>
					<td>
						<div class="box">
							<span class="filetype">
							<input type="text" class="file-text" readonly="readonly" />
							<span class="file-btn">ã�ƺ���</span>
							<span class="file-select"><input type="file" id="image" name="image" class="input-file" size="3"></span>
							</span>
						</div>
					</td>
				</tr>
				<tr>
					<th>��ǰ ����</th>
					<td><input type="text" name="price" id="price" maxlength="8"  placeHolder="��ǰ ������ �Է��Ͻʽÿ�." />��</td>
				</tr>
				<tr>
					<th>��ǰ ����</th>
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
					<th>���η�</th>
					<td>
						<select id="sale" name="sale" class="form-control" >
							<c:forEach begin="10" end="100" step="10" var="percent">
								<option value="${percent }">${percent }%</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<th>���� �Ⱓ</th>
					<td>
						<!-- sale_start_dt, sale_end_dt -->
						<input type="text" name="sale_start_dt" id="datepicker1" class="datepicker" readonly="readonly"> ~
  						<input type="text" name="sale_end_dt" id="datepicker2" class="datepicker"  readonly="readonly">
					</td>
				</tr>
				<tr>
					<th>��ǰ����</th>
					<td>
						<textarea id="content" name="content"></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button type="button" id="insertBtn" class="btn btn-primary">��ǰ���</button>
						<button type="button" id="previewContentBtn" class="btn btn-default">�̸�����</button>
						<button type="button" id="cancelInsertBtn" class="btn btn-default">��Ϻ���</button>
					</td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>