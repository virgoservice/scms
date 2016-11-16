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
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<script type="text/javascript" src="lib/PIE_IE678.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css"
	href="<%=path%>/resources/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css"
	href="<%=path%>/resources/lib/Hui-iconfont/1.0.7/iconfont.css" />
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>文章评论</title>
</head>
<body>
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>栏目
		<span class="c-gray en">&gt;</span>正文<a
			class="btn btn-success radius r"
			style="line-height: 1.6em; margin-top: 3px"
			href="javascript:location.replace(location.href);" title="刷新"><i
			class="Hui-iconfont">&#xe68f;</i></a>
	</nav>

	<div class="page-container">
		<p>文章正文</p>
	</div>

	<!--文章评论-->
	<div class="ml-40">
		<div class="f-24">
			文章评论 <span>${total}条</span>
		</div>
		<!-- add comment -->
		<div class="commentList">
			<div class="cavatar">
				<a href="#"> <i class="avatar size-L radius"> <img alt=""
						src="<%=path%>/resources/static/h-ui/images/ucnter/avatar-default.jpg"></i></a>
			</div>
			<div class="comment-main">
				<textarea id="commentText" class="input-text size-XL" placeholder="写下你的评论..."></textarea>
				<button type="button" id="publish_comment"
					class="btn btn-secondary radius" onclick="comment_add('<%=path%>/comment/ajaxCommentSave', 1, 1)">发表评论</button>
			</div>
		</div>
		<div>
			<ul id="clist" class="commentList">
				<c:forEach items="${commentList}" var="comment">
					<li class="item clearfix">
						<div class="cavatar">
							<a href="#"> <i class="avatar size-L radius"> <img alt=""
									src="<%=path%>/resources/static/h-ui/images/ucnter/avatar-default.jpg"></i></a>
						</div>
						<div class="comment-main">
							<div class="comment-header">
								<div class="comment-meta">
									<a class="comment-author" href="javascript:;" target="_blank">${comment.userNickName}</a>
									<fmt:formatDate value="${comment.createTime}"
										pattern="yyyy-MM-dd hh:mm:ss" />
								</div>
							</div>

							<div class="comment-body">
								<p>${comment.text}</p>
							</div>

							<div class="comment-main:before">
								<a title="点赞" class="" href="javascript:;" onclick="comment_agree('<%=path%>/comment/ajaxCommentAgree', ${comment.id})"> <i
									class="Hui-iconfont">&#xe697;</i> <span class="f-12 c-666">赞(${comment.agree})</span>
								</a> <a title="回复" class="" href="javascript:;"> <i
									class="Hui-iconfont">&#xe622;</i> <span class="f-12 c-666">回复(${comment.replyCount})</span>
								</a> <a title="举报" class="" href="javascript:;"> <i
									class="Hui-iconfont">&#xe6cd;</i> <span class="f-12 c-666">举报</span>
								</a>
							</div>
						</div>
					</li>
				</c:forEach>
			</ul>
		</div>
		<a href="javascript:;">点击加载更多</a>
	</div>
<script type="text/javascript" src="<%=path %>/resources/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=path %>/resources/defaultScript/com.seelecloud.scms.comment.js"></script>
</body>
</html>
