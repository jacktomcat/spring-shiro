package com.chsoft.shiro.controller;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSONObject;
import com.chsoft.shiro.facade.entity.User;
import com.chsoft.shiro.facade.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@RequestMapping("list_index.do")
	@RequiresPermissions("user:list")
  	public String list_index(HttpServletRequest request,Model model) throws Exception{
		return "list";
	}
	
	
	@RequestMapping("list.do")
	@RequiresPermissions("user:list")
	@ResponseBody
  	public JSONObject list(HttpServletRequest request,Model model) throws Exception{
		JSONObject obj = new JSONObject();
		List<User> list = userService.getList();
		obj.put("total", list.size());
		obj.put("rows", list);
		return obj;
	}
	
	
	@RequestMapping("add.do")
  	public String add(HttpServletRequest request,Model model) throws Exception{
		return null;
	}
	
	
	@RequestMapping("update.do")
  	public String update(HttpServletRequest request,Model model) throws Exception{
		return null;
	}
	
	
	@RequestMapping("delete.do")
  	public String delete(HttpServletRequest request,Model model) throws Exception{
		return null;
	}
	
}
