<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "//:"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!--_meta 作为公共模版分离出去-->
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand"><meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
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
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]--><!--/meta 作为公共模版分离出去-->
<title>栏目设置</title>
</head>
<body>
<div class="page-container">
	<sf:form method="post" class="form form-horizontal"	id="form-category-add" modelAttribute="channel">
		<div id="tab-category" class="HuiTab">
			<div class="tabBar cl">
					<span>基本设置</span>
				</div>
			<div class="tabCon">
			
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span
						class="c-red">*</span>栏目名称：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<sf:input type="text" class="input-text" name="title" value="" placeholder="栏目名称不能为空"
							 path="title" />
				</div>
			</div>
			
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3">栏目类型：</label>
				<div class="formControls col-xs-8 col-sm-9"> <span
							class="select-box">								
					<sf:select name="" class="select" path="type">
						<sf:option value="1">导航栏目</sf:option>
						<sf:option value="2">文章列表栏目</sf:option>
						<sf:option value="3">文章内容栏目</sf:option>
						<sf:option value="4">最火栏目</sf:option>
					</sf:select>
					</span> </div>
				<div class="col-3"> </div>
			</div>
			
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span
						class="c-red">*</span>是否推荐：</label>
				<sf:radiobutton path="recommend" value="1"/>是
				<sf:radiobutton path="recommend" value="0"/>不是
			</div>
			
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-3"><span
							class="c-red">*</span>栏目状态：</label>
					<sf:radiobutton path="status" value="1"/>启用
					<sf:radiobutton path="status" value="0"/>停用
				</div>
						
			</div>
		</div>
		
		<div class="row cl">
			<div class="col-9 col-offset-3">
				<input class="btn btn-primary radius" id="sub1" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
			</div>
		</div>
		
	</sf:form>
</div>

<!--_footer 作为公共模版分离出去-->                                                 
<script type="text/javascript" src="<%=path %>/resources/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="<%=path %>/resources/lib/layer/2.1/layer.js"></script> 
<script type="text/javascript" src="<%=path %>/resources/lib/icheck/jquery.icheck.min.js"></script> 
<script type="text/javascript" src="<%=path %>/resources/lib/jquery.validation/1.14.0/jquery.validate.min.js"></script> 
<script type="text/javascript" src="<%=path %>/resources/lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="<%=path %>/resources/lib/jquery.validation/1.14.0/messages_zh.min.js"></script> 
<script type="text/javascript" src="<%=path %>/resources/static/h-ui/js/H-ui.js"></script> 
<script type="text/javascript" src="<%=path %>/resources/static/h-ui.admin/js/H-ui.admin.js"></script> 
<script type="text/javascript" src="<%=path %>/resources/lib/ztree/js/jquery.ztree.core.min.js"></script>
<script type="text/javascript" src="<%=path %>/resources/defaultScript/com.seelecloud.scms.channel.js"></script>
<script type="text/javascript" src="<%=path %>/resources/defaultScript/com.seelecloud.scms.channelSave.js"></script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>