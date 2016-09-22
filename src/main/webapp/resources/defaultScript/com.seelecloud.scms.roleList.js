/**
 * @Author:vabo
 * @DateTime:2016-09-19
 * @Description:管理员管理role的jQuery脚本信息，包括role的add,edit,delete
 * @Version:1.0.0
 */
/*
 * 参数解释： title 标题 url 请求的url id 需要操作的数据id w 弹出层宽度（缺省调默认值） h 弹出层高度（缺省调默认值）
 */
/* 管理员-角色-添加 */
function admin_role_add(title, url, w, h) {
	layer_show(title, url, w, h);
}

/* 管理员-角色-编辑 */
function admin_role_edit(title, url, id, w, h) {
	layer_show(title, url, w, h);
}

/* 管理员-角色-删除 */
function admin_role_del(obj, url) {
	layer.confirm('角色删除须谨慎，确认要删除吗？', function(index) {
		// 此处请求后台程序，下方是成功后的前台处理……

		$(obj).parents("tr").remove();
		$.post(url, null, null);
//		parent.location.reload();
		layer.msg('已删除!', {
			icon : 1,
			time : 1000
		});
	});
}
