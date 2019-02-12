<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>显示商品</title>
<link
	href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<script src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/jquery.min.js"></script>
<script
	src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<link href="${APP_PATH }/back/style.css" rel="stylesheet">
</head>
<title>图片上传测试</title>
<body>

	<form method="post" class="addFormDetail"
		action="admin_productImage_save" enctype="multipart/form-data">
		<table class="addTable">
			<tr>
				<td>请选择本地图片 宽度790 为佳</td>
			</tr>
			<tr>
				<td><input id="filepathDetail" type="file" name="pictureFile" /></td>
			</tr>
			<tr class="submitTR">
				<td align="center">
					<button type="submit" class="btn btn-success">提 交</button>
				</td>
			</tr>
		</table>
	</form>
	<img img height="50px" src="img/productDetail/1.jpg">
	<img img height="50px" src="img/productDetail/2.jpg">

</body>
</html>
