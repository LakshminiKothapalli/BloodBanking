package com.cognizant.bloodbankservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.bloodbankservice.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	AddressService addressService;
	
	@GetMapping("/state")
	public List<String> getState() {
		return addressService.getState();
	}

	@GetMapping("/area/{state}")
	public List<String> getArea(@PathVariable String state) {
		System.err.println("1"+state);
		String substring=state.substring(3);
		System.err.println("2"+substring);
		return addressService.getArea(substring);
	}

	@GetMapping("/pincode/{area}")
	public Integer getPincode(@PathVariable String area) {
		System.err.println("3"+area);
		String substring=area.substring(3);
		System.err.println("4"+substring);
		return addressService.getPincode(substring);

	}
	
	

}
