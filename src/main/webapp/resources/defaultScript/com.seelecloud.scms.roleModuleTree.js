/**
 * @Author:vabo
 * @DateTime:2016-09-29
 * @Description:
 * @Version:1.0.0
 */

var zTreeObj = null;//
var zNodes = null;

$(document).ready(function() {
	var setting = {
			view: {
				showIcon: false,
				showLine: true
			},
			
			async: {
				enable: true,
				type:"GET",
				//如果请求到的值是null, 应该如何提示
				url: $("#ctx").val()+"/admin/role/roleModuleData/" + $("#roleId").val(),
			},
			
			callback: {
				onAsyncSuccess: zTreeOnAsyncSuccess
			},
			
			data: {
				simpleData: {
					enable: true,
					idKey: "id",
					pIdKey: "parentId",
					rootPId: 0
				},
				key:{
					name:"moduleName"
				}
			}
	};
	
	zTreeObj = $.fn.zTree.init($("#moduleTree"), setting, zNodes);
});

function zTreeOnAsyncSuccess()
{
	// tips no data TODO
	zTreeObj.expandAll(true);
}

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

function close_moduleTree()
{
	var index = parent.layer.getFrameIndex(window.name);
	parent.layer.close(index);
}
