package com.cognizant.bloodbankservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.bloodbankservice.repository.AddressRepository;

@Service
public class AddressService {

	@Autowired
	AddressRepository addressRepository;

	public List<String> getState() {
		return addressRepository.getState();
	}

	public List<String> getArea(String state) {
		return addressRepository.getArea(state);
	}

	public Integer getPincode(String area) {
		return addressRepository.getPincode(area);

	}
}
