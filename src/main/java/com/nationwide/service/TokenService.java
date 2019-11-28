package com.nationwide.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.nationwide.persistence.domain.Token;
import com.nationwide.persistence.repository.TokenRepository;

@Component
public class TokenService {
	
	@Autowired
	private TokenRepository repo;
	
	public Token createToken(String username){
		String bearertoken = randomString();
		Token t = new Token();
		t.setUsername(username);
		t.setBearertoken(bearertoken);
		return repo.save(t);
	}
	
	private String randomString() {
		return "random";
	}

	public void deleteToken(String deleteToken) {	
	}
}