function validate(codeTableManageForm) {
	if (codeTableManageForm.paramName.value == "") {
		alert("请输入码表名!");
		return false;
	} else if (codeTableManageForm.paramText.value == "") {
		alert("请输入码表内容!");
		return false;
	} else if(codeTableManageForm.isMenu.value == ""){
		alert("请选择是否有孩子节点!");
		return false;
	}
	return true;
}

function isNumber(str) // 判断是否为非负整数
{
	var rx = /^[0-9]+$/;
	return rx.test(str);
}
