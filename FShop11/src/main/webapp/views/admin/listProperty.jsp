<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<title>属性管理</title>
<link
	href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<script src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/jquery.min.js"></script>
<script
	src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<link href="${APP_PATH }/css/back/style.css" rel="stylesheet">
</head>
<body>




<div class="workingArea">

	<ol class="breadcrumb">
		<li><a href="admin_category_list">所有分类</a></li>
		<li><a href="admin_property_list?cid=${c.id}">${c.name}</a></li>
		<li class="active">属性管理</li>
	</ol>



	<div class="listDataTableDiv">
		<table
				class="table table-striped table-bordered table-hover  table-condensed">
			<thead>
			<tr class="success">
				<th>ID</th>
				<th>属性名称</th>
				<th>编辑</th>
				<th>删除</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${ps}" var="p">

				<tr>
					<td>${p.id}</td>
					<td>${p.name}</td>
					<td><a href="" data-toggle="modal" data-target="#property_update_${p.id}"><span
							class="glyphicon glyphicon-edit"></span></a></td>
					<td><a deleteLink="true"
						   href="admin_property_delete?id=${p.id}"><span
							class=" 	glyphicon glyphicon-trash"></span></a></td>

				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>

	<div class="panel panel-warning addDiv">
		<div class="panel-heading">新增属性</div>
		<div class="panel-body">
			<form method="post" id="addForm" action="admin_property_add">
				<table class="addTable">
					<tr>
						<td>属性名称</td>
						<td><input id="name" name="name" type="text"
								   class="form-control"></td>
					</tr>
					<tr class="submitTR">
						<td colspan="2" align="center">
							<input type="hidden" name="cid" value="${c.id}">
							<button type="submit" class="btn btn-success">提 交</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	
<c:forEach items="${ps}" var="p">
	<form action="admin_property_update" method="post">
		<!-- Modal -->
		<div class="modal fade" id="property_update_${p.id}" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">编辑</h4>
					</div>
					<div class="modal-body">
					<input type="hidden" name="id" value="${p.id}">
					<input type="hidden" name="cid" value="${c.id}">

						<div class="form-group">
							<label for="exampleInputEmail1">属性名称</label> <input type="text"
								name="name" value="${p.name}" class="form-control" id="exampleInputEmail1"
								placeholder="属性名称">
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="submit" class="btn btn-primary">更新</button>
					</div>
				</div>
			</div>
		</div>
	</form>
	</c:forEach>
</div>

</body>
</html>
