/**
 * @Author:张瑞：修改
 * @DateTime:2016-10-19
 * @Description:添加，删除，查看，授权，停/启用等操作的脚本信息
 * @Version:1.0.0
 */
/*
 * 参数解释： title 标题 url 请求的url id 需要操作的数据id w 弹出层宽度（缺省调默认值） h 弹出层高度（缺省调默认值）
 */
/* 系统-栏目-添加 */
function system_category_add(title, url, w, h) {
	layer_show(title, url, w, h);
}
/* 系统-栏目-编辑 */
function system_category_edit(title, url, id, w, h) {
	layer_show(title, url, w, h);
}
/* 系统-栏目-删除 */
function system_category_del(obj, id) {
	layer.confirm('确认要删除吗？', function(index) {
		$(obj).parents("tr").remove();
		layer.msg('已删除!', {
			icon : 1,
			time : 1000
		});
	});
}

/*树*/
var zTreeObj = null;//
var zNodes = null;

$(document).ready(function() {
	var setting = {
			view: {
				selectedMulti: false,
				dblClickExpand:true
			},
			
			async: {
				enable: true,
				type:"GET",
				//如果请求到的值是null, 应该如何提示 代表当前路径：$("#ctx")
				url: $("#ctx").val()+"/admin/content/ajaxchannel",
			},
			
			callback: {
				onAsyncSuccess: zTreeOnAsyncSuccess,
				onClick:channel_child,
			},
			
			data: {
				simpleData: {
					enable: true,
					idKey: "id",
					pIdKey: "parentId",
					rootPId: -1,
				},
				key:{
					name:"title"
				}
			}
	};
	
	zTreeObj = $.fn.zTree.init($("#channelTree"), setting, zNodes);
});

/**
 * 回调函数
 */
function zTreeOnAsyncSuccess()
{
	// tips no data TODO
	zTreeObj.expandAll(false);
}

/**
 * 点击任意栏目，列出他的所有子栏目
 */
function channel_child(event,treeId,treeNode){
	$("#cc").attr("src", $("#ctx").val()+"/admin/content/channel/"+treeNode.id);
}

/**
 * 编辑树
 * @param title
 * @param url
 * @param id
 * @param w
 * @param h
 */
function edit_moduleTree(title, url, id, w, h)
{
	url = $("#ctx").val() + url + id;
	layer.open({
		type: 2,
		area: [w+'px', h +'px'],
		fix: false,
		maxmin: true,
		shade:0.4,
		title: title,
		content: url
	});
}

/**
 * 关闭树
 */
function close_moduleTree()
{
	var index = parent.layer.getFrameIndex(window.name);
	parent.layer.close(index);
}