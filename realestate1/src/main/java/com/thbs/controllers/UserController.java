package com.thbs.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.thbs.constantProperties.UserConstants;
import com.thbs.models.User;
import com.thbs.models.house;
import com.thbs.repo.UserRepository;
import com.thbs.services.UserServiceImpl;
import com.thbs.services.UserServices;

@Controller
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserServices userService;

	@Autowired
	UserRepository userRepository;
	@Autowired
	MainController mc;

	@RequestMapping(value =UserConstants.REGISTER, method = RequestMethod.POST)
	public String Save(User u) {
		String registerUser= mc.registerUser(u);
		return registerUser;
	}

	/*
	 * @RequestMapping(value =UserConstants.LOGIN, method = RequestMethod.POST)
	 * public String loginUser(String username, String password) { String loginUser=
	 * userService.login(username,password); return loginUser; }
	 */
	@GetMapping(UserConstants.USERPROFILE)
	public ResponseEntity<User> getAUserById(@PathVariable String username) {
		ResponseEntity<User> userProfile = userService.profile(username);
		return userProfile;
	}

	@DeleteMapping(UserConstants.UNREGISTER)
	public ResponseEntity<User> DeleteUserById(@PathVariable String username) {
		ResponseEntity<User> deleteUser = userService.unregister(username);
		return deleteUser;
	}
	
	/*
	 * @GetMapping(UserConstants.GETAHOUSEBYID) public house getAHouseById(int pid)
	 * { String house= return null;
	 * 
	 * }
	 */
	

	/*
	 * @PatchMapping("/reset/{username}") public ResponseEntity<User>
	 * UpdatePassword(@PathVariable String username, String password) {
	 * Optional<User> u = userRepository.findById(username);
	 * u1.setPassword(password);
	 * 
	 * return new ResponseEntity<User>(u1, HttpStatus.OK); }
	 */

}
