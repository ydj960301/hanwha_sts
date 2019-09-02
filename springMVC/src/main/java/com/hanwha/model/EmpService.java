package com.hanwha.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//db안가는 로직은 서비스로옴!
	

@Service
public class EmpService {
	@Autowired
	EmpDAO_mybatis dao;
	
	/*public List<EmpVO> selectbyJob(String job,int sal) {
		return dao.selectbyJob(job,sal);
	}*/
	public List<String> selectAlljob() {
		return dao.selectAlljob();
	
	}
		
	/*public List<Integer> selectAllman() {
		return dao.selectAllman();
	}
	
	public List<EmpVO> selectbyDept(int id) {
		return dao.selectbyDept(id);
	}*/
	public List<EmpVO> selectAll() {
		return dao.selectAll();
	}

	public EmpVO selectId(int id) {
		return dao.selectId(id);
	}
	public int insertEmp(EmpVO e) {
		return dao.insertEmp(e);
	}
	
	public int deleteEmp(int id) {
		return dao.deleteEmp(id);
	}

	public int updateEmpt(EmpVO e) {
		return dao.updateEmpt(e);
	}

}
