package com.encora.security.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class DemoController {

	@GetMapping("/hi")
	public String sayHello() {
		
		return  "Hello User how are you?";
	}
	
	@GetMapping("/welcome")
	public String unprotectedAPI() {
		return "This is unprotected API";
	}
	
	@GetMapping("/revenue")
	@Secured("ROLE_ADMIN")
	public String revenueDetails() {
		return "Your revenue for the month is 20 Million USD";
	}
	
}
