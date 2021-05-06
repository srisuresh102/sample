package com.cts.training.bean;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
//@Table(name="user_details")
public class User {
	@Id
//	@Column(name ="user_id")
	private Long id;
	private String username;
	private  String address;
	private Long phone;
	private String password;
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
