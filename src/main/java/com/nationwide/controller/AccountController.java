package com.nationwide.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nationwide.service.AccountService;

@RestController
@CrossOrigin("*")
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
}