/**
 * @Author:vabo
 * @DateTime:2016-09-19
 * @Description:管理员管理moudle
 * @Version:1.0.0
 */
/*
参数解释：
title	标题
url		请求的url
id		需要操作的数据id
w		弹出层宽度（缺省调默认值）
h		弹出层高度（缺省调默认值）
*/
/* 模块添加 */
function module_add(title, url, w, h) {
	layer_show(title, url, w, h);
}

/* 模块编辑 */
function module_edit(title, url, id, w, h) {
	layer_show(title, url, w, h);
}

/* 模块删除 */
function module_delete(obj, url, id) {
	layer.confirm('确认要删除吗？', function(index) {
		// 此处请求后台程序
		$.post(url, null, null);

		//成功后的前台处理
		layer_show(url,id);
		$(obj).parents("tr").remove();
		layer.msg('已删除!', {
			icon : 1,
			time : 1000
		});
	});
}

