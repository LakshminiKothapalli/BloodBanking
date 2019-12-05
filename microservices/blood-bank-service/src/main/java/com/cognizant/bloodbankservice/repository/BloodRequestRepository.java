package com.cognizant.bloodbankservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.bloodbankservice.model.BloodRequest;
import com.cognizant.bloodbankservice.model.User;

@Repository
public interface BloodRequestRepository extends JpaRepository<BloodRequest, Integer>{

	@Query("FROM User u WHERE u.bloodgroup=?1")
	public List<User> requestBlood(String bloodGroup);
		
	
}
