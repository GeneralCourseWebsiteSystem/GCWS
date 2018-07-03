function validate(moduleManageForm) {
	if (moduleManageForm.moduleName.value == "") {
		alert("请输入模块名!");
		return false;
	} else if (moduleManageForm.modulePath.value == "") {
		alert("请输入模块路由!");
		return false;
	} else if(moduleManageForm.isMenu.value == ""){
		alert("请选择是否为目录!");
		return false;
	}
	return true;
}

function isNumber(str) // 判断是否为非负整数
{
	var rx = /^[0-9]+$/;
	return rx.test(str);
}
