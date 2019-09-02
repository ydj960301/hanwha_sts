package com.hanwha.util;

import java.sql.*;

public class DButil_oracle {

	public static Connection getConnect() {
		//String url="jdbc:oracle:thin:@192.168.0.31:1521:xe";
		String url="jdbc:oracle:thin:@localhost:1521:HWORACLE";
		String user="hr";
		String pw="hr";
		Connection conn=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			conn=DriverManager.getConnection(url,user,pw);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	public static void DBclose(ResultSet rs,Connection conn, Statement st) {
		try {
			if(rs!=null) rs.close();
			if(conn!=null) conn.close();
			if(st!=null) st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
