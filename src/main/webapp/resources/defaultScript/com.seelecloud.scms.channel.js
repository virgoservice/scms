/**
 * @Author:张瑞
 * @DateTime:2016-10-19
 * @Description:添加，删除，查看，授权，停/启用等操作的脚本信息
 * @Version:1.0.0
 */
/*
 * 参数解释： title 标题 url 请求的url id 需要操作的数据id w 弹出层宽度（缺省调默认值） h 弹出层高度（缺省调默认值）
 */
/* 系统-栏目-添加 */
function system_channel_add(title, url, w, h) {
	layer_show(title, url, w, h);
}
/* 系统-栏目-编辑 */
function system_channel_edit(title, url,w, h) {
	layer_show(title, url, w, h);
}
/* 系统-栏目-删除 */
function system_channel_del(obj, id) {
	layer.confirm('确认要删除吗？', function(index) {
		$(obj).parents("tr").remove();
		layer.msg('已删除!', {
			icon : 1,
			time : 1000
		});
	});
}

/* 插件树：传入setting原型扩展方法 */
var zTreeObj = null;//
(function($) {
	$.fn.mytree = function(opts) {
		var setting = $.extend({
				view: {
					selectedMulti: false,
					dblClickExpand:true
				},
				
				async: {
					enable: true,
					type:"GET",
					//如果请求到的值是null, 应该如何提示 代表当前路径：$("#ctx")
					url: opts?(opts.url||"ajaxchannel"):"ajaxchannel"
				},
				mine: {
					listChild:1,
					srcElement:"#listChannel"
				},
				callback: {
					onAsyncSuccess: function zTreeOnAsyncSuccess()
					{
						zTreeObj.expandAll(true);
					},
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
		},opts||{});
		var _mine = setting.mine;
		zTreeObj = $.fn.zTree.init($(this), setting);
		zTreeObj.getCheckParentNodes = getCheckParentNodes;
		zTreeObj.getCheckChildNodes = getCheckChildNodes;
		if(_mine.listChild) {
			zTreeObj.setting.callback.onClick = listChild;
		}
	
		/**
		 * 回调函数
		 */
		function zTreeOnAsyncSuccess()
		{
			// tips no data TODO
			zTreeObj.expandAll(true);
		}
	
		/**
		 * 点击任意栏目，列出他的所有子栏目
		 */
		function listChild(event,treeId,treeNode){
			$(_mine.srcElement).attr("src","channel/"+treeNode.id);
		}
	
		function getCheckParentNodes(treeNode,checked) {
			var ps = new Array();
			var pn;
			while((pn=treeNode.getParentNode())) {
				if(pn.checked==checked) ps.push(pn);
				treeNode = pn;
			}
			return ps;
		}
		
		//第三个参数存储所有子节点
		function getCheckChildNodes(treeNode,checked,cs) {
			var ccs;
			if((ccs=treeNode.children)) {
				for(var i=0;i<ccs.length;i++) {
					var c = ccs[i];
					if(c.checked==checked) {
						cs.push(c);
					}
					getCheckChildNodes(c,checked,cs);
				}
			}
		}
		
		return zTreeObj;
	};
})(jQuery);
