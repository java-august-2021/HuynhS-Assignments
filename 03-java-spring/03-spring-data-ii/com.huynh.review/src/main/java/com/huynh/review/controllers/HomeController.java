package com.huynh.review.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.huynh.review.models.Event;
import com.huynh.review.models.Message;
import com.huynh.review.models.User;
import com.huynh.review.services.EventService;
import com.huynh.review.services.MessageService;
import com.huynh.review.services.UserService;
import com.huynh.review.validations.EventValidations;
import com.huynh.review.validations.UserValidations;

@Controller
public class HomeController {
	@Autowired
	private UserService uService;

	@Autowired
	private UserValidations validation;
	
	@Autowired
	private EventService eService;
	

	
	//index page

	@GetMapping("/")
	public String home(@ModelAttribute("user") User user) {
		return "home.jsp";
	}
	//user register
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		validation.validate(user, result);
		if(result.hasErrors()) {
			return "redirect:/";
		}else {
			User newUser = this.uService.registerAUser(user);
			session.setAttribute("user__id", newUser.getId());
			return "redirect:/events";
		}
	}
	
	//login
	@PostMapping("/login")
	public String userLogin(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session, RedirectAttributes redirect) {
		if(!this.uService.authenticateUser(email, password)) {
			redirect.addFlashAttribute("error", "Invalid Credentials");
			return "redirect:/";
		}else {
			User user = this.uService.findUserByEmail(email);
			session.setAttribute("user__id", user.getId());
			return "redirect:/events";
		}
	}
	
	//logout
	@PostMapping("/logout")
	public String personLogout(HttpSession session, RedirectAttributes redirect) {
		if(session.getAttribute("user__id") == null) {
			redirect.addFlashAttribute("error", "Please login to use this function");
			return "redirect:/";
		}else {
			session.invalidate();
			return "redirect:/";
		}
	}
	
	//events page
	
	public static String[] states = {
			"CA", "WA", "NV", "NY", "FL"
	};
	
	@GetMapping("/events")
	public String events(@ModelAttribute("event") Event event, HttpSession session, Model model) {
		User loggedInUser = this.uService.findOneUser((Long)session.getAttribute("user__id"));
		if(loggedInUser == null) {
			return "redirect:/";
		}else {
		model.addAttribute("user", loggedInUser.getId());
		model.addAttribute("loggedInUser", loggedInUser);
		List<Event> allEvents = this.eService.findAllEvents();
		model.addAttribute("allEvents", allEvents);
		List<Event> inStates = this.eService.findInStateEvents(loggedInUser.getState());
		model.addAttribute("instates", inStates);
		List<Event> outOfStates = this.eService.findOutOfStateEvents(loggedInUser.getState());
		model.addAttribute("outOfStates", outOfStates);
		model.addAttribute("states", states);
		return "events.jsp";
		}
	}
	/*
	@PostMapping("/addEvent")
	public String addEvent(@Valid @ModelAttribute("event") Event event, BindingResult result, HttpSession session) {
		eventValidation.eventValidate(event, result);
		if(result.hasErrors()) {
			return "events.jsp";
		}else {
			Event newEvent = this.eService.createOneEvent(event);
			System.out.println("success");
			return "redirect:/events";
		}
	}*/
	
	@PostMapping("/addEvent")
	public String addEvent(@Valid @ModelAttribute("event") Event event, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			System.out.println("error");
			return "redirect:/events";
		}else {
			this.eService.createOneEvent(event);
			System.out.println("success");
			return "redirect:/events";
		}
	}
	
	
	//delete event
	@GetMapping("/events/deletePage/{id}")
	public String deleteAnEvent(@PathVariable("id") Long id, HttpSession session, Model model) {
		if(session.getAttribute("user__id") == null) {
			return "redirect:/";
		}
		else {
			model.addAttribute("event", this.eService.findOneEvent(id));
			return "delete.jsp";
		}
	}
	
	@PostMapping("/delete/{id}")
	public String deleteEvent(@PathVariable("id") Long id, HttpSession session) {
		if(session.getAttribute("user__id") == null) {
			return "redirect:/";
		}else {
			this.eService.deleteOneEvent(id);
			return "redirect:/events";
		}
	}
	
	
	//edit event
	@GetMapping("/events/editPage/{id}")
	public String editEventPage(@ModelAttribute("event") Event event, @PathVariable("id") Long id, HttpSession session, Model model) {
		if(session.getAttribute("user__id") == null) {
			return "redirect:/";
		}
			Event eventToBeEdit = this.eService.findOneEvent(id);
			model.addAttribute("event", eventToBeEdit);
			return "edit.jsp";
	}
	
	
	
	@PostMapping("/editEvent/{id}")
	public String editEvent(@Valid @ModelAttribute("event") Event event, BindingResult result, HttpSession session) {
		if(session.getAttribute("user__id") == null) {
			return "redirect:/";
		}
		if(result.hasErrors()) {
			return "edit.jsp";
		}else {
			this.eService.editOneEvent(event);
			return "redirect:/events";
		}
	}
	
	//Event Detail
	@GetMapping("/events/{id}")
	public String eventDetail(@PathVariable("id") Long id, HttpSession session, Model model) {
		if(session.getAttribute("user__id") == null) {
			return "redirect:/";
		}
		User currentUser = this.uService.findOneUser((Long)session.getAttribute("user__id"));
		model.addAttribute("user", currentUser);
		Event e = this.eService.findOneEvent(id);
		model.addAttribute("e", e);
		return "detail.jsp";
	}
	
	@PostMapping("/message/{id}")
	public String addMessage(@PathVariable("id") Long id, HttpSession session, @RequestParam("eventMsg") String message, RedirectAttributes redirect) {
		Long userID = (Long) session.getAttribute("user__id");
		if(userID == null) {
			return "redirect:/";
		}
		if(message.isBlank()) {
			redirect.addFlashAttribute("error", "Field cannot be empty");
			return "redirect:/events/" + id;
		}
		if(message.length() < 3) {
			redirect.addFlashAttribute("error", "Field is required minimum 3 characters");
			return "redirect:/events/"+id;
		}
		
		Event thisEvent = this.eService.findOneEvent(id);
		User thisUser = this.uService.findOneUser(userID);
		this.eService.message(message, thisEvent, thisUser);
		System.out.println("success");
		return "redirect:/events/" + id;
		
	}

	
	@GetMapping("/userJoinEvent/{id}")
	public String joinEvent(HttpSession session, @PathVariable("id") Long eventID) {
		User loggedInUser = this.uService.findOneUser((Long)session.getAttribute("user__id"));
		if(loggedInUser == null) {
			return "redirect:/";
		}
		Event eventWaitingTobeJoined = this.eService.findOneEvent(eventID);
		User userWhoIsJoiningEvent = this.uService.findOneUser(loggedInUser.getId());
		this.eService.userJoinsEvent(eventWaitingTobeJoined, userWhoIsJoiningEvent);
		return "redirect:/events";
	}
	
	@GetMapping("/userLeaveEvent/{id}")
	public String leaveEvent(HttpSession session, @PathVariable("id") Long eventID) {
		User loggedInUser = this.uService.findOneUser((Long)session.getAttribute("user__id"));
		if(loggedInUser == null) {
			return "redirect:/";
		}
		Event eventWaitingTobeJoined = this.eService.findOneEvent(eventID);
		User userWhoIsJoiningEvent = this.uService.findOneUser(loggedInUser.getId());
		this.eService.userLeavesEvent(eventWaitingTobeJoined, userWhoIsJoiningEvent);
		System.out.println("success");
		return "redirect:/events";
	}
	
	
	
	
	
	
	
	
}
