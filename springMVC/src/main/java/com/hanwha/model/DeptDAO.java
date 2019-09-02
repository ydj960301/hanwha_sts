package com.hanwha.model;

import java.sql.*;
import java.util.*;
import java.util.Date;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hanwha.util.DButil_oracle;

/*
 * DAO(Data Access Object): �����Ͻ� ����
 
 */
@Repository //component��� �ǹ̿� ���� xml������ bin�ִ°�!!!
//<bin id=:deptDAO" class="com.~~"/> �̷��� xml���� ���ִ°Ͱ� �����ǹ� 
public class DeptDAO {
	@Autowired
	DataSource ds;
	
	public List<DeptDTO> selectAll() {
		
		//�μ������� ���� �����Ͷ�
		List<DeptDTO> arr=new ArrayList<>();
		Connection conn=null;
		Statement st=null; //������ st�� �����Ҽ��־���ϴ� �ۿ��� ����.
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
		//Ư�� �μ� �˻�
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
