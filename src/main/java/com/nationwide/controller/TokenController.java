package com.nationwide.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nationwide.persistence.domain.Token;
import com.nationwide.service.TokenService;

@RestController
@CrossOrigin("*")
@RequestMapping("/account")
public class TokenController {
	
	@Autowired
	private TokenService service;
	
	@PostMapping("/saveToken/{username}")
	public Token createToken(@PathVariable String username){
		return service.createToken(username);
	}
	
}