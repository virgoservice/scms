/**
 * @Author:vabo
 * @DateTime:2016-09-29
 * @Description:
 * @Version:1.0.0
 */

$(document).ready(function() {
	var zNodes;
	var zTreeObj;
	
	var setting = {
			view: {
				showIcon: false,
				showLine: true
			},
			async: {
				enable: true,
				type:"POST",
				//如果请求到的值是null, 应该如何提示
				url: $("#ctx").val()+"/admin/role/roleModuleData/" + $("#roleId").val(),
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
	zTreeObj.expandAll(true);// there is invalid TODO
});

function edit_moduleTree(title, url, id)
{
	var index = parent.layer.getFrameIndex(window.name);
	//parent.location.reload();
	url += id;
	alert(url);
	layer_show(title, url, 750, 600);
	parent.layer.close(index);
}

function close_moduleTree()
{
	var index = parent.layer.getFrameIndex(window.name);
	parent.layer.close(index);
}
