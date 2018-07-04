function validate(programForm) {
	if (programForm.programId.value == "") {
		alert("请选择栏目名!");
		return false;
	} else if (programForm.isShow.value == "") {
		alert("请选择是否展示!");
		return false;
	}
	return true;
}
