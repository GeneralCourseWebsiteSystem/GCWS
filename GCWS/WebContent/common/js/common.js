function systemTime() {
	// 获取系统时间。
	var dateTime = new Date();
	var y = dateTime.getFullYear(); // 获取年份
	var m = dateTime.getMonth() + 1; // 获取月份 返回0-11
	var d = dateTime.getDate(); // 获取日
	var w = dateTime.getDay(); // 获取星期几 返回0-6 (0=星期天)
	var ww = ' 星期' + '日一二三四五六'.charAt(new Date().getDay());// 星期几
	var hh = dateTime.getHours();
	var mm = dateTime.getMinutes();
	var ss = dateTime.getSeconds();

	// 分秒时间是一位数字，在数字前补0。
	mm = extra(mm);
	ss = extra(ss);
	m = extra(m);
	d = extra(d);

	// 将时间显示到ID为time的位置，时间格式形如：19:18:02
	document.getElementById("time").innerHTML = y + "年" + m + "月" + d + "日 "
			+ hh + ":" + mm + ":" + ss;

	// 每隔1000ms执行方法systemTime()。
	setTimeout("systemTime()", 1000);
}

// 补位函数。
function extra(x) {
	// 如果传入数字小于10，数字前补一位0。
	if (x < 10) {
		return "0" + x;
	} else {
		return x;
	}
}
function doMenu(obj) {
	var items = obj.parentNode.getElementsByTagName("ul");
	var itmUl;
	if (items.length > 0) {
		itmUl = items[0];
	}
	if (itmUl.className != "ex") {
		cxAll();
		itmUl.className = "ex";
	} else {
		itmUl.className = "cx";
	}
}
function statUp() {
	systemTime();
	cxAll();
}
function cxAll() {
	var ulDom = document.getElementById("menu");
	var items = ulDom.getElementsByTagName("ul");
	for (var i = 0; i < items.length; i++) {
		items[i].className = "cx";
	}
}
