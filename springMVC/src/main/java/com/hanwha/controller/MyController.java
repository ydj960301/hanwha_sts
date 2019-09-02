package com.hanwha.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hanwha.model.DeptDAO;
import com.hanwha.model.DeptDAO_mybatis;
import com.hanwha.model.DeptDTO;
import com.hanwha.model.EmpDAO;
import com.hanwha.model.EmpDAO_mybatis;
import com.hanwha.model.EmpService;
import com.hanwha.model.EmpVO;

@Controller //애가 컨트롤러라는것을 알리기위해 servlet-context.xml에가서 등록해줘야함.
public class MyController {
	//@Autowired
	//DeptDAO dao;
	
	@Autowired
	//EmpService service;
	EmpDAO_mybatis service;
	
	@Autowired
	DeptDAO_mybatis dao;
	
	
	@RequestMapping("/404")
	public String error404(Model m) {
		m.addAttribute("company","한화");
		m.addAttribute("manager","이해수");
		return "error404";
	}
	@ExceptionHandler(Exception.class)
	public String error500(Exception e,Model m) {
		m.addAttribute("company","한화");
		m.addAttribute("manager","이해수");
		m.addAttribute("phone","01097913090");
		m.addAttribute("message",e.getMessage());
		return "error500";
	}
	
	/*@RequestMapping("/500")
	public String error500(Model m) {
		m.addAttribute("company","한화");
		m.addAttribute("manager","이해수");
		m.addAttribute("phone","01097913090");
		return "error500";
	}*/
	
////////////////////Emp////////////////////////
	@RequestMapping("/emp/emplist")
	public ModelAndView selectAll() {
		ModelAndView mv=new ModelAndView();
		mv.addObject("emplist",service.selectAll());
		mv.setViewName("emp/empAll");
		return mv;
	}
	
	@RequestMapping(value="/emp/empdetail",method= RequestMethod.GET)
	public ModelAndView empdetail(int id) {
		ModelAndView mv=new ModelAndView();
		mv.addObject("emp", service.selectId(id));
		mv.addObject("deptlist", dao.selectAll());
		mv.addObject("joblist", service.selectAlljob());
		mv.setViewName("emp/empdetail");
		
		return mv;
	}
	@RequestMapping(value="/emp/empdetail",method= RequestMethod.POST)
	public String empdetailPost(EmpVO e) {
		 service.updateEmpt(e);
		
		return "redirect:emplist";
	}
	
	@RequestMapping(value="/emp/empinsert",method= RequestMethod.GET)
	public ModelAndView empinsert() {
		ModelAndView mv=new ModelAndView();
		mv.addObject("deptlist", dao.selectAll());
		mv.addObject("joblist", service.selectAlljob());
		mv.setViewName("emp/empinsert");
		return mv;
	}
	@RequestMapping(value="/emp/empinsert",method= RequestMethod.POST)
	public String empinsertPost(EmpVO e) {
		 service.insertEmp(e);
		
		return "redirect:emplist";
	}
	
	@RequestMapping(value="/emp/empdelete")
	public String empdelete(int id) {
		service.deleteEmp(id);
		
		return "redirect:emplist";
	}
	
	
	
	
	///////////////////DEPT/////////////////////////////////////
	
	@RequestMapping("/dept/deptlist")
	public String deptlist(Model m) {
		m.addAttribute("deptlist",dao.selectAll());
		
		return "Dept/deptlist";
	}
	@RequestMapping(value="/dept/deptdetail",method= RequestMethod.GET)
	public String deptdetail(int deptid,Model m) {
		m.addAttribute("dept", dao.selectById(deptid));
		
		return "Dept/deptdetail";
	}
	
	@RequestMapping(value="/dept/deptdetail",method= RequestMethod.POST)
	public String deptupdate(DeptDTO d) {
		dao.updateDept(d);
		return "redirect:deptlist";
	}
	
	@RequestMapping(value="/dept/deptinsert",method= RequestMethod.GET)
	public String deptinsertGet() {
		
		return "Dept/deptinsert";
		
		
	}
	
	   @RequestMapping("/dept/deptdownload")
	   public void download(String folder, String file, HttpServletRequest request, HttpServletResponse response) throws IOException {
	   //deptdownload?folder=resources&file=${dept.fileName}
	        response.setHeader("Content-Disposition", "attachment;filename="+file);
	        String fullPath = request.getSession().getServletContext().getRealPath(folder + "/" + file);    
	        FileInputStream fi = new FileInputStream(fullPath);    
	        ServletOutputStream sout = response.getOutputStream();    
	        byte[] buf = new byte[1024];    
	        int size = 0;    
	        while((size = fi.read(buf, 0, 1024))!=-1){      
	           sout.write(buf, 0, size);    
	        }    
	        fi.close();    
	        sout.close();
	   }
	
	   @RequestMapping(value = "/dept/deptinsert", method = RequestMethod.POST)
	   public String deptInsertPost(DeptDTO dept, HttpServletRequest request) {
	      MultipartFile uploadfile = dept.getUploadfile();         
	      if (uploadfile == null) {
	         return "redirect:deptinsert";
	      }
	      String path = request.getSession().getServletContext().getRealPath("/resources");         
	      String fileName = uploadfile.getOriginalFilename();         
	      String fpath = path +"\\" + fileName;                
	      dept.setFileName(fileName); //파일경로저장 
	      System.out.println(fpath);
	      try {                               
	         File file = new File(fpath);            
	         uploadfile.transferTo(file);          
	      } catch (IOException e) {     
	            e.printStackTrace();     
	      }
	      
	      dao.insertDept(dept);
	      return "redirect:deptlist"; 
	   }
	
	@RequestMapping(value="/dept/deptdelete")
	public String deptdelete(int deptid) {
		dao.deleteDept(deptid);
		
		return "redirect:deptlist";
	}
	

	

}
