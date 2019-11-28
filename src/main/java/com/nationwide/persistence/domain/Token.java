package com.nationwide.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
public class Token{
	
	@Id
	@GeneratedValue
	private long id;
	private String username;
	private String bearertoken;
	
	public Token() {
	}

	public Token(long id, String username, String bearertoken) {
		this.id = id;
		this.username = username;
		this.bearertoken = bearertoken;
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

	public String getBearertoken() {
		return bearertoken;
	}

	public void setBearertoken(String bearertoken) {
		this.bearertoken = bearertoken;
	}
	
}