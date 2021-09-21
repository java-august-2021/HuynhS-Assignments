package com.huynh.review.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huynh.review.models.Event;
import com.huynh.review.models.EventMessage;
import com.huynh.review.models.User;
import com.huynh.review.repositories.EventMessageRepository;
import com.huynh.review.repositories.EventRepository;


@Service
public class EventService {
	@Autowired
	private EventRepository eRepo;

	@Autowired
	private EventMessageRepository emRepo;
	
	
	public List<Event> findAllEvents(){
		return this.eRepo.findAll();
	}
	
	public Event createOneEvent(Event event) {
		return this.eRepo.save(event);
	}
	
	public Event findOneEvent(Long id) {
		return this.eRepo.findById(id).orElse(null);
	}
	
	public Event editOneEvent(Event event){
		return this.eRepo.save(event);
	}
	
	public String deleteOneEvent(Long id) {
		this.eRepo.deleteById(id);
		return id + "was deleted";
	}
	
	public List<Event> findInStateEvents(String state){
		return this.eRepo.findByState(state);
	}
	
	public List<Event> findOutOfStateEvents(String state){
		return this.eRepo.findByStateIsNot(state);
	}


	public Event userJoinsEvent(Event event, User user) {
		List<User> userWhoJoins = event.getJoinners();
		userWhoJoins.add(user);
		return this.eRepo.save(event);
	}
	public Event userLeavesEvent(Event event, User user) {
		List<User> userWhoJoins = event.getJoinners();
		userWhoJoins.remove(user);
		return this.eRepo.save(event);
	}
	
	public void message(String comment,Event event, User user) {
		this.emRepo.save(new EventMessage(comment,event, user));
	}
	

}
