package com.chsoft.shiro.custom;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cas.CasRealm;
import org.apache.shiro.subject.PrincipalCollection;
import com.chsoft.shiro.facade.entity.Permission;
import com.chsoft.shiro.facade.entity.Role;
import com.chsoft.shiro.facade.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CasShiroRealm extends CasRealm {
	
	@Autowired
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username = (String)principals.getPrimaryPrincipal();  
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();  
        
        List<Role> roles = userService.getRoleByUserName(username);
        Set<String> codeList = new HashSet<String>();
        for (Role role : roles) {
        	codeList.add(role.getCode());
		}
        authorizationInfo.setRoles(codeList);  
        
        List<Permission> permissionList = userService.getPermissionListByUserName(username);
        Set<String> permissions = new HashSet<String>();
        for (Permission permission : permissionList) {
        	permissions.add(permission.getCode());
		}
        authorizationInfo.setStringPermissions(permissions);  
        return authorizationInfo;
	}
	

}
