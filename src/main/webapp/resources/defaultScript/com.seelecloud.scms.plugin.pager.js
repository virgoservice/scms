/**
 * @Author:谭朝红
 * @DateTime:2016-09-22
 * @Description:分页处理插件
 * @Version:1.0.0
 */
;(function($,window,document){	//为了避免一些不必要的麻烦，在最前面添加一个“;”，这是约定，我也不知道为什么，反正好使
	var setting;
	var dataList = new Array();
	$.fn.pagefn=function(options){
		var defaults = {
			page:1,	//分页的起始页，默认是从第一页开始
			pageSize:10	//分页的大小，默认是每页10条数据
		};
		setting = $.extend(defaults,options,{});
		//3.在这里实现功能代码，this代表调用本插件的对象
		return dataPage(setting);
		//4.使之能够链式操作
	}
	function dataPage(curr){
		$.getJSON(setting.ctx+setting.url,{
			page:curr||1,
			pageSize:setting.pageSize
		},function(res){
			laypage({
				cont:setting.pageLabel,
				pages:Math.ceil(setting.totalSize/setting.pageSize),
				curr:curr||1,
				first:'首页',
				last:'尾页',
				prev:'上一页',
				next:'下一页',
				skip:true,
				groups:setting.groups,
				jump:function(obj,first){
					if(!first){
						dataPage(obj.curr);
					}
				}
			});
			$(setting.tal).html(PackageData(res));
		});
	}
	
	function PackageData(res){
		var content = "";
		$.each(res,function(i,o){
			content+="<tr class='text-c'><td><input type='checkbox' value='1' name=''></td>";
			for(var j = 0;j<setting.args.length;j++){
				var arg = setting.args[j];
				if(o[arg]==undefined){
					content+="<td>"+ "null" +"</td>";
				}
				else if(j == setting.args.length){
					break;
				}else{
						content+="<td>"+o[arg]+"</td>";
					}
			}
			
//			if(setting.showOperate != "{}")// 如果没有operate栏就不需要
			{
				var str=null;
				content += "<td>";
				str= $(setting.showOperate).html();
				for(var n=0; n<setting.operates.length; n++)
				{
					var op = setting.operates[n];
					var id = "'" + o["id"] + "'";
					var url = "'" + setting.ctx + op.url + o["id"] + "'";	//传入 id 值
					str = str.replace(/url/, url);
					str = str.replace(/id/, id);
				}
				content += str;
				content += "</td>";
			}
			content +"</tr>";
		}); 
		return content;
	}
	
})(jQuery,window,document); //转化为父类的引用（这个可以跳过，不用去理解）
