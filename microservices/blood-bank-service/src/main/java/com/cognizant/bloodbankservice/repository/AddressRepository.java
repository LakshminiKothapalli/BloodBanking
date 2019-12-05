package com.cognizant.bloodbankservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.bloodbankservice.model.Address;

@Repository
public interface AddressRepository  extends JpaRepository<Address, Integer> {

	@Query(value="SELECT DISTINCT addr_state FROM address",nativeQuery=true)
	public List<String> getState();
	
	@Query(value="SELECT addr_area FROM address WHERE addr_state=:state",nativeQuery=true)
	public List<String> getArea(@Param(value="state") String state);
	
	@Query(value="SELECT addr_pincode FROM address WHERE addr_area=:area",nativeQuery=true)
	public Integer getPincode(@Param(value="area") String area);
	
}
