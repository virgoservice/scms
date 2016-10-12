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
				type:"GET",
				url: $("#ctx").val()+"/admin/role/roleModuleEditData/",
			},
			
//		callback: {
//			onAsyncSuccess: zTreeOnAsyncSuccess
//		},
			
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
	zTreeObj.setting.view.expandSpeed = "";
	zTreeObj.expandAll(true);// there is invalid TODO
	zTreeObj.setting.view.expandSpeed = "fast";
});

function submit_tree_edit()
{
	//读取节点选中状态，发送到服务器
}
