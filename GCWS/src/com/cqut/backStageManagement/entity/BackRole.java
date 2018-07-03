package com.cqut.backStageManagement.entity;

public class BackRole {
	
    private String roleName;
	
	private Integer id;

	public BackRole() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BackRole(String roleName, Integer id) {
		super();
		this.roleName = roleName;
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}