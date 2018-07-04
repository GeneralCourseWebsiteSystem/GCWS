package com.cqut.authorityManagement.entity;

import java.sql.Date;

/**
 * 
 * @author 刘华
 * 权限管理所需的实体
 *
 */

public class ModuleRole {
	private int id;
	private int module_id;
	private int role_id;
	private Date create_time;
	private Byte is_delete;
	private String remark;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getModule_id() {
		return module_id;
	}
	public void setModule_id(int module_id) {
		this.module_id = module_id;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Byte getIs_delete() {
		return is_delete;
	}
	public void setIs_delete(Byte is_delete) {
		this.is_delete = is_delete;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public ModuleRole() {
		super();
	}
	public ModuleRole(int id, int module_id, int role_id, Date create_time, Byte is_delete, String remark) {
		super();
		this.id = id;
		this.module_id = module_id;
		this.role_id = role_id;
		this.create_time = create_time;
		this.is_delete = is_delete;
		this.remark = remark;
	}
	
	
	
}
