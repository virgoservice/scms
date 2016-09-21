$(function(){
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
			var index = parent.layer.getFrameIndex(window.name);
			parent.location.reload();
			parent.layer.close(index);
		}
	});
});