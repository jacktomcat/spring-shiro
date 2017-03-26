package com.chsoft.shiro.facade.entity;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3291729596584924081L;
	
	private String id;
	private String userName;
	private String password;
	private String email;
	private String mobile;

	
	private List<Permission> menuList;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public List<Permission> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Permission> menuList) {
		this.menuList = menuList;
	}
}
