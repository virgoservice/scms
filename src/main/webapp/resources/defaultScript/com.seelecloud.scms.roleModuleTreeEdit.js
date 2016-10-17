/**
 * @Author:vabo
 * @DateTime:2016-09-29
 * @Description:
 * @Version:1.0.0
 */

var zNodes;
var zTreeObj;

$(document).ready(function() {
	
	var setting = {
			view: {
				showIcon: false,
				showLine: true
			},
			
			async: {
				enable: true,
				type:"GET",
				url: $("#ctx").val()+"/admin/role/roleModuleEditData/" + $("#roleId").val(),
			},
			
			callback: {
				onAsyncSuccess: zTreeOnAsyncSuccess
			},
			
			check: {
				enable: true,
				nocheckInherit: true,
				chkStyle:"checkbox",
				chkboxType:{"Y":"ps", "N":"ps"}
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
	zTreeObj.expandAll(true);	
}

function submit_tree_edit()
{
	//读取节点选中状态，发送到服务器
	var url = $("#ctx").val() + "/admin/role/ajaxSendRoleModuleEdit";
	var roleId = $("#roleId").val();
	var array = new Array();
	var nodes = zTreeObj.getChangeCheckedNodes();
	for(var i=0; i<nodes.length; i++)
		array.push(nodes[i].id);
	
	$.ajax({
		 type:"POST",
		 url: url,
		 async: false,
		 data:{
			 "roleId": roleId,
			 "moduleIds": array
			 },
		 success:function(data){
			 alert("edit module success");
			 }
		 });
	
	var index = parent.layer.getFrameIndex(window.name);
	parent.location.reload();
	parent.layer.close(index);
}

function cancel_edit()
{
	var index = parent.layer.getFrameIndex(window.name);
	parent.layer.close(index);
}


