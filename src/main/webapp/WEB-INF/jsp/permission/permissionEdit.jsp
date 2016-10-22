<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"//:"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<LINK rel="Bookmark" href="<%=path %>/resources/favicon.ico" >
<LINK rel="Shortcut Icon" href="<%=path %>/resources/favicon.ico" />
<!--[if lt IE 9]>
<script type="text/javascript" src="<%=path %>/resources/lib/html5.js"></script>
<script type="text/javascript" src="<%=path %>/resources/lib/respond.min.js"></script>
<script type="text/javascript" src="<%=path %>/resources/lib/PIE_IE678.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="<%=path %>/resources/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="<%=path %>/resources/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="<%=path %>/resources/lib/Hui-iconfont/1.0.7/iconfont.css" />
<link rel="stylesheet" type="text/css" href="<%=path %>/resources/lib/icheck/icheck.css" />
<link rel="stylesheet" type="text/css" href="<%=path %>/resources/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="<%=path %>/resources/static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="<%=path %>/resources/lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>权限管理</title>
</head>
<body>
<div class="page-container">
<INPUT type="hidden" id="ctx"  value="<%=request.getContextPath()%>"/>
<article class="page-container">
	<sf:form action="#" modelAttribute="" method="POST" class="form form-horizontal" id="form-admin-permission-edit">
		<%-- <sf:hidden id="id" name="id" value="${managerId}" /> --%>
 		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">管理员名称：${manager.managerName}</label>
 		</div>
 		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">选择角色:</label>
			<select onChange="select_change(this.value)">
				<c:forEach items="${roleList}" var="role">
					<option value="${role.id}">${role.roleName}</option>
				</c:forEach>
			</select>
		</div>
		
		<!-- 用来保存roleList的  description值 -->
		<div id = "roleList" style="display:none;" class="row cl">
			<c:forEach items="${roleList}" var="role">
				<input id="${role.id}"  title="desc_${role.id}" value="${role.description}" />
			</c:forEach>
		</div>
		
		<div class="row cl">
		    <label class="form-label col-xs-4 col-sm-3">角色描述:</label>		
			<div id="role_description">
				<TEXTAREA cols="20" rows="5" disabled="disabled" id ="description"></TEXTAREA>
			</div>
		</div>

		<div class="row cl col-xs-4 col-sm-3">
			<button type="submit" class="btn btn-success radius" id="admin-permission-edit" name="admin-permission-edit"><i class="icon-ok"></i> 确定</button>
			<button type="button" class="btn btn-secondary radius" id="cancel" name="cancel" onclick="cancel_edit()"><i class="icon-ok"></i>取消</button>
		</div>
	</sf:form>
</article>
</div>
<script type="text/javascript" src="<%=path %>/resources/lib/jquery/1.9.1/jquery.min.js"></script>  
<script type="text/javascript" src="<%=path %>/resources/lib/layer/2.1/layer.js"></script> 
<script type="text/javascript" src="<%=path %>/resources/lib/laypage/1.2/laypage.js"></script> 
<script type="text/javascript" src="<%=path %>/resources/lib/My97DatePicker/WdatePicker.js"></script> 
<script type="text/javascript" src="<%=path %>/resources/static/h-ui/js/H-ui.js"></script> 
<script type="text/javascript" src="<%=path %>/resources/static/h-ui.admin/js/H-ui.admin.js"></script> 
<script type="text/javascript" src="<%=path %>/resources/defaultScript/com.seelecloud.scms.permissionEdit.js"></script> 
</body>
</html>
