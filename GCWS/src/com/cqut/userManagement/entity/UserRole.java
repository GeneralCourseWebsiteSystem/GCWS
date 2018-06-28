package com.cqut.userManagement.entity;

public class UserRole {
	
	private Integer id;
	
	/**role.role_name*/
	private String roleName;
	
	private String userName;
	
	private String phoneNumber;
	
	private Byte isLock;
	
	private Byte isAssociates;

	public UserRole() {
		super();
	}

	public UserRole(Integer id, String roleName, String userName, String phoneNumber, Byte isLock, Byte isAssociates) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.userName = userName;
		this.phoneNumber = phoneNumber;
		this.isLock = isLock;
		this.isAssociates = isAssociates;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Byte getIsLock() {
		return isLock;
	}

	public void setIsLock(Byte isLock) {
		this.isLock = isLock;
	}

	public Byte getIsAssociates() {
		return isAssociates;
	}

	public void setIsAssociates(Byte isAssociates) {
		this.isAssociates = isAssociates;
	}
}
