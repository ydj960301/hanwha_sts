package com.hanwha.myapp;

public class UserDTO {
	Integer pw;
	String username;
	String userid;
	public Integer getPw() {
		return pw;
	}
	public void setPw(Integer pw) {
		this.pw = pw;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getId() {
		return userid;
	}
	public void setId(String id) {
		this.userid = id;
	}
	@Override
	public String toString() {
		return "UserDTO [pw=" + pw + ", username=" + username + ", id=" + userid + "]";
	}
	
	
	
	

}
