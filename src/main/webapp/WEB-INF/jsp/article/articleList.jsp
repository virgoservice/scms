<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
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
<title>文章管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 内容管理 <span class="c-gray en">&gt;</span> 文章列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="text-c"> 
	日期范围：
		<input type="text" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'logmax\')||\'%y-%M-%d\'}'})" id="logmin" class="input-text Wdate" style="width:120px;"/>
		-
		<input type="text" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'logmin\')}',maxDate:'%y-%M-%d'})" id="logmax" class="input-text Wdate" style="width:120px;"/>
		<input type="text" name="" id="" placeholder=" 文章名称" style="width:250px" class="input-text"/>
		<span class="select-box inline">
			<select name="" class="select">
				<option value="0">选择栏目</option>
			    <c:forEach items="${publishChannel }" var="c">
			    	<c:if test="${c.id eq cid }">
						<option value="${c.id }" selected="selected">${c.title }</option>
					</c:if>
					<c:if test="${c.id ne cid }">
						<option value="${c.id }">${c.title }</option>
					</c:if>
				</c:forEach>
			</select>
		</span>
		<button name="" id="" class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜索文章</button>
	</div>
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l">
	<a href="javascript:;" onclick="datadelTest()" class="btn btn-danger radius">
			<i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a>
		<a href="javascript:;" onclick="article_add('添加文章','<%=path%>/article/articleSave','900','700')" class="btn btn-primary radius">
			<i class="Hui-iconfont">&#xe600;</i> 添加文章</a> 
			<a href="<%=path%>/article/publicationArticleList"  data-title="已发布文章" class="btn btn-success radius">
			<i class="Hui-iconfont">&#xe676;</i> 已发布文章</a> 
			<a href="<%=path%>/article/unpublicationArticleList"  data-title="未发布文章" class="btn btn-danger radius">
			<i class="Hui-iconfont">&#xe706;</i> 未发布文章</a></span> 
			<span class="r">共有数据：<strong>54</strong> 条</span> </div>
			<span style="position:relative;top:10px;left:10px;">显示
			<select name="" style="width:50px;" class="select">
				<option value="10">10</option>
				<option value="25">25</option>
				<option value="50">50</option>
			</select>
			条</span>
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort">
			<thead>
				<tr class="text-c">
					<th width="120">文章标题</th>
					<th width="70">创建者</th>	
					<th width="110">创建时间</th>
					<th width="70">发布者</th>	
					<th width="110">发布时间</th>	
					<th width="80">发布状态</th>
					<th width="80">所属栏目</th>
					<th width="50">是否推荐</th>	
					<th width="50">操作</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${articleVos }" var="a">
				<tr class="text-c" >
					<td class="text-l">
					<a href="javascript:;" onclick="article_add('文章查看','<%=path%>/article/articleShow/${a.id }','900','700')" style="cursor:pointer;position:relative;left:18%" class="text-primary" title="查看">
						<IMG alt="" src="<%=path %>/resources/img/1.jpg" style="width:100px;height:100px;" /> ${a.title }
					</a>
					</td>
					<td>${a.publisher }</td>
					<%-- <td><fmt:formatDate value="${a.createTime }" pattern="yyyy-MM-dd"/> </td> --%>
					<td><fmt:formatDate value="${a.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
					<c:if test="${a.status eq 1}">
						<td>${a.publisher }</td>
						<td><fmt:formatDate value="${a.publishTime }" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
						<td class="td-status"><span class="label label-success radius">已发布</span></td>
					</c:if>
					<c:if test="${a.status eq 0}">
						<td>待定</td>
						<td>待定</td>
						<td class="td-status"><span class="label label-danger radius">未发布</span></td>
					</c:if>
					<td>${a.channelName }</td>
					<td>
						<c:if test="${a.recommend eq false }">不推荐</c:if>
						<c:if test="${a.recommend eq true }">推荐</c:if>
					</td>					
					<td class="f-14 td-manage"> 
					<a style="text-decoration:none" class="ml-5" onClick="article_edit('资讯编辑','<%=path%>/article/articleUpdate/${a.id }','900','700')" href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a> 
					<a style="text-decoration:none" class="ml-5" onClick="article_del(this,'10001')" href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
				</tr>
			</c:forEach>	
			</tbody>
		</table>
	</div>
</div>
<script type="text/javascript" src="<%=path %>/resources/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="<%=path %>/resources/lib/layer/2.1/layer.js"></script> 
<script type="text/javascript" src="<%=path %>/resources/lib/icheck/jquery.icheck.min.js"></script> 
<script type="text/javascript" src="<%=path %>/resources/lib/jquery.validation/1.14.0/jquery.validate.min.js"></script> 
<script type="text/javascript" src="<%=path %>/resources/lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="<%=path %>/resources/lib/jquery.validation/1.14.0/messages_zh.min.js"></script> 
<script type="text/javascript" src="<%=path %>/resources/lib/My97DatePicker/WdatePicker.js"></script> 
<script type="text/javascript" src="<%=path %>/resources/static/h-ui/js/H-ui.js"></script> 
<script type="text/javascript" src="<%=path %>/resources/static/h-ui.admin/js/H-ui.admin.js"></script> 
<script type="text/javascript" src="<%=path %>/resources/defaultScript/com.seelecloud.scms.articleList.js"></script>
</body>
</html>