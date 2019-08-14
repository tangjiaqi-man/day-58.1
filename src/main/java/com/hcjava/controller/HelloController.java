package com.hcjava.controller;

import java.nio.channels.SeekableByteChannel;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.hcjava.entity.User;

@Controller
@RequestMapping("/demo")
/**
 * ������֤
 * @author lenovo
 *
 */
public class HelloController {
	
	@RequestMapping("/hello.do")
	public String hello() {
		System.out.println("���������óɹ�");
		
		return "jsp/hello";
	}
	/*
	 * ���ղ�����4�ַ�ʽ
	 * 
	 */
	//ֱ�ӽ���
	@RequestMapping("/hello1.do")
	public ModelAndView hello1(HttpServletRequest request) {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		return new ModelAndView("jsp/hello");
	}
	/*ʹ�ò�����������
	  * ��contorller�з���������ǰ̨��������ֵ��������һ�¾Ϳ���ֱ��ʹ��
	 */
	@RequestMapping("/hello2.do")
	public ModelAndView hello2(String userName,String password) {
	System.out.println(userName);
	System.out.println(password);
	return new ModelAndView("jsp/hello");
	}
	//����̨���ղ�����ǰ̨���Ĳ�������һ��,����ͨ��@RequestParmǿ��ת��Ϊ��̨����
	@RequestMapping("/hello3.do")
	public ModelAndView hello3(String userName,@RequestParam("password") String pwd) {
		return new ModelAndView("jsp/hello");
	}
	/**
	 * ʹ�ö�����ղ���
	 * ��ʹ�ö�����ղ���ʱ,���뱣֤���������ֵ��ǰ̨���ݹ����Ĳ�������ȫһ��
	 * ��ʱSpringmvc��Ժ������Զ�ƥ�����Ӧ������
	 * ���Ե�ǰ̨�������Ĳ����Ƚ϶�ʱ,�������ö���������
	 */
	@RequestMapping("hello4.do")
	public ModelAndView hello4(User user) {
		System.out.println(user.getPassWord());
		System.out.println(user.getUserName());
		return new ModelAndView("jsp/hello");
	}
	//��������
	/*
	 * ʹ��ModelAndView��������,��תҳ���ͬʱ��������.�൱��ת��(�Ȱ�������ת��ҳ��)
	 * ���ǻ�������
	 */
	@RequestMapping("hello5.do")
	public ModelAndView hello5() {
	Map<String, Object> date = new HashMap<String,Object>();
	date.put("success", true);
	date.put("message", "�����ɹ�");
	System.out.println(Use)
		return new ModelAndView("jsp/hello",date);
	}
	//ʹ��ModelMap��������
	@RequestMapping("hello6.do")
	public ModelAndView hello6(ModelMap model) {
		model.addAttribute("falsel", false);
		model.addAttribute("hello6", "modeMap");
		return new ModelAndView("jsp/hello");
	}
	//ʹ��@ModelAttribute����Bean����
	@ModelAttribute("age")
	public int getage() {
		return 28;	
	}
	/*
	 * ʹ��@ModelAttrbut��������ֵ
	 * String userName:��ֵ��ǰ̨��������ֵ
	 */
	@RequestMapping("/hello7.do")
	public ModelAndView hello7(@ModelAttribute("userName") String userName) {
		return new  ModelAndView("jsp/hello");
	}
	//ʹ��session
	@RequestMapping("/hello8.do")
	public ModelAndView hello8(HttpSession session,User user) {
		user.setUserName("zs");
		session.setAttribute("salary", 8888);
		session.setAttribute("user", user);
		return new ModelAndView("jsp/hello");	
	}//����string
	//�߼���ͼ
	@RequestMapping("hello9.do")
	public String hello9(ModelMap model,User user) {
		user.setUserName("ls");
	model.addAttribute("user", user);
		return "jsp/hello";
	}
	//ϵͳ�Ĵ���ҳ��
	@RequestMapping("hello10.do")
	public String hello10() {
		return "jsp/error";
	}
	//ʹ��ModeAndView�ض���
	@RequestMapping("/hello11.do")
	public ModelAndView hello11(User user) {
		if(user.getUserName().equals("zs")){
				return new ModelAndView("jsp/hello");
	}else {
		return new ModelAndView(new RedirectView("hello10.do"));
	}
 }
	//ʹ��redirect�ض���
	@RequestMapping("hello12.do")
	public String hello12(User user ) {
		if(user .getUserName().equals("zs")) {
			return "jsp/hello";
		}else {
			return "redirect:hello10.gfcvgjtffcf";
		}
			
	}
}