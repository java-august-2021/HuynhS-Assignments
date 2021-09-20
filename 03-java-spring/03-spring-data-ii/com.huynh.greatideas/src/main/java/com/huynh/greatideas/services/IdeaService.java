package com.huynh.greatideas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huynh.greatideas.models.Idea;
import com.huynh.greatideas.repositories.IdeaRepository;

@Service
public class IdeaService {
	@Autowired 
	private IdeaRepository iRepo;
	
	public List<Idea> findAllIdeas(){
		return this.iRepo.findAll();
	}
	
	public Idea createOneIdea(Idea idea) {
		return this.iRepo.save(idea);
	}
	
	public Idea findOneIdea(Long id) {
		return this.iRepo.findById(id).orElse(null);
	}
	
	public Idea updateOneIdea(Idea idea) {
		return this.iRepo.save(idea);
	}
	
	public String deleteOneIdea(Long id) {
		this.iRepo.deleteById(id);
		return id + "was deleted";
	}
}
