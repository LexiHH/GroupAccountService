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
	
	@PostMapping("/{username}")
	public Token createToken(@PathVariable String username){
		return service.createToken(username);
	}
	
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
	public String updateToken(@PathVariable String bearerToken) {
		return service.updateBearerToken(bearerToken);
	}
}