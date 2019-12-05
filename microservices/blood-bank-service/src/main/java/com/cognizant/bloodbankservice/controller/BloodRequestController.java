package com.cognizant.bloodbankservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.cognizant.bloodbankservice.model.BloodRequest;
import com.cognizant.bloodbankservice.model.User;
import com.cognizant.bloodbankservice.service.BloodRequestService;

@RestController
@RequestMapping("/request")
public class BloodRequestController {

private static final Logger LOGGER = LoggerFactory.getLogger(BloodRequestController.class);
	
	@Autowired
	BloodRequestService bloodRequestService;
	
	@GetMapping("/{bloodGroup}")
	public List<User> requestBlood(@PathVariable String bloodGroup) {
		LOGGER.info("Start-Blood Request Service");
		return bloodRequestService.requestBlood(bloodGroup);
	}
	
	@GetMapping("/{bloodgroup}/{pincode}")
	public List<User> bloodAvailability(@PathVariable String bloodgroup,@PathVariable int pincode)
	{
		return bloodRequestService.bloodAvailability(bloodgroup, pincode);
	}
	
	@PostMapping("/{userName}")
	public void postRequirement(@RequestBody BloodRequest request,@PathVariable String userName) {
		bloodRequestService.postRequirement(request,userName);
	}
	
	@GetMapping("")
	public List<BloodRequest> requirements() {
		LOGGER.info("Start-Blood Request Service");
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		LOGGER.info("Authenticate " + authentication);
		String user = authentication.getName();

		if (user.equals("anonymousUser")) {
			return bloodRequestService.requirements();
		}
		
		return bloodRequestService.requirements();
	}
	
	
	 
}

