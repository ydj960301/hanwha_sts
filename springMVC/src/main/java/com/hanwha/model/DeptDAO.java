package com.hanwha.model;

import java.sql.*;
import java.util.*;
import java.util.Date;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hanwha.util.DButil_oracle;

/*
 * DAO(Data Access Object): 비지니스 로직
 
 */
@Repository //component라는 의미와 같음 xml문서에 bin넣는것!!!
//<bin id=:deptDAO" class="com.~~"/> 이렇게 xml문서 해주는것과 같은의미 
public class DeptDAO {
	@Autowired
	DataSource ds;
	
	public List<DeptDTO> selectAll() {
		
		//부서정보를 전부 가져와라
		List<DeptDTO> arr=new ArrayList<>();
		Connection conn=null;
		Statement st=null; //닫을때 st에 접근할수있어야하니 밖에서 선언.
		ResultSet rs=null;
		String sql="select * from departments ";
		try {
			conn=ds.getConnection();
			st=conn.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()) {
				int deptid=rs.getInt("department_id");
				String dname=rs.getString("department_name");
				DeptDTO dept=new DeptDTO(deptid,dname);
				arr.add(dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			DButil_oracle.DBclose(rs, conn, st);
		}
		
		return arr;
		
	}
	
	public DeptDTO selectById(int id){
		//특정 부서 검색
		DeptDTO dept=null;
		Connection conn=null;
		String sql="select * from departments where department_id="+id;
		Statement st=null;
		ResultSet rs=null;
		try {
			conn=ds.getConnection();
			st = conn.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()) {
				int deptid=rs.getInt("department_id");
				String dname=rs.getString("department_name");
				dept=new DeptDTO(deptid,dname);
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			DButil_oracle.DBclose(rs, conn, st);
		}
		
		return dept;
		
		
	}

	public int insertDept(DeptDTO d) {
		int result=0;
		Connection conn=null;
		PreparedStatement st=null;
		String sql="insert into departments (department_id,department_name) values(?,?)";
		try {
			conn=ds.getConnection();
			st=conn.prepareStatement(sql);
			st.setInt(1,d.getDept_id());
			st.setString(2,d.getDeptname());
			result=st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	public int updateDept(DeptDTO d) {
		int result=0;
		Connection conn=null;
		PreparedStatement st=null;
		String sql="update departments set department_name=? where department_id=?";
		try {
			conn=ds.getConnection();
			st=conn.prepareStatement(sql);
			st.setInt(2,d.getDept_id());
			st.setString(1,d.getDeptname());
			result=st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return result;
	}
	public int deleteDept(int d) {
		int result=0;
		Connection conn=null;
		PreparedStatement st=null;
		String sql="delete from departments where department_id=?";
		try {
			conn=ds.getConnection();
			st=conn.prepareStatement(sql);
			st.setInt(1,d);
			result=st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return result;
	}

}
