<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>SCMC|贵州塞拉科技有限公司</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<LINK rel="Bookmark"
	href="<%=request.getContextPath()%>/resources/favicon.ico">
<LINK rel="Shortcut Icon"
	href="<%=request.getContextPath()%>/resources/favicon.ico" />
<!-- CSS -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/assets/css/reset.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/assets/css/supersized.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/assets/css/style.css" />
<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
<script src="<%=request.getContextPath()%>/resources/assets/js/html5.js"></script>
<![endif]-->
</head>
<body>
	<div class="page-container">
		<h1>SCMS</h1>
		<form action="#" method="post">
			<input type="text" name="username" class="username"	placeholder="请输入您的用户名！" />
			<input type="password" name="password" class="password" placeholder="请输入您的用户密码！" />
			<input type="Captcha" class="Captcha" name="Captcha" placeholder="请输入验证码！" />
			<button type="submit" class="submit_button">登录</button>
			<div class="error">
				<span>+</span>
			</div>
		</form>
		<br /> <br /> 贵州塞拉科技有限公司
	</div>
	
	<!-- Javascript -->
	<script
		src="<%=request.getContextPath()%>/resources/assets/js/jquery-1.8.2.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/assets/js/supersized.3.2.7.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/assets/js/supersized-init.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/assets/js/scripts.js"></script>
</body>
</html>