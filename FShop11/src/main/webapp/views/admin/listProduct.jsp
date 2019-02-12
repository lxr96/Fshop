<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>产品管理</title>
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
			<li class="active">产品管理</li>
			<li class="active">${c.name}</li>
		</ol>

		<div class="listDataTableDiv">
			<table
				class="table table-striped table-bordered table-hover  table-condensed">
				<thead>
					<tr class="success">
						<th>ID</th>
						<th>图片</th>
						<th>产品名称</th>
						<th>产品小标题</th>
						<th width="53px">原价格</th>
						<th width="80px">优惠价格</th>
						<th width="80px">库存数量</th>
						<th width="80px">图片管理</th>
						<th width="80px">设置属性</th>
						<th width="42px">编辑</th>
						<th width="42px">删除</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ps}" var="p">
						<tr>
							<td>${p.id}</td>
							<td><img height="40px" src="img/category/${c.id}.jpg">

							</td>
							<td>${p.name}</td>
							<td>${p.subtitle}</td>
							<td>${p.originalprice}</td>
							<td>${p.promoteprice}</td>
							<td>${p.stock}</td>
							<td><a href="admin_productImage_list?pid=${p.id}"><span
									class="glyphicon glyphicon-picture"></span></a></td>
							<td><a href="admin_propertyValue_edit?pid=${p.id}"><span
									class="glyphicon glyphicon-th-list"></span></a></td>

							<td><a href="" data-toggle="modal"
								data-target="#product_update_${p.id}"><span
									class="glyphicon glyphicon-edit"></span></a></td>
							<td><a deleteLink="true"
								href="admin_product_delete?id=${p.id}"><span
									class="     glyphicon glyphicon-trash"></span></a></td>

						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="panel panel-warning addDiv">
			<div class="panel-heading">新增产品</div>
			<div class="panel-body">
				<form method="post" id="addForm" action="admin_product_add">
					<table class="addTable">
						<tr>
							<td>产品名称</td>
							<td><input id="name" name="name" type="text"
								class="form-control"></td>
						</tr>
						<tr>
							<td>产品小标题</td>
							<td><input id="subtitle" name="subtitle" type="text"
								class="form-control"></td>
						</tr>
						<tr>
							<td>原价格</td>
							<td><input id="originalprice" value="99.98"
								name="originalprice" type="text" class="form-control"></td>
						</tr>
						<tr>
							<td>优惠价格</td>
							<td><input id="promoteprice" value="19.98"
								name="promoteprice" type="text" class="form-control"></td>
						</tr>
						<tr>
							<td>库存</td>
							<td><input id="stock" value="99" name="stock" type="text"
								class="form-control"></td>
						</tr>
						<tr class="submitTR">
							<td colspan="2" align="center"><input type="hidden"
								name="cid" value="${c.id}">
								<button type="submit" class="btn btn-success">提 交</button></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
	<c:forEach items="${ps}" var="p">
		<form action="admin_product_update" method="post">
			<!-- Modal -->
			<div class="modal fade" id="product_update_${p.id}" tabindex="-1"
				role="dialog" aria-labelledby="myModalLabel">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title" id="myModalLabel">编辑商品</h4>
						</div>
						<div class="modal-body">
							<input type="hidden" name="id" value="${p.id}"> <input
								type="hidden" name="cid" value="${p.cid}">

							<div class="form-group">
								<label for="name">产品名称</label> <input id="name" name="name"
									value="${p.name}" type="text" class="form-control"
									id="product_name">
							</div>
							<div class="form-group">
								<label for="subtitle">产品小标题</label> <input id="subtitle"
									name="subtitle" value="${p.subtitle}" type="text"
									class="form-control" id="product_subtitle">
							</div>
							<div class="form-group">
								<label for="originalprice">原价</label> <input id="originalprice"
									value="${p.originalprice}" name="originalprice" type="text"
									class="form-control">
							</div>
							<div class="form-group">
								<label for="promoteprice">促销价格</label> <input id="promoteprice"
									value="${p.promoteprice}" name="promoteprice" type="text"
									class="form-control">
							</div>
							<div class="form-group">
								<label for="stock">库存</label> <input id="stock"
									value="${p.stock}" name="stock" type="text"
									class="form-control">
							</div>
							<div class="form-group">
								<label for="stock">销售状态</label>
								<div class="radio">
									<label> <input type="radio" name="pstatus"
										id="optionsRadios1" value="normal" checked>正常 
									</label>
									<label> <input type="radio" name="pstatus"
										id="optionsRadios2" value="locked">冻结
									</label>
								</div>
							</div>

						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">关闭</button>
							<button type="submit" class="btn btn-primary">更新</button>
						</div>
					</div>
				</div>
			</div>
		</form>
	</c:forEach>
</body>
</html>
