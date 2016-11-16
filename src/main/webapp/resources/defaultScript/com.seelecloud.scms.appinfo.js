$(function(){	
	//加载表单页面
	$.Huitab("#tab-system .tabBar span","#tab-system .tabCon","current","click","0");
	
	//jquery-plugin-validate验证
	$("#form-article-add").validate({
		rules:{
			appName:{
				required:true,
				minlength:1,
				maxlength:25
			},
			appKeyword:{
				required:true,
				minlength:1,
				maxlength:8
			},
			appDescription:{
				required:true,
				minlength:1,
				maxlength:80
			},
		},		
	 messages: {
		 appName:{
		        required: "请输入您的网站名称",
		        minlength: "您的网站名称长度不能大于25个汉字"
		      },
		 appKeyword: {
		        required: "请输入您的关键词",
		        minlength: "您的关键词长度不能大于8个汉字"
		      },	      
		 appDescription: {
		        required: "请输入您的描述",
		        minlength: "您的描述长度不能大于80个汉字"
		      }
	    },
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){
			$(form).ajaxSubmit();
		}
	});
});
