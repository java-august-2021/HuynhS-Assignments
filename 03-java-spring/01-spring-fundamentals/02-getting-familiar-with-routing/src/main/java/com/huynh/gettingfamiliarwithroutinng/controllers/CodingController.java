package com.huynh.gettingfamiliarwithroutinng.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class CodingController {
	@RequestMapping("/coding")
	private String coding() {
		return "Hello Coding Dojo!";
	};
	
	@RequestMapping("/coding/python")
	private String codingpython() {
		return "Python/Django was awesome!";
	};
	
	@RequestMapping("/coding/java")
	private String codingjava() {
		return "Java/Spring is better!";
	};
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
