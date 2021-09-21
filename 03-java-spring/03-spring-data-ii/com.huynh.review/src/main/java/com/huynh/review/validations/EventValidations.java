package com.huynh.review.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.huynh.review.models.Event;
import com.huynh.review.repositories.EventRepository;





@Component
public class EventValidations {
	@Autowired
	private EventRepository rRepo;
	
	public boolean supports(Class<?> clazz) {
		return Event.class.equals(clazz);
	}
	
	public void eventValidate(Object object, Errors errors) {
		Event event = (Event)object;
		
		if(event.getName().length() < 3 || event.getName().isBlank()) {
			errors.rejectValue("name", "Event Name", "Field is required minimum of 3 characters");
		}
		
		if(event.getLocation().length() < 3 || event.getLocation().isBlank()) {
			errors.rejectValue("location", "Event Location", "Field is required minimum of 3 characters");
		}
		
		if(event.getState().isBlank()) {
			errors.rejectValue("state", "Event State", "Field is required");
		}
	}
	
}
