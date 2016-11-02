/**
 * @Author:vabo
 * @DateTime:2016-10-28
 * @Description: comment list, add, delete, agree, report, reply
 * @Version:1.0.0
 */
/*
 * 参数解释： title 标题 url 请求的url id 需要操作的数据id w 弹出层宽度（缺省调默认值） h 弹出层高度（缺省调默认值）
 */

/*
 * 发表评论 如果没有登录弹出登录窗口, 或者允许匿名评论
 */
function comment_add(url, contentId, type) {
	$.post(url, {
		contentId : contentId,
		type : type,
		text : $("commentText").val()
	}, function() {
		location.reload();
	});
}

/*
 * 点赞, 是否允许匿名点赞
 */
function comment_agree(url, id) {
	$.post(url, {
		id : id
	}, function() {
		location.reload();
	});
}

/*
 * 删除一条评论, 作者/文章发布者/管理员
 */
function comment_del(obj, id) {
	layer.confirm('确认要删除吗？', function(index) {
		$(obj).parents("tr").remove();
		layer.msg('已删除!', 1);
	});
}

/*
 * 记名举报, 匿名举报
 */
function comment_report(obj, id) {

}

/*
 * 添加一条回复记录
 */
function comment_reply(obj, id) {

}

/* 页面加载完成之后，加载第一页数据 */
//$(document).ready(function() {
//
//	$.getJSON('', {
//		page : curr || 1
//	// 向服务端传的参数，此处只是演示
//	}, function(res) {
//		// 此处仅仅是为了演示变化的内容
//		var demoContent = (new Date().getTime() / Math.random() / 1000) | 0;
//		document.getElementById('view1').innerHTML = res.content + demoContent;
//		// 显示分页
//
//		laypage({
//			cont : 'page8', // 容器。值支持id名、原生dom对象，jquery对象,
//			pages : 7, // 总页数
//			groups : 0, // 连续分数数0
//			prev : false, // 不显示上一页
//			next : '查看更多',
//			skin : 'flow', // 设置信息流模式的样式
//			jump : function(obj) {
//				if (obj.curr === 6) {
//					this.next = '没有更多了';
//				}
//				$('#view8').append(appendimg(obj.curr));
//			}
//		});
//	});
//});
