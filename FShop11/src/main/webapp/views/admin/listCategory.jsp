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
<link href="${APP_PATH }/css/back/style.css" rel="stylesheet">
</head>
<body>
<div class="workingArea">
    <ol class="breadcrumb">
		<li><a href="admin_category_list">所有分类</a></li>
		<li class="active">分类管理</li>
	</ol> 
	<div class="listDataTableDiv">
		<table
			class="table table-striped table-bordered table-hover  table-condensed">
			<thead>
				<tr class="success">
					<th>ID</th>
					<th>图片</th>
					<th>分类名称</th>
					<th>属性管理</th>
					<th>产品管理</th>
					<th>编辑</th>
					<th>删除</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${cs}" var="c">

					<tr>
						<td>${c.id}</td>
						<td><img height="40px" src="img/category/${c.id}.jpg"></td>
						<td>${c.name}</td>

						<td><a href="admin_property_list?cid=${c.id}"><span
								class="glyphicon glyphicon-th-list"></span></a></td>
						<td><a href="admin_product_list?cid=${c.id}"><span
								class="glyphicon glyphicon-shopping-cart"></span></a></td>
						<td><a href="" data-toggle="modal" data-target="#myModal_update_${c.id}"><span
								class="glyphicon glyphicon-edit"></span></a></td>
						<td><a deleteLink="true"
							href="admin_category_delete?id=${c.id}"><span
								class="   glyphicon glyphicon-trash"></span></a></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<!-- Button trigger modal -->
	<button type="button" class="btn btn-primary btn-lg"
		data-toggle="modal" data-target="#myModal">新增分类</button>
	<form action="admin_category_add" method="post">
		<!-- Modal -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">新增分类</h4>
					</div>
					<div class="modal-body">

						<div class="form-group">
							<label for="exampleInputEmail1">分类名称</label> <input type="text"
								name="name" class="form-control" id="exampleInputEmail1"
								placeholder="分类名称">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">排序编号</label> <input
								type="number" name="orderCid" class="form-control"
								id="exampleInputPassword1" placeholder="排序编号">
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="submit" class="btn btn-primary">保存</button>
					</div>
				</div>
			</div>
		</div>
	</form>

	<c:forEach items="${cs}" var="c">
	<form action="admin_category_update" method="post">
		<!-- Modal -->
		<div class="modal fade" id="myModal_update_${c.id}" tabindex="-1" role="dialog"
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
					<input type="hidden" name="id" value="${c.id}">

						<div class="form-group">
							<label for="exampleInputEmail1">分类名称</label> <input type="text"
								name="name" value="${c.name}" class="form-control" id="exampleInputEmail1"
								placeholder="分类名称">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">排序编号</label> <input
								type="number" name="orderCid" value="${c.orderCid}" class="form-control"
								id="exampleInputPassword1" placeholder="排序编号">
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
	<!-- Button trigger modal 
	<button type="button" class="btn btn-primary btn-lg"
		data-toggle="modal" data-target="#myModal_update">编辑</button>
		
	<form action="admin_category_update" method="post">
		<div class="modal fade" id="myModal_update_${c.id}" tabindex="-1" role="dialog"
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
					<input type="text" name="id" value="6">

						<div class="form-group">
							<label for="exampleInputEmail1">分类名称</label> <input type="text"
								name="name" class="form-control" id="exampleInputEmail1"
								placeholder="分类名称">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">排序编号</label> <input
								type="number" name="orderCid" class="form-control"
								id="exampleInputPassword1" placeholder="排序编号">
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="submit" class="btn btn-primary">更新</button>
					</div>
				</div>
			</div>
		</div>
	</form>-->
</body>
</html>
