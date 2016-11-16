<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "//:"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<LINK rel="Bookmark" href="<%=path%>/resources/favicon.ico">
<LINK rel="Shortcut Icon" href="<%=path%>/resources/favicon.ico" />
<!--[if lt IE 9]>
<script type="text/javascript" src="<%=path%>/resources/lib/html5.js"></script>
<script type="text/javascript" src="<%=path%>/resources/lib/respond.min.js"></script>
<script type="text/javascript" src="<%=path%>/resources/lib/PIE_IE678.js"></script>
<![endif]-->
<%-- <link rel="stylesheet" type="text/css"
	href="<%=path%>/resources/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css"
	href="<%=path%>/resources/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css"
	href="<%=path%>/resources/static/h-ui.admin/skin/default/skin.css" />
<link rel="stylesheet" type="text/css"
	href="<%=path%>/resources/static/h-ui.admin/css/style.css" /> --%>
<link rel="stylesheet"
	href="<%=path%>/resources/lib/cropper/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=path%>/resources/lib/cropper/css/cropper.min.css" />
<link rel="stylesheet"
	href="<%=path%>/resources/lib/cropper/css/main.css" />
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<!--/meta 作为公共模版分离出去-->
<title>文件管理</title>
</head>
<body>
	<div class="page-container">
		<sf:form action="" modelAttribute="file" method="post"
			class="form form-horizontal">
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"> <span
					class="c-red"></span>文件名称：
				</label>
				<div class="formControls col-xs-8 col-sm-9">
					<sf:input path="title" type="text" class="input-text" value=""
						placeholder="" id="fileTitle" name="fileTitle" />
				</div>
			</div>

			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3">文件描述：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<sf:input path="description" type="text" class="input-text"
						value="" placeholder="" id="description" name="description" />
				</div>
			</div>

<!-- 			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3">选择文件：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<div class="uploader-thum-container">
						<div id="fileList" class="uploader-list"></div>
						<div id="filePicker">选择文件：</div>
						<button id="btn-star"
							class="btn btn-default btn-uploadstar radius ml-10">开始上传</button>
					</div>
				</div>
			</div> -->

			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3">封面图片：</label>
				<div class="" id="frontCover">
					<!-- Current avatar -->
					<div class="front-cover" title="选择图片">
						<img src="" alt="Avatar"> </img>
					</div>

					<!-- Cropping modal -->
					<div class="modal fade" id="avatar-modal" aria-hidden="true"
						aria-labelledby="avatar-modal-label" role="dialog" tabindex="-1">
						<div class="modal-dialog modal-lg">
							<div class="modal-content">
								<form class="avatar-form" action="<%=path%>/files/imgCut"
									enctype="multipart/form-data" method="post">
									<div class="modal-header">
										<button class="close" data-dismiss="modal" type="button">&times;</button>
										<h4 class="modal-title" id="avatar-modal-label">Change
											Avatar</h4>
									</div>
									<div class="modal-body">
										<div class="front-cover-body">

											<!-- Upload image and data -->
											<div class="avatar-upload">
												<input class="avatar-src" name="avatar_src" type="hidden"><input
													class="avatar-data" name="avatar_data" type="hidden"><label
													for="avatarInput">本地上传</label> <input class="avatar-input"
													id="avatarInput" name="avatar_file" type="file">
											</div>

											<!-- Crop and preview -->
											<div class="row">
												<div class="col-md-9">
													<div class="front-cover-wrapper"></div>
												</div>
											<!--<div class="col-md-3">
													<div class="avatar-preview preview-lg"></div>
													<div class="avatar-preview preview-md"></div>
													<div class="avatar-preview preview-sm"></div>
												</div> -->
											</div>

											<div class="row avatar-btns">
												<div class="col-md-9">
													<div class="btn-group">
														<button class="btn btn-primary" data-method="rotate"
															data-option="-15" type="button" title="逆旋转">-15deg</button>
													</div>
													<div class="btn-group">
														<button class="btn btn-primary" data-method="rotate"
															data-option="15" type="button" title="顺旋转">15deg</button>
													</div>
												</div>
												<div class="col-md-9">
													<button class="btn btn-primary btn-block avatar-save"
														type="submit">开始上传</button>
												</div>
											</div>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
					<!-- /.modal -->

					<!-- Loading state -->
			 		<div class="loading" aria-label="Loading" role="img" tabindex="-1"></div>
				</div>
			</div>

			<div class="row cl">
				<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
					<button type="submit" class="btn btn-success radius" id="" name="">
						<i class="icon-ok"></i>确定
					</button>
				</div>
			</div>
		</sf:form>
	</div>


	<!--_footer 作为公共模版分离出去-->
	<script type="text/javascript"
		src="<%=path%>/resources/lib/jquery/1.9.1/jquery.min.js"></script>
	<!--/_footer /作为公共模版分离出去-->
	<script src="<%=path%>/resources/lib/cropper/js/bootstrap.min.js"></script>
	<script src="<%=path%>/resources/lib/cropper/js/cropper.min.js"></script>
	<script src="<%=path%>/resources/lib/cropper/js/main.js"></script>
</body>
</html>
