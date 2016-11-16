<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
<link rel="stylesheet" type="text/css" href="<%=path %>/resources/lib/ueditor/1.4.3.3/third-party/webuploader/webuploader.css" />
<link rel="stylesheet" type="text/css" href="<%=path %>/resources/cropper/css/bootstraps.min.css" />
<link rel="stylesheet" type="text/css" href="<%=path %>/resources/cropper/css/cropper.min.css" />
<link rel="stylesheet" type="text/css" href="<%=path %>/resources/cropper/css/mains.css" />
<link rel="stylesheet" type="text/css" href="<%=path %>/resources/cropper/css/font-awesome.min.css" />
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
  <div class="row cl">
	<label class="form-label col-xs-4 col-sm-2" style="left:55px;">文章封面：</label>
	<div class="formControls col-xs-8 col-sm-9">
	<div class="uploader-thum-container">
		<div id="fileList" class="uploader-list"></div>
		<div id="filePicker" style="float:left;">
	<!-- start -->	
		<div class="container" id="crop-avatar">
		   <!-- Current avatar -->
		<div class="avatar-view" title="Change the avatar">
		  <img src="<%=path %>/resources/lib/cropper/img/picture.jpg" alt="Avatar" style="height:100%;">
		</div>
		<!-- Cropping modal -->
		<div class="modal fade" style="width:660px;height:490px;margin-top:-320px;margin-left:auto;margin-right:auto;" id="avatar-modal" aria-hidden="true" aria-labelledby="avatar-modal-label" role="dialog" tabindex="-1">
		  <div class=" modal-lg">
		    <div>
		      <form class="avatar-form" action="ajaxCropperImageUpload" enctype="multipart/form-data" method="post" accept="image/*">
		        <div class="modal-header">
		          <button type="button" class="close" data-dismiss="modal">&times;</button>
		          <h4 class="modal-title" id="avatar-modal-label">更改封面</h4>
		        </div>
		        <div class="modal-body">
		          <div class="avatar-body">
		            <!-- avatar_file(源文件),avatar_data(裁剪参数JSON[x,y,w,h]),avatar-src(源文件路径) -->
		            <div class="avatar-upload">
		              <input type="hidden" class="avatar-src" name="avatar_src">
		              <input type="hidden" class="avatar-data" name="avatar_data">
		              <label for="avatarInput" class="btn btn-primary" style="width:100px;">选择图片</label>
		              <input type="file" class="avatar-input" id="avatarInput" name="avatar_file" style="display: none;" accept="image/*">
		            </div>
		            <!-- Crop and preview -->
		            <div class="row">
		              <div class="col-md-6">
		                <div class="avatar-wrapper"></div>
		              </div>
		              <div class="col-md-6">
		                <div class="avatar-preview preview-lg"></div>
		                <div class="avatar-preview preview-md"></div>
		                <div class="avatar-preview preview-sm"></div>
		              </div>
		            </div>
		<!-- 操作按钮 -->
            <div class="row avatar-btns">
              <div class="col-md-6">
                 <div class="btn-group">
		         <button type="button" class="btn btn-primary" data-method="setDragMode" data-option="move" title="Move">
		           <span class="docs-tooltip" data-toggle="tooltip" title="$('#avatarInput').cropper(&quot;setDragMode&quot;, &quot;move&quot;)">
		             <span class="fa fa-arrows"></span>
		           </span>
		         </button>
		         <button type="button" class="btn btn-primary" data-method="setDragMode" data-option="crop" title="Crop">
		           <span class="docs-tooltip" data-toggle="tooltip" title="$('#avatarInput').cropper(&quot;setDragMode&quot;, &quot;crop&quot;)">
		             <span class="fa fa-crop"></span>
		           </span>
		         </button>
		       </div>
		        <div class="btn-group">
		         <button type="button" class="btn btn-primary" data-method="zoom" data-option="0.1" title="Zoom In">
		           <span class="docs-tooltip" data-toggle="tooltip" title="$('#avatarInput').cropper(&quot;zoom&quot;, 0.1)">
		             <span class="fa fa-search-plus"></span>
		           </span>
		         </button>
		         <button type="button" class="btn btn-primary" data-method="zoom" data-option="-0.1" title="Zoom Out">
		           <span class="docs-tooltip" data-toggle="tooltip" title="$('#avatarInput').cropper(&quot;zoom&quot;, -0.1)">
		             <span class="fa fa-search-minus"></span>
		           </span>
		         </button>
		       </div>
		       <div class="btn-group">
		         <button type="button" class="btn btn-primary" data-method="rotate" data-option="45" title="Rotate Right">
		           <span class="docs-tooltip" data-toggle="tooltip" title="$('#avatarInput').cropper(&quot;rotate&quot;, 45)">
		             <span class="fa fa-rotate-right"></span>
		           </span>
		         </button>
		       </div>
	              </div>
	              <div class="col-md-2">
	                <button type="submit" class="btn btn-primary btn-block avatar-save">提交</button>
	              </div>
	            </div>
	          </div>
	        </div>
	      </form>
	    </div>
		  </div>
		</div><!-- /.modal -->
		<!-- Loading state -->
		  <div class="loading" aria-label="Loading" role="img" tabindex="-1"></div>
		</div>
		<!-- end -->
			</div>
		 </div>
	  </div>
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
				<input type="text" readonly  placeholder="请选择一个文章栏目"  name="channelName" id="channelName" style="cursor:pointer;height:26px;font-size:13.3px;padding-left:8px;"/>
				<input type="hidden" id="channelId" name="channelId" value="0"  />
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">文章摘要：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<sf:textarea path="description" cols="" rows="" class="textarea"  placeholder="说点什么...最少输入10个字符" datatype="*10-100" dragonfly="true" nullmsg="备注不能为空！" onKeyUp="textarealength(this,200)"/>
				<p class="textarea-numberbar"><em class="textarea-length">0</em>/200</p>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">文章来源：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<sf:input path="source" class="input-text"/>
			</div>
		</div>
		
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">文章内容：</label>
			<div class="formControls col-xs-8 col-sm-9" style="margin-bottom:15px;"> 
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
<script type="text/javascript" src="<%=path %>/resources/cropper/js/bootstraps.min.js"></script>
<script type="text/javascript" src="<%=path %>/resources/cropper/js/cropper.min.js"></script>
<script type="text/javascript" src="<%=path %>/resources/cropper/js/mains.js"></script>
<script type="text/javascript" src="<%=path %>/resources/defaultScript/com.seelecloud.scms.channel.js"></script>
<script type="text/javascript" src="<%=path %>/resources/defaultScript/com.seelecloud.scms.articleSave.js"></script>
</body>
</html>