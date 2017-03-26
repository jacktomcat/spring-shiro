package com.chsoft.shiro.facade.service.impl;

import java.util.List;

import com.chsoft.shiro.facade.entity.Permission;
import com.chsoft.shiro.facade.entity.Role;
import com.chsoft.shiro.facade.entity.User;
import com.chsoft.shiro.facade.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chsoft.shiro.facade.dao.UserDao;


@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	
	@Override
	public User getUserByName(String userName) {
		return userDao.getLoginUser(userName);
	}

	@Override
	public User getUserById(String id) {
		return null;
	}

	@Override
	public List<User> getList() {
		return null;
	}

	@Override
	public List<Permission> getPermissionList(String userId) {
		return null;
	}

	@Override
	public List<Permission> getPermissionListByUserName(String userName) {
		return null;
	}

	@Override
	public List<Permission> getMenuList(String userId) {
		return null;
	}

	@Override
	public List<Role> getRoleByUserName(String userName) {
		return null;
	}

}
