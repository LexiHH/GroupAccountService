package com.nationwide.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nationwide.persistence.domain.Token;
import com.nationwide.persistence.repository.TokenRepository;

import net.bytebuddy.utility.RandomString;

@Component
public class TokenService {
	
	@Autowired
	private TokenRepository repo;
	
	/**
	 * Takes in a String and creates a new blank {@link Token}. <BR>
	 * Uses the method {@link #randomString()} to make a bearer token. <BR>
	 * Assigns the given username and created bearer token to the new Token <BR>
	 * and saves this in the table.
	 * 
	 * @param username
	 * @return
	 */
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

	/**
	 * Method receives the bearer token to be updated.<br>
	 * A reference to the token containing this bearer token is created using the {@link #getByBearerToken} method.<br>
	 * The {@link #randomString} method is then called to generate a new bearer token value.<br>
	 * This new value is then assigned to the token.
	 * @param bearerToken
	 * @return Message to say if the token was not found or if it was updated
	 */
	public Token updateBearerToken(String bearerToken) {
		Token token = getByBearerToken(bearerToken);
		String bearertoken = randomString();
		token.setBearertoken(bearertoken);
		repo.flush();
		return token;
	}

	
	public Token getByBearerToken(String bearerToken){
		Token token = repo.findByBearerToken(bearerToken).orElseThrow(() -> new RuntimeException("Bearer token not found"));
		return token;
	}

}