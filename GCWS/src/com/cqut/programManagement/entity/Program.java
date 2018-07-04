package com.cqut.programManagement.entity;

import java.util.Date;

/**
 * 栏目类
 * @author lxh
 * @date 2018.7.4
 *
 */
public class Program {
	
	private Integer id;
	
	private String programName;
	
	private String programPath;
	
	private String programCode;
	
	private Date createTime;
	
	private Byte isDelete;
	
	private String remark;

	public Program() {
		super();
	}

	public Program(Integer id, String programName, String programPath, String programCode, Date createTime,
			Byte isDelete, String remark) {
		super();
		this.id = id;
		this.programName = programName;
		this.programPath = programPath;
		this.programCode = programCode;
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
