package com.cognizant.bloodbankservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.bloodbankservice.exception.UserAlreadyExistsException;
import com.cognizant.bloodbankservice.model.User;
import com.cognizant.bloodbankservice.repository.RoleRepository;
import com.cognizant.bloodbankservice.repository.UserRepository;
import com.cognizant.bloodbankservice.security.AppUserDetailsService;

@RequestMapping("/users")
@RestController
public class UserController {

	@Autowired
	AppUserDetailsService appUserDetailsService;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@PostMapping("")
	public String signup(@RequestBody User user) throws UserAlreadyExistsException {
		return appUserDetailsService.signup(user);

	}
}
