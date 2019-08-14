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
 * 配置验证
 * @author lenovo
 *
 */
public class HelloController {
	
	@RequestMapping("/hello.do")
	public String hello() {
		System.out.println("第三步配置成功");
		
		return "jsp/hello";
	}
	/*
	 * 接收参数的4种方式
	 * 
	 */
	//直接接收
	@RequestMapping("/hello1.do")
	public ModelAndView hello1(HttpServletRequest request) {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		return new ModelAndView("jsp/hello");
	}
	/*使用参数方法接收
	  * 当contorller中方法参数和前台传过来的值参数名字一致就可以直接使用
	 */
	@RequestMapping("/hello2.do")
	public ModelAndView hello2(String userName,String password) {
	System.out.println(userName);
	System.out.println(password);
	return new ModelAndView("jsp/hello");
	}
	//当后台接收参数和前台传的参数名不一样,可以通过@RequestParm强制转换为后台参数
	@RequestMapping("/hello3.do")
	public ModelAndView hello3(String userName,@RequestParam("password") String pwd) {
		return new ModelAndView("jsp/hello");
	}
	/**
	 * 使用对象接收参数
	 * 当使用对象接收参数时,必须保证对象的属性值和前台传递过来的参数名完全一致
	 * 此时Springmvc会对号入座自动匹配相对应的属性
	 * 所以当前台传过来的参数比较多时,建议适用对象来接受
	 */
	@RequestMapping("hello4.do")
	public ModelAndView hello4(User user) {
		System.out.println(user.getPassWord());
		System.out.println(user.getUserName());
		return new ModelAndView("jsp/hello");
	}
	//传出数据
	/*
	 * 使用ModelAndView传出数据,跳转页面的同时传出数据.相当于转发(先绑定数据在转发页面)
	 * 这是基本操作
	 */
	@RequestMapping("hello5.do")
	public ModelAndView hello5() {
	Map<String, Object> date = new HashMap<String,Object>();
	date.put("success", true);
	date.put("message", "操作成功");
	System.out.println(Use)
		return new ModelAndView("jsp/hello",date);
	}
	//使用ModelMap传出数据
	@RequestMapping("hello6.do")
	public ModelAndView hello6(ModelMap model) {
		model.addAttribute("falsel", false);
		model.addAttribute("hello6", "modeMap");
		return new ModelAndView("jsp/hello");
	}
	//使用@ModelAttribute传出Bean属性
	@ModelAttribute("age")
	public int getage() {
		return 28;	
	}
	/*
	 * 使用@ModelAttrbut传出参数值
	 * String userName:该值是前台传过来的值
	 */
	@RequestMapping("/hello7.do")
	public ModelAndView hello7(@ModelAttribute("userName") String userName) {
		return new  ModelAndView("jsp/hello");
	}
	//使用session
	@RequestMapping("/hello8.do")
	public ModelAndView hello8(HttpSession session,User user) {
		user.setUserName("zs");
		session.setAttribute("salary", 8888);
		session.setAttribute("user", user);
		return new ModelAndView("jsp/hello");	
	}//返回string
	//逻辑视图
	@RequestMapping("hello9.do")
	public String hello9(ModelMap model,User user) {
		user.setUserName("ls");
	model.addAttribute("user", user);
		return "jsp/hello";
	}
	//系统的错误页面
	@RequestMapping("hello10.do")
	public String hello10() {
		return "jsp/error";
	}
	//使用ModeAndView重定向
	@RequestMapping("/hello11.do")
	public ModelAndView hello11(User user) {
		if(user.getUserName().equals("zs")){
				return new ModelAndView("jsp/hello");
	}else {
		return new ModelAndView(new RedirectView("hello10.do"));
	}
 }
	//使用redirect重定向
	@RequestMapping("hello12.do")
	public String hello12(User user ) {
		if(user .getUserName().equals("zs")) {
			return "jsp/hello";
		}else {
			return "redirect:hello10.gfcvgjtffcf";
		}
			
	}
}