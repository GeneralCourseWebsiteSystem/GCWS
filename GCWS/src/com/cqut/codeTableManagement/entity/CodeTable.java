package com.cqut.codeTableManagement.entity;

import java.util.Date;

/**
 * 码表类
 * @author 罗杏函
 * @date 2018.7.3
 */
public class CodeTable {
	
	private Integer id;
	
	private String paramCode;
	
	private String paramName;
	
	private String paramText;
	
	private String parentCode;
	
	private Integer level;
	
	private String codeType;
	
	private Byte hasChild;
	
	private Date createTime;
	
	private Byte isDelete;
	
	private String remark;

	public CodeTable() {
		super();
	}

	public CodeTable(Integer id, String paramCode, String paramName, String paramText, String parentCode, Integer level,
			String codeType, Byte hasChild, Date createTime, Byte isDelete, String remark) {
		super();
		this.id = id;
		this.paramCode = paramCode;
		this.paramName = paramName;
		this.paramText = paramText;
		this.parentCode = parentCode;
		this.level = level;
		this.codeType = codeType;
		this.hasChild = hasChild;
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

	public String getParamCode() {
		return paramCode;
	}

	public void setParamCode(String paramCode) {
		this.paramCode = paramCode;
	}

	public String getParamName() {
		return paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public String getParamText() {
		return paramText;
	}

	public void setParamText(String paramText) {
		this.paramText = paramText;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getCodeType() {
		return codeType;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	public Byte getHasChild() {
		return hasChild;
	}

	public void setHasChild(Byte hasChild) {
		this.hasChild = hasChild;
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
