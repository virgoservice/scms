/**
 * @Author:张瑞
 * @DateTime:2016-10-19
 * @Description:添加，删除，查看，授权，停/启用等操作的脚本信息
 * @Version:1.0.0
 */
$(function() {
		$('.skin-minimal input').iCheck({
			checkboxClass : 'icheckbox-blue',
			radioClass : 'iradio-blue',
			increaseArea : '20%'
		});
		$.Huitab("#tab-category .tabBar span", "#tab-category .tabCon",
				"current", "click", "0");
	});
