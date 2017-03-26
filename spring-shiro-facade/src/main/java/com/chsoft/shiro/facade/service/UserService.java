package com.chsoft.shiro.facade.service;

import java.util.List;

import com.chsoft.shiro.facade.entity.Permission;
import com.chsoft.shiro.facade.entity.Role;
import com.chsoft.shiro.facade.entity.User;


public interface UserService {
    
	public User getUserByName(String userName);
	
	public User getUserById(String id);
	
	public List<User> getList();
	
    public List<Permission> getPermissionList(String userId);
    
    public List<Permission> getPermissionListByUserName(String userName);
	
	public List<Permission> getMenuList(String userId);
	
	public List<Role> getRoleByUserName(String userName);

}
