package com.huynh.review.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {
	@GetMapping("/employee")
	public String eForm() {
		return "employeeForm.jsp";
	}
}
