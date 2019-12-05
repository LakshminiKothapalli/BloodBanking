package com.cognizant.bloodbankservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.bloodbankservice.model.Hospital;
import com.cognizant.bloodbankservice.model.User;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Integer>{

	
	@Query("FROM Hospital h WHERE h.name=?1")
	public Hospital findByName(String name);
	
	@Query(value="SELECT hp_id FROM Hospital h WHERE h.hp_name=?1",nativeQuery=true)
	public int findId(String name);
	
	@Query(value="select hp_name from hospital h where h.hp_pincode=:pincode",nativeQuery=true)
	public List<String> getHospitalList(@Param(value = "pincode")int pincode);
}
