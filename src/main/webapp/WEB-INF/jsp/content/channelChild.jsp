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
<link rel="stylesheet" type="text/css" href="<%=path %>/resources/defaultCss/com.seelecloud.scms.channel.css" />
<link rel="stylesheet" type="text/css" href="<%=path %>/resources/lib/ztree/css/zTreeStyle.css" />
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>栏目列表</title>
</head>
<body class="pos-r">
<div style="margin-left:280px;">
	<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 栏目管理 <span class="c-gray en">&gt;</span> 栏目列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
	<div class="page-container">
		<div class="text-c">			
			<input type="text" name="" id="" placeholder=" 栏目名称,id" style="width:250px" class="input-text">
			<button name="" id="" class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜索</button>
		</div>
		<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"> 
		
		<c:choose>
		    <c:when test="${currentChannelName.parentId ge 0}">
		        <a class="btn btn-primary radius" href="#"><i class="Hui-iconfont"></i> 当前栏目:  ${currentChannelName.title } </a>
		    </c:when>
		    <c:otherwise>
		        <a class="btn btn-primary radius" href="#"><i class="Hui-iconfont"></i> 当前栏目: 网站内容管理栏目 </a>
		    </c:otherwise>
		</c:choose>
		
		<a class="btn btn-primary radius" onclick="system_channel_add('添加【 ${currentChannelName.title }】子栏目功能','<%=path%>/admin/content/channelSave/ ${currentChannelName.id }' ,'800','600')" href="javascript:;">
		<i class="Hui-iconfont">&#xe600;</i> 添加栏目</a></span> 
		<!--${currentChannelName.id} 获取当前操作的id  -->
		<span class="r">共有数据：<strong>${currentChannelName.id}</strong> 条</span> </div>
		<div class="mt-20">
			<table class="table table-border table-bordered table-bg table-hover table-sort">
				<thead>
					<tr class="text-c">
						<th width="60">栏目名称 </th>	
						<th width="60">栏目类型</th>
						<th width="60">栏目点击量</th>
						<th width="60">栏目顺序</th>
						<th width="60">是否推荐</th>
						<th width="60">栏目状态</th>
						<th width="40">操作</th>
					</tr>
				</thead>
				<tbody>
				  <c:forEach items="${channels }" var="c">
					<tr class="text-c va-m">						
						<td>${c.name }</td>
						<td>${c.title}</td>
						<td>${c.hint }</td>
						<td>${c.channelOrder }</td>
						<td>${c.recommend }</td>
						<c:if test="${c.status eq 1}">
							<td class="td-status"><span class="label label-success radius">启用</span></td>
							<td class="f-14"><a title="编辑" href="javascript:;" onclick="system_channel_edit('编辑【 ${currentChannelName.title }】子栏目功能','<%=path%>/admin/content/channelUpdate/ ${c.id }' ,'800','600')" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a></td>
						</c:if>
						<c:if test="${c.status eq 0}">
							<td class="td-status"><span class="label label-danger radius">停止</span></td>
							<td class="f-14"><a title="编辑" href="javascript:;" onclick="system_channel_edit('编辑【 ${currentChannelName.title }】子栏目功能','<%=path%>/admin/content/channelUpdate/ ${c.id }' ,'800','600')" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a></td>
						</c:if>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
<script type="text/javascript" src="<%=path %>/resources/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="<%=path %>/resources/lib/layer/2.1/layer.js"></script>
<script type="text/javascript" src="<%=path %>/resources/lib/My97DatePicker/WdatePicker.js"></script> 
<script type="text/javascript" src="<%=path %>/resources/static/h-ui/js/H-ui.js"></script> 
<script type="text/javascript" src="<%=path %>/resources/static/h-ui.admin/js/H-ui.admin.js"></script> 
<script type="text/javascript" src="<%=path %>/resources/defaultScript/com.seelecloud.scms.plugin.pager.js"></script>
<script type="text/javascript" src="<%=path %>/resources/lib/ztree/js/jquery.ztree.core.min.js"></script>
<script type="text/javascript" src="<%=path %>/resources/defaultScript/com.seelecloud.scms.channel.js"></script>
</body>
</html>