package com.hanwha.model;

import org.springframework.web.multipart.MultipartFile;

//VO value object 라고도 많이 씀
//java beans 기술:defualt 생성자 /getter,setter
public class DeptDTO { //data transfer object 데이터전송하는 객체 형태 
	private int dept_id;
	private String deptname;
	
	
	private int department_id;
	private String department_name;
	
	MultipartFile uploadfile; 
	 
	String fileName; //파일의 경로 저장.
	
	
	public String getFileName() {
		return fileName;
	}



	public void setFileName(String fileName) {
		this.fileName = fileName;
	}



	public MultipartFile getUploadfile() {
		return uploadfile;
	}



	public void setUploadfile(MultipartFile uploadfile) {
		this.uploadfile = uploadfile;
	}



	public DeptDTO() {
		
	}
	
	
	
	public int getDepartment_id() {
		return department_id;
	}



	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
		this.dept_id = department_id;
	}



	public String getDepartment_name() {
		return department_name;
	}



	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
		this.deptname = department_name;
	}



	public DeptDTO(int dept_id,String deptname) {
		this.dept_id=dept_id;
		this.deptname=deptname;
	}
	public int getDept_id() {
		return dept_id;
	}
	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
		this.department_id=dept_id;
		
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
		this.department_name=deptname;
	}



	@Override
	public String toString() {
		return "DeptDTO [dept_id=" + dept_id + ", deptname=" + deptname + ", department_id=" + department_id
				+ ", department_name=" + department_name + ", uploadfile=" + uploadfile + ", fileName=" + fileName
				+ "]";
	}



	

	
	
	
	

}
