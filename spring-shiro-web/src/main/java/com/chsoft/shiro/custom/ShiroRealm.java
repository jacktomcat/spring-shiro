package com.chsoft.shiro.custom;

import java.util.ArrayList;
import java.util.List;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import com.chsoft.shiro.facade.entity.Permission;
import com.chsoft.shiro.facade.entity.User;
import com.chsoft.shiro.facade.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ShiroRealm extends AuthorizingRealm {
	
	@Autowired
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void setName(String name) {
		super.setName("shiroRealm");
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String userName = (String) token.getPrincipal();
		User user = null;
		SimpleAuthenticationInfo simpleAuthenticationInfo = null;
		try {
			user = userService.getUserByName(userName);

			if (user == null) {
				return null;
			}

			String password = user.getPassword();

			List<Permission> menuList = userService.getMenuList(user.getId());
			user.setMenuList(menuList);
			
			simpleAuthenticationInfo = new SimpleAuthenticationInfo(user, password,this.getName());
			
			//String salt = "jackjboss";
			//simpleAuthenticationInfo = new SimpleAuthenticationInfo(user, password, ByteSource.Util.bytes(salt),this.getName());

		} catch (Exception e1) {
			e1.printStackTrace();
		}

		return simpleAuthenticationInfo;
	}
	
	

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		User user =  (User) principals.getPrimaryPrincipal();
		List<Permission> permissionList = null;
		try {
			permissionList = userService.getPermissionList(user.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<String> permissions = new ArrayList<String>();
		if(permissionList!=null){
			for(Permission ps:permissionList){
				permissions.add(ps.getCode());
			}
		}
		
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		simpleAuthorizationInfo.addStringPermissions(permissions);

		return simpleAuthorizationInfo;
	}
	

	public void clearCached() {
		PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
		super.clearCache(principals);
	}

}
