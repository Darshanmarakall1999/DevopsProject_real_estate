package com.thbs.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.thbs.models.User;
import com.thbs.repo.UserRepository;
@Service
public class UserServiceImpl implements UserServices {
	@Autowired
	UserRepository userRepository;
	
	@Override
	public ResponseEntity<User> profile(String username) {
		// TODO Auto-generated method stub
		Optional<User> p = userRepository.findById(username);
		if (p != null) {
			User user = p.get();
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}
	
	@Override
	public ResponseEntity<User> unregister(String username) {
		// TODO Auto-generated method stub
		userRepository.deleteById(username);
		if (userRepository.existsById(username))
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}

	@Override
	public String registerUser(User user) {
		// TODO Auto-generated method stub
		Optional<User> searchUser = userRepository.findById(user.getUsername());
		if (searchUser.isPresent()) {
			User userFound = searchUser.get();
			return "sameusername";

		} else {
			/* user.setPassword(user.getPassword()); */
			User saveUser = userRepository.save(user);
			return "index";
		}
	}

	@Override
	public String login(String username,String password) {
		// TODO Auto-generated method stub
		Optional<User> searchUser = userRepository.findById(username);
		if (searchUser.isPresent()) {
			User userFromDb = searchUser.get();
			if (password.equals(userFromDb.getPassword())) {

				return "estate_details";
			} else {
				return "index";
			}

		} else
			return "index";
	}

}
