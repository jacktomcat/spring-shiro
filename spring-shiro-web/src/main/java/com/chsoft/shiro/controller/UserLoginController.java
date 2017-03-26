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


@Controller
@RequestMapping("/")
public class UserLoginController {

	@RequestMapping("login.do")
  	public String login(HttpServletRequest request,Model model) throws Exception{
		// �����½ʧ�ܴ�request�л�ȡ��֤�쳣��Ϣ��shiroLoginFailure����shiro�쳣���ȫ�޶���
		String exceptionClassName = (String) request.getAttribute("errorCodeFailure");
		// ����shiro���ص��쳣��·���жϣ��׳�ָ���쳣��Ϣ
		if (exceptionClassName != null) {
			if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
				model.addAttribute("error", "�˺Ų�����");//���ջ��׸��쳣������
			} else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
				model.addAttribute("error", "�û���/�������");
			} else if ("randomCodeError".equals(exceptionClassName)) {
				model.addAttribute("error", "��֤����� ");
			} else {
				model.addAttribute("error", "δ֪����");
			}
		}
		// �˷����������½�ɹ�����֤�ɹ�����shiro��֤�ɹ����Զ���ת����һ������·��
		// ��½ʧ�ܻ���loginҳ��
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
