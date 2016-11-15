<?xml version="1.0" encoding="UTF-8" ?>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<LINK rel="Bookmark" href="<%=path %>/resources/favicon.ico" >
<LINK rel="Shortcut Icon" href="<%=path %>/resources/favicon.ico" />
<!--[if lt IE 9]>
<script type="text/javascript" src="<%=path %>/lib/html5.js"></script>
<script type="text/javascript" src="<%=path %>/lib/respond.min.js"></script>
<script type="text/javascript" src="<%=path %>/lib/PIE_IE678.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="<%=path %>/resources/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="<%=path %>/resources/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="<%=path %>/resources/lib/Hui-iconfont/1.0.7/iconfont.css" />
<link rel="stylesheet" type="text/css" href="<%=path %>/resources/lib/icheck/icheck.css" />
<link rel="stylesheet" type="text/css" href="<%=path %>/resources/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="<%=path %>/resources/static/h-ui.admin/css/style.css" />
<link rel="stylesheet" type="text/css" href="<%=path %>/resources/lib/ztree/css/zTreeStyle.css" />
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<!--/meta 作为公共模版分离出去-->

<title>新增文章 </title>
</head>
<body>
<article class="page-container">
<div id="menuContent" class="menuContent" style="display:none; position: absolute;background:#eee;z-index:999;border:1px solid #999">
	<ul id="mytree" class="ztree" style="margin-top:0;overflow: auto;"></ul>
</div>
	<sf:form method="post" modelAttribute="articleVo" class="form form-horizontal" id="form-article-add">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>文章标题：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<sf:input path="title" class="input-text" placeholder="请输入文章标题"/>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">简略标题：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<sf:input path="subtitle" class="input-text" placeholder="可不填写" />
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>分类栏目：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" readonly  placeholder="请选择一个文章栏目" value=${articleVo.channelName }  name="channelName" id="channelName" style="cursor:pointer;height:26px;font-size:13.3px;padding-left:8px;"/>
				<input type="hidden" id="channelId" name="channelId" value="0" /> <!-- 到时候传递栏目id给文章 -->
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">文章摘要：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<sf:textarea path="description" cols="" rows="" class="textarea"  placeholder="说点什么...最少输入10个字符" datatype="*10-100" dragonfly="true" nullmsg="备注不能为空！" onKeyUp="textarealength(this,200)"/>
				<p class="textarea-numberbar"><em class="textarea-length">0</em>/200</p>
			</div>
		</div>
		<%-- <div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">文章创建者：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<sf:input path="publisher" class="input-text" placeholder="请输入文章发布者"/>
			</div>
		</div>
		 --%>
		 <%-- <div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">文章创建日期：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<sf:input path="createTime" onfocus="WdatePicker({isShowWeek:true})" id="datemin" class="input-text Wdate"/>
			</div>
		</div> --%>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">文章来源：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<sf:input path="source" class="input-text"/>
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">缩略图：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<div class="uploader-thum-container">
					<div id="fileList" class="uploader-list"></div>
					<div id="filePicker">选择图片</div><br>
					<button id="btn-star" class="btn btn-default btn-uploadstar radius ml-10">开始上传</button>
				</div>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">文章内容：</label>
			<div class="formControls col-xs-8 col-sm-9"> 
			<!-- 	<script id="editor" type="text/plain" style="width:100%;height:400px;"></script>  -->
				<sf:textarea path="content" id="editor" type="text/plain" style="width:100%;height:400px;"/>
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 保存并提交审核</button>
				<button onClick="article_save();" class="btn btn-secondary radius" type="button"><i class="Hui-iconfont">&#xe632;</i> 保存草稿</button>
				<button onClick="removeIframe();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
			</div>
		</div>
	</sf:form>
</article>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="<%=path %>/resources/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="<%=path %>/resources/lib/layer/2.1/layer.js"></script> 
<script type="text/javascript" src="<%=path %>/resources/lib/icheck/jquery.icheck.min.js"></script> 
<script type="text/javascript" src="<%=path %>/resources/lib/jquery.validation/1.14.0/jquery.validate.min.js"></script> 
<script type="text/javascript" src="<%=path %>/resources/lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="<%=path %>/resources/lib/jquery.validation/1.14.0/messages_zh.min.js"></script> 
<script type="text/javascript" src="<%=path %>/resources/static/h-ui/js/H-ui.js"></script> 
<script type="text/javascript" src="<%=path %>/resources/static/h-ui.admin/js/H-ui.admin.js"></script> 
<!--/_footer /作为公共模版分离出去-->
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="<%=path %>/resources/lib/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=path %>/resources/lib/ueditor/1.4.3.3/third-party/webuploader/webuploader.min.js"></script> 
<script type="text/javascript" src="<%=path %>/resources/lib/ueditor/1.4.3.3/ueditor.config.min.js"></script> 
<script type="text/javascript" src="<%=path %>/resources/lib/ueditor/1.4.3.3/ueditor.all.min.js"> </script> 
<script type="text/javascript" src="<%=path %>/resources/lib/ueditor/1.4.3.3/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript" src="<%=path %>/resources/lib/ztree/js/jquery.ztree.core.min.js"></script>
<script type="text/javascript" src="<%=path %>/resources/defaultScript/com.seelecloud.scms.channel.js"></script>
<script type="text/javascript" src="<%=path %>/resources/defaultScript/com.seelecloud.scms.articleSave.js"></script>
<script type="text/javascript" src="<%=path %>/resources/defaultScript/com.seelecloud.scms.articleUpdate.js"></script>
</body>
</html>