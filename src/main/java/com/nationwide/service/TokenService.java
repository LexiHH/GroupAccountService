package com.nationwide.service;

import java.util.Optional;
import java.util.UUID;

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
		String bearertoken = UUID.randomUUID().toString();
		return bearertoken;
	}
	
	public void deleteToken(String bearerToken) {
		repo.delete(getByBearerToken(bearerToken));
	}
	
	public String updateBearerToken(String bearerToken) {
		Token token = getByBearerToken(bearerToken);
		if(token==null) {
			return "Token not found";
		}
		else {
		String bearertoken = randomString();
		token.setBearertoken(bearertoken);
		repo.save(token);
		return "Token Updated";
		}
	}
	
	public Token getByBearerToken(String bearerToken){
		Token token = repo.findByBearerToken(bearerToken).orElseThrow(() -> new RuntimeException("Bearer token not found"));
		return token;
	}

}