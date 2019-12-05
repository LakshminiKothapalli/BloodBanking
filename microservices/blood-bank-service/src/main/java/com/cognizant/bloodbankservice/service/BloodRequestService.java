package com.cognizant.bloodbankservice.service;


import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cognizant.bloodbankservice.model.BloodRequest;
import com.cognizant.bloodbankservice.model.User;
import com.cognizant.bloodbankservice.repository.BloodRequestRepository;
import com.cognizant.bloodbankservice.repository.UserRepository;

@Service
public class BloodRequestService {

	private static final Logger LOGGER = LoggerFactory.getLogger(BloodRequestService.class);
	
	@Autowired
	BloodRequestRepository bloodRequestRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Transactional
	public List<User> requestBlood(String bloodGroup) {
		LOGGER.info("Start-Blood Request Service");
		return bloodRequestRepository.requestBlood(bloodGroup);
	}
	
	@Transactional
	public List<User> bloodAvailability(String bloodgroup,int pincode)
	{
		return userRepository.bloodAvailability(bloodgroup, pincode);
	}

	@Transactional
	public void postRequirement(@RequestBody BloodRequest request,String userName ) {
		User user = userRepository.findByUsername(userName);
		request.setUserId(user);
		bloodRequestRepository.save(request);
	}
	
	@Transactional
	public List<BloodRequest> requirements() {
		LOGGER.info("Start-Blood Request Service");
		return bloodRequestRepository.findAll();
	}
	
}
