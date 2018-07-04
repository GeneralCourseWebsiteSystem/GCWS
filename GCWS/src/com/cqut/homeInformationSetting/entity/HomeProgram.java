package com.cqut.homeInformationSetting.entity;

import java.util.Date;

/**
 * HomeProgram类用于首页展示所需要的栏目
 * @author lxh
 *
 */
public class HomeProgram {

	private Integer id;
	
	private Integer programId;
	
	private String programName;
	
	private String programPath;
	
	private String programCode;
	
	private Byte isShow;
	
	private Integer showNo;
	
	private String width;
	
	private String height;
	
	private String cssName;
	
	private Date createTime;
	
	private Byte isDelete;
	
	private String remark;

	public HomeProgram() {
		super();
	}

	public HomeProgram(Integer id, Integer programId, String programName, String programPath, String programCode,
			Byte isShow, Integer showNo, String width, String height, String cssName, Date createTime, Byte isDelete,
			String remark) {
		super();
		this.id = id;
		this.programId = programId;
		this.programName = programName;
		this.programPath = programPath;
		this.programCode = programCode;
		this.isShow = isShow;
		this.showNo = showNo;
		this.width = width;
		this.height = height;
		this.cssName = cssName;
		this.createTime = createTime;
		this.isDelete = isDelete;
		this.remark = remark;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProgramId() {
		return programId;
	}

	public void setProgramId(Integer programId) {
		this.programId = programId;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public String getProgramPath() {
		return programPath;
	}

	public void setProgramPath(String programPath) {
		this.programPath = programPath;
	}

	public String getProgramCode() {
		return programCode;
	}

	public void setProgramCode(String programCode) {
		this.programCode = programCode;
	}

	public Byte getIsShow() {
		return isShow;
	}

	public void setIsShow(Byte isShow) {
		this.isShow = isShow;
	}

	public Integer getShowNo() {
		return showNo;
	}

	public void setShowNo(Integer showNo) {
		this.showNo = showNo;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getCssName() {
		return cssName;
	}

	public void setCssName(String cssName) {
		this.cssName = cssName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Byte getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Byte isDelete) {
		this.isDelete = isDelete;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
