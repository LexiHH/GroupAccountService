package com.nationwide.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Entity
public class Account{
	@Id
	@GeneratedValue
	private long id;
	private String username;
	private String password;
	
	public Account() {
	}
	
	public Account(long id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}