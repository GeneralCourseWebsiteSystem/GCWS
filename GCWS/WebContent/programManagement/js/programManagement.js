function validate(programForm) {
	if (programForm.programName.value == "") {
		alert("请输入栏目名!");
		return false;
	} else if (programForm.programPath.value == "") {
		alert("请输入栏目路径!");
		return false;
	}
	return true;
}
