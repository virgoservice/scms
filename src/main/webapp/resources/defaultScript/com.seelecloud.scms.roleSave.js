/**
 * @Author:vabo
 * @DateTime:2016-09-22
 * @Description:对要添加的角色信息进行校验
 * @Version:1.0.0
 */
$(function() {
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	
	$("#form-admin-role-add").validate({
		rules:{
			roleName:{
				required:true,
				minlength:1,
				maxlength:16
			},
			description:{
				required:true,
				minlength:1,
				maxlength:128
			},
		},
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){
			$(form).ajaxSubmit();
			setTimeout("refresh_close()", 15);//这里需要延时等待 ajax提交
		}
	});
});

function refresh_close()
{
	var index = parent.layer.getFrameIndex(window.name);
	parent.location.reload();
	parent.layer.close(index);
}
