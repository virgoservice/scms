<?xml version="1.0" encoding="UTF-8" ?>
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
<meta name="renderer" content="webkit|ie-comp|ie-stand"><m eta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<LINK rel="Bookmark" href="<%=path %>/resources/favicon.ico">
<LINK rel="Shortcut Icon" href="<%=path %>/resources/favicon.ico" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<script type="text/javascript" src="lib/PIE_IE678.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css"
	href="<%=path %>/resources/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css"
	href="<%=path %>/resources/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css"
	href="<%=path %>/resources/lib/Hui-iconfont/1.0.7/iconfont.css" />
<link rel="stylesheet" type="text/css" href="<%=path %>/resources/lib/icheck/icheck.css" />
<link rel="stylesheet" type="text/css"
	href="<%=path %>/resources/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css"
	href="<%=path %>/resources/static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]--><!--/meta 作为公共模版分离出去-->
<title>栏目设置</title>
</head>
<body>
<div class="page-container">
	<form action="" method="post" class="form form-horizontal"
			id="form-category-add">
		<div id="tab-category" class="HuiTab">
			<div class="tabBar cl">
					<span>基本设置</span>
				</div>
			<div class="tabCon">
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-3">栏目ID：</label>
					<div class="formControls col-xs-8 col-sm-9">11230</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-3"><span
							class="c-red">*</span>上级栏目：</label>
					<div class="formControls col-xs-8 col-sm-9"> <span
								class="select-box">
						<select class="select" id="sel_Sub" name="sel_Sub"
								onchange="SetSubID(this);">
							<option value="0">顶级分类</option>
							<option value="10">分类一级</option>
							<option value="101">&nbsp;&nbsp;├ 分类二级</option>
							<option value="102">&nbsp;&nbsp;├ 分类二级</option>
							<option value="20">分类一级</option>
							<option value="200">&nbsp;&nbsp;├ 分类二级</option>
						</select>
						</span> </div>
					<div class="col-3"> </div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-3"><span
							class="c-red">*</span>分类名称：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text" class="input-text" value="" placeholder=""
								id="" name="" datatype="*2-16" nullmsg="用户名不能为空">
					</div>
					<div class="col-3"> </div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-3">别名：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text" class="input-text" value="" placeholder=""
								id="" name="">
					</div>
					<div class="col-3"> </div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-3">目录：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text" class="input-text" value="" placeholder=""
								id="" name="">
					</div>
					<div class="col-3"> </div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-3">内容类型：</label>
					<div class="formControls col-xs-8 col-sm-9"> <span
								class="select-box">
						<select name="" class="select">
							<option value="1">文章</option>
							<option value="2">图片</option>
							<option value="3">商品</option>
							<option value="4">视频</option>
							<option value="5">专题</option>
							<option value="6">链接</option>
						</select>
						</span> </div>
					<div class="col-3"> </div>
				</div>
			</div>
			</div>
		</div>
		<div class="row cl">
			<div class="col-9 col-offset-3">
				<input class="btn btn-primary radius" type="submit"	value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
			</div>
		</div>
	</form>
</div>
</div>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="<%=path %>/resources/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="<%=path %>/resources/lib/layer/2.1/layer.js"></script> 
<script type="text/javascript" src="<%=path %>/resources/lib/icheck/jquery.icheck.min.js"></script> 
<script type="text/javascript"
		src="<%=path %>/resources/lib/jquery.validation/1.14.0/jquery.validate.min.js"></script> 
<script type="text/javascript"
		src="<%=path %>/resources/lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript"
		src="<%=path %>/resources/lib/jquery.validation/1.14.0/messages_zh.min.js"></script> 
<script type="text/javascript" src="<%=path %>/resources/static/h-ui/js/H-ui.js"></script> 
<script type="text/javascript" src="<%=path %>/resources/static/h-ui.admin/js/H-ui.admin.js"></script> 
<!--/_footer /作为公共模版分离出去-->
<script type="text/javascript" src="<%=path %>/resources/defaultScript/com.seelecloud.scms.channelSave.js"></script>
<script type="text/javascript" src="<%=path %>/resources/lib/ztree/js/jquery.ztree.all-3.5.min.js"></script> 
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>