package com.cqut.userManagement.entity;

public class RoleUserLink {
	
	private Integer id;
	
	private Integer uId;
	
	private String roleName;
	
	private String userName;
	
	private String account;

	public RoleUserLink() {
		super();
	}

	public RoleUserLink(Integer id, Integer uId,String roleName, String userName, String account) {
		super();
		this.id = id;
		this.uId= uId;
		this.roleName = roleName;
		this.userName = userName;
		this.account = account;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}
	

}
