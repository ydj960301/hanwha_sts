package com.hanwha.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DeptDAO_mybatis {
	@Autowired
	SqlSession session;
	
	public List<DeptDTO> selectAll() {
		return session.selectList("com.hanwha.dept.selectAll");
	}
	
	public DeptDTO selectById(int id){
		return session.selectOne("com.hanwha.dept.selectbyid",id);
		
	}
	public int insertDept(DeptDTO d) {
		System.out.println(d);
		return session.insert("com.hanwha.dept.insertdept",d);
	}
	public int updateDept(DeptDTO d) {
		return session.update("com.hanwha.dept.update",d);
	}
	
	public int deleteDept(int d) {
		return session.delete("com.hanwha.dept.delete",d);
	}

}
