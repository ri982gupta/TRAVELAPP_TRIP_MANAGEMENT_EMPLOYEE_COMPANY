package com.sjprogramming.SpringBootDATADB.demo.persistence;

import javax.persistence.*;

@Entity
@Table(name = "Login")

public class Login {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "empId", nullable = true)
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
