package com.chsoft.shiro.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/role")
public class RoleController {

	@RequestMapping("list.do")
	@RequiresPermissions("role:list")
  	public String list(HttpServletRequest request,Model model) throws Exception{
		return "list";
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
