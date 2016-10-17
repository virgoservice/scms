/**
 * @Author:vabo
 * @DateTime:2016-10-11
 * @Description:
 * @Version:1.0.0
 */
roleList = new Array();
$(function() {
	$("#roleList input").each(function() {
		var role = new Object();
		role.id = $(this).attr('id');
		role.description = $(this).val();
		roleList.push(role);
	});
});

function find_desccription_by_id(id, roleList) {
	for (var i = 0; i < roleList.length; i++) {
		if (id == roleList[i].id) {
			return roleList[i].description;
		}
	}

	return "";
}

function select_change(select) {
	var roleid = select;
	var description = find_desccription_by_id(select, roleList);
	$("#description").val(description);
}

function cancel_edit() {
	var index = parent.layer.getFrameIndex(window.name);
	parent.location.reload();
	parent.layer.close(index);
}
