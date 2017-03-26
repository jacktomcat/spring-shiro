package com.chsoft.shiro.facade.service;

import java.util.List;
import com.chsoft.shiro.facade.entity.Permission;


public interface PermissionService {
    
	
	public List<Permission> getPermissionList(String userId);
	
	public List<Permission> getMenuList(String userId);
	
}
