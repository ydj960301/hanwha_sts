package com.hanwha.myapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
//@Controller= component �� �������� �ǹ�
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/retest")
	public String retest() {
		System.out.print("retest");
		//retrun "han" //han.jsp�� ��� ����   --> forward�����
		return "redirect:han"; //han �Լ� ���� ȣ�� �����̷�Ʈ!
	}
	
	@RequestMapping(value = "/para2")
	public ModelAndView para2(UserDTO d ) {
		ModelAndView mv=new ModelAndView();
		mv.addObject("userid",d.getId());
		mv.addObject("username",d.getUsername()+"��");
		mv.addObject("pw",d.getPw()+100);
		mv.setViewName("pararesult");
		
		
		return mv;
	}
	
	
	@RequestMapping(value = "/para")
	public ModelAndView para(String userid,String username,Integer pw ) {
		ModelAndView mv=new ModelAndView();
		mv.addObject("userid",userid);
		mv.addObject("username",username+"��");
		mv.addObject("pw",pw+100);
		mv.setViewName("pararesult");
		
		
		return mv;
	}
	
	@RequestMapping(value = "/han")
	public ModelAndView han() {
		ModelAndView mv=new ModelAndView();
		mv.addObject("company","��ȭ");
		mv.addObject("dept","����");
		mv.addObject("name","�ؼ�¯");
		mv.setViewName("test3");
		
		
		return mv;
	}
	@RequestMapping(value = {"/test","/test2"})
	public String test2(Model m) {
		m.addAttribute("company","��ȭ");
		m.addAttribute("dept","����");
		m.addAttribute("name","�ؼ�");
		
		
		return "test3";
	}
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("myname","HS");
		
		
		return "NewFile";
	}
	
}
