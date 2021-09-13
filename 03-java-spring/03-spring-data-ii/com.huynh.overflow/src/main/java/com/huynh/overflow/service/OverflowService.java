package com.huynh.overflow.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huynh.overflow.models.Answer;
import com.huynh.overflow.models.Question;
import com.huynh.overflow.models.Tag;
import com.huynh.overflow.repository.AnswerRepository;
import com.huynh.overflow.repository.QuestionRepository;
import com.huynh.overflow.repository.TagRepository;

@Service
public class OverflowService {

	@Autowired
	private AnswerRepository aRepo;
	@Autowired
	private QuestionRepository qRepo;
	@Autowired
	private TagRepository tagRepo;
	
	public Tag getOneTag(String subject) {
		return this.tagRepo.findBySubject(subject);
	}
	
	
	public ArrayList<Tag> splitTags(String tags) {
		ArrayList<Tag> tagsForQuestion = new ArrayList<Tag>();
		String[] tagsToProcess = tags.split(", ");
		
		for(String s : tagsToProcess) {
			if(this.tagRepo.existsBySubject(s)) {
				Tag tagToAdd = this.getOneTag(s);
				tagsForQuestion.add(tagToAdd);
			}else {
				Tag newTag = new Tag();
				newTag.setSubject(s);
				this.tagRepo.save(newTag);
				tagsForQuestion.add(this.getOneTag(s));
			}
		}
		return tagsForQuestion;

	}
	
	public Question createQuestion(Question question) {
		question.setTags(this.splitTags(question.getTagsFromFrontEnd()));
		return this.qRepo.save(question);
	}
	
	public Answer createAnswer(Answer answer) {
		return this.aRepo.save(answer);
	}
	
	public List<Question> getAllQuestions(){
		return this.qRepo.findAll();
	}
	
	
	public Question findOneQuestion(Long id) {
		return this.qRepo.findById(id).orElse(null);
	} 
	
}
