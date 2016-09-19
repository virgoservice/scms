/**
 * @Author:谭朝红
 * @DateTime:2016-09-19
 * @Description:管理员管理模块的jQuery脚本信息，包括管理员的添加，删除，查看，授权，停/启用等操作的脚本信息
 * @Version:1.0.0
 */
/**
 * ===============1.index.jsp部分js脚本 开始====================
 */
/*资讯-添加*/
function article_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*图片-添加*/
function picture_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*产品-添加*/
function product_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*用户-添加*/
function member_add(title,url,w,h){
	layer_show(title,url,w,h);
}

/**
 * ===============1.index.jsp部分js脚本 结束====================
 */




