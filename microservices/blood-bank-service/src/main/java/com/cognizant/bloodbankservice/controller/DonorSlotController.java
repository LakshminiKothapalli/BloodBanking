package com.cognizant.bloodbankservice.controller;
import java.sql.Date;
import java.sql.Time;
//import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.bloodbankservice.model.SlotBooking;
import com.cognizant.bloodbankservice.service.DonorSlotService;

@RestController
@RequestMapping("/slot")
public class DonorSlotController {

	@Autowired
	DonorSlotService donorSlotService;
	
	@GetMapping("/hospital/{pincode}")
	public List<String> getHospitalList(@PathVariable int pincode) {
		return donorSlotService.getHospitalList(pincode);
	}
	
	
	@GetMapping("/{hospitalName}/{date}/{time}")
	public int getNoOfDonors(@PathVariable("hospitalName") String hospitalName,@PathVariable("date") Date date,@PathVariable("time")  Time time) {
		System.err.println("hospitalName+++++time#####date***"+date+hospitalName);

		System.err.println(donorSlotService.getNoOfDonors(hospitalName,date,time));
		return donorSlotService.getNoOfDonors(hospitalName,date,time);
	}
	
	
	
	@PostMapping("/{hospitalName}")
	public void saveSlot(@RequestBody SlotBooking slot,@PathVariable String hospitalName) {
		System.out.println("dshjugh"+hospitalName);
		donorSlotService.saveSlot(slot,hospitalName);
	}
	
	
}
