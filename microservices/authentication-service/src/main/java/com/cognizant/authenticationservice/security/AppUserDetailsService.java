package com.cognizant.authenticationservice.security;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cognizant.authenticationservice.exception.UserAlreadyExistsException;
import com.cognizant.authenticationservice.model.Role;
import com.cognizant.authenticationservice.model.User;
import com.cognizant.authenticationservice.repository.RoleRepository;
import com.cognizant.authenticationservice.repository.UserRepository;

@Service
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(AppUserDetailsService.class);

	public AppUserDetailsService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Bean
	public PasswordEncoder encodePassword() {
		LOGGER.info("Start");
		return new BCryptPasswordEncoder();
	}

	@Override
	public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		LOGGER.info("Start of loadUserByUsername");
		LOGGER.debug("UserRepository:{}", userRepository);
		userRepository.findByUsername(user);
		LOGGER.debug("User:{}", user);

		if (user == null) {
			throw new UsernameNotFoundException("Username not found");
		}

		else {
			AppUser appUser = new AppUser(userRepository.findByUsername(user));
			return appUser;
		}
	}

	public String signup(User signedUser) throws UserAlreadyExistsException {
		LOGGER.info("Start of signup");
		System.err.println(signedUser);
		User userCheck = userRepository.findByUsername(signedUser.getUsername());
		if (userCheck == null) {
			User user = new User();
			user.setUsername(signedUser.getUsername());
			user.setFirstname(signedUser.getFirstname());
			user.setLastname(signedUser.getLastname());
			user.setAge(signedUser.getAge());
			user.setGender(signedUser.getGender());
			user.setBloodgroup(signedUser.getBloodgroup());
			user.setContactNo(signedUser.getContactNo());
			user.setEmail(signedUser.getEmail());
			user.setWeight(signedUser.getWeight());
			user.setPassword(encodePassword().encode(signedUser.getPassword()));
			user.setArea(signedUser.getArea());
			user.setState(signedUser.getState());
			user.setPincode(signedUser.getPincode());
			Role role = roleRepository.findByName("USER");
			Set<Role> roles = new HashSet<>();
			roles.add(role);
			user.setRoleList(roles);
			userRepository.save(user);
			return "true";

		} else {
			return "false";

		}

	}
}
