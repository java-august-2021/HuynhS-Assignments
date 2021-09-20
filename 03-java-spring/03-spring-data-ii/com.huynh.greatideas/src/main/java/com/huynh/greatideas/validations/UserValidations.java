package com.huynh.greatideas.validations;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.huynh.greatideas.models.User;
import com.huynh.greatideas.repositories.UserRepository;



@Component
public class UserValidations {
	@Autowired
	private UserRepository uRepo;
	
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}
	
	public void validate(Object target, Errors errors) {
		User user = (User)target;
		//passwords
		if(!user.getPassword().equals(user.getConfirmPassword())) {
			errors.rejectValue("password", "Incorrect Password", "Passwords do not match");
		}
		
		//email
		
		if(this.uRepo.existsByEmail(user.getEmail())) {
			errors.rejectValue("email", "Email exists", "Email already exists");
		}
	
		//first name
		if(user.getFirstName().length() < 3 || user.getFirstName().isBlank()) {
			errors.rejectValue("firstName", "First Name Error", "Field is required minimum 3 characters");
		}
		
		//last name
		if(user.getLastName().length() < 3 || user.getLastName().isBlank()) {
			errors.rejectValue("lastName", "Last Name Error", "Field is required minimum 3 characters");
		}
		
	}
}
