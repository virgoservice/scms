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
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<script type="text/javascript" src="lib/PIE_IE678.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="<%=path %>/resources/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="<%=path %>/resources/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="<%=path %>/resources/lib/Hui-iconfont/1.0.7/iconfont.css" />
<link rel="stylesheet" type="text/css" href="<%=path %>/resources/lib/icheck/icheck.css" />
<link rel="stylesheet" type="text/css" href="<%=path %>/resources/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="<%=path %>/resources/static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>栏目管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 系统管理 <span class="c-gray en">&gt;</span> 栏目管理 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="text-c">
		<input type="text" name="" id="" placeholder="栏目名称、id" style="width:250px" class="input-text">
		<button name="" id="" class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜索</button>
	</div>
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l">
	<a class="btn btn-primary radius"  href="javascript:;" onclick="system_category_add('添加栏目','<%=path%>/admin/content/channelSave')"><i class="Hui-iconfont">&#xe600;</i> 添加栏目</a></span> <span class="r">共有数据：<strong>54</strong> 条</span> </div>
	<div class="mt-20">
		<table class="table table-border table-bordered table-hover table-bg table-sort">
			<thead>
				<tr class="text-c">
					<th width="60">栏目标题</th>	
					<th width="60">栏目分类</th>
					<th width="60">栏目名称</th>
					<th width="60">栏目推荐</th>
					<th width="60">发布状态</th>
					<th width="80">操作</th>
				</tr>
			</thead>
			<tbody>
				<tr class="text-c">
					<td>1</td>
					<td>1</td>
					<td>1</td>
					<td>1</td>
					<td class="text-l">一级栏目</td>
					<td class="f-14"><a title="编辑" href="javascript:;" onclick="system_category_edit('栏目编辑','system-category-add.html','1','700','480')" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a> <a title="删除" href="javascript:;" onclick="article_category_del(this,'1')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
				</tr>
				<tr class="text-c">
					<td>1</td>
					<td>1</td>
					<td>1</td>
					<td>1</td>
					<td class="text-l">&nbsp;&nbsp;├&nbsp;二级栏目</td>
					<td class="f-14"><a title="编辑" href="javascript:;" onclick="system_category_edit('栏目编辑','system-category-add.html','2','700','480')" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a> <a title="删除" href="javascript:;" onclick="article_category_del(this,'2')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
				</tr>
				<tr class="text-c">
					<td>1</td>
					<td>1</td>
					<td>1</td>
					<td>1</td>
					<td class="text-l">&nbsp;&nbsp;├&nbsp;二级栏目</td>
					<td class="f-14"><a title="编辑" href="javascript:;" onclick="system_category_edit('栏目编辑','system-category-add.html','3','700','480')" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a> <a title="删除" href="javascript:;" onclick="system-category_del(this,'3')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<script type="text/javascript" src="<%=path %>/resources/lib/jquery/1.9.1/jquery.min.js"></script>  
<script type="text/javascript" src="<%=path %>/resources/lib/layer/2.1/layer.js"></script> 
<script type="text/javascript" src="<%=path %>/resources/lib/laypage/1.2/laypage.js"></script> 
<script type="text/javascript" src="<%=path %>/resources/lib/My97DatePicker/WdatePicker.js"></script> 
<script type="text/javascript" src="<%=path %>/resources/static/h-ui/js/H-ui.js"></script> 
<script type="text/javascript" src="<%=path %>/resources/static/h-ui.admin/js/H-ui.admin.js"></script> 
<script type="text/javascript" src="<%=path %>/resources/defaultScript/com.seelecloud.scms.plugin.pager.js"></script>
<script type="text/javascript" src="<%=path %>/resources/defaultScript/com.seelecloud.scms.channel.js"></script>

</body>
</html>