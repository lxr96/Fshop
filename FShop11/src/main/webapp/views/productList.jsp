<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
   pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>显示商品</title>
    <link href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/jquery.min.js"></script>
    <script src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    
    <script type="text/javascript">
    $(document).ready(function(){
        $("#search").click(function(){
         alert("success");
          });
        });
    $(document).on("click","search",function(){
    	var id=$("#keyword").value;
		alert(id+"success");
    	
    });
    
    function search(keyword){
    	$("#search").click(function(){
			var id=$("#keyword").value;
			alert(id);
		});
    	/*
    	$.ajax({
    		url:"p_show",
    		data:"keyword="+keyword,
    		type:"GET",
    		success:function(result){
    			arlet("success"+keyword);
    		}
    	});*/
    }
    
    </script>
    
  </head>
  <body>
  
  <div class="row">
  <div class="col-md-2 col-md-offset-2">
    <div class="input-group">
      <input type="text" class="form-control" placeholder="Search for..." id="keyword">
      <span class="input-group-btn">
        <button class="btn btn-default" type="button" id="search">搜索</button>
      </span>
    </div>
  </div>
</div>
<div class="row">
<div class="col-md-8 col-md-offset-2">
   <table>
    <tr>
        <th>序号</th><th>商品名称</th><th>类型</th><th>价格</th><th>库存</th><th>供应商</th><th>评论数</th><th>修改时间</th><th>操作</th>
    </tr>
    <tr>123</tr>
    <c:forEach items="${productlist}" var="product">  
            <tr bgcolor="#EFF3F7">  
                <td>${product.id }</td>
                <td>${product.name }</td>
                <td>${product.subtitle }</td>
                <td>${product.originalprice }</td>
                <td>${product.promoteprice }</td>
                <td>${product.cname }</td>
                <td>${product.uname }</td>
                <td>${product.stock }</td>    
                <td>
                      <button>编辑</button>
                      <button id="" onclick="deletes(${product.id })">删除</button>
                </td> 
            </tr>  
        </c:forEach> 
  </table> 
  <br><br>
</div>
</div>
<div class="row">
<div class="col-md-6 col-md-offset-2">
  <p>当前是第${pageinfo.pageNum}页，总${pageinfo.pages}页，总${pageinfo.total}条记录</p>
  <ul class="pagination">
    <li>
      <a href="p_show?pn=1">首页</a>
    </li>
    <li>
      <a href="p_show?pn=${pageinfo.pageNum-1}" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    <c:forEach items="${pageinfo.navigatepageNums}" var="navigatepageNums"> 
    <li><a href="p_show?pn=${navigatepageNums}">${navigatepageNums}</a></li> 
    </c:forEach>
    <li>
      <a href="p_show?pn=${pageinfo.pageNum+1}" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
    <li>
      <a href="p_show?pn=${pageinfo.pages}">末页</a>
    </li>
  </ul>
</div>
</div>
  
  </body>
</html>
