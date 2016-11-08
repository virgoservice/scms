/**
 * @Author:张瑞
 * @DateTime:2016-10-19
 * @Description:添加，删除，查看，授权，停/启用等操作的脚本信息
 * @Version:1.0.0
 */
$(function(){	
	function showMenu() {
		$("#mytree").width($(this).width()+30);
		var channelObj = $("#channelName");
		var channelOffset = $("#channelName").offset();
		$("#menuContent").css({
			left : channelOffset.left + "px",
			top : channelOffset.top + channelObj.outerHeight() + "px"
		}).slideDown("fast");

		$("body").bind("mousedown", onBodyDown);
	}
	
	function hideMenu() {
		$("#menuContent").fadeOut("fast");
		$("body").unbind("mousedown", onBodyDown);
	}
	
	function onBodyDown(event) {
		if (!(event.target.id == "menuContent" || $(event.target).parents(
				"#menuContent").length > 0)) {
			hideMenu();
		}
	}

	var tree = null;
	tree = $("#mytree").mytree({
		async: {
			enable: true,
			type:"GET",
			//如果请求到的值是null, 应该如何提示 代表当前路径：$("#ctx")
			url: "/scms/article/ajaxchannel"
		},
		callback:{
			onAsyncSuccess:function(){
				tree.expandAll(true);
			},
			onDblClick: function beforeonClick(event, treeId, treeNode) {
				$("#channelName").val(treeNode.title);
				$("#channelId").val(treeNode.id);
				hideMenu();
			},
			beforeClick:function beforeClick(treeId, treeNode) {
				var check = (treeNode && !treeNode.isParent);
				if (!check) alert("不能选择根节点...");
				return check;								
			}
		}
	}); 
	$("#channelName").click(showMenu);
	
});
