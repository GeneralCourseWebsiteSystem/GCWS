package com.cqut.common.util;

import java.text.SimpleDateFormat;

public class SysUtil {
	/**
	 * 功能：拼接分页时候的html代码 
	 * @author: hujun copy by lxh
	 * @param allCount 总的记录数
	 * @param currentPage 当前页数
	 * @param limit 每页显示记录数
	 * @param url 没有分页是的查询条件
	 * @return 拼接好了的html代码
	 */
	public static String createPage(int allCount, int currentPage, int limit, String url) {
		String pageStr = "";// 存储最终拼接好的html

		if (allCount == 0) {
			return "";
		}

		synchronized (pageStr) {
			int allPage = (int) Math.ceil((allCount * 1.0) / limit);// 计算出总有多少页
			int i, j;// 分页变量
			String pageCnfig = url;
			int index = pageCnfig.indexOf("?");// 判断原来的url里面是否有参数，有参数就在原来的基础上添加，没有就加添加

			for (i = currentPage - 1; i >= currentPage - 4; i--) {
				pageCnfig = url;
				if (i >= 1) {
					if (index > 0) {
						pageCnfig += "&curPage=" + i + "&limit=" + limit;
					} else {
						pageCnfig += "?curPage=" + i + "&limit=" + limit;
					}
					pageStr = "<span><a href='" + pageCnfig + "'>" + i + "</a></span>" + pageStr;
				} else {
					break;
				}
			}

			if (currentPage != 1) {
				pageCnfig = url;
				if (index > 0) {
					pageCnfig += "&curPage=" + (currentPage - 1) + "&limit=" + limit;
				} else {
					pageCnfig += "?curPage=" + (currentPage - 1) + "&limit=" + limit;
				}
				pageStr = "<span><a href='" + pageCnfig + "'>上一页</a></span>" + pageStr;
			}

			for (j = currentPage; j <= currentPage + 4; j++) {
				pageCnfig = url;
				if (j <= allPage) {
					if (index > 0) {
						pageCnfig += "&curPage=" + j + "&limit=" + limit;
					} else {
						pageCnfig += "?curPage=" + j + "&limit=" + limit;
					}
					if (currentPage == j) {
						pageStr = pageStr + "<span><a href='" + pageCnfig + "' class='currentPage'>" + j
								+ "</a></span>";
					} else {
						pageStr = pageStr + "<span><a href='" + pageCnfig + "'>" + j + "</a></span>";
					}
				} else {
					break;
				}

			}

			if (currentPage != allPage) {
				pageCnfig = url;
				if (index > 0) {
					pageCnfig += "&curPage=" + (currentPage + 1) + "&limit=" + limit;
				} else {
					pageCnfig += "?curPage=" + (currentPage + 1) + "&limit=" + limit;
				}
				pageStr += "<span><a href='" + pageCnfig + "'>下一页</a></span>";
			}
		}

		return pageStr;

	}
}
