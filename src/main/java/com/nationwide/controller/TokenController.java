package com.nationwide.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nationwide.persistence.domain.Token;
import com.nationwide.service.TokenService;

@RestController
@CrossOrigin("*")
@RequestMapping("/token")
public class TokenController {
	
	@Autowired
	private TokenService service;
	
	
	/**
	 * Takes in a String and calls the {@link #createToken(String)} method to create a new {@link Token}.
	 * @param username
	 * @return
	 */
	@PostMapping("/{username}")
	public Token createToken(@PathVariable String username){
		return service.createToken(username);
	}
	
	/**
	 * Takes in GET request and {@link bearerToken} token in URL from client and sends to Service method.
	 * @param bearerToken
	 * @return returns either error message or Token JSON object.
	 */
	@GetMapping("/{bearerToken}")
	public Token getToken(@PathVariable String bearerToken){
		return service.getByBearerToken(bearerToken);
	}
	
	@DeleteMapping("/{bearerToken}")
	public String deleteToken(@PathVariable String bearerToken) {
		service.deleteToken(bearerToken);
		return "Token Deleted";
	}
	
	@PutMapping("/{bearerToken}")
	public Token updateToken(@PathVariable String bearerToken) {
		return service.updateBearerToken(bearerToken);
	}
}