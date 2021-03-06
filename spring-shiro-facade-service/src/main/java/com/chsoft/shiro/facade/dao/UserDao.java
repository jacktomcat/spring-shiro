package com.chsoft.shiro.facade.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.chsoft.shiro.facade.entity.User;


/**
 * 
 * @作者 zhuhh
 * @描述   运维账号实体数据库接口层
 * @创建时间 2016年3月14日 下午12:55:23
 * @修改时间
 */
public interface UserDao{

	/**
	 * 校验用户名唯一性
	 * @author limr
	 * @param user
	 * @return
	 */
	User getUserByUserName(User user);
	
	/**
	 * 根据用户名获取当前登录用户
	 * @param userName
	 * @return
	 */
	public User getLoginUser(@Param("userName") String userName);
	
	
	/**
	 * 根据角色id查询角色所拥有的用户
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	public List<User> getUsers()throws Exception;

}
