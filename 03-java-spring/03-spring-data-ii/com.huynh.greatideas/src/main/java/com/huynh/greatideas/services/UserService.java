package com.huynh.greatideas.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huynh.greatideas.models.Idea;
import com.huynh.greatideas.models.User;
import com.huynh.greatideas.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository uRepo;
	
	
	public User findUserByEmail(String email) {
		return this.uRepo.findByEmail(email);
	}
	
	public User findOneUser(Long id) {
		return this.uRepo.findById(id).orElse(null);
	}
	
	public User registerAUser(User user) {
		String hashedpw = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(10));
		user.setPassword(hashedpw);
		return this.uRepo.save(user);
	}
	
	public boolean authenticateUser(String email, String password ) {
		User user = this.uRepo.findByEmail(email);
		if(user==null) {
			return false;
		}else {
			return BCrypt.checkpw(password, user.getPassword());
		}
	}
	
	public User userLikesIdea(Idea idea, User user) {
		List<Idea> listOfIdeasLikedByUser = user.getIdeasLiked();
		listOfIdeasLikedByUser.add(idea);
		return this.uRepo.save(user);

	}
	public User userunLikeIdea(Idea idea, User user) {
		List<Idea> listOfIdeasLikedByUser = user.getIdeasLiked();
		listOfIdeasLikedByUser.remove(idea);
		return this.uRepo.save(user);

	}
	
}
