package com.cognizant.bloodbankservice.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.bloodbankservice.controller.BloodRequestController;
import com.cognizant.bloodbankservice.model.BloodRequest;
import com.cognizant.bloodbankservice.model.ExperienceSharing;
import com.cognizant.bloodbankservice.model.User;
import com.cognizant.bloodbankservice.repository.ExperienceSharingRepository;
import com.cognizant.bloodbankservice.repository.UserRepository;

@Service
public class ExperienceSharingService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ExperienceSharingService.class);

	@Autowired
	ExperienceSharingRepository experienceSharingRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Transactional
	public void experience(ExperienceSharing experience,String userName) {
		User user = userRepository.findByUsername(userName);
		experience.setUserId(user);
		experienceSharingRepository.save(experience);
	}
	
	@Transactional
	public List<ExperienceSharing> getExperience() {
		LOGGER.info("Start-ExperienceSharing Service");
		return experienceSharingRepository.findAll();
	}
	
}
