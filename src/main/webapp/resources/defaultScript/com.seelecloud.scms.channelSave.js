/**
 * @Author:张瑞
 * @DateTime:2016-10-19
 * @Description:添加，删除，查看，授权，停/启用等操作的脚本信息
 * @Version:1.0.0
 */
$(function() {
	//加载表单页面
	$.Huitab("#tab-category .tabBar span", "#tab-category .tabCon",
			"current", "click", "0");
	
	$("#form-category-add").validate({
		rules:{
			title:{
				required:true,
			},
		},
		 messages: {
			 title:{
			        required: "请输入您的栏目名称",
			      }
		    },
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){ //提交表单，跳转页面
			form.submit();
			setTimeout("refresh_close()", 15);//这里需要延时等待 ajax提交
		}
	});
});


function refresh_close()
{
	var index = parent.layer.getFrameIndex(window.name);
	parent.parent.refreshTree();//刷新树！(重点)
	parent.location.reload();
	parent.layer.close(index);
}

