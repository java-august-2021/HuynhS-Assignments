package com.huynh.overflow.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.huynh.overflow.models.Answer;
import com.huynh.overflow.models.Question;
import com.huynh.overflow.service.OverflowService;
import com.huynh.overflow.validators.TagValidator;

@Controller
public class HomeController {
	@Autowired
	private OverflowService oService;
	@Autowired
	private TagValidator validator;
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("allQuestions", this.oService.getAllQuestions());
		return "dashboard.jsp";
	}
	
	@GetMapping("/new")
	public String newQuestion(@ModelAttribute("question") Question question) {
		return "new.jsp";
	}
	
	@PostMapping("newQuestion")
	public String addQuestion(@Valid @ModelAttribute("question") Question question, BindingResult result) {
		validator.validate(question, result);
		if(result.hasErrors()) {
			return "new.jsp";
		}else {
			this.oService.createQuestion(question);
			return "redirect:/";
		}
		
	}
	
	@GetMapping("/show/{id}")
	public String show(@PathVariable("id") Long id, Model model, @ModelAttribute("answer") Answer answer) {
		model.addAttribute("question", this.oService.findOneQuestion(id));
		return "question.jsp";
		
	}
	
	@PostMapping("/addAnswer")
	public String addAnswer(@Valid @ModelAttribute("answer") Answer answer, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("question", this.oService.findOneQuestion(answer.getQuest().getId()));
			return "question.jsp";
		}
		this.oService.createAnswer(answer);
		return "redirect:/show/" + answer.getQuest().getId();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
