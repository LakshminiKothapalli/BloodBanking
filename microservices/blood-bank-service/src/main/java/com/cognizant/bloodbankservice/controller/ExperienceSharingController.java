package com.cognizant.bloodbankservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.bloodbankservice.model.ExperienceSharing;
import com.cognizant.bloodbankservice.service.ExperienceSharingService;

@RestController
@RequestMapping("/experience")
public class ExperienceSharingController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExperienceSharingController.class);
	
	@Autowired
	ExperienceSharingService experienceSharingService;
	
	
	@PostMapping("/{userName}")
	public void experience(@RequestBody ExperienceSharing experience,@PathVariable String userName) {
		experienceSharingService.experience(experience,userName);
	}
	
	@GetMapping("")
	public List<ExperienceSharing> getExperience() {
LOGGER.info("Start-Blood Request Service");
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		LOGGER.info("Authenticate " + authentication);
		String user = authentication.getName();

		if (user.equals("anonymousUser")) {
			return experienceSharingService.getExperience();
		}
		
		return experienceSharingService.getExperience();
		
	}
}
