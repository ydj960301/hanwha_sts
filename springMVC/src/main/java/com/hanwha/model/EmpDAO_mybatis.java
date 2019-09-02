package com.hanwha.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Date;

import com.hanwha.util.DButil_oracle;

@Repository
public class EmpDAO_mybatis {
	@Autowired
	SqlSession s;
	
	
	public List<String> selectAlljob() {
		return s.selectList("com.hanwha.emp.selectalljob");
	
	}
		
	public List<EmpVO> selectAll() {
		return s.selectList("com.hanwha.emp.selectAll");
	}

	public EmpVO selectId(int id) {
		return s.selectOne("com.hanwha.emp.selectbyid",id);
	}
	public int insertEmp(EmpVO e) {
		return s.insert("com.hanwha.emp.insert",e);
	}
	
	public int deleteEmp(int id) {
		return s.delete("com.hanwha.emp.delete",id);
	}

	public int updateEmpt(EmpVO e) {
		return s.update("com.hanwha.emp.update",e);
	}

}
