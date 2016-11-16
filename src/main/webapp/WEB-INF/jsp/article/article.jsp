<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "//:"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="<%=path %>/resources/lib/html5.js"></script>
<script type="text/javascript" src="<%=path %>/resources/lib/respond.min.js"></script>
<script type="text/javascript" src="<%=path %>/resources/lib/PIE_IE678.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css"
	href="<%=path%>/resources/static/h-ui/css/H-ui.min.css" />
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css"
	href="<%=path%>/resources/lib/Hui-iconfont/1.0.7/iconfont.css" />
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<!-- 文章标题 -->
<title>文章</title>
</head>
<body style="background:#F0F0F0;">
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 内容管理 <span class="c-gray en">&gt;</span> 查看文章 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">	
	<div class="mt-20">
	<h3 class="admin_link_bar" style="text-align:center">
	<span>${article.title }</span>
	</h3>
		<table  class="table table-border table-bordered table-bg table-hover table-sort">
			<tbody>
				<tr>
					<td style="text-align:center;">作者：administrator1 &nbsp;&nbsp;&nbsp;&nbsp;
					创建时间：<fmt:formatDate value="${article.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				</tr>
				<tr>
					<td colspan="2">文章摘要:&nbsp;&nbsp;${article.description }</td>
				</tr>
				<tr>
					<td colspan="2">文章内容:</td>
				</tr>
				<tr>
					<td colspan="2" style="background:#F0F0F0;">
						${content.content }
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
	<!-- 正文 -->
	<div class="page-container">
		<p>文章正文</p>
	</div>

	<!--文章评论-->
	<div class="ml-40"></div>
	
	<!-- footer -->
	<script type="text/javascript"
		src="<%=path%>/resources/lib/jquery/1.9.1/jquery.min.js"></script>
</body>
</html>
