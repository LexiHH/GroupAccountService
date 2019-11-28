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

import com.nationwide.dto.ResponseTokenDto;
import com.nationwide.mapping.MyMapping;
import com.nationwide.persistence.domain.Token;
import com.nationwide.service.TokenService;

@RestController
@CrossOrigin("*")
@RequestMapping("/token")
public class TokenController {
	
	@Autowired
	private TokenService service;
	
	@Autowired
	private MyMapping myMapping;
	
	
	/**
	 * Takes in a String and calls the {@link #createToken(String)} method to create a new {@link Token}.
	 * @param username
	 * @return
	 */
	@PostMapping("/{username}")
	public ResponseTokenDto createToken(@PathVariable String username){
		Token createdToken = service.createToken(username);
		return myMapping.map(createdToken, ResponseTokenDto.class);
		
	}
	
	/**
	 * Takes in GET request and {@link bearerToken} token in URL from client and sends to Service method.
	 * @param bearerToken
	 * @return returns either error message or Token JSON object.
	 */
	@GetMapping("/{bearerToken}")
	public ResponseTokenDto getToken(@PathVariable String bearerToken){
		Token createdToken = service.getByBearerToken(bearerToken);
		return myMapping.map(createdToken, ResponseTokenDto.class);
	}
	
	@DeleteMapping("/{bearerToken}")
	public String deleteToken(@PathVariable String bearerToken) {
		service.deleteToken(bearerToken);
		return "Token Deleted";
	}
	
	@PutMapping("/{bearerToken}")
	public ResponseTokenDto udpateToken(@PathVariable String bearerToken){
		Token createdToken = service.updateBearerToken(bearerToken);
		return myMapping.map(createdToken, ResponseTokenDto.class);
	}
}