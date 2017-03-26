package com.chsoft.shiro.facade.entity;

import java.io.Serializable;

public class RolePermission implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3291729596584924081L;

	private String id;
	private String roleId;
	private String permissionId;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(String permissionId) {
		this.permissionId = permissionId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
}
