package com.cos.blog.test;

public class Member {
	private int id;
	private String username;
	private int password;
	private String email;
	//
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Member(int id, String username, int password, String email) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}	
}
