/**
 * @Author:谭朝红
 * @DateTime:2016-09-19
 * @Description:管理员管理模块的jQuery脚本信息，包括管理员的添加，删除，查看，授权，停/启用等操作的脚本信息
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
/*管理员-增加*/
function admin_add(title,url,w,h){
layer_show(title,url,w,h);
}
/*管理员-删除*/
function admin_del(obj,id){
layer.confirm('确认要删除吗？',function(index){
	//此处请求后台程序，下方是成功后的前台处理……
	
	$(obj).parents("tr").remove();
	layer.msg('已删除!',{icon:1,time:1000});
});
}
/*管理员-编辑*/
function admin_edit(title,url,id,w,h){
layer_show(title,url,w,h);
}
/*管理员-停用*/
function admin_stop(obj,id){
layer.confirm('确认要停用吗？',function(index){
	//此处请求后台程序，下方是成功后的前台处理……
	
	$(obj).parents("tr").find(".td-manage").prepend('<a onClick="admin_start(this,id)" href="javascript:;" title="启用" style="text-decoration:none"><i class="Hui-iconfont">&#xe615;</i></a>');
	$(obj).parents("tr").find(".td-status").html('<span class="label label-default radius">已禁用</span>');
	$(obj).remove();
	layer.msg('已停用!',{icon: 5,time:1000});
});
}

/*管理员-启用*/
function admin_start(obj,id){
layer.confirm('确认要启用吗？',function(index){
	//此处请求后台程序，下方是成功后的前台处理……
	
	
	$(obj).parents("tr").find(".td-manage").prepend('<a onClick="admin_stop(this,id)" href="javascript:;" title="停用" style="text-decoration:none"><i class="Hui-iconfont">&#xe631;</i></a>');
	$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已启用</span>');
	$(obj).remove();
	layer.msg('已启用!', {icon: 6,time:1000});
});
}