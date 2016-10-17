<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
<link rel="stylesheet" type="text/css" href="<%=path %>/resources/static/ztree/css/demo.css" />
<link rel="stylesheet" type="text/css" href="<%=path %>/resources/static/ztree/css/zTreeStyle.css" />
<!--[if IE 6]>
<script type="text/javascript" src="<%=path %>/resources/lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>角色模块编辑</title>
</head>
<body>
	<div>
		<ul id="moduleTree" class="ztree"></ul>
		<button type="button" id="submit" onclick="submit_tree_edit()">确定</button>
		<button type="button" id="cancel" onclick="cancel_edit()">取消</button>
	</div>
	<input type="hidden" id="ctx" value="<%=path%>" />
	<input type="hidden" id="roleId" value="${roleId}" />
<script type="text/javascript" src="<%=path %>/resources/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=path %>/resources/static/ztree/js/jquery.ztree.core.min.js"></script>
<script type="text/javascript" src="<%=path %>/resources/static/ztree/js/jquery.ztree.excheck.min.js"></script>
<script type="text/javascript" src="<%=path %>/resources/lib/layer/2.1/layer.js"></script> 
<script type="text/javascript" src="<%=path %>/resources/defaultScript/com.seelecloud.scms.roleModuleTreeEdit.js"></script>
</body>
</html>
