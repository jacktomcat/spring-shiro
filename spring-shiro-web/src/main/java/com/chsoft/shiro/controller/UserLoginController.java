package com.chsoft.shiro.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chsoft.shiro.facade.entity.User;


@Controller
@RequestMapping("/")
public class UserLoginController {

	@RequestMapping("login.do")
  	public String login(HttpServletRequest request,Model model) throws Exception{
		// 如果登陆失败从request中获取认证异常信息，shiroLoginFailure就是shiro异常类的全限定名
		String exceptionClassName = (String) request.getAttribute("errorCodeFailure");
		// 根据shiro返回的异常类路径判断，抛出指定异常信息
		if (exceptionClassName != null) {
			if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
				model.addAttribute("error", "账号不存在");//最终会抛给异常处理器
			} else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
				model.addAttribute("error", "用户名/密码错误");
			} else if ("randomCodeError".equals(exceptionClassName)) {
				model.addAttribute("error", "验证码错误 ");
			} else {
				model.addAttribute("error", "未知错误");
			}
		}
		// 此方法不处理登陆成功（认证成功），shiro认证成功会自动跳转到上一个请求路径
		// 登陆失败还到login页面
		return "login";
	}
	
	
	@RequestMapping("index.do")
  	public String index(Model model){
		Subject subject = SecurityUtils.getSubject();
		Object principal = subject.getPrincipal();
		/*User user = (User) subject.getPrincipal();
		model.addAttribute("loginUser", user);*/
		return "index";
	}
	
	
	
	@RequestMapping("logout.do")
  	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/index.do";
	}
}
