/**
 * @Author:vabo
 * @DateTime:2016-10-11
 * @Description:
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
/*管理员-权限-编辑*/
function admin_permission_edit(title,url,id,w,h){
	url += id;
	layer_show(title,url,w,h);
}

/*管理员-权限-删除*/
function admin_permission_del(obj, url, id){
	layer.confirm('角色删除须谨慎，确认要删除吗？',function(index){
		url += id;
		$.post(url, null, null);
		$(obj).parents("tr").remove();
		layer.msg('已解除该权限!',{icon:1,time:1000});
	});
}
