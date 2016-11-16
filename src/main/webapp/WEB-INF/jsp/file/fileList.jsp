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
<title>文件管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>内容管理 <span class="c-gray en">&gt;</span>文件管理 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="cl pd-5 bg-1 bk-gray"> <span class="l"> <a href="javascript:;" onclick="fileUpload('file upload', '<%=path%>/files/fileSave',600,500)" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量管理</a> <a class="btn btn-primary radius" href="javascript:;" onclick=""><i class="Hui-iconfont">&#xe600;</i>上传文件</a> </span> <span class="r">共有文件：<strong>${totalSize}</strong>个</span> </div>
	<table class="table table-border table-bordered table-hover table-bg">
		<thead>
			<tr>
				<th scope="col" colspan="6">文件管理</th>
			</tr>
			<tr class="text-c">
				<th width="25"><input type="checkbox" value="" name=""></th>
				<!-- <th width="40">ID</th> -->
				<th width="250">文件名</th>
				<th width="250">文件大小</th>
				<th width="250">修改日期</th>
				<th >文件描述</th>
				<th width="250">操作</th>
			</tr>
		</thead>
		<tbody id="tal">
 				<tr class="text-c">
					<td><input type="checkbox" value="" name=""></td>
					<!-- <td>fileId</td> -->
					<td><i class="Hui-iconfont Hui-iconfont-picture"></i> fileTitle</td>
					<td>size</td>
					<td>2014-6-11 11:11:42</td>
					<td>file description</td>
					<td class="f-14">
						<!-- 在这里显示操作方法 -->
						<a title="edit" id="" href="javascript:;" onclick="" style="text-decoration:none">
							<i class="Hui-iconfont">&#xe6df;</i></a>
						<a title="del" id="" href="javascript:;" onclick="" style="text-decoration:none">
							<i class="Hui-iconfont">&#xe6e2;</i></a>
						<a title="download" id="" href="javascript:;" onclick="" style="text-decoration:none">
							<i class="Hui-iconfont">&#xe640;</i></a>
						<a title="shared" id="" href="javascript:;" onclick="" style="text-decoration:none">
							<i class="Hui-iconfont">&#xe6aa;</i></a>
					</td>
				</tr>
 				<tr class="text-c">
					<td><input type="checkbox" value="" name=""></td>
					<!-- <td>fileId</td> -->
					<td><i class="Hui-iconfont Hui-iconfont-file"></i> fileTitle</td>
					<td>size</td>
					<td>2014-6-11 11:11:42</td>
					<td>file description</td>
					<td class="f-14">
						<!-- 在这里显示操作方法 -->
						<a title="edit" id="" href="javascript:;" onclick="" style="text-decoration:none">
							<i class="Hui-iconfont">&#xe6df;</i></a>
						<a title="del" id="" href="javascript:;" onclick="" style="text-decoration:none">
							<i class="Hui-iconfont">&#xe6e2;</i></a>
						<a title="download" id="" href="javascript:;" onclick="" style="text-decoration:none">
							<i class="Hui-iconfont">&#xe640;</i></a>
						<a title="shared" id="" href="javascript:;" onclick="" style="text-decoration:none">
							<i class="Hui-iconfont">&#xe6aa;</i></a>
					</td>
				</tr>
		</tbody>
	</table>
	
</div>
<script type="text/javascript" src="<%=path %>/resources/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=path %>/resources/lib/layer/2.1/layer.js"></script>
<script type="text/javascript" src="<%=path %>/resources/static/h-ui.admin/js/H-ui.admin.js"></script>
<script type="text/javascript">
	function fileUpload(title, url, w, h) {
		layer_show(title, url, w, h);
	}
</script>
</body>
</html>
