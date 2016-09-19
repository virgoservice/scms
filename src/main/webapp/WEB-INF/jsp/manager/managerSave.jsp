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
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<!--/meta 作为公共模版分离出去-->

<title>添加管理员 - 管理员管理 - H-ui.admin v2.4</title>
<meta name="keywords" content="H-ui.admin v2.3,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description" content="H-ui.admin v2.3，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
<article class="page-container">
	<sf:form action="./managerSave"  modelAttribute="manager" class="form form-horizontal" id="form-admin-add">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>管理员名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<sf:input path="managerName" type="text" class="input-text" placeholder="请输入管理员名称" id="managerName" name="managerName" />
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>管理员姓名：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<sf:input path="managerNickname" type="text" class="input-text" placeholder="请输入管理员姓名" id="managerNickname" name="managerNickname" />
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>初始密码：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<sf:input path="password" type="password" class="input-text" autocomplete="off" value="" placeholder="管理员密码" id="password" name="password"/>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>确认密码：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="password" class="input-text" autocomplete="off"  placeholder="确认新密码" id="password2" name="password2">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>管理员状态：</label>
			<div class="formControls col-xs-8 col-sm-9 skin-minimal">
				<div class="radio-box">
					<sf:radiobutton path="status" value="1"/>
					<label for="sex-1">启用</label>
				</div>
				<div class="radio-box">
					<sf:radiobutton path="status" value="0" />
					<label for="sex-2">停用</label>
				</div>
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
			</div>
		</div>
	</sf:form>
</article>

<!--_footer 作为公共模版分离出去--> 
<script type="text/javascript" src="http://lib.h-ui.net/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="http://lib.h-ui.net/layer/2.1/layer.js"></script> 
<script type="text/javascript" src="http://lib.h-ui.net/icheck/jquery.icheck.min.js"></script> 
<script type="text/javascript" src="http://lib.h-ui.net/jquery.validation/1.14.0/jquery.validate.min.js"></script> 
<script type="text/javascript" src="http://lib.h-ui.net/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="http://lib.h-ui.net/jquery.validation/1.14.0/messages_zh.min.js"></script>
<script type="text/javascript" src="<%=path %>/resources/lib/jquery.validation/1.14.0/jquery-form.js"></script>  
<script type="text/javascript" src="<%=path %>/resources/static/h-ui/js/H-ui.js"></script> 
<script type="text/javascript" src="<%=path %>/resources/static/h-ui.admin/js/H-ui.admin.js"></script> 
<script type="text/javascript" src="<%=path %>/resources/defaultScript/com.seelecloud.scms.managerSave.js"></script> 

<!--/_footer /作为公共模版分离出去--> 

<!--请在下方写此页面业务相关的脚本--> 
<script type="text/javascript">

</script> 
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>
