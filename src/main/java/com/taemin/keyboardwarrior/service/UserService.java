package com.taemin.keyboardwarrior.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taemin.keyboardwarrior.model.User;
import com.taemin.keyboardwarrior.repository.UserRepository;
import com.taemin.keyboardwarrior.service.impl.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User modifyUser(User user) {
		return userRepository.save(user);		
	}

	@Override
	public User getUser(String userId) throws Exception {
		User user = userRepository.findById(userId).get();
		if(user == null)
			throw new Exception(userId + " is not exist");
		return user;
	}
	@Override
	public void deleteUser(String userId) {
		userRepository.deleteById(userId);
		
	}
	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	

}
