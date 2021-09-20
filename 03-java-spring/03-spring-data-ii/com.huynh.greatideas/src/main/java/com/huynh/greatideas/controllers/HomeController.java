package com.huynh.greatideas.controllers;

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

import com.huynh.greatideas.models.Idea;
import com.huynh.greatideas.models.User;
import com.huynh.greatideas.services.IdeaService;
import com.huynh.greatideas.services.UserService;
import com.huynh.greatideas.validations.UserValidations;


@Controller	
public class HomeController {
	@Autowired
	private UserService uService;
	
	@Autowired
	private UserValidations validator;
	
	@Autowired
	private IdeaService iService;
	
	@GetMapping("/")
	public String home(@ModelAttribute("user") User user) {
		return "index.jsp";
	}
	
	//user register
	@PostMapping("/register")
	public String userRegister(
			@Valid
			@ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		validator.validate(user, result);
		if(result.hasErrors()) {
			return "index.jsp";
		}else {
			User newUser = (User) this.uService.registerAUser(user);
			session.setAttribute("user__id", newUser.getId());
			return "ideas.jsp";
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
			return "redirect:/ideas";
		}
	}
	//ideas
	@GetMapping("/ideas")
	public String ideas(Model model, HttpSession session) {
		if(session.getAttribute("user__id") == null) {
			return "redirect:/";	
		}
		else {
			Long loggedInUser = (Long)session.getAttribute("user__id");
			model.addAttribute("userWhoLiked", this.uService.findOneUser(loggedInUser));
			List<Idea> ideas = this.iService.findAllIdeas();
			model.addAttribute("ideas", ideas);
			return "ideas.jsp";
		}
	}
	//new page
	@GetMapping("/ideas/new")
	public String newIdea(Model model, HttpSession session, @ModelAttribute("idea") Idea idea) {
		if(session.getAttribute("user__id") == null) {
			return "redirect:/";	
		}
		else {
			Long loggedInUser = (Long)session.getAttribute("user__id");
			User user = this.uService.findOneUser(loggedInUser);
			model.addAttribute("user", user);
			return "new.jsp";
		}
	}
	//create idea
	@PostMapping("/ideas/create")
	public String createNewIdea(HttpSession session, @Valid @ModelAttribute("idea") Idea idea, BindingResult result, RedirectAttributes redirect) {
		if(session.getAttribute("user__id") == null) {
			return "redirect:/";	
		}
		if(result.hasErrors()) {
			return "new.jsp";
		}
		else {
			this.iService.createOneIdea(idea);
			return "redirect:/ideas";
		}
	}
	//delete idea
	@GetMapping("/ideas/{id}/delete")
	public String deleteOneIdea(HttpSession session, @PathVariable("id") Long id) {
		if(session.getAttribute("user__id") == null) {
			return "redirect:/";	
		}
		else {
			this.iService.deleteOneIdea(id);
			return "redirect:/ideas";
		}
	}
	
	// get one single idea
	@GetMapping("/ideas/{id}")
	public String ideaDetail(HttpSession session, @PathVariable("id") Long id, Model model) {
		if(session.getAttribute("user__id") == null) {
			return "redirect:/";	
		}
		else {
			Long loggedInUser = (Long)session.getAttribute("user__id");
			User user = this.uService.findOneUser(loggedInUser);
			model.addAttribute("user", user);
			Idea idea = this.iService.findOneIdea(id);
			model.addAttribute("idea", idea);
			return "idea.jsp";
		}
	}
	//edit page
	@GetMapping("/ideas/{id}/edit")
	public String editIdeaPage(HttpSession session,@PathVariable("id") Long id, Model model,@ModelAttribute("idea") Idea idea) {
		if(session.getAttribute("user__id") == null) {
			return "redirect:/";	
		}

		else {
			Idea ideaToBeEdited = this.iService.findOneIdea(id);
			model.addAttribute("idea", ideaToBeEdited);
			return "edit.jsp";
			
		}
	}
	//update
	@PostMapping("/ideas/{id}/update")
	public String ideaUpdate(@Valid @ModelAttribute("event") Idea idea, BindingResult result, HttpSession session) {
		if(session.getAttribute("user__id") == null) {
			return "redirect:/";
		}
		if(result.hasErrors()) {
			return "edit.jsp";
		}else {
			this.iService.updateOneIdea(idea);
			return "redirect:/ideas";
		}
	}
	
	//like
	@GetMapping("/ideas/{id}/like")
	public String like(HttpSession session, @PathVariable("id") Long id) {
		if(session.getAttribute("user__id") == null) {
			return "redirect:/";
		}
		else {
			User currentLikedUser = this.uService.findOneUser((Long)session.getAttribute("user__id"));
			Idea ideaToBeLiked = this.iService.findOneIdea(id);
			this.uService.userLikesIdea(ideaToBeLiked, currentLikedUser);
			return "redirect:/ideas";
		}
	}
	//unlike
	@GetMapping("/ideas/{id}/unlike")
	public String unlike(HttpSession session, @PathVariable("id") Long id) {
		if(session.getAttribute("user__id") == null) {
			return "redirect:/";
		}
		else {
			User currentLikedUser = this.uService.findOneUser((Long)session.getAttribute("user__id"));
			Idea ideaToBeLiked = this.iService.findOneIdea(id);
			this.uService.userunLikeIdea(ideaToBeLiked, currentLikedUser);
			return "redirect:/ideas";
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
	
	
	
}
