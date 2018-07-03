package com.cqut.moduleManagement.entity;

import java.util.Date;

/**
 * 模块表
 * @author lxh
 * @dete 2018.7.2
 *
 */
public class Module {

	private Integer id;
	
	private String moduleCode;
	
	private String moduleName;
	
	private String modulePath;
	
	private String parentCode;
	
	private Byte isMenu;
	
	private String level;
	
	private Date createTime;
	
	private Byte isDelete;
	
	private String remark;

	public Module() {
		super();
	}

	public Module(Integer id, String moduleCode, String moduleName, String modulePath, String parentCode, Byte isMenu,
			String level, Date createTime, Byte isDelete, String remark) {
		super();
		this.id = id;
		this.moduleCode = moduleCode;
		this.moduleName = moduleName;
		this.modulePath = modulePath;
		this.parentCode = parentCode;
		this.isMenu = isMenu;
		this.level = level;
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

	public String getModuleCode() {
		return moduleCode;
	}

	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getModulePath() {
		return modulePath;
	}

	public void setModulePath(String modulePath) {
		this.modulePath = modulePath;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public Byte getIsMenu() {
		return isMenu;
	}

	public void setIsMenu(Byte isMenu) {
		this.isMenu = isMenu;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
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
