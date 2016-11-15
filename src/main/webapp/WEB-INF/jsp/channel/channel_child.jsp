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
<link rel="stylesheet" type="text/css" href="<%=path %>/resources/lib/ztree/css/channel.css" />
<link rel="stylesheet" type="text/css" href="<%=path %>/resources/lib/ztree/css/zTreeStyle.css" />
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>栏目列表</title>
</head>
<body class="pos-r">
<div style="margin-left:240px;">
	<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 栏目管理 <span class="c-gray en">&gt;</span> 栏目列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
	<div class="page-container">
		<div class="text-c">			
			<input type="text" name="" id="" placeholder=" 栏目名称,id" style="width:250px" class="input-text">
			<button name="" id="" class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜索</button>
		</div>
		<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"> 
		
		<c:choose>
		    <c:when test="${pc.parentId eq -1}">
		      <a class="btn btn-primary radius" href="#"><i class="Hui-iconfont"></i> 当前栏目: 网站内容管理栏目 </a>
		    </c:when>
		    <c:when test="${pc.parentId ge 0}">
		        <a class="btn btn-primary radius" href="#"><i class="Hui-iconfont"></i> 当前栏目:  ${pc.title } </a>
		    </c:when>
		    <c:otherwise>
		        <a class="btn btn-primary radius" href="#"><i class="Hui-iconfont"></i> 当前栏目: 网站内容管理栏目 </a>
		    </c:otherwise>
		</c:choose>
		
		<a class="btn btn-primary radius" onclick="system_category_add('添加栏目','<%=path%>/admin/content/channelSave','800','600')" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加栏目</a></span> 
		<span class="r">共有数据：<strong>54</strong> 条</span> </div>
		
		<!-- <span style="position:relative;top:10px;left:10px;">显示
			<select name="" style="width:50px;" class="select">
				<option value="10">10</option>
				<option value="25">25</option>
				<option value="50">50</option>
			</select>
			条</span> -->
		
		<div class="mt-20">
			<table class="table table-border table-bordered table-bg table-hover table-sort">
				<thead>
					<tr class="text-c">
						<th width="60">栏目名称 </th>	
						<th width="60">栏目类型</th>
						<th width="60">栏目点击量</th>
						<th width="60">是否推荐</th>
						<th width="60">栏目状态</th>
						<th width="80">操作</th>
					</tr>
				</thead>
				<tbody>
				  <c:forEach items="${channels }" var="c">
					<tr class="text-c va-m">
						<td>${c.title}</td>
						<td>${c.type }</td>
						<td>${c.hint }</td>
						<td>${c.recommend }</td>
						<c:if test="${c.status eq 1}">
							<td class="td-status"><span class="label label-success radius">启用</span></td>
							<td class="f-14"><a title="编辑" href="javascript:;" onclick="system_category_edit('栏目编辑','system-category-add.html','1','700','480')" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a> <a title="删除" href="javascript:;" onclick="article_category_del(this,'1')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
						</c:if>
						<c:if test="${c.status eq 0}">
							<td class="td-status"><span class="label label-danger radius">停止</span></td>
							<td class="f-14"><a title="编辑" href="javascript:;" onclick="system_category_edit('栏目编辑','system-category-add.html','1','700','480')" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a> <a title="删除" href="javascript:;" onclick="article_category_del(this,'1')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
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