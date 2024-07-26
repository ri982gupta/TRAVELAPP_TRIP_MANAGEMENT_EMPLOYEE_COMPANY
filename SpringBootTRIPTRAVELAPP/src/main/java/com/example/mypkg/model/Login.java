package com.example.mypkg.model;

public class Login {
	private Long id;
	private String email;
	private String password;
	private Long empId;
	
	public Login() {
		
	}
	
	public Login(Long id, String email, String password, Long empId) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.empId = empId;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	
}
