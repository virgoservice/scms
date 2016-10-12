/**
 * @Author:vabo
 * @DateTime:2016-10-11
 * @Description:
 * @Version:1.0.0
 */
function select_change(select)
{
	//TODO
	$("#description").val(select);
}

function cancel_edit()
{
	var index = parent.layer.getFrameIndex(window.name);
	parent.location.reload();
	parent.layer.close(index);
}
