package com.chsoft.shiro.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/permission")
public class PermissionController {

	@RequestMapping("list.do")
  	public String list(HttpServletRequest request,Model model) throws Exception{
		return null;
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
