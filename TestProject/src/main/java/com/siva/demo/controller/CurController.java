package com.siva.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siva.demo.config.CurConfiguration;

@RestController
public class CurController {
	
	@Autowired
	CurConfiguration configuration;
	@GetMapping("/cur-service")
	public CurConfiguration currencyConverter() {
	
		return configuration;
	}

}
