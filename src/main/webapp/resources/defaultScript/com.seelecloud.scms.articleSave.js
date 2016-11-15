/**
 * @Author:张瑞
 * @DateTime:2016-10-19
 * @Description:添加，删除，查看，授权，停/启用等操作的脚本信息
 * @Version:1.0.0
 */
$(function(){
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	
	/* 系统-栏目-添加 */
	function picture_add(title, url, w, h) {
		layer_show(title, url, w, h);
	}
	
	$list = $("#fileList"),
	$btn = $("#btn-star"),
	state = "pending",
	uploader;
	
	
	var uploader = WebUploader.create({
		auto: true,
		swf: 'lib/webuploader/0.1.5/Uploader.swf',
	
		// 文件接收服务端。
		server: 'fileupload.php',
	
		// 选择文件的按钮。可选。
		// 内部根据当前运行是创建，可能是input元素，也可能是flash.
		pick: '',
	
		// 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
		resize: false,
		// 只允许选择图片文件。
		accept: {
			title: 'Images',
			extensions: 'gif,jpg,jpeg,bmp,png',
			mimeTypes: 'image/*'
		}
	});
	uploader.on( 'fileQueued', function( file ) {
		var $li = $(
			'<div id="' + file.id + '" class="item">' +
				'<div class="pic-box"><img></div>'+
				'<div class="info">' + file.name + '</div>' +
				'<p class="state">等待上传...</p>'+
			'</div>'
		),
		$img = $li.find('img');
		$list.append( $li );
	
		// 创建缩略图
		// 如果为非图片文件，可以不用调用此方法。
		// thumbnailWidth x thumbnailHeight 为 100 x 100
		uploader.makeThumb( file, function( error, src ) {
			if ( error ) {
				$img.replaceWith('<span>不能预览</span>');
				return;
			}
	
			$img.attr( 'src', src );
		}, thumbnailWidth, thumbnailHeight );
	});
	// 文件上传过程中创建进度条实时显示。
	uploader.on( 'uploadProgress', function( file, percentage ) {
		var $li = $( '#'+file.id ),
			$percent = $li.find('.progress-box .sr-only');
	
		// 避免重复创建
		if ( !$percent.length ) {
			$percent = $('<div class="progress-box"><span class="progress-bar radius"><span class="sr-only" style="width:0%"></span></span></div>').appendTo( $li ).find('.sr-only');
		}
		$li.find(".state").text("上传中");
		$percent.css( 'width', percentage * 100 + '%' );
	});
	
	// 文件上传成功，给item添加成功class, 用样式标记上传成功。
	uploader.on( 'uploadSuccess', function( file ) {
		$( '#'+file.id ).addClass('upload-state-success').find(".state").text("已上传");
	});
	
	// 文件上传失败，显示上传出错。
	uploader.on( 'uploadError', function( file ) {
		$( '#'+file.id ).addClass('upload-state-error').find(".state").text("上传出错");
	});
	
	// 完成上传完了，成功或者失败，先删除进度条。
	uploader.on( 'uploadComplete', function( file ) {
		$( '#'+file.id ).find('.progress-box').fadeOut();
	});
	uploader.on('all', function (type) {
        if (type === 'startUpload') {
            state = 'uploading';
        } else if (type === 'stopUpload') {
            state = 'paused';
        } else if (type === 'uploadFinished') {
            state = 'done';
        }

        if (state === 'uploading') {
            $btn.text('暂停上传');
        } else {
            $btn.text('开始上传');
        }
    });

    $btn.on('click', function () {
        if (state === 'uploading') {
            uploader.stop();
        } else {
            uploader.upload();
        }
    });
	
//	var ue = 
		UE.getEditor('editor');
	
	$("#form-article-add").validate({
		rules:{
			title:{
				required:true,	
			},
			channelName:{
				 required: true,
			     minlength: 1
			}
		},
		 messages: {
			 title:{
			        required: "请输入您的文章名称",
			      },
			      channelName:{
				 	minlength: "请选择一个栏目"
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
	
	function showMenu() {
		$("#mytree").width($(this).width()+30);
		$("#mytree").height($(this).height()+250);
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

function refresh_close()
{
	var index = parent.layer.getFrameIndex(window.name);
	parent.location.reload();
	parent.layer.close(index);
}
