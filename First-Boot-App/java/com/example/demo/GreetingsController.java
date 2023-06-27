package com.example.demo;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GreetingsController {

	@GetMapping("/hi/{userName}")
	public String wishUser(@PathVariable("userName") String userName) {
		
		String msg = "Hello "+userName+" Current Time is "+ new Date();
		System.out.println(msg);
		return msg;
	}
}
