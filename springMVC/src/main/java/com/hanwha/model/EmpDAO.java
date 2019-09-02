package com.hanwha.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Date;

import com.hanwha.util.DButil_oracle;

@Repository
public class EmpDAO {
	@Autowired
	DataSource ds;
	
	public List<EmpVO> selectbyJob(String job,int sal) {
		List<EmpVO> arr=new ArrayList<>();
		Connection con=null;
		
		PreparedStatement st=null;
		ResultSet  rs=null;
		String sql="select * from employees where job_id=? AND salary>=?";
		try {
			con=ds.getConnection();
			st = con.prepareStatement(sql);
			st.setString(1, job);//1번째 ?에 job을 넣어라
			st.setInt(2, sal); 
			rs=st.executeQuery();
			while(rs.next()) {
				int employee_id=rs.getInt("employee_id"); 
				String first_name=rs.getString("first_name"); 
				String last_name=rs.getString("last_name");
				String email=rs.getString("email");
				String phone_number=rs.getString("phone_number");
				Date hire_date=rs.getDate("hire_date");
				String job_id=rs.getString("job_id");
				int salary=rs.getInt("salary");
				double commission_pct=rs.getDouble("commission_pct"); 
				int manager_id=rs.getInt("manager_id");
				int department_id=rs.getInt("department_id");
				EmpVO emp=new EmpVO(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id);
				arr.add(emp);
			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return arr;
	}
	public List<String> selectAlljob() {
		List<String> arr=new ArrayList<>();
		Connection con=null;
		Statement st=null;
		ResultSet  rs=null;
		String sql="select * from jobs";
		try {
			con=ds.getConnection();
			st = con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()) {
				arr.add(rs.getString(1));
			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return arr;
	}
	public List<Integer> selectAllman() {
		List<Integer> arr=new ArrayList<>();
		Connection con=null;
		Statement st=null;
		ResultSet  rs=null;
		String sql="select distinct manager_id from employess";
		try {
			con=ds.getConnection();
			st = con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()) {
				arr.add(rs.getInt(1));
			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return arr;
	}
	
	public List<EmpVO> selectbyDept(int id) {
		List<EmpVO> arr=new ArrayList<>();
		Connection con=null;
		Statement st=null;
		ResultSet  rs=null;
		String sql="select * from employees where department_id="+id;
		try {
			con=ds.getConnection();
			st = con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()) {
				int employee_id=rs.getInt("employee_id"); 
				String first_name=rs.getString("first_name"); 
				String last_name=rs.getString("last_name");
				String email=rs.getString("email");
				String phone_number=rs.getString("phone_number");
				Date hire_date=rs.getDate("hire_date");
				String job_id=rs.getString("job_id");
				int salary=rs.getInt("salary");
				double commission_pct=rs.getDouble("commission_pct"); 
				int manager_id=rs.getInt("manager_id");
				int department_id=rs.getInt("department_id");
				EmpVO emp=new EmpVO(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id);
				arr.add(emp);
			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return arr;
	}
	public List<EmpVO> selectAll() {
		List<EmpVO> arr=new ArrayList<>();
		Connection con=null;
		Statement st=null;
		ResultSet  rs=null;
		String sql="select * from employees";
		try {
			con=ds.getConnection();
			st = con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()) {
				int employee_id=rs.getInt("employee_id"); 
				String first_name=rs.getString("first_name"); 
				String last_name=rs.getString("last_name");
				String email=rs.getString("email");
				String phone_number=rs.getString("phone_number");
				Date hire_date=rs.getDate("hire_date");
				String job_id=rs.getString("job_id");
				int salary=rs.getInt("salary");
				double commission_pct=rs.getDouble("commission_pct"); 
				int manager_id=rs.getInt("manager_id");
				int department_id=rs.getInt("department_id");
				EmpVO emp=new EmpVO(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id);
				arr.add(emp);
			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return arr;
	}

	public EmpVO selectId(int id) {
		EmpVO emp=null;
		Connection conn=null;
		Statement st=null;
		ResultSet  rs=null;
		String sql="select * from employees where employee_id="+id;
		try {
			conn=ds.getConnection();
			st = conn.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()) {
				int employee_id=rs.getInt("employee_id"); 
				String first_name=rs.getString("first_name"); 
				String last_name=rs.getString("last_name");
				String email=rs.getString("email");
				String phone_number=rs.getString("phone_number");
				Date hire_date=rs.getDate("hire_date");
				String job_id=rs.getString("job_id");
				int salary=rs.getInt("salary");
				double commission_pct=rs.getDouble("commission_pct"); 
				int manager_id=rs.getInt("manager_id");
				int department_id=rs.getInt("department_id");
				emp=new EmpVO(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id);
				
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return emp;
	}
	public int insertEmp(EmpVO e) {
		int result=0;
		Connection conn=null;
		String sql="insert into employees values(?,?,?,?,?,?,?,?,?,?,?) ";
		PreparedStatement st=null;
		
		
		try {
			conn=ds.getConnection();
			st=conn.prepareStatement(sql);
			st.setInt(1, e.getEmployee_id());
			st.setString(2, e.getFirst_name());
			st.setString(3, e.getLast_name());
			st.setString(4, e.getEmail());
			st.setString(5, e.getPhone_number());
			st.setDate(6, e.getHire_date());
			st.setString(7, e.getJob_id());
			st.setInt(8, e.getSalary());
			st.setDouble(9, e.getCommission_pct());
			st.setInt(10, e.getManager_id());
			st.setInt(11, e.getDepartment_id());
			
			result=st.executeUpdate();
			
			
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
		return result;
		
	}
	
	public int deleteEmp(int id) {
		
		int result=0;
		Connection conn=null;
		String sql="delete from employees where employee_id=? ";
		PreparedStatement st=null;
		
		
		try {
			conn=ds.getConnection();
			st=conn.prepareStatement(sql);
			st.setInt(1, id);
			result=st.executeUpdate();
			}
		catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
		return result;
	}

	public int updateEmpt(EmpVO e) {
		int result=0;
		Connection conn=null;
		String sql="update employees set first_name=?, "
				+ "last_name=?,  email=?, phone_number=? where employee_id=? ";
		PreparedStatement st=null;
		try {
			conn=ds.getConnection();
			st=conn.prepareStatement(sql);
			st.setString(1,e.getFirst_name());
			st.setString(2,e.getLast_name());
			st.setString(3,e.getEmail());
			st.setString(4,e.getPhone_number());
			st.setInt(5, e.getEmployee_id());
			result=st.executeUpdate();
			}
		catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
		return result;
		
	}

}
